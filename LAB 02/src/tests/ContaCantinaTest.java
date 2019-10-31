package tests;
/**
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */


import org.junit.Assert;
import org.junit.Test;
import lab2.ContaCantina;

public class ContaCantinaTest {
	
	@Test 
	public void testaDetalhes() {
		ContaCantina cantina = new ContaCantina("Cantina Alamedas");
		cantina.cadastraLanche(4, 50, "bolo");
		cantina.cadastraLanche(4, 50, "bolacha");
		cantina.cadastraLanche(4, 50, "café dois litros");
		cantina.cadastraLanche(4, 50, "coca");
		cantina.cadastraLanche(4, 50, "pastel");
		cantina.cadastraLanche(4, 50, "coxinha");
		Assert.assertEquals("Retornou detalhes errado", "1:coxinha 2:bolacha 3:café dois litros 4:coca 5:pastel", cantina.listarDetalhes()); 
		cantina.cadastraLanche(4, 50, "bolo");
		Assert.assertEquals("Retornou detalhes errado", "1:coxinha 2:bolo 3:café dois litros 4:coca 5:pastel", cantina.listarDetalhes()); 
		cantina.cadastraLanche(4, 50, "guarana");
		Assert.assertEquals("Retornou detalhes errado", "1:coxinha 2:bolo 3:guarana 4:coca 5:pastel", cantina.listarDetalhes()); 

	}

}
