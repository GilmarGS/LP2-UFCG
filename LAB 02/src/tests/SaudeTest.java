package tests;

/**
 * 
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
import org.junit.Assert;
import org.junit.Test;
import lab2.Saude;

public class SaudeTest {
	private Saude saude;

	@Test
	public void testaDefinirEmoji() {
		saude = new Saude();
		saude.definirEmoji(":)");
		Assert.assertEquals("Retornou geral errado", "boa :)", saude.geral());
		saude.defineSaudeMental("boa");
		Assert.assertEquals("Retornou geral errado", "boa ", saude.geral());

		saude.defineSaudeMental("fraca");
		saude.defineSaudeFisica("fraca");
		Assert.assertEquals("Retornou geral errado", "fraca ", saude.geral());

		saude.definirEmoji(":(");
		Assert.assertEquals("Retornou geral errado", "fraca :(", saude.geral());

		saude.defineSaudeMental("fraca");
		Assert.assertEquals("Retornou geral errado", "fraca ", saude.geral());

		saude.defineSaudeMental("boa");
		saude.defineSaudeFisica("fraca");
		Assert.assertEquals("Retornou geral errado", "ok ", saude.geral());
		saude.definirEmoji(":|");
		Assert.assertEquals("Retornou geral errado", "ok :|", saude.geral());
	}

}
