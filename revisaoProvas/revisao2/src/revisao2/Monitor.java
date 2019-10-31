package  revisao2;

import java.util.ArrayList;
import java.util.List;

public class Monitor {
	private String nome;
	private String email;
	private List<Atividade> atividades;
	
	public Monitor(String nome, String email)  {
		this.nome = nome;
		this.email = email;
		this.atividades = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return nome + "-" + email;
	}
	
	public void cadastrarAtividadeAC(int horas, int qac) {
		Atividade atividade = new AC(horas, qac);
		cadastraAtividade(atividade);
	}

	public void cadastrarAtividadeEX(int horas, int qex) {
		Atividade atividade = new EX(horas, qex);
		cadastraAtividade(atividade);
	}

	public void cadastrarAtividadePROJ(int horas, int qpro) {
		Atividade atividade = new PROJ(horas, qpro);
		cadastraAtividade(atividade);
		
	}
	public void cadastraAtividade(Atividade atividade) {
		this.atividades.add(atividade);
	}

	public void cadastrarAtividadeTUTOR(int horas, int qtut) {
		Atividade atividade = new TUTOR(horas, qtut);
		cadastraAtividade(atividade);
		
	}
	
	public String imprimeAtividades(int posicao) {
		int contador = 0;
		String retorno = "";
		for(Atividade atividade : this.atividades) {
			if(contador == posicao) {
				 retorno += atividade.toString();
				 return retorno;
			}else {
				contador += 1;
			}
		}
		return retorno;
	}
	public int totalHorasAtividades() {
		int horas = 0;
		for(Atividade atividade : this.atividades) {
			horas += atividade.getHoras();
		}
		return horas;
	}
}
