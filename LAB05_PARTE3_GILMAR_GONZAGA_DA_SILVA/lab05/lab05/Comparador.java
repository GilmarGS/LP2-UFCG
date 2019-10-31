package lab05;

import java.util.Comparator;

public class Comparador implements Comparator<Cenario> {
	/**
	 * @param cenario1
	 *            Um cenario a ser comparado.
	 * @param cenario2
	 *            Outro cenario a ser comparado.
	 *            
	 *            Compara um cenario com o atual a partir do valor de apostas do cenario.
	 *            
	 * @return o inteiro que vai ser verificado para comparacao.
	 *
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2){
		
		return cenario2.totalDeApostas() - cenario1.totalDeApostas() ;
	}
}