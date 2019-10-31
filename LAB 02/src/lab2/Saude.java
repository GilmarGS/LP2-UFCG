package lab2;

/**
 * Representa o estado de sa�de de um aluno. � feita uma an�lise da sa�de mental
 * e f�sica, que s�o representadas como "boa" ou "fraca".
 * 
 * @author Gilmar Gonzaga da Silva 
 * matricula - 117210921
 */
public class Saude {
	private String saudeMental;
	private String saudeFisica;
	private String emoji;

	/**
	 * Constr�i o estado de sa�de f�sica e mental do aluno, considerando ambas
	 * inicialmente como boa, podendo o aluno definir um emoji para expressar o seu
	 * estado de sa�de atual.
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}

	/**
	 * @param valor
	 *            o estado de sa�de mental, pode ser "boa", "ok" ou "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		defineEmojiPadrao();
	}

	/**
	 * @param valor
	 *            o estado de sa�de f�sica, pode ser "boa", "ok" ou "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		defineEmojiPadrao();
	}

	/**
	 * O relat�rio de sa�de do aluno retorna sem emoji, caso o estado de sa�de
	 * f�sica ou mental seja alterada.
	 */
	private void defineEmojiPadrao() {
		this.emoji = "";
	}

	/**
	 * @return retorna a a situa��o da sa�de geral do aluno, considerando a sa�de
	 *         f�sica e mental.
	 */
	public String geral() {
		if (saudeMental.equals("fraca") && saudeFisica.equals("fraca")) {
			return "fraca" + " " + this.emoji;
		} else if (saudeMental.equals("boa") && saudeFisica.equals("fraca")
				|| saudeMental.equals("fraca") && saudeFisica.equals("boa")) {
			return "ok" + " " + this.emoji;
		} else {
			return "boa" + " " + this.emoji;
		}
	}

	/**
	 * @param valor
	 *            o aluno define um emoji, String, de acordo com o seu estado de
	 *            sa�de. No formato: ":)".
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
}
