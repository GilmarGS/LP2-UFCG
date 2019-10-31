package tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import lab05.Cenario;

/*
 * Esta classe testa as funcionalidades da classe Cenario.
 * 
 * @author Gilmar Gonzaga
 * Matricula: 117210921
 **/

public class CenarioTest {
Cenario cenario, cenario2, cenario3;
	
	/**
	 *  Este metodo cria cenarios antes de cada teste.
	 */
	
	@Before
	public void criaCenario() {
		try {
			cenario = new Cenario("TODOS OS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cenario2 = new Cenario("ESSE LAB VAI SER UM 10.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Testa o metodo de cadastrar novas apostas. 
	 */

	@Test (expected = IllegalArgumentException.class)
	public void testarCadastrarAposta() {
		
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals(1, cenario.getApostas().size());
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals(2, cenario.getApostas().size());
		cenario2.cadastrarAposta("Gilmar Silva", 100, "VAI ACONTECER");
		assertEquals(1, cenario2.getApostas().size());
		
		cenario.cadastrarAposta("Gilmar Silva", 0, "N VAI ACONTECER");
	}
	
	/**
	 * Testa o metodo de quantidade total de apostas.
	 */
	
	@Test
	public void testarTotalDeApostas() {
		
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals(1, cenario.totalDeApostas());
		cenario.cadastrarAposta("Gilmar Silva", 100, "N VAI ACONTECER");
		assertEquals(2, cenario.totalDeApostas());
		cenario2.cadastrarAposta("Gilmar Gonzaga", 100, "VAI ACONTECER");
		assertEquals(1, cenario2.totalDeApostas());
		
	}
	
	/**
	 * Testa o metodo de somar os valores das apostas. 
	 */
	
	@Test
	public void testarValorTotalDeApostas() {
		
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals(100, cenario.valorTotalDeApostas());
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals(200, cenario.valorTotalDeApostas());
		cenario2.cadastrarAposta("Gilmar Gonzaga", 500, "VAI ACONTECER");
		assertEquals(500, cenario2.valorTotalDeApostas());
		
	}
	
	/**
	 * Testa o metodo de exibir apostas. 
	 */
	
	@Test
	public void testarExibeApostas() {
		
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		assertEquals("Gilmar Gonzaga - 100 - N VAI ACONTECER\n", cenario.exibeApostas());
		
		cenario.cadastrarAposta("Joao de Jesus", 50, "N VAI ACONTECER");
		cenario.cadastrarAposta("Maria Silva", 300, "VAI ACONTECER");
		assertEquals("Gilmar Gonzaga - 100 - N VAI ACONTECER\n"
				+ "Joao de Jesus - 50 - N VAI ACONTECER\n"
				+ "Maria Silva - 300 - VAI ACONTECER\n", cenario.exibeApostas());
	}
	
	/**
	 * Este metodo testa a funcao de fechar apostas. 
	 */
	
	@Test
	public void testarFecharApostas() {
		
		assertEquals("TODOS OS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Não Finalizado", cenario.toString());
		cenario.fecharAposta(true);
		assertEquals("TODOS OS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Finalizado (ocorreu)", cenario.toString());
		cenario.fecharAposta(false);
		assertEquals("TODOS OS ALUNOS DE LP2 PAGARAO A CADEIRA POR MEDIA. - Finalizado (n ocorreu)", cenario.toString());
		
	}
	
	/**
	 * Este metodo testa a funcionalidade de somar os valores de quem perdeu. 
	 */
	
	@Test
	public void testarSomarValoresDeQuemPerdeu() {
		
		cenario.cadastrarAposta("Gilmar Gonzaga", 100, "N VAI ACONTECER");
		cenario.fecharAposta(false);
		assertEquals(0, cenario.somarValoresDeQuemPerdeu());
		
		cenario.cadastrarAposta("Joao de Jesus", 100, "VAI ACONTECER");
		cenario.cadastrarAposta("Maria Silva", 50, "VAI ACONTECER");
		assertEquals(150, cenario.somarValoresDeQuemPerdeu());
	}

	

}

