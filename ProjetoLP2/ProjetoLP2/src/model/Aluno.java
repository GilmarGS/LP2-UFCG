package model;
/**
 * 
 * @author gilmar
 *
 */
public class Aluno {
	// DEIXAR PRIVATE. Motivacao: ver material de jacques/neto
	private String nome;
	private String matricula;
	private int codCurso;
	private String telefone;
	private String email;
	private int nota;
	
	public Aluno(String nome, String matricula, int codCurso, String telefone, String email) throws Exception{
		validaAluno(nome);	
		this.matricula = matricula;
		this.nome = nome;
		this.codCurso = codCurso;
		this.telefone = telefone;
		this.email = email;
		this.nota = 0;
	}
	
	public void validaAluno(String nome) {
		if (nome.trim().equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
	
	public int getCodCurso() {
		return codCurso;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		if (!this.telefone.trim().equals("")) {
			return this.matricula + " - " + this.nome + " - " + this.codCurso + " - " + this.telefone + " - "
					+ this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.codCurso + " - " + this.email;
		}
	}

}
