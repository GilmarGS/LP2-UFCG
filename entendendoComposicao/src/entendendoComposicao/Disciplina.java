package entendendoComposicao;

import java.util.HashSet;
import java.util.Set;

public class Disciplina {
	private String nome;
	private String codID;
	private int cargaHoraria;
	private Set <Aluno> alunos;
	
	public Disciplina(String nome, String codID, int cargaHoraria) {
		this.nome = nome;
		this.codID = codID;
		this.cargaHoraria = cargaHoraria;
		this.alunos = new HashSet<>();
	}
	public void matricularAluno(Aluno aluno) throws Exception {
		if(alunos.contains(aluno)) {
			throw new Exception ("Aluno já existe!");
		}
		alunos.add(aluno);	
	}
	public void desmatricularAluno(Aluno aluno) throws Exception {
		if(!alunos.contains(aluno)) {
			throw new Exception ("Aluno não existente!");
		}
		alunos.remove(aluno);
	}
	public String getNome() {
		return nome;
	}
	public boolean isalunoCadastrado(Aluno aluno) {
		return (alunos.contains(aluno));
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodID() {
		return codID;
	}

	public void setCodID(String codID) {
		this.codID = codID;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", codID=" + codID + ", cargaHoraria=" + cargaHoraria + ", alunos=" + alunos
				+ "]";
	}
	
	
}
