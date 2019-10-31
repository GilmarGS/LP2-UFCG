package lab05;

/**
 * Representa um cenario bonus cadastrado no sistema.
 * 
 * @author Gilmar Gonzaga da Silva - 117210921
 *
 */
public class CenarioBonus extends Cenario {
	private int bonus;
	/**
	 * Cria um cenario bonus com uma descricao,colecao de apostas e bonus.
	 *
	 * @param novaDescricao
	 *            A descricao do cenario.
	 * @param novoBonus
	 *            O bonus do cenario.
	 * @param novoCenario
	 *             Identificacao do cenario.
	 */
	public CenarioBonus(String descricao,int novoCenario, int novoBonus) {
		super(descricao, novoCenario);
		if (novoBonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}

		this.bonus = novoBonus;
	}
	
	/**
	 * Recupera valor total de apostas perdedoras mais o bonus para ser calculado o valor a ser rateiado 
	 * entre os ganhadores.
	 *
	 * @return valor total de apostas perdedoras.
	 */
	@Override
	public int getTotalRateioCenario() {
		return (super.getTotalRateioCenario() + bonus);
	}

	/**
	 * Recupera o bonus do cenario.
	 *
	 * @return O bonus do cenario.
	 */
	public double getBonus() {
		return bonus;
	}
	/**
	 * Transforma os dados do cenario com bonus em string.
	 *
	 * @return String com os dados do cenario com bonus.
	 */
	@Override
	public String toString() {
		double bonusEmReal = bonus / 100.00;
		
		String resultado = String.format("%.2f", bonusEmReal);

		return super.toString() +" - R$ "+ resultado;
	}

}

