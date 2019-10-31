package lab04;
import java.util.HashMap;
/**
 * Realiza cadastro de alunos, para isso e verificado a matricula, caso ja existe nao e possivel
 * cadastrar.
 * 
 * @author Gilmar Gonzaga
 */
public class AlunosCadastrados {
	private HashMap<String, Aluno> mapaMatriculaAlunos;

	/**
	 * Controi um mapa para cadastrar os alunos, a chave e a matricula informada e o
	 * valor e um conjunto de alunos.
	 */
	public AlunosCadastrados() {
		this.mapaMatriculaAlunos = new HashMap<>();
	}

	/**
	 * Esse metodo cadastra um aluno, verifica se a matricula informada para
	 * cadastro ja existe, caso exista e lancado uma excecao e uma mensagem
	 * informando que a matricula ja esta cadastrada.
	 * 
	 * @param aluno
	 *            recebe um aluno do tipo Aluno e verifica se a sua matricula ja
	 *            existe, se nao existir o aluno e cadastrado.
	 * @throws Exception
	 *             lanca uma excecao caso a matricula ja esteja cadastrada.
	 */
	public void cadastrarAluno(Aluno aluno) throws Exception {
		if (isAlunoCadastrado(aluno.getMatricula())) {
			throw new Exception("MATRÍCULA JÁ CADASTRADA!");
		}
		this.mapaMatriculaAlunos.put(aluno.getMatricula(), aluno);
	}

	/**
	 * Esse metodo verifica se uma matricula ja existe.
	 * 
	 * @param matricula
	 *            informa uma matricula.
	 * @return retorna um booleano.
	 */
	public boolean isAlunoCadastrado(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}

	/**
	 * Esse metodo retorna o toString caso um aluno informado esteja cadastrado.
	 * 
	 * @param matricula
	 *            informa a matricula de um aluno para verificar se o aluno ja esta
	 *            cadastrado.
	 * @return retorna a representação textual de um aluno.
	 * @throws Exception
	 *             lanca uma excecao caso o aluno nao exista.
	 */
	public String exibirAluno(String matricula) throws Exception {
		return retornaAluno(matricula).toString();
	}

	/**
	 * Esse metodo verifica se um aluno e cadastrado e em caso afirmativo retorna-o.
	 * 
	 * @param matricula
	 *            matricula do aluno que servira para verificar se o aluno esta
	 *            cadastrado.
	 * @return retorna um aluno cadastrado.
	 * @throws Exception
	 *             se nao existir nenhum aluno o metodo lanca uma excecao.
	 */
	public Aluno retornaAluno(String matricula) throws Exception {
		if (isAlunoCadastrado(matricula)) {
			Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
			return aluno;
		}
		throw new Exception("Aluno não cadastrado.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapaMatriculaAlunos == null) ? 0 : mapaMatriculaAlunos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunosCadastrados other = (AlunosCadastrados) obj;
		if (mapaMatriculaAlunos == null) {
			if (other.mapaMatriculaAlunos != null)
				return false;
		} else if (!mapaMatriculaAlunos.equals(other.mapaMatriculaAlunos))
			return false;
		return true;
	}

}