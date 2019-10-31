package lab05;
/**
 * Representacao de uma aposta assegurada por taxa.
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */
public class SeguroTaxa extends Seguro {
	private int valorAposta;
	private double taxa;
	
	
	/**
	 *  Cria seguro a partir da taxa para calculo do valor assegurado
	 
	 * @param valorAposta
	 *            O valor da aposta.
	 * @param novaTaxa
	 *            A taxa a ser manipulada.
	 * @param novoCusto
	 *            O custo da aposta assegurada        
	 */
	public SeguroTaxa(int valorAposta,double novaTaxa,int novoCusto) {
		
		super(novoCusto);		
		
		this.valorAposta = valorAposta;
		this.taxa = novaTaxa;
	
	}

	/**
	    * Recupera valor assegurado.
	    * 
	    * @return this.valorAssegurado
	    * 		 O valor assegurado.
	    */
	@Override
	public int calculaValorAssegurado() {
		return (int) (valorAposta * this.taxa);
	}
	/**
	    * Recupera o tipo do seguro.
	    * 
	    * @return 
	    * 		 O tipo do seguro.
	    */
	@Override
	public String getTipo() {
		return "SeguroTaxa";
	}
	

	/**
	 * Transforma os dados da aposta assegurada por valor em string.
	 *
	 * @return String com os dados da aposta.
	 */
	@Override
	public String toString() {
			int taxaInt = (int) (this.taxa * 100);
			
			return super.toString() +" - ASSEGURADA (TAXA) -"+taxaInt+"%";
	
	}
}
