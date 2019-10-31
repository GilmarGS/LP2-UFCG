package tests;

/**
 * 
 * matricula - 117210921
 * @author Gilmar Gonzaga da Silva
 * 
 */

import lab2.Disciplina;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes da classe Disciplina.
 *
 */
public class DisciplinaTest {
	private Disciplina P2;
	private Disciplina P1;
	private Disciplina Calculo;	

	@Before public void criaDisciplinas() {
		int[] pesos = {1,2,3,4};
		P2 = new Disciplina("PROGRAMAÇÃO 2", 4, pesos);
		P1 = new Disciplina("PROGRAMAÇÃO 1", 4);
		Calculo = new Disciplina("CALCULO");
	}

	@Test 
	public void testaCalculaMediaSemPesos() {
		Calculo.cadastraNota(1, 5.0);
		Calculo.cadastraNota(2, 8.0);
		Calculo.cadastraNota(3, 3.0);
		Calculo.cadastraNota(4, 10.0);
		Assert.assertFalse("Retornou aprovado, quando a media eh 6.5", Calculo.aprovado()); 

		P1.cadastraNota(1, 5.0);
		P1.cadastraNota(2, 8.0);
		P1.cadastraNota(3, 10.0);
		P1.cadastraNota(4, 10.0);
		Assert.assertTrue("Retornou reprovado, quando a media eh 8.25", P1.aprovado());
	}

	@Test 
	public void testaCalculaMediaComPesos() {
		P2.cadastraNota(1, 5.0);
		P2.cadastraNota(2, 8.0);
		P2.cadastraNota(3, 3.0);
		P2.cadastraNota(4, 10.0);
		Assert.assertTrue("Retornou reprovado, quando a media eh 7.0", P2.aprovado()); 

		P2.cadastraNota(1, 3.0);
		P2.cadastraNota(2, 8.0);
		P2.cadastraNota(3, 3.0);
		P2.cadastraNota(4, 2.0);
		Assert.assertFalse("Retornou aprovado, quando a media eh 3.6", P2.aprovado());


	}

}
