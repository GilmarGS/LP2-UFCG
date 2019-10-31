package revisao1;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private String matricula;
	private List<Atividade> atividades;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.atividades = new ArrayList<Atividade>();
	}
	public String toString() {
		return this.nome + " - " + this.matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void cadastraAtividade(String nome, String descricao) {
		Atividade atv = new Atividade(nome, descricao);
		this.atividades.add(atv);
	}
	public int numeroDeAtividadesCadastrado() {
		return this.atividades.size();
	}
	public String todasAtividas() {
		String retorno = "";
		for (Atividade atv : this.atividades) {
			retorno += atv.toString()+"\n";
		}
		return retorno;
	}
}
