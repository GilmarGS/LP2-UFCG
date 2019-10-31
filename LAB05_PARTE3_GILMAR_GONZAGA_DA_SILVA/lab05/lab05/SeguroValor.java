package lab05;
/**
 * Representacao de uma aposta assegurada no valor.
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */
public class SeguroValor extends Seguro {
	private int valorAssegurado;
	
	/**
	 * Cria seguro a partir do valor assegurado
	 * 
	 * @param novoValorAssegurado
	 *            O valor assegurado a ser manipulado.
	 * @param novoCusto
	 *            O custo da aposta assegurada        
	 */
	public SeguroValor(int novoValorAssegurado,int novoCusto) {
		super(novoCusto);
		
		this.valorAssegurado = novoValorAssegurado;
	}
	/**
	    * Recupera valor assegurado.
	    * 
	    * @return this.valorAssegurado
	    * 		 O valor assegurado.
	    */
	@Override
	public int calculaValorAssegurado() {
		return this.valorAssegurado;
	}
	/**
	    * Recupera o tipo do seguro.
	    * 
	    * @return 
	    * 		 O tipo do seguro.
	    */
	@Override
	public String getTipo() {
		return "SeguroValor";
	}
	
	

	/**
	 * Transforma os dados da aposta assegurada por valor em string.
	 *
	 * @return String com os dados da aposta.
	 */
	@Override
	public String toString() {
			double valorAsseguradoReal = this.valorAssegurado / 100;
			 
			return super.toString() +" - ASSEGURADA (VALOR) - R$"+ String.format("%.2f", valorAsseguradoReal);
		
	}
}

