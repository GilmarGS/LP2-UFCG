package revisao3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSistemaAC {

	private SistemaACIf sac;

	@Before
	public void setup() {
		sac = new SistemaAC();
	}

	@Test
	public void testePasso1() throws Exception {
		// CADASTRO E BUSCA DE ALUNOS
		cadastraMichelDudu();
		Assert.assertEquals("1510171 --- Michel Teimoso --- 2015.1", sac.buscaAluno("1510171"));
		Assert.assertEquals("1510157 --- Dudu Cunhado --- 2015.1", sac.buscaAluno("1510157"));
	}

	private void cadastraMichelDudu() {
		sac.cadastraAluno("1510171", "Michel Teimoso", "2015.1");
		sac.cadastraAluno("1510157", "Dudu Cunhado", "2015.1");
	}

	@Test
	public void testePasso1Exception() throws Exception {
		// CADASTRO E BUSCA DE ALUNOS EXC.
		try {
			sac.cadastraAluno("   ", "Michel Teimoso", "2015.1");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula invalida.", e.getMessage());
		}
		try {
			sac.cadastraAluno("1510157", "   ", "2015.1");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome invalido.", e.getMessage());
		}
		try {
			sac.cadastraAluno("1510157", "Michel Teimoso", "    ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Periodo invalido.", e.getMessage());
		}
		cadastraMichelDudu();
		try {
			cadastraMichelDudu();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula ja cadastrada.", e.getMessage());
		}
	}

	@Test
	public void testePasso2() throws Exception {
		// CADASTRO E BUSCA DE ATIVIDADES
		cadastraMichelDudu();
		cadastraAC();
		
		List<String> respostaEsperada = new ArrayList<>();
		respostaEsperada.add("ICE: Inteligencia em Contas Estrangeiras - 1 semestre(s) - PPPD");
		respostaEsperada.add("ICE: Inteligencia em Contas Estrangeiras - 1 semestre(s) - PPPD");
		respostaEsperada.add("EVENTO: Congresso Nacional de Impedimento em Software");
		Assert.assertEquals(respostaEsperada, sac.consultaAC("1510157"));
	}

	private void cadastraAC() {
		sac.cadastraAC("1510157", "ICE: Inteligencia em Contas Estrangeiras", "PPPD", 1);
		sac.cadastraAC("1510157", "ICE: Inteligencia em Contas Estrangeiras", "PPPD", 1);
		sac.cadastraAC("1510157", "Congresso Nacional de Impedimento em Software", "PE", 1);
		sac.cadastraAC("1510171", "Programacao 2 - The Best Programacao", "PM", 2);
		sac.cadastraAC("1510171", "Lab Programacao 2 - The Best Lab Programacao", "PM", 1);
	}

	@Test
	public void testePasso2Exception() throws Exception {
		try {
			sac.consultaAC(" ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula invalida.", e.getMessage());
		}
		try {
			sac.consultaAC("123456");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula nao encontrada.", e.getMessage());
		}
		cadastraMichelDudu();
		try {
			sac.cadastraAC("1510157", "Erro.. Erro..", "PM", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Unidade invalida para esta AC.", e.getMessage());
		}
		try {
			sac.cadastraAC("1510157", "Erro.. Erro..", "PE", 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Unidade invalida para esta AC.", e.getMessage());
		}
		try {
			sac.cadastraAC("1510157", "Erro.. Erro..", "PAMONHA", 2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Tipo de atividade invalido.", e.getMessage());
		}
	}

	@Test
	public void testePasso3() throws Exception {
		// CALCULA CREDITOS
		cadastraMichelDudu();
		cadastraAC();
		Assert.assertEquals(5, sac.calculaCreditos("1510157"));
		Assert.assertEquals(4, sac.calculaCreditos("1510171"));
	}

	@Test
	public void testePasso3AoLimite() throws Exception {
		cadastraMichelDudu();
		cadastraAC();
		cadastraAC();
		cadastraAC();
		cadastraAC();
		Assert.assertEquals(6, sac.calculaCreditos("1510157"));
		Assert.assertEquals(6, sac.calculaCreditos("1510171"));
	}
	
	@Test
	public void testePasso3Exception() throws Exception {
		try {
			sac.calculaCreditos(" ");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula invalida.", e.getMessage());
		}
		try {
			sac.calculaCreditos("123456");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Matricula nao encontrada.", e.getMessage());
		}
	}
	
	@Test
	public void testePasso4() throws Exception {
		cadastraMichelDudu();
		cadastraAC();
		List<String> resultado = new ArrayList<>();
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 5");
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 4");
		Assert.assertEquals(resultado, sac.listaAlunos());
	}

	@Test
	public void testePasso5() throws Exception {
		cadastraMichelDudu();
		cadastraAC();
		List<String> resultado = new ArrayList<>();
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 5");
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 4");
		Assert.assertEquals(resultado, sac.listaAlunos());
		sac.defineOrdenacao("creditos");
		resultado = new ArrayList<>();
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 4");		
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 5");
		Assert.assertEquals(resultado, sac.listaAlunos());
		sac.defineOrdenacao("matricula");
		resultado = new ArrayList<>();
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 5");
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 4");		
		Assert.assertEquals(resultado, sac.listaAlunos());
	}

	@Test
	public void testePasso5Empate() throws Exception {
		cadastraMichelDudu();
		cadastraAC();
		sac.defineOrdenacao("creditos");
		List<String> resultado = new ArrayList<>();
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 4");		
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 5");
		Assert.assertEquals(resultado, sac.listaAlunos());
		cadastraAC();
		cadastraAC();
		cadastraAC();
		cadastraAC();
		resultado = new ArrayList<>();
		resultado.add("1510157 --- Dudu Cunhado --- 2015.1 --- 6");
		resultado.add("1510171 --- Michel Teimoso --- 2015.1 --- 6");		
		Assert.assertEquals(resultado, sac.listaAlunos());
	}
	
	@Test
	public void testePasso5Exception() throws Exception {
		try {
			sac.defineOrdenacao("teste");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Tipo ordenacao invalido.", e.getMessage());
		}
	}
	
}