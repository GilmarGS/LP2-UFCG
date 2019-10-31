package lab05;
/**
 * Representacao de um estado do cenario
 * 
 * @author Gilmar Gonzaga da Silva
 *
 */
public enum EstadoCenario {
	FINALIZADO_TRUE("Finalizado (ocorreu)"), NAO_FINALIZADO("Nao finalizado"), FINALIZADO_FALSE(
			"Finalizado (n ocorreu)");

	private String estado;

	/**
	 *
	 * @param novoEstado
	 *            A descricao do estado.
	 * 
	 */
	private EstadoCenario(String novoEstado) {
		this.estado = novoEstado;
	}

	/**
	 * Recupera o estado do cenario.
	 *
	 * @return O estado do cenario.
	 */
	public String getEstadoCenario() {
		return estado;
	}

}
