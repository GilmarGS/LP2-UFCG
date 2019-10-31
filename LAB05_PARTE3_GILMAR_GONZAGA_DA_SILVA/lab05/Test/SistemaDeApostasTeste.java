package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lab05.SistemaDeApostas;

public class SistemaDeApostasTeste {
	private SistemaDeApostas sistema;
	
	/**
	    * Cria o sistem de aposta.
	    */                                                                    
	@Before
	public void criaSistema() {
		sistema = new SistemaDeApostas(100000,0.01);
	}
	
	/**
	    * Testa o valor do caixa que esta no sistema.
	    */ 
	@Test
	public void testGetCaixa() {
		assertEquals(100000,sistema.getCaixa());
	}
	/**
	    * Testa o cadastramento de cenario.
	    */ 
	@Test
	public void testCadastraCenario() {
		sistema.cadastrarCenario("Ira chover amanha");
		assertEquals(1,sistema.verificaTotalCenarios());
		
	}
	/**
	    * Testa como o cenario eh exibido.
	    */ 
	@Test
	public void testExibirCenario() {
		sistema.cadastrarCenario("Ira chover amanha");
		assertEquals("1 - Ira chover amanha - Nao finalizado",sistema.exibirCenario(1));
	}
	/**
	    * Testa como o cenario eh exibido ordanado.
	    */ 
	@Test
	public void testExibirCenarioOrdenado() {
		sistema.cadastrarCenario("A musica do carnaval sera Envolvimento");
		assertEquals("1 - A musica do carnaval sera Envolvimento - Nao finalizado",sistema.exibirCenario(1));
	}
	/**
	    * Testa como todos os cenarios cadastrados sao exibidos todos juntos.
	    */ 
	@Test
	public void testExibirCenarios() {
		sistema.cadastrarCenario("Ira chover amanha");
		sistema.cadastrarCenario("A musica do carnaval sera Envolvimento");
		assertEquals("1 - Ira chover amanha - Nao finalizado"+"\n"+"2 - A musica do carnaval sera Envolvimento - Nao finalizado"+"\n",sistema.exibirCenarios());
	}
	/**
	    * Testa cadastramento da aposta para um cenario.
	    */ 
	@Test
	public void testCadastrarAposta() {
		sistema.cadastrarCenario("O show nao ira acabar cedo");
		sistema.cadastrarAposta(1,"Gilmar Gonzaga",20000,"VAI ACONTECER");
		assertEquals(1,sistema.totalDeApostas(1));
	}
	/**
	    * Testa a obtencao do valor apostado que vai para o caixa do sistema.
	    */ 
	@Test
	public void testGetCaixaCenario() {
		sistema.cadastrarCenario("A campainha vai tocar as 10hs");
		
		sistema.cadastrarAposta(1,"Gilmar Gonzaga",20000,"N VAI ACONTECER");
		sistema.cadastrarAposta(1,"Gleyser Guimaraes",199,"N VAI ACONTECER");
		sistema.cadastrarAposta(1,"Gleyser Guimaraes",10000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Ana Paula",30000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Maria",20000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Vania Silva",10000,"VAI ACONTECER");
		
		sistema.fecharAposta(1,true);
	
		assertEquals(201,sistema.getCaixaCenario(1));
	}
	/**
	    * Testa a obtencao do valor apostado que sera dividido entre apostas ganhadoras.
	    */ 
	@Test
	public void testGetTotalRateioCenario() {
		sistema.cadastrarCenario("O campinense vai subir para serie c");
		
		sistema.cadastrarAposta(1,"Gilmar Gonzaga",20000,"N VAI ACONTECER");
		sistema.cadastrarAposta(1,"Gilmar Gonzaga",199,"N VAI ACONTECER");
		sistema.cadastrarAposta(1,"Maria Silva",10000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Vania Silva",30000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Larissa Cabral",20000,"VAI ACONTECER");
		sistema.cadastrarAposta(1,"Nicoly Cabral",10000,"VAI ACONTECER");
		
		sistema.fecharAposta(1,true);
	
		assertEquals(19998,sistema.getTotalRateioCenario(1));
	}

}