package revisao1;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
	private Map<String, Aluno> alunos;

	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
	}
	public void cadastrarAluno(String nome, String matricula) {
		Aluno student = new Aluno(nome, matricula);
		this.alunos.put(matricula, student);
	}
	public void cadastrarAtividade(String matricula, String nome, String descricao) {
		this.alunos.get(matricula).cadastraAtividade(nome, descricao);
	}
	public String exibeAtividades(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		return aluno.todasAtividas();
	}
}
