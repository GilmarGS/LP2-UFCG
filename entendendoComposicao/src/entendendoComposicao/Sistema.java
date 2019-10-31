package entendendoComposicao;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
	private Map <String, Aluno> alunos;
	private Map <String, Disciplina> disciplinas;

	public Sistema() {
		this.alunos = new HashMap<>();
		this.disciplinas = new HashMap<>();
	}

	public void cadastraAluno(String nome, String matricula) throws Exception {
		Aluno aluno = new Aluno(nome, matricula);
		if(this.alunos.containsKey(matricula)) {
			throw new Exception ("Aluno já cadastrado!");
		}
		this.alunos.put(matricula, aluno);
	}
	public void removeAluno(String matricula) throws Exception {
		if(!this.alunos.containsKey(matricula)) {
			throw new Exception ("Matricula não cadastrada!");
		}
		this.alunos.remove(matricula);
	}
	public void cadastraDisciplina(String nome, String codID, int cargaHoraria) throws Exception {
		Disciplina disciplina = new Disciplina (nome, codID, cargaHoraria);
		if(this.disciplinas.containsKey(codID)) {
			throw new Exception ("Disciplina já cadastrada!");
		}
		this.disciplinas.put(codID, disciplina);
	}
	public void removeDisciplina(String codID) throws Exception {
		if(!this.disciplinas.containsKey(codID)) {
			throw new Exception ("Disciplina não cadastrada!");
		}
		this.disciplinas.remove(codID);
		}
	public void matriculaAluno(String matricula, String codID) throws Exception {
		Aluno aluno = retornaAluno(matricula);
		Disciplina disciplina = retornaDisciplina(codID);
		disciplina.matricularAluno(aluno);
	}
	public void desmatriculaAluno(String matricula, String codID) throws Exception {
		Aluno aluno = retornaAluno(matricula);
		Disciplina disciplina = retornaDisciplina(codID);
		disciplina.desmatricularAluno(aluno);
	}
	private Aluno retornaAluno(String matricula) {
		return(this.alunos.get(matricula));
		
	}
	private Disciplina retornaDisciplina(String codID) {
		return(this.disciplinas.get(codID));
	}
	public String exibirDisciplina(String codID) {
		return(retornaDisciplina(codID).toString());
	}
}

