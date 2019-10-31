package lab3;

/**
 * Classe responsavel por um contato.
 * 
 * @author Gilmar Gonzaga
 * @matricula 117210921
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;

	/**
	 * Constroi um contato com nome, sobrenome e telefone.
	 * 
	 * @param nome
	 *            cadastra o nome do contato.
	 * @param sobrenome
	 *            cadastra o sobrenome do contato.
	 * @param telefone
	 *            cadastra o telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}

	/**
	 * Metodo getter para o nome do contato.
	 * 
	 * @return retorna o nome cadastrado para o contato.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo setter para alterar o nome do contato.
	 * 
	 * @param nome
	 *            cadastra novo nome para o contato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo getter para o sobrenome do contato.
	 * 
	 * @return retorna o sobrenome cadastrado para o contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Metodo setter para alterar o sobrenome do contato.
	 * 
	 * @param sobrenome
	 *            cadastra novo sobrenome para o contato.
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Metodo getter para o telefone do contato.
	 * 
	 * @return retorna o telefone cadastrado para o contato.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo setter para alterar o telefone do contato.
	 * 
	 * @param telefone
	 *            cadastra novo telefone para o contato.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Representacao em String do nome, sobrenome e telefone do contato cadastrado.
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}
}
