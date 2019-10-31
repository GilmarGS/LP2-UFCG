package lab05;


public class Aposta {

	private String nomeApostador, previsao;
	private int valorAposta;

	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		verificaApostadorVazioNulo(nomeApostador);
		verificaApostaValida(valorAposta);
		verificaPrevisaoValida(previsao);
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}


	public String toString() {
		return this.nomeApostador + " - " + "R$" + String.format("%.2f", (this.valorAposta) / 100.0) + " - "
				+ this.previsao;
	}


	public int getValor() {
		return this.valorAposta;
	}


	public String getNomeApostador() {
		return this.nomeApostador;
	}


	public String getPrevisao() {
		return this.previsao;
	}


	public void verificaApostadorVazioNulo(String apostador) {
		if (apostador.trim().equals("") || apostador == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
	}


	public void verificaApostaValida(int aposta) {
		if (aposta <= 0) {
			throw new NullPointerException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
	}


	public void verificaPrevisaoValida(String previsao) {
		if (previsao.trim().equals("") || previsao == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}
}

