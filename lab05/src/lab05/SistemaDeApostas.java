package lab05;

import java.util.ArrayList;

/**
 * Esta classe eh referente as funcionalidades do sistema.
 * 
 * @author Gilmar Gonzaga Matricula: 117210921
 */


import java.util.ArrayList;
import java.util.Iterator;

public class SistemaDeApostas {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;

	public SistemaDeApostas(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.cenarios = new ArrayList<Cenario>();
		this.caixa = caixa;
		this.taxa = taxa;
	}

	public int getCaixa() {
		return this.caixa;
	}

	public void setCaixa(int valor) {
		verificaSetCaixaValido(valor);
		this.caixa = valor;
	}

	public double getTaxa() {
		return this.taxa;
	}

	public Cenario getCenario(int cenario) {
		verificaConsultaCenario(cenario);
		return cenarios.get(cenario - 1);
	}

	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenarios.size();
	}

	public String exibirCenario(int cenario) {
		verificaConsultaCenario(cenario);
		return cenario + " - " + getCenario(cenario).toString();
	}


	public String exibirCenarios() {
		String todosCenarios = "";
		Iterator<Cenario> itr = cenarios.iterator();
		while (itr.hasNext()) {
			Cenario cenario = itr.next();
			todosCenarios += cenario.toString() + "\n";
		}
		return todosCenarios;
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		verificaApostaCenario(cenario);
		Aposta aposta = new Aposta(apostador, valor, previsao);
		getCenario(cenario).adicionaAposta(aposta);
	}


	public int valorTotalDeApostas(int cenario) {
		verificaCenarioValorTotal(cenario);
		return getCenario(cenario).getValorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) {
		verificaTotalApostas(cenario);
		return getCenario(cenario).getQuantidadeDeApostas();
	}

	public String exibeApostas(int cenario) {
		return getCenario(cenario).exibeApostas();
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		verificaFecharAposta(cenario);
		getCenario(cenario).setEstado(ocorreu);
		this.caixa += getCaixaCenario(cenario);
	}

	public int getCaixaCenario(int cenario) {
		verificaGetCaixaCenario(cenario);
		return (int) (getCenario(cenario).calculaValorApostasPerdedoras() * getTaxa());
	}

	public int getTotalRateioCenario(int cenario) {
		verificaRateioCenario(cenario);
		return getCenario(cenario).calculaRateio(getTaxa());

	}
	
	public void verificaSetCaixaValido(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Erro: Caixa negativo");
		}
	}

	public void verificaConsultaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
	}

	public void verificaApostaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
	}
	
	public void verificaApostaSeguraCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
	}

	public void verificaCenarioValorTotal(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
	}

	public void verificaTotalApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
	}

	public void verificaFecharAposta(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == true) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
	}

	public void verificaGetCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == false) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
	}

	public void verificaRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == false) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
	}
	

}

