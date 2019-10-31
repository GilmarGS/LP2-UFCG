package colecoes;

public class Funcionarios {
	private String nome;
	private String cpf;
	private double salario;
	private String setor;
	
	public Funcionarios(String nome, String cpf, double salario, String setor) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.setor = setor;
	}
	

	public String toString() {
		return "Funcionarios [nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", setor=" + setor + "]";
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
}
