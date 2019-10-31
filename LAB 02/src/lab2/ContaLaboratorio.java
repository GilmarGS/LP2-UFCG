package lab2;

/** 
 * Representa a conta de um aluno em um laborat�rio na Universidade que estuda,
 * a conta tem espa�o de 2000mb e pode ser adicionado mais espa�o ou diminu�-lo.
 *
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
public class ContaLaboratorio {
	private String nomeLaboratorio;
	private int cota;
	private int espacoOcupado;

	/** 
	 * Para construir o laborat�rio, primeiramente ser� dado um nome, assim como atribuir valores
	 * para o tamanho que o laborat�rio pode ter e quanto de espa�o tem inicialemente 
	 * na conta do aluno.
	 *
	 * @param nomeLaboratorio refere-se ao nome String dado ao laboratorio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
		this.espacoOcupado = 0;
	}
	/**
	 * @param nomeLaboratorio nomeLaboratorio refere-se ao nome String dado ao laboratorio.
	 * @param cota � o tamanho m�ximo, inteiro, que cada conta no laborat�rio pode ter.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoOcupado = 0;
	}

	/**
	 * @param consomeEpaco determina o tamanho do espa�o que ser� liberado na conta do aluno.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado = this.espacoOcupado + mbytes;
	}

	/**
	 * @param liberaEpaco determina o tamanho do espa�o que ser� retirado na conta do aluno.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado = this.espacoOcupado - mbytes;
	}

	/**
	 * @return verdadeiro se o valor for maior ou igual a 2000, caso contr�rio retorna falso.
	 */
	public boolean atingiuCota() {
		return this.espacoOcupado >= this.cota;
	}
	/**
	 * Retorna String que representa o nome do laborat�rio. A representa��o tem 
	 * o formato: "Nome do Laborat�rio".
	 * 
	 * @return a representa��o em String do nome do laborat�rio. 
	 */
	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	/**
	 * Retorna a representa��o em string do nome do laborat�rio, quanto o aluno
	 * ocupou de espa�o em sua conta e qual o limite m�ximo para cada conta. 
	 * Segue o formato: "Nome do Laborat�rio 0000/0000".
	 */
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}