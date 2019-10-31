package revisao3;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String matricula;
	private String nome;
	private String periodo;
	private List<Atividade> atividades;
	
	public Aluno(String matricula, String nome, String periodo) {
		this.matricula = matricula;
		this.nome = nome;
		this.periodo = periodo;
		this.atividades = new ArrayList<Atividade>();
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getPeriodo() {
		return periodo;
	}
	
	public String toString() {
		return this.matricula + " --- " + this.nome + " --- " + this.periodo;
	}
	
	public void cadastrarAC(String nome, String tipo, int qtdade) {
		Atividade atividade;
		switch (tipo) {
		case "PPPD":
			atividade = new PPPD(nome, qtdade);
			this.atividades.add(atividade);
			break;
		case "PM":
			atividade = new PM(nome, qtdade);
			this.atividades.add(atividade);
			break;
		case "PE":
			atividade = new PE(nome, qtdade);
			this.atividades.add(atividade);
		default:
			break;
		}
	}

	public List<String> consultaAC() {
		List<String> retorno = new ArrayList<String>();
		for(Atividade atividade : this.atividades) {
			retorno.add(atividade.toString());
		}
		return retorno;
	}
}
