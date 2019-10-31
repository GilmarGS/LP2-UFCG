package refazendoProvaLp2162;

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
	public void cadastrarAtividade(String nome, int qtdade, String tipo) {
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
			break;
		default:
			break;
		}
	}
	public List<String> consultaAtividade(){
		List<String> retorno = new ArrayList<String>();
		for(Atividade atv : this.atividades) {
			retorno.add(atv.toString());
		}
		return retorno;
	}

	public int calculaCredito() {
		int creditoPPPD = 0;
		int creditoPM = 0;
		int creditoPE = 0;
		
		for(Atividade atividade : this.atividades) {
			if(atividade.getTipo().equals(EnumAtividades.PPPD)) {
				creditoPPPD += atividade.converteEmCredito();
			} else if (atividade.getTipo().equals(EnumAtividades.PM)) {
				creditoPM += atividade.converteEmCredito();
			}else if (atividade.getTipo().equals(EnumAtividades.PE)) {
				creditoPE += atividade.converteEmCredito();
			}
		}
		return Math.min(creditoPPPD, 4) + Math.min(creditoPM, 6) + Math.min(creditoPE, 2);
	}
}
