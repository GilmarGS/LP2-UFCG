package lab05;
/**
 * Representacao do seguro para uma aposta.
 * @author gilmar
 *
 */
public abstract class Seguro {

	protected int custo;
	/**
	 * Cria um seguro para aposta, com custo.
	 *
	 * @param novoCusto
	 *            O custo do seguro.
	 */
	public Seguro(int novoCusto) {
		this.custo = novoCusto;
		
	}
	/**
	    * Recupera valor assegurado.
	    * 
	    * @return this.valorAssegurado
	    * 		 O valor assegurado.
	    */
	abstract int calculaValorAssegurado();
	/**
	    * Recupera o tipo do seguro.
	    * 
	    * @return 
	    * 		 O tipo do seguro.
	    */
	abstract String getTipo();

	/**
	    * Recupera custo.
	    * 
	    * @return custo
	    * 		O custo da aposta
	    */ 
	public int getCusto() {
		return custo;
	}

}