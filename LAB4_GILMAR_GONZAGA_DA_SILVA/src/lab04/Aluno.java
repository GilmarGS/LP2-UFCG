package lab04;
/**
 * Representação de um estudante. Todo aluno precisa ter uma matrícula e é identificado unicamente
 * por esta matrícula.
 * @author Gilmar Gonzaga
 *
 */
public class Aluno {
	private String nome;
	private String matricula;
	private String curso;

	/**
	 * Constroi um aluno a partir das strings matricula, nome e curso.
	 * 
	 * @param matricula
	 *            matricula que identifica o aluno.
	 * @param nome
	 *            nome do aluno.
	 * @param curso
	 *            curso em que o aluno foi matriculado.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getCurso() {
		return curso;
	}

	/**
	 * Representacao textual de um aluno.
	 */
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Aluno other = (Aluno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
