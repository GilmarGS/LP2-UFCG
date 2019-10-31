package lab05;
/**
 * Responsavel por armazenar a colecao de cenarios, inicializar o caixa do sistema e
 * estipular um valor para taxa.
 * 
 * @author Gilmar Gonzaga da Silva - 117210921
 */
import java.util.ArrayList;
import java.util.Collections;

public class SistemaDeApostas {
	private int caixa;
	private double taxa = 0.0;
	private int cenario = 1;

	private ArrayList<Cenario> cenarios;
	private ArrayList<Cenario> cenariosOrdenados;

	/**
	 * Constroi caixa, taxa e colecao de cenarios.
	 * 
	 * @param novoCaixa
	 *            constroi caixa do sistema.
	 * @param novaTaxa
	 *            constroi taxa do sistema.
	 */
	public SistemaDeApostas(int novoCaixa, double novaTaxa) {
		if (novoCaixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		} else if (novaTaxa < 0.0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.taxa = novaTaxa;
		this.caixa = novoCaixa;
		this.cenarios = new ArrayList<>();
		this.cenariosOrdenados = new ArrayList<>(this.cenarios);
	}

	/**
	 * Recupera valor de caixa.
	 *
	 * @return caixa.
	 */
	public int getCaixa() {
		return caixa;
	}

	/**
	 * @param descricao
	 *            A descricao do cenario.
	 * 
	 *            Cria cenario e o cadastra na colecao.
	 *
	 */
	public void cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao,this.cenario);
		cenarios.add(cenario);
		this.cenario ++;
	}
	/**
	 * @param descricao
	 *            A descricao do cenario.
	 * @param bonus
	 *            O bonus do cenario.
	 *           
	 *            Cria cenario com bonus e o cadastra na colecao.
	 *
	 */
	public void cadastrarCenario(String descricao, int bonus) {
		caixa -= bonus;

		CenarioBonus cenarioBonus = new CenarioBonus(descricao,cenario, bonus);
		cenarios.add(cenarioBonus);
		this.cenario ++;
		
	}
	/**
	 * @param ordem
	 *            A forma de ordenacao de cenarios requerida.
	 */
	public void alterarOrdem(String ordem) {
		if (ordem.equals("") || ordem.trim().length() == 0 ) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		} else if (ordem.equals("nome")) {
			this.cenariosOrdenados = new ArrayList<>(this.cenarios);
			Collections.sort(this.cenariosOrdenados);
		} else if (ordem.equals("apostas")) {
			Comparador comparadorPorValor = new Comparador() ;
			this.cenariosOrdenados = new ArrayList<>(this.cenarios);
			Collections.sort(this.cenariosOrdenados,comparadorPorValor);
		} else if (ordem.equals("cadastro")) {
			this.cenariosOrdenados = new ArrayList<>(this.cenarios);
		} else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
		 
	}
	/**
	 * @param cenario
	 *            A identificacao do cenario.
	 * @return representacao string do cenario.  
	 */
	public String exibirCenarioOrdenado(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		
		if (this.cenariosOrdenados.isEmpty()) {
			this.cenariosOrdenados = new ArrayList<>(this.cenarios);
		}
		
		
		return this.cenariosOrdenados.get(cenario - 1).toString();
	}

	/**
	 * @param cenario
	 *            O numero do cenario.
	 * 
	 *            Recupera o cenario.
	 *
	 * @return Recuperacao em string do cenario.
	 */
	public String exibirCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta de cenario: Cenario nao cadastrado");
		}

		return this.cenarios.get(cenario - 1).toString();
	}

	/**
	 * Recupera listagem de cenarios.
	 *
	 * @return Recuperacao em string dos cenarios.
	 */
	public String exibirCenarios() {

		String listagemCenarios = "";
		for (Cenario cenario : cenarios) {
			listagemCenarios += (cenario.toString() + "\n");

		}
		return listagemCenarios;
	}

	/**
	 * @param cenario
	 *            O cenanio a ser exibido.
	 * @param apostador
	 *            O nome do apostador.
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsao da aposta.
	 * 
	 *            Identifica o cenario e cadastra aposta.
	 * @return identificacao da aposta.           
	 *
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		} else if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		} else if (previsao.equals("") || previsao.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

		Aposta aposta = new Aposta(apostador, valor, previsao);
		cenarios.get(cenario - 1).adicionaAposta(aposta);
	}
	/**
	 * @param cenario
	 *            O cenanio a ser exibido.
	 * @param apostador
	 *            O nome do apostador.
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsao da aposta.
	 * @param cenario
	 *            O cenario a ser manipulado.
	 * @param valorAssegurado
	 *            O valor assegurado da aposta assegurada.
	 * @param custo
	 *            O custo aposta assegurada  
	 *@return identificacao da aposta.                  
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		} else if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		} else if (previsao.equals("") || previsao.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		} else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		} else if (apostador.equals("") || apostador.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		
		Aposta aposta = new Aposta(apostador, valor, previsao);
		caixa += custo;
		
		aposta.cadastraSeguroValor(valorAssegurado, custo);
		
		return cenarios.get(cenario - 1).adicionaApostaComSeguro(aposta);
	}
	/**
	 * @param cenario
	 *            O cenanio a ser exibido.
	 * @param apostador
	 *            O nome do apostador.
	 * @param valor
	 *            O valor da aposta.
	 * @param previsao
	 *            A previsao da aposta.
	 * @param cenario
	 *            O cenario a ser manipulado.
	 * @param taxa
	 *            A taxa da aposta assegurada.
	 * @param custo
	 *            O custo aposta assegurada  
	 *@return identificacao da aposta.                  
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao,double taxa, int custo) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		} else if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		} else if (previsao.equals("") || previsao.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		} else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		} else if (apostador.equals("") || apostador.trim().length() == 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
	
		Aposta aposta = new Aposta(apostador, valor, previsao);
		
		caixa += custo;
		
		aposta.cadastraSeguroTaxa(taxa, custo);
	
		return cenarios.get(cenario - 1).adicionaApostaComSeguro(aposta);
	}
	
	

	/**
	 * @param cenario
	 *            O numero do cenario.
	 * 
	 *            Recupera valor total de apostas.
	 *
	 * @return total de valor apostado.
	 */
	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return cenarios.get(cenario - 1).valorTotalDeApostas();
	}

	/**
	 * @param cenario
	 *            O numero do cenario.
	 * 
	 *            Recupera a quantidade de apostas.
	 *
	 * @return total de apostas.
	 */
	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return cenarios.get(cenario - 1).totalDeApostas();

	}

	/**
	 * @param cenario
	 *            O numero do cenario.
	 * 
	 *            Recupera aposta.
	 *
	 * @return representacao em string da aposta.
	 */
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario - 1).exibeApostas();
	}

	/**
	 * @param cenario
	 *            O numero do cenario.
	 * @param ocorreu
	 *            O valor booleano que indica se o cenario ocorreu.
	 * 
	 *            Encerra cenario dizendo estado.
	 *
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		cenarios.get(cenario - 1).fecharAposta(ocorreu);
		
		this.caixa += (int) (cenarios.get(cenario - 1).getCaixaCenario() * this.taxa);
		
		this.caixa -= cenarios.get(cenario - 1).somaValoresAssegurados(ocorreu); // nao ta pegando
	}
	/**
	 * @param cenario
	 *            O cenario a ser manipulado.
	 * @param apostaAssegurada
	 *            A identificacaoo da aposta assegurada.
	 * @param valor
	 *            O valor assegurado aposta assegurada     
	 * @return valorAssegurado.                 
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		
		return cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada - 1,valor);
	}
	/**
	 * @param cenario
	 *            O cenario a ser manipulado.
	 * @param apostaAssegurada
	 *            A identificacao da aposta assegurada.
	 * @param taxa
	 *            O valor da taxa aposta assegurada
	 * @return valorAssegurado.                     
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		
		return cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada - 1,taxa);
	}
	/**
	 * @param cenario
	 *            O numero do cenario.
	 * 
	 *            Recupera a subtracao do valor das apostas perdedoras pela
	 *            taxa.
	 *
	 *
	 * @return valor a ser adicionado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}

		return (int) (cenarios.get(cenario - 1).getCaixaCenario() * this.taxa);
	}

	
	/**
	 * @param cenario
	 *            O numero do cenario. Subtrai o valor total de apostas
	 *            perdedoras pela quantia que sera adicionado ao caixa
	 *
	 * @return total de valor a rateiar.
	 */
	public int getTotalRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (cenario - 1 >= cenarios.size()) {
			throw new IndexOutOfBoundsException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		} else if ((cenarios.get(cenario - 1).getEstado()).equals("Nao finalizado")) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		int valorTotalPerdedores = (cenarios.get(cenario - 1).getTotalRateioCenario());

		int valorGetCaixaCenario = (int) (cenarios.get(cenario - 1).getCaixaCenario() * this.taxa);

		return (valorTotalPerdedores - valorGetCaixaCenario);
	}

	/**
	 * Verifica quantidade de cenarios.
	 *
	 * @return total de cenarios.
	 */
	public int verificaTotalCenarios() {
		return cenarios.size();
	}

}