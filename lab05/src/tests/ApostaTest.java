package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import lab05.Aposta;

/**
 * Esta classe testa as funcionalidades da classe Aposta
 * 
 * @author Gilmar Gonzaga Matricula: 117210921
 */

public class ApostaTest {

	Aposta aposta, aposta2, aposta3;

	/**
	 * Este metodo cria apostas antes de todo teste.
	 */

	@Before
	public void criaAposta() {
		aposta = new Aposta("Gilmar Gonzaga", 500, true);
		aposta2 = new Aposta("Gilmar Silva", 100, false);
	}

	/**
	 * Este metodo testa o ToString.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testarToString() {

		assertEquals("Gilmar Gonzaga - 500 - VAI ACONTECER", aposta.toString());
		assertEquals("Gilmar Silva - 100 - N VAI ACONTECER", aposta2.toString());

		aposta3 = new Aposta(null, 0, false);
	}

}
