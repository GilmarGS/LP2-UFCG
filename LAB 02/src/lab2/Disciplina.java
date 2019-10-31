package lab2;

/** 
 * Representa as possíveis disciplinas que os alunos podem cadastrar em um semestre na 
 * universidade, alem dos nomes dessas disciplinas, temos quantas são precisas para estudar cada
 * uma delas, além da quantidade notas e seus respectivos pesos.
 *
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
import java.util.Arrays;

/**
 * Representação das disciplinas em que o aluno está matriculado. Será definido nomes das
 * disciplinas, quantas horas serão dedicadas de estudo, quantas notas terá durante o curso, 
 * pesos para cada nota e a média no final do curso, se for igual ou maior que 7 será aprovado,
 * caso contrário está reprovado.
 * 
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
public class Disciplina {
	private String nomeDisciplina;
	private int horasEstudo;
	private double[] notas;
	private int[] pesos;
	private final int NUMERODENOTASDEFAULT = 4;
	private final Double MEDIA = 7.0;

	/**
	 * Constrói a disciplina com nome, horas necessárias de estudo, quantas notas
	 * terá e seus respectivos pesos.
	 * 
	 * @param nomeDisciplina
	 *            o nome da disciplina no formato "Nome da Disciplina".
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = retornaNotasVazias(NUMERODENOTASDEFAULT);
		this.pesos = retornaPesosVazios(NUMERODENOTASDEFAULT);
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            define-se o nome da disciplina como String.
	 *            
	 * @param numeroDeNotas
	 *            a quantidade de notas que o aluno terá no semestre é inteiro.
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = retornaNotasVazias(numeroDeNotas);
		this.pesos = retornaPesosVazios(numeroDeNotas);
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            atribuição da String nome da disciplina.
	 * 
	 * @param numeroDeNotas
	 *            a quantidade em inteiro do numero de notas.
	 * 
	 * @param pesos
	 *            pesos para para as suas notas da disciplina quando o professor atribuir,
	 *            criado um array de inteiro com os pesos para cada nota.
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = retornaNotasVazias(numeroDeNotas);
		this.pesos = pesos;
	}

	/**
	 * 
	 * @param horas
	 *            é definido um número inteiro para a carga horária de estudo para
	 *            a disciplina.
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo = horasEstudo + horas;
	}

	/**
	 * 
	 * @param nota
	 *            é o inteiro que representa qual a nota está sendo cadastrada.
	 *            Exemplo nota 1, refere-se a primeira nota da disciplina.
	 * 
	 * @param valorNota
	 *            é a pontuação obtida em cada nota informada.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Verifica se a média é maior ou igual a 7 para retornar verdadeiro e se for menor
	 * retorna falso.
	 * 
	 * @return verdadeiro se a media for igual ou maior que 7 e falso caso seja
	 *         inferior.
	 */
	public boolean aprovado() {
		return calculaMedia() >= this.MEDIA;
	}

	/**
	 * 
	 * @return o cálculo da média da disciplina, obtida no final do curso.
	 */
	private double calculaMedia() {
		double somaNotas = 0;
		double media;

		for (int i = 0; i < this.notas.length; i++) {
			somaNotas += this.notas[i] * this.pesos[i];
		}
		media = somaNotas / retornaSomaDosPesos();
		return media;
	}

	/**
	 * 
	 * @param numeroDeNotas
	 *            a quantidade de notas que o aluno terá.
	 *            
	 * @return retorna um array de inteiros com notas vazias, para serem preenchidas
	 *         quando o aluno for realizando as avaliações da disciplina.
	 */
	private double[] retornaNotasVazias(int numeroDeNotas) {
		double[] notas = new double[numeroDeNotas];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = 0;
		}

		return notas;
	}

	/**
	 * 
	 * @param numeroDeNotas
	 *            a quantidade de notas para definir quantos pesos serão necessários
	 *            para a disciplina.
	 * 
	 * @return retorna um valor inteiro para cada posição do array em que será
	 *         atribuído o peso para cada nota do aluno.
	 */
	private int[] retornaPesosVazios(int numeroDeNotas) {
		int[] notas = new int[numeroDeNotas];
		for (int i = 0; i < notas.length; i++) {
			notas[i] = 1;
		}

		return notas;
	}

	/** 
	 * Faz a soma dos pesos que foram atribuídos para o cálculo da média.
	 * 
	 * @return retorno um inteiro que corresponde a soma dos pesos informados.
	 */
	private int retornaSomaDosPesos() {
		int retorno = 0;
		for (int peso : this.pesos) {
			retorno += peso;
		}

		return retorno;
	}

	/**
	 * Retorna o nome da disciplina cursada por um aluno.
	 * 
	 * @return retorna uma String com o nome da disciplina.
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	/**
	 * Retorna a representação em String do nome de uma disciplina, quantas horas de estudo
	 * a média obtida pelo aluno e as notas obtidas durante o semestre.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.notas);
	}

}
