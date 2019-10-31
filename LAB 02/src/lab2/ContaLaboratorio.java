package lab2;

/** 
 * Representa a conta de um aluno em um laboratório na Universidade que estuda,
 * a conta tem espaço de 2000mb e pode ser adicionado mais espaço ou diminuí-lo.
 *
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
public class ContaLaboratorio {
	private String nomeLaboratorio;
	private int cota;
	private int espacoOcupado;

	/** 
	 * Para construir o laboratório, primeiramente será dado um nome, assim como atribuir valores
	 * para o tamanho que o laboratório pode ter e quanto de espaço tem inicialemente 
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
	 * @param cota é o tamanho máximo, inteiro, que cada conta no laboratório pode ter.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoOcupado = 0;
	}

	/**
	 * @param consomeEpaco determina o tamanho do espaço que será liberado na conta do aluno.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado = this.espacoOcupado + mbytes;
	}

	/**
	 * @param liberaEpaco determina o tamanho do espaço que será retirado na conta do aluno.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado = this.espacoOcupado - mbytes;
	}

	/**
	 * @return verdadeiro se o valor for maior ou igual a 2000, caso contrário retorna falso.
	 */
	public boolean atingiuCota() {
		return this.espacoOcupado >= this.cota;
	}
	/**
	 * Retorna String que representa o nome do laboratório. A representação tem 
	 * o formato: "Nome do Laboratório".
	 * 
	 * @return a representação em String do nome do laboratório. 
	 */
	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

	/**
	 * Retorna a representação em string do nome do laboratório, quanto o aluno
	 * ocupou de espaço em sua conta e qual o limite máximo para cada conta. 
	 * Segue o formato: "Nome do Laboratório 0000/0000".
	 */
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}