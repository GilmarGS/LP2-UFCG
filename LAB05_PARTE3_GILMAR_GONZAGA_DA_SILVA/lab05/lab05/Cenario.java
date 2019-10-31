package lab05;
/**
* Representacao de um cenario cadastrado no Sistema, todo
* cenario no sistema tem um estado, descricao e colecao de apostas.
* 
* @author Gilmar Gonzaga da Silva - 117210921
*/
import java.util.ArrayList;

public class Cenario implements Comparable<Cenario> {
	private EstadoCenario estado = EstadoCenario.NAO_FINALIZADO;
	private int cenario;
	private String descricao;

	private ArrayList<Aposta> apostas;

	/**
	 * Cria um cenario com uma descricao e uma colecao de apostas.
	 *
	 * @param novaDescricao
	 *            A descricao do cenario.
	 * @param novoCenario
	 *            Identificacao do cenario.
	 * 
	 */
	public Cenario(String novaDescricao, int novoCenario) {
		if (novaDescricao.equals("") || novaDescricao.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		} else if (novaDescricao.equals(null)) {
			throw new NullPointerException("novoApostador nulo");
		}
		this.descricao = novaDescricao;
		this.cenario = novoCenario;
		apostas = new ArrayList<>();
	}
	/**
	 * @param outroCenario
	 *            O cenario a ser comparado.
	 * 
	 *            Compara um cenario com o atual a partir da descricao do cenario.
	 *            
	 * @return o inteiro que vai ser verificado para comparacao.
	 *
	 */
	@Override
	public int compareTo(Cenario outroCenario){
	    return this.descricao.compareTo(outroCenario.getDescricao());
	}
	/**
	 * Recupera a descricao do cenario.
	 *
	 * @return A descricao do cenario.
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * Recupera o estado do cenario.
	 *
	 * @return O estado do cenario.
	 */
	public String getEstado() {
		return this.estado.getEstadoCenario();
	}

	/**
	 * @param aposta
	 *            A aposta a ser adicionada.
	 * 
	 *            Adiciona aposta na colecao de apostas.
	 *
	 */
	public void adicionaAposta(Aposta aposta) {
		apostas.add(aposta);

	}
	/**
	 * @param aposta
	 *            A aposta a ser adicionada.
	 * 
	 *            Adiciona aposta assegurada na colecao de apostas.
	 * @return o numero q identifica  aposta
	 *
	 */
	public int adicionaApostaComSeguro(Aposta aposta) {
		apostas.add(aposta);
		
		return apostas.size() + 1;
	}

	/**
	 * Recupera valor total de apostas.
	 *
	 * @return valor total de apostas.
	 */
	public int valorTotalDeApostas() {
		int valorTotal = 0;
		for (Aposta aposta : apostas) {
			valorTotal += aposta.getValorAposta();
		}
		return valorTotal;
	}

	/**
	 * Recupera total de apostas.
	 *
	 * @return total de apostas.
	 */
	public int totalDeApostas() {
		return apostas.size();
	}

	/**
	 * Exibe representacao em string das apostas.
	 *
	 * @return listagem de apostas.
	 */
	public String exibeApostas() {
		String listagemApostas = "";
		for (Aposta aposta : apostas) {
			listagemApostas += (aposta.toString() + "\n");
		}
		return listagemApostas;
	}
	/**
	 * @param apostaAssegurada
	 *            A identificacao da aposta assegurada.
	 * @param valor
	 *            O valor assegurado aposta assegurada 
	 * @return valorAssegurado       
	 */
	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		int custo = apostas.get(apostaAssegurada - 1).seguro.getCusto();
		
		return  apostas.get(apostaAssegurada - 1).alterarSeguroValor(valor,custo);
		
	}
	/**
	 * @param apostaAssegurada
	 *            A identificacao da aposta assegurada.
	 * @param taxa
	 *            O valor da taxa aposta assegurada 
	 * @return valorAssegurado              
	 */
	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		int custo = apostas.get(apostaAssegurada - 1).seguro.getCusto();
		
		return apostas.get(apostaAssegurada - 1).alterarSeguroTaxa(taxa,custo);
		
	}
	/**
	 * @param ocorreu
	 *            O valor booleano que indica se o cenario ocorreu.
	 *
	 *            Fecha cenario e altera o estado.
	 *
	 */
	public void fecharAposta(boolean ocorreu) {
		if (!estado.equals(EstadoCenario.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if (ocorreu == true) {
			this.estado = EstadoCenario.FINALIZADO_TRUE;
		} else {
			this.estado = EstadoCenario.FINALIZADO_FALSE;
		}
	}

	/**
	 * Recupera valor total de apostas perdedoras para ser multiplicada pela taxa e adicionada ao caixa.
	 *
	 * @return valor total de apostas perdedoras.
	 */
	public int getCaixaCenario() {
		if (estado.equals(EstadoCenario.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}

		int valorTotalPerdedores = 0;
		for (Aposta aposta : apostas) {
			if (aposta.valorPrevisao() != valorEstado()) {
				valorTotalPerdedores += aposta.getValorAposta();
			}
		}
		return valorTotalPerdedores;
	}

	/**
	 * @param ocorreu
	 *            O valor booleano que indica se o cenario ocorreu.
	 * 
	 *           Soma valores assegurados das apostas com seguro.
	 * @return valoresAssegurados
	 * 			Os valoresAssegurados.
	 *
	 */
	public int somaValoresAssegurados(boolean ocorreu) {
		int valoresAssegurados = 0;
		for (Aposta aposta : apostas) {
			if (aposta.valorPrevisao() != ocorreu && aposta.getTemSeguro()) {
				valoresAssegurados += aposta.seguro.calculaValorAssegurado();	
			}
		}
		return valoresAssegurados;
		
	}
	/**
	 * Recupera valor total de apostas perdedoras para ser calculado o valor a ser rateiado entre os ganhadores.
	 *
	 * @return valor total de apostas perdedoras.
	 */
	public int getTotalRateioCenario() {
		return getCaixaCenario();
	}

	/**
	 * Verifica igualdade da string caracteristica do estado do cenario.
	 *
	 * @return Validade booleana da igualdade.
	 */
	public boolean valorEstado() {
		if (estado.getEstadoCenario().equals("Finalizado (ocorreu)")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param aposta
	 *            A aposta a ser verificada.
	 * 
	 *            Verifica existencia de aposta.
	 *
	 * @return Validade booleana da existencia.
	 */
	public boolean verificaExistenciaAposta(Aposta aposta) {
		return apostas.contains(aposta);
	}
	/**
	 *@param posicao
	 *            A posicao da aposta a ser recuperada.
	 * Recupera uma aposta no cenario.
	 *
	 * @return Uma aposta no cenario.
	 */
	public Aposta getAposta(int posicao) {
		return apostas.get(posicao - 1);
	}

	/**
	 * Transforma os dados do cenario em string.
	 *
	 * @return String com os dados do cenario.
	 */
	@Override
	public String toString() {
		return this.cenario+" - " + descricao + " - " + estado.getEstadoCenario();
	}
	/**
	 * Identificacao numerica do cenario.
	 *
	 * @return A Identificacao numerica do cenario.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}
	/**
	 * @param obj
	 * 		O objeto a ser comparado a igualdade.
	 * 
	 * Compara igualdade entre cenario a partir da descricao.
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
		Cenario other = (Cenario) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}