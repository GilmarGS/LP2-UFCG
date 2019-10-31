package colecoes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmpresaFilial {
	private String nome;
	private String cidade;
	private String estado;
	private String cod;
	private Set<Funcionarios> funcionarios;
	public EmpresaFilial(String nome, String cidade, String estado, String cod) {
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.cod = cod;
		this.funcionarios = new HashSet<>();
	}
	public void cadastrarFuncionario(String nome, String cpf, double salario, String setor) throws Exception {
		Funcionarios funcionario = new Funcionarios(nome, cpf, salario, setor);
		if(funcionarios.contains(funcionario)) {
			throw new Exception ("Funcionario já cadastrado!");
		}
		funcionarios.add(funcionario);
	}
	public void removerFuncionario(Funcionarios funcionario) throws Exception {
		if(!funcionarios.contains(funcionario)) {
		throw new Exception ("Funcionario não cadastrado!");
		}
		funcionarios.remove(funcionario);
	}
	public void pesquisarPorSalario(double salario) {
		ArrayList<String> retorno = new ArrayList<>();
		for(Funcionarios funcionario : this.funcionarios) {
			if (funcionarios.) {
				
			}
		}
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
}
