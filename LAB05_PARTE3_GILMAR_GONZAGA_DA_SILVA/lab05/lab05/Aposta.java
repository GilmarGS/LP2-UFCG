package lab05;

/**
 * Representa uma aposta cadastrada no sistema, com nome do apostador, valor da
 * aposta e previsao.
 * 
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */
public class Aposta {
	private String apostador;
	private int valorAposta;
	private String previsao;
	
	protected Seguro seguro; 
	
	private boolean temSeguro = false; 
	
	/**
	 * Cria uma aposta com apostador, valor e previsao.
	 *
	 * @param novoApostador
	 *            O nome do novoApostador.
	 * @param novoValorAposta
	 *            O valor da aposta.
	 * 
	 * @param novaPrevisao
	 *            A previsao da aposta
	 */
	public Aposta(String novoApostador, int novoValorAposta, String novaPrevisao) {
		if (novoApostador.equals("") || novoApostador.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (novaPrevisao.equals("") || novaPrevisao.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		} else if (novoApostador.equals(null)) {
			throw new NullPointerException("novoApostador nulo");
		} else if (novaPrevisao.equals(null)) {
			throw new NullPointerException("novaPrevisao nula");
		}

		this.apostador = novoApostador;
		this.valorAposta = novoValorAposta;
		this.previsao = novaPrevisao;
	}
	
	/**
	 * @param valorAssegurado
	 *            O valor assegurado da aposta.
	 * @param custo
	 *            O custo da aposta.
	 */
	public void cadastraSeguroValor(int valorAssegurado,int custo) {
		seguro = new SeguroValor(valorAssegurado,custo);
		temSeguro = true;
	}
	/**
	 * @param taxa
	 *            A taxa da aposta.
	 * @param custo
	 *            O custo da aposta.
	 */
	public void cadastraSeguroTaxa(double taxa,int custo) {
		seguro = new SeguroTaxa(this.valorAposta,taxa,custo);
		temSeguro = true;
	}

	/**
	 * Recupera o valor da aposta.
	 *
	 * @return O valor da aposta.
	 */
	public int getValorAposta() {
		return valorAposta;
	}

	/**
	 * Recupera a previsao da aposta.
	 *
	 * @return A previsao da aposta.
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * Recupera o nome do apostador.
	 *
	 * @return O nome do apostador.
	 */
	public String getApostador() {
		return apostador;
	}
	/**
	 * Recupera se aposta tem seguro.
	 *
	 * @return Boolean que indica se aposta tem seguro.
	 */
	public boolean getTemSeguro() {
		return this.temSeguro;
	}
	/**
	 * @param valor
	 *            O valor assegurado aposta assegurada  
	 * @param custo
	 *            O custo da aposta.
	 *            
	 * @return this.valorAssegurado
	 * 			  O valor assegurado.
	 */
	public int alterarSeguroValor(int valor,int custo) {
		seguro = new SeguroValor(valor,custo);
		
		return seguro.calculaValorAssegurado();
	}
	
	/**
	 * @param taxa
	 *           A taxa assegurada da aposta assegurada   
	 * @param custo
	 *            O custo da aposta.
	 *                          
	 * @return this.valorAssegurado
	 * 			  O valor assegurado.
	 */
	public int alterarSeguroTaxa(double taxa,int custo) {
		seguro = new SeguroTaxa(this.valorAposta,taxa,custo);
		
		
		return seguro.calculaValorAssegurado();
	}
	/**
	 * Verifica previsao da aposta.
	 *
	 * @return Validade booleana da indicando caracteristica da aposta.
	 */
	public boolean valorPrevisao() {
		if (previsao.equals("VAI ACONTECER")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Identificacao numerica da aposta.
	 *
	 * @return A Identificacao numerica da aposta.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostador == null) ? 0 : apostador.hashCode());
		result = prime * result + ((previsao == null) ? 0 : previsao.hashCode());
		result = prime * result + valorAposta;
		return result;
	}
	/**
	 * @param obj
	 * 		O objeto a ser comparado a igualdade.
	 * 
	 * Compara igualdade entre aposta a partir do apostador e previsao.
	 *
	 * @return valor da comparacao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (apostador == null) {
			if (other.apostador != null)
				return false;
		} else if (!apostador.equals(other.apostador))
			return false;
		if (previsao == null) {
			if (other.previsao != null)
				return false;
		} else if (!previsao.equals(other.previsao))
			return false;
		if (valorAposta != other.valorAposta)
			return false;
		return true;
	}


	/**
	 * Transforma os dados da aposta em string verificando se a aposta contem seguro e caso contenha o seu tipo.
	 *
	 * @return String com os dados da aposta.
	 */
	@Override
	public String toString() {
		double valorApostaEmReal = valorAposta / 100;
		String resultado = String.format("%.2f", valorApostaEmReal);
		
		if (this.temSeguro && seguro.getTipo().equals("SeguroValor")) {
			
			double valorAsseguradoReal = seguro.calculaValorAssegurado() / 100;
			 
			return apostador + " - " +"R$"+ resultado + " - " + previsao+" - ASSEGURADA (VALOR) - R$"+ String.format("%.2f", valorAsseguradoReal);
	
		} else {
			
			return apostador + " - " +"R$"+ resultado + " - " + previsao;
		}
	}
	
		
}