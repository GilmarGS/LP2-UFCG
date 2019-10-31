package lab05;

import java.util.ArrayList;

public class Cenario {

	private String descricao;
	private String estado;
	private ArrayList<Aposta> apostas;

	public Cenario(String descricao) {
		verificaDescricao(descricao);
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<>();
	}
	
	public String exibeApostas() {
		String todasApostas = "";
		for (Aposta aposta : this.apostas) {
			todasApostas += aposta.toString() + "\n";
		}
		return todasApostas;
	}


	public void adicionaAposta(Aposta aposta) {
		this.apostas.add(aposta);
	}

	public int calculaValorApostasPerdedoras() {
		int soma = 0;
		if (this.estado.equals("Finalizado (ocorreu)")) {
			for (Aposta aposta : this.apostas) {
				if (aposta.getPrevisao().equals("N VAI ACONTECER")) {
					soma += aposta.getValor();
				}
			}

		} else if (this.estado.equals("Finalizado (n ocorreu)")) {
			for (Aposta aposta : this.apostas) {
				if (aposta.getPrevisao().equals("VAI ACONTECER")) {
					soma += aposta.getValor();
				}
			}

		}
		return soma;
	}
	
	public int calculaRateio(double taxa) {
		return (int) (calculaValorApostasPerdedoras() - (calculaValorApostasPerdedoras() * taxa)) ;
	}

	@Override
	public String toString() {
		return this.descricao + " - " + this.estado;
	}

	public String getDescricao(){
		return this.descricao;
	}

	public String getEstado(){
		return this.estado;
	}

	public int getQuantidadeDeApostas() {
		return this.apostas.size();
	}
	

	public int getValorTotalDeApostas() {
		int soma = 0;
		for (Aposta aposta : this.apostas) {
			soma += aposta.getValor();
		}
		return soma;
	}
	

	public void setEstado(boolean ocorreu) {
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (n ocorreu)";
		}
	}


	public void verificaDescricao(String descricao) {
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
	}


	public boolean verificaCenarioFechado() {
		return !this.estado.equals("Nao finalizado");
	}
}
