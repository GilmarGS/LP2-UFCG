package lab2;

/**
 * Representa��o de uma cantina na universidade. Com nome, lanches que s�o vendidos 
 * e seus respectivos valores dados em centavos.
 * 
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */
public class ContaCantina {
	private String nomeCantina;
	private int itensConsumidos;
	private int valorPago;
	private String[] detalhes;
	private int controle;

	/** 
	 * Constr�i uma cantina, com a String nome, itens vendidos nela dado em inteiro e o valor dele
	 * tamb�m em inteiro
	 * .
	 * @param nomeCantina define em String o nome dado para cantina.
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
		this.itensConsumidos = 0;
		this.valorPago = 0;
		this.detalhes = criaDetalhesVazio();
		this.controle = 0;
	}

	/**
	 * @param qtdItens quantos itens foram consumidos na cantina.
	 * @param valorCentavos quanto custa cada item, valor informado � em centavos.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.itensConsumidos = itensConsumidos + qtdItens;
		this.valorPago = valorPago + valorCentavos;
	}

	/**
	 * @param qtdItens quantos itens foram consumidos na cantina.
	 * @param valorCentavos  quanto custa cada item, valor informado � em centavos.
	 * @param detalhes array de string que detalha o alimento consumido.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.itensConsumidos = itensConsumidos + qtdItens;
		this.valorPago = valorPago + valorCentavos;
		this.detalhes[this.controle] = detalhes;
		atualizacontrole();
	}

	/**
	 * atualiza a posi��o em que deve ser colocado a descri��o do alimento consumido, 
	 * variando entre as posi��es 0 e 4.
	 */
	private void atualizacontrole() {
		if (this.controle == 4) {
			this.controle = 0;
			return;			
		}
		this.controle += 1;

	}

	/**
	 * @return pega o nome da cantina e o retorna.
	 */
	public String getNomeCantina() {
		return nomeCantina;
	}

	/**
	 * @param valorCentavos vaalor em centavos pago pelos itens consumidos na cantina.
	 */
	public void pagaConta(int valorCentavos) {
		this.valorPago = valorPago - valorCentavos;
	}

	/**
	 * retuna a representa��o em string do nome da cantina, quantos itens o aluno consumiu 
	 * e quanto pagou no total.
	 */
	public String toString() {
		return this.nomeCantina + " " + this.itensConsumidos + " " + this.valorPago;
	}

	/**
	 * @return retorna cada detalhe adicionado ao item consumido no formato String
	 *         Array seguindo o exemplo "["bolo", "caf�", "lanchinho refor�ado",
	 *         "copo de coca","pastel"].
	 */
	private String[] criaDetalhesVazio() {
		String[] detalhes = {"", "", "", "", ""};
		return detalhes;
	}
	
	/**
	 * @return retorna os �ltimos cinco detalhes do que foi consumido pelo o aluno na cantina.
	 */
	public String listarDetalhes() {
		String retorno = "";
		for(int i = 0; i < this.detalhes.length; i++) {
			retorno += (i+1) + ":" + this.detalhes[i] + " ";
		}
		return retorno.trim();
	}
}

