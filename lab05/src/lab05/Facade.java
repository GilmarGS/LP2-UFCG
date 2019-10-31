package lab05;

import easyaccept.EasyAccept;

public class Facade {

	private SistemaDeApostas sistema; 
	public static void main(String[] args) {

		args = new String[] {"Facade", "testes_aceitacao/us1_test.txt"};
		EasyAccept.main(args);
	}

	/**
	 * Inicializa o sistem com um valor e taxa.
	 * 
	 * @param caixa
	 *            eh o valor disponivel no caixa.
	 * @param taxa
	 *            eh a taxa cobrada sobre as apostas.
	 */
	public void inicializa(int caixa, double taxa) {
		this.sistema = new SistemaDeApostas(caixa, taxa);
	}

	/**
	 * Cadastra cenario e retorma a numeracao do cenario cadastrado.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @return retorna a numeracao do cenario criado.
	 */
	public int cadastrarCenario(String descricao) {
		return this.sistema.cadastrarCenario(descricao);
	}

	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}

	public int getCaixa() {
		return sistema.getCaixa();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);

	}

	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalDeApostas(cenario);
	}

	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}
	
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
    	return 0;
    }
    
    public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	return 0;
    }
    
    public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	return 0;
    }

}
