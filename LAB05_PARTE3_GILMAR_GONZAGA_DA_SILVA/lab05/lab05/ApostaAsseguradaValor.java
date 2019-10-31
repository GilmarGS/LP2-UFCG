package lab05;
/**
 * Representacao de uma aposta assegurada por valor. Toda aposta assegurada por valor tem nome do
 * apostador, valor da aposta, previsao, valor do seguro e cust0.
 * 
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */
public class ApostaAsseguradaValor extends Aposta {
	private int valorAssegurado;
	private int custo;
	private boolean asseguradaValor;
	private double taxa = 0.0;
	/**
	 * @param novoApostador
	 *            O nome do novoApostador.
	 * @param novoValorAposta
	 *            O valor da aposta.
	 * @param novaPrevisao
	 *            A previsao da aposta
	 * @param novoValorAssegurado
	 *            O valor assegurado a ser manipulado.
	 * @param novoCusto
	 *            O custo da aposta assegurada        
	 */
	public ApostaAsseguradaValor(String novoApostador, int novoValorAposta, String novaPrevisao,int novoValorAssegurado,int novoCusto) {
		
		super(novoApostador,novoValorAposta,novaPrevisao);

		this.valorAssegurado = novoValorAssegurado;
		this.custo = novoCusto;
		asseguradaValor = true;
	}
	
	/**
	 * @param taxa
	 *           A taxa assegurada da aposta assegurada      
	 * @return this.valorAssegurado
	 * 			  O valor assegurado.
	 */
	public int alterarSeguroTaxa(double taxa) {
		asseguradaValor = false;
		this.valorAssegurado = (int) (super.getValorAposta() * taxa);
		this.taxa = taxa;
		
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
	    * Verifica se a aposta eh assegurada por taxa;
	    * 
	    * @return asseguradaTaxa
	    * 		Valor booleano.
	    */ 
	public boolean isAsseguradaValor() {
		return asseguradaValor;
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
	 * Transforma os dados da aposta assegurada por valor em string.
	 *
	 * @return String com os dados da aposta.
	 */
	@Override
	public String toString() {
		if (asseguradaValor) {
			double valorAsseguradoReal = this.valorAssegurado / 100;
			 
			return super.toString() +" - ASSEGURADA (VALOR) - R$"+ String.format("%.2f", valorAsseguradoReal);
		} else {
			int taxaInt = (int) (this.taxa * 100);
			
			return super.toString() +" - ASSEGURADA (TAXA) -"+taxaInt+"%";
		}
		
	}
}