package lab05;
/**
 * Representacao de uma aposta assegurada por taxa. Toda aposta assegurada por taxa tem nome do
 * apostador, valor da aposta, previsao, taxa e cust0.
 * 
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */

public class ApostaAsseguradaTaxa extends Aposta {
	private double taxa;
	private int custo;
	private int valorAssegurado;
	private boolean asseguradaTaxa;
	
	/**
	 * @param novoApostador
	 *            O nome do novoApostador.
	 * @param novoValorAposta
	 *            O valor da aposta.
	 * @param novaPrevisao
	 *            A previsao da aposta
	 * @param novaTaxa
	 *            A taxa a ser manipulada.
	 * @param novoCusto
	 *            O custo da aposta assegurada        
	 */
	public ApostaAsseguradaTaxa(String novoApostador, int novoValorAposta, String novaPrevisao,double novaTaxa,int novoCusto) {
		super(novoApostador,novoValorAposta,novaPrevisao);
		
		this.taxa = novaTaxa;
		this.custo = novoCusto;
		this.valorAssegurado = (int) (super.getValorAposta() * taxa);
		asseguradaTaxa = true;
	}
	
	/**
	 * @param valor
	 *            O valor assegurado aposta assegurada      
	 * @return this.valorAssegurado
	 * 			  O valor assegurado.
	 */
	public int alterarSeguroValor(int valor) {
		asseguradaTaxa = false;
		this.valorAssegurado = valor;
		
		return this.valorAssegurado;
	}
	/**
	    * Recupera valor assegurado.
	    * 
	    * @return this.valorAssegurado
	    * 		 O valor assegurado.
	    */ 
	public int getValorAssegurado() {
		return this.valorAssegurado;
	}
	/**
	    * Recupera custo.
	    * 
	    * @return custo
	    * 		O custo da aposta
	    */ 
	public int getCusto() {
		return custo;
	}
	
	/**
	    * Verifica se a aposta eh assegurada por taxa;
	    * 
	    * @return asseguradaTaxa
	    * 		Valor booleano.
	    */ 
	public boolean ehAsseguradaTaxa() {
		return asseguradaTaxa;
	}

	/**
	 * Transforma os dados da aposta assegurada por valor em string.
	 *
	 * @return String com os dados da aposta.
	 */
	@Override
	public String toString() {
		if (asseguradaTaxa) {
			int taxaInt = (int) (this.taxa * 100);
			
			return super.toString() +" - ASSEGURADA (TAXA) -"+taxaInt+"%";
		} else {
			double valorAsseguradoReal = this.valorAssegurado / 100;
			 
			return super.toString() +" - ASSEGURADA (VALOR) - R$"+ String.format("%.2f", valorAsseguradoReal);
		}
		
	}
}

