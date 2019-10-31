package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import lab05.SistemaDeApostas;

/**
 * Esta classe testa as funcionalidades da classe SistemaDeApostas
 * @author Gilmar Gonzaga
 * matricula: 117210921
 *
 */
public class SistemaDeApostasTest {

	SistemaDeApostas sistema;
	
	@Before
	public void criaSistema() throws Exception {
		sistema = new SistemaDeApostas(100, 0.10);
	}
	
	
	@Test
	public void testarCadastrarCenario() throws Exception {
		assertEquals(1, sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA."));
		assertEquals(2, sistema.cadastrarCenario("ESSE LAB VAI SER UM 10."));
		// FALTA TESTAR DESCRICAO VAZIA
	}
	
	/*@Test
	public void testarExibirCenario() {
		
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		sistema.cadastrarCenario("ESSE LAB VAI SER UM 10.");
		
		assertEquals("1 - TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Não Finalizado", sistema.exibirCenario(1));
		assertEquals("2 - ESSE LAB VAI SER UM 10. - Não Finalizado", sistema.exibirCenario(2));
		
	}
	
	@Test
	public void testarExibirCenarios() {
		
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		assertEquals("1 - TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Não Finalizado\n", sistema.exibirCenarios());
		sistema.cadastrarCenario("ESSE LAB VAI SER UM 10.");
		assertEquals("1 - TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Não Finalizado\n"
				+ "2 - ESSE LAB VAI SER UM 10. - Não Finalizado\n", sistema.exibirCenarios());
	}
	
	@Test
	public void testarCadastrarAposta() {
		
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals("Gilmar Gonzaga - 100 - VAI ACONTECER\n", sistema.getCenarios().get(0).exibeApostas());
		sistema.cadastrarAposta(1, "Maria Silva", 100, "VAI ACONTECER");
		assertEquals("Gilmar Gonzaga - 100 - VAI ACONTECER\n"
				+ "Maria Silva - 100 - VAI ACONTECER\n", sistema.getCenarios().get(0).exibeApostas());
	}
	
	@Test
	public void testarValorTotalDeApostas() {
		
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		assertEquals(0, sistema.valorTotalDeApostas(1));
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals(100, sistema.valorTotalDeApostas(1));
		sistema.cadastrarAposta(1, "Maria Silva", 100, "N VAI ACONTECER");
		assertEquals(200, sistema.valorTotalDeApostas(1));
	}
	
	@Test
	public void testarTotalDeApostas() {
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		assertEquals(0, sistema.totalDeApostas(1));
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals(2, sistema.totalDeApostas(1));
	}
	
	@Test
	public void testarExibeApostas() {
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		assertEquals("", sistema.exibeApostas(1));
		
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals("Gilmar Gonzaga - 100 - VAI ACONTECER\n", sistema.exibeApostas(1));
	}
	
	@Test
	public void testarGetCaixaCenario() {
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		assertEquals(0, sistema.getCaixaCenario(1));
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals(0, sistema.getCaixaCenario(1));
		sistema.fecharAposta(1, "n ocorreu");
		assertEquals(10, sistema.getCaixaCenario(1));
	}
	
	@Test
	public void testarGetTotalRateio() {
		sistema.cadastrarCenario("TODOS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		sistema.cadastrarAposta(1, "Gilmar Gonzaga", 100, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Maria Silva", 200, "N VAI ACONTECER");
		sistema.fecharAposta(1, "n ocorreu");
		
		assertEquals(90, sistema.getTotalRateioCenario(1));
	}*/
	
	

}
