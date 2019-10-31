package lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * Cadastra alunos em um grupo de estudos, cria-se o grupo a partir de um tema.
 * @author Gilmar Gonzaga
 *
 */
public class GrupoDeEstudos {
	private HashMap<String, HashSet<Aluno>> mapaCadastraGrupo;
	private ArrayList<String> temas;

	/**
	 * Constroi a colecao responsavel por guardar os alunos cadastrados e salvar o
	 * nome do tema da mesma forma como foi criado.
	 */
	public GrupoDeEstudos() {
		this.mapaCadastraGrupo = new HashMap<>();
		this.temas = new ArrayList<>();
	}

	/**
	 * Cdastra um tema para um grupo de estudo.
	 * 
	 * @param tema
	 *            o nome do assunto estudado no grupo de estudo.
	 * @throws Exception
	 *             lanca uma excecao caso o tema ja esteja cadastrado.
	 */
	public void cadastrarTema(String tema) throws Exception {
		if (isTemaCadastrado(tema)) {
			throw new Exception("GRUPO JÁ CADASTRADO!");
		}
		HashSet<Aluno> alunos = new HashSet<>();
		this.temas.add(tema);
		this.mapaCadastraGrupo.put(tema.toUpperCase(), alunos);
	}

	/**
	 * Cadastra um aluno no grupo de estudo.
	 * 
	 * @param aluno
	 *            o aluno que entrara no grupo.
	 * @param tema
	 *            o tema em que o aluno sera cadastrado.
	 * @throws Exception
	 *             lanca uma excecao caso o aluno ou o tema nao existam.
	 */
	public void cadastrarAlunoNoGrupo(Aluno aluno, String tema) throws Exception {
		if (!isTemaCadastrado(tema)) {
			throw new Exception("Grupo não cadastrado.");
		}
		HashSet<Aluno> alunosDesseTema = mapaCadastraGrupo.get(tema.toUpperCase());
		alunosDesseTema.add(aluno);
		mapaCadastraGrupo.put(tema, alunosDesseTema);

	}

	/**
	 * Verifica se o tema informado esta cadastrado.
	 * 
	 * @param tema
	 *            informa o tema a ser verificado.
	 * @return retorna um booleano.
	 */
	public boolean isTemaCadastrado(String tema) {
		return this.mapaCadastraGrupo.containsKey(tema.toUpperCase());
	}

	/**
	 * Imprime os alunos cadastrado em um grupo de estudo.
	 * 
	 * @param tema
	 *            e o nome do grupo de estudo.
	 * @return retorna uma representacao textual dos alunos cadastrados no grupo de
	 *         estudo.
	 * @throws Exception
	 *             lanca uma excecao caso o tema procurado nao esteja cadastrado.
	 */
	public String imprimirAluno(String tema) throws Exception {
		if (!isTemaCadastrado(tema)) {
			throw new Exception("Grupo não cadastrado.");
		}
		HashSet<Aluno> alunosDoTema = this.mapaCadastraGrupo.get(tema.toUpperCase());
		String retorno = "";
		for (Aluno aluno : alunosDoTema) {
			retorno += "*" + " " + aluno.toString() + "\n";
		}
		return retorno;

	}

}
