package lab3;

/**
 * Classe responsael por criar o objeto contato.
 * 
 * @author Gilmar Gonzaga
 * @matricula 117210921
 */
public class Agenda {
	private Contato[] contatos;

	/**
	 * O construtor instacia o objeto contato do tipo Contato com array de 100
	 * posicoes.
	 */
	public Agenda() {
		contatos = new Contato[100];
	}

	/**
	 * Esse metodo verifica se a posicao informada esta dentro das posicoes
	 * existentes dentro do array para criar um novo contato. Caso não esteja o
	 * tratamento de excecao exibe uma mensagem informado que a posicao eh inavlida.
	 * 
	 * @param contato
	 *            cadastra um contato com nome, sobrenome e telefone.
	 * @param posicao
	 *            informa a posicao em que o contato sera criado dentro do array.
	 * @throws Exception
	 *             se a posicao nao existir o programa exibe mensagem para o usuario
	 *             informando que a posicao nao e valida.
	 */
	public void cadastrarContato(Contato contato, int posicao) throws Exception {
		if (posicao < 1 || posicao > 100) {
			throw new Exception("POSIÇÃO INVÁLIDA!");
		}
		contatos[posicao - 1] = contato;
	}

	/**
	 * Esse metodo busca um contato cadastrado atraves da posicao informada.
	 * 
	 * @param posicao
	 *            deve ser um numero inteiro maior que 1 e menor que 100.
	 * @return retorna o contato cadastrado na posicao indicada.
	 * @throws Exception
	 *             se a posicao informada for diferente do esperado, o programa
	 *             informa que a posicao nao e valida.
	 */
	public Contato retornaContato(int posicao) throws Exception {
		if (posicao < 1 || posicao > 100) {
			throw new Exception("POSIÇÃO INVÁLIDA!");
		}
		Contato contato = contatos[posicao - 1];
		return contato;
	}

	/**
	 * Metodo para listar todos os contatos cadastrados.
	 * 
	 * @return retorna a lista de todos os contatos cadastrados, da seguinte forma:
	 *         posicao em que foi cadastrado, nome e sobrenome.
	 */
	public String listaContatos() {
		String retorno = "";
		for (int i = 0; i < 100; i++) {
			if (contatos[i] != null) {
				Contato contato = contatos[i];
				int posicao = i + 1;
				retorno += posicao + " - " + contato.getNome() + " " + contato.getSobrenome() + "\n";
			}
		}
		return retorno;
	}
}
