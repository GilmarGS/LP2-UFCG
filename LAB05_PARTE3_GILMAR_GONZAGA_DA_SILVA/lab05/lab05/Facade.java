package lab05;

import easyaccept.EasyAccept;

public class Facade {

	SistemaDeApostas sistema;
	
	public static void main(String[] args) {
		args = new String[] {"lab05.Facade", "acceptance_test/us1_test.txt", 
				             "acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt",
				             "acceptance_test/us4_test.txt",  "acceptance_test/us5_test.txt",
				             "acceptance_test/us6_test.txt", "acceptance_test/us7_test.txt"};
		EasyAccept.main(args);
	}

	public void inicializa(int caixa, double taxa) {
		sistema = new SistemaDeApostas(caixa, taxa);
	}

	public int getCaixa() {
		return sistema.getCaixa();
	}

	public void cadastrarCenario(String descricao) {
		sistema.cadastrarCenario(descricao);
	}

	public void cadastrarCenario(String descricao, int bonus) {
		sistema.cadastrarCenario(descricao, bonus);
	}

	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		return sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
	}

	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao,double taxa, int custo) {
		return sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
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

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return sistema.alterarSeguroValor(cenario,apostaAssegurada,valor);
	}
	

	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return sistema.alterarSeguroTaxa(cenario,apostaAssegurada,taxa);
}

	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}
	public void alterarOrdem(String ordem) {
		sistema.alterarOrdem(ordem);
	}
	public String exibirCenarioOrdenado(int cenario) {
		return sistema.exibirCenarioOrdenado(cenario);
	}
}
