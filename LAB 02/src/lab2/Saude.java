package lab2;

/**
 * Representa o estado de saúde de um aluno. É feita uma análise da saúde mental
 * e física, que são representadas como "boa" ou "fraca".
 * 
 * @author Gilmar Gonzaga da Silva 
 * matricula - 117210921
 */
public class Saude {
	private String saudeMental;
	private String saudeFisica;
	private String emoji;

	/**
	 * Constrói o estado de saúde física e mental do aluno, considerando ambas
	 * inicialmente como boa, podendo o aluno definir um emoji para expressar o seu
	 * estado de saúde atual.
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}

	/**
	 * @param valor
	 *            o estado de saúde mental, pode ser "boa", "ok" ou "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		defineEmojiPadrao();
	}

	/**
	 * @param valor
	 *            o estado de saúde física, pode ser "boa", "ok" ou "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		defineEmojiPadrao();
	}

	/**
	 * O relatório de saúde do aluno retorna sem emoji, caso o estado de saúde
	 * física ou mental seja alterada.
	 */
	private void defineEmojiPadrao() {
		this.emoji = "";
	}

	/**
	 * @return retorna a a situação da saúde geral do aluno, considerando a saúde
	 *         física e mental.
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
	 *            saúde. No formato: ":)".
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
}
