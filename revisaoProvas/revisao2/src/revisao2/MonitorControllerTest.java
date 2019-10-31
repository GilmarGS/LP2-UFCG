package  revisao2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonitorControllerTest {

	private static final String MONITOR_NAO_ENCONTRADO = "Monitor nao encontrado";
	private static final String CAMPO_NULO_OU_VAZIO = "Campo nulo ou vazio";
	private static final Object VALOR_INVALIDO = "Valor Invalido";
	private MonitorController controller;
	private String emailInvalido = "not.found@example.com";
	private String emailMarcelo = "marcelo.marmelo@example.com";
	private String emailPedro = "pedro.parque@example.net";
	private String emailIsabel = "isabel.isabelly@example.com";
	private String emailAna = "ana.anamaria@example.net";
	private String nomeMarcelo = "Marcelinho Marmelo";
	private String nomePedro = "Pedro Parque";
	private String nomeIsabel = "Isabel Isabelly";
	private String nomeAna = "Ana AnaMaria";

	@Before
	public void setUp() {
		this.controller = new MonitorController();
	}

	@Test
	public void testPasso1_Monitores() throws Exception {
		Assert.assertEquals("[]", this.controller.listarMonitores());
		this.controller.cadastrarMonitor(nomeMarcelo, emailMarcelo);
		String resposta = "[" + nomeMarcelo + "-" + emailMarcelo + "]";
		Assert.assertEquals(resposta, this.controller.listarMonitores());
		
		//testando mesmo email:
		this.controller.cadastrarMonitor(nomeMarcelo, emailMarcelo);
		Assert.assertEquals(resposta, this.controller.listarMonitores());
		
		this.controller.cadastrarMonitor(nomeAna, emailAna);
		
		resposta = "[" + nomeAna + "-" + emailAna + ", " + nomeMarcelo + "-" + emailMarcelo + "]";
		Assert.assertEquals(resposta, this.controller.listarMonitores());
	}

	/*@Test
	public void testPasso1_Excecoes() throws Exception {
		try {
			this.controller.cadastrarMonitor(null, emailMarcelo);
			Assert.fail("Excecao nao capturada");
		} catch (Exception e) {
			Assert.assertEquals(CAMPO_NULO_OU_VAZIO, e.getMessage());
		}
		try {
			this.controller.cadastrarMonitor(nomeMarcelo, "     ");
			Assert.fail("Excecao nao capturada");
		} catch (Exception e) {
			Assert.assertEquals(CAMPO_NULO_OU_VAZIO, e.getMessage());
		}

	}*/

	private void populaMonitor() throws Exception {
		this.controller.cadastrarMonitor(nomeMarcelo, emailMarcelo);
		this.controller.cadastrarMonitor(nomePedro, emailPedro);
		this.controller.cadastrarMonitor(nomeIsabel, emailIsabel);
		this.controller.cadastrarMonitor(nomeAna, emailAna);
	}

	@Test
	public void testPasso2_1_ImprimeAtividade() throws Exception {
		populaMonitor();
		this.controller.cadastrarAC(emailMarcelo, 2, 1);
		Assert.assertEquals("AC - 2 - 1", this.controller.imprimeAtividade(emailMarcelo, 0));
		this.controller.cadastrarEX(emailPedro, 3, 2);
		Assert.assertEquals("EX - 3 - 2", this.controller.imprimeAtividade(emailPedro, 0));
		this.controller.cadastrarPROJ(emailIsabel, 4, 3);
		Assert.assertEquals("PROJ - 4 - 3", this.controller.imprimeAtividade(emailIsabel, 0));
		this.controller.cadastrarTUTOR(emailAna, 5, 4);
		Assert.assertEquals("TUTOR - 5 - 4", this.controller.imprimeAtividade(emailAna, 0));
	}

	@Test
	public void testPasso2_2_ImprimeAtividadeLista() throws Exception {
		populaMonitor();
		this.controller.cadastrarAC(emailMarcelo, 2, 1);
		Assert.assertEquals("AC - 2 - 1", this.controller.imprimeAtividade(emailMarcelo, 0));
		this.controller.cadastrarEX(emailMarcelo, 3, 2);
		Assert.assertEquals("EX - 3 - 2", this.controller.imprimeAtividade(emailMarcelo, 1));
		this.controller.cadastrarPROJ(emailMarcelo, 4, 3);
		Assert.assertEquals("PROJ - 4 - 3", this.controller.imprimeAtividade(emailMarcelo, 2));
		this.controller.cadastrarTUTOR(emailMarcelo, 5, 4);
		Assert.assertEquals("TUTOR - 5 - 4", this.controller.imprimeAtividade(emailMarcelo, 3));
		this.controller.cadastrarAC(emailMarcelo, 6, 7);
		Assert.assertEquals("AC - 6 - 7", this.controller.imprimeAtividade(emailMarcelo, 4));
		Assert.assertEquals("AC - 2 - 1", this.controller.imprimeAtividade(emailMarcelo, 0));
		Assert.assertEquals("TUTOR - 5 - 4", this.controller.imprimeAtividade(emailMarcelo, 3));
	}

	@Test
	public void testPasso2_3_VariasAtividades() throws Exception {
		populaMonitor();
		Assert.assertEquals(0, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarAC(emailMarcelo, 2, 1);
		Assert.assertEquals(2, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarEX(emailMarcelo, 3, 2);
		Assert.assertEquals(5, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarPROJ(emailMarcelo, 4, 3);
		Assert.assertEquals(9, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarTUTOR(emailMarcelo, 5, 4);
		Assert.assertEquals(14, this.controller.totalHorasAtividades(emailMarcelo));

	}

	@Test
	public void testPasso2_4_AtividadesRepetidas() throws Exception {
		populaMonitor();
		Assert.assertEquals(0, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarAC(emailMarcelo, 2, 1);
		this.controller.cadastrarEX(emailMarcelo, 3, 2);
		this.controller.cadastrarPROJ(emailMarcelo, 4, 3);
		this.controller.cadastrarTUTOR(emailMarcelo, 5, 4);
		Assert.assertEquals(14, this.controller.totalHorasAtividades(emailMarcelo));
		this.controller.cadastrarAC(emailMarcelo, 2, 1);
		this.controller.cadastrarEX(emailMarcelo, 3, 2);
		this.controller.cadastrarPROJ(emailMarcelo, 4, 3);
		this.controller.cadastrarTUTOR(emailMarcelo, 5, 4);
		Assert.assertEquals(28, this.controller.totalHorasAtividades(emailMarcelo));
	}

	/*@Test
	public void testPasso2_Exception() throws Exception {
		populaMonitor();
		try {
			this.controller.cadastrarAC("         ", 1, 1);
			Assert.fail("Excecao nao capturada");
		} catch (Exception e) {
			Assert.assertEquals(CAMPO_NULO_OU_VAZIO, e.getMessage());
		}
	
		try {
			this.controller.imprimeAtividade(emailMarcelo, -1);
			Assert.fail("Excecao nao capturada");
		} catch (Exception e) {
			Assert.assertEquals(VALOR_INVALIDO, e.getMessage());
		}
		//vc pode fazer mais testes aqui

	}*/

	@Test
	public void testPasso3() throws Exception {
		populaMonitor();
		Assert.assertEquals(0, this.controller.calculaDesempenho(emailMarcelo), 0.0001);
		this.controller.cadastrarAC(emailMarcelo, 2, 10);
		this.controller.cadastrarAC(emailMarcelo, 2, 20);
		this.controller.cadastrarAC(emailMarcelo, 1, 1);
		this.controller.cadastrarEX(emailMarcelo, 2, 2);
		this.controller.cadastrarEX(emailMarcelo, 4, 1);
		this.controller.cadastrarPROJ(emailMarcelo, 3, 10);
		this.controller.cadastrarTUTOR(emailMarcelo, 2, 1);
		this.controller.cadastrarTUTOR(emailMarcelo, 2, 1);
		this.controller.cadastrarTUTOR(emailMarcelo, 2, 2);
		Assert.assertEquals(19.0, this.controller.calculaDesempenho(emailMarcelo), 0.0001);
	}

	/*@Test
	public void testPasso3_Exception() throws Exception {
		populaMonitor();
		try {
			this.controller.imprimeAtividade(emailInvalido, -1);
			Assert.fail("Excecao nao capturada");
		} catch (Exception e) {
			Assert.assertEquals(MONITOR_NAO_ENCONTRADO, e.getMessage());
		}
	}*/

	@Test
	public void testPasso4() throws Exception {
		//aqui eh vc quem faz os testes
	}

}