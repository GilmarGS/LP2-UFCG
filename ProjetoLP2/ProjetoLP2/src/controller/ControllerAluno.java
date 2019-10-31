package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import model.Aluno;
import model.AlunoComparatorEmail;
import model.AlunoComparatorMatricula;
import model.AlunoComparatorNome;

public class ControllerAluno {
	private Map<String, Aluno> alunos;
	private Comparator<Aluno> comparadorAtual;
	
	
	public ControllerAluno() {
		this.alunos = new HashMap<>();
		this.comparadorAtual = new AlunoComparatorNome();
	}

	public void cadastrarAluno(String nome, String matricula, int codCurso, String telefone, String email) throws Exception {
		validarEmail(email);
		if(this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		
		Aluno novoAluno = new Aluno(nome, matricula, codCurso, telefone, email);
		this.alunos.put(matricula, novoAluno);
	}
	
	public String recuperaAluno(String matricula) {
		if(!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return this.alunos.get(matricula).toString();
	}
	
	public String listarAlunos() {
		Collection<Aluno> valores = alunos.values();
		ArrayList<Aluno> lista = new ArrayList<Aluno>(valores);		
		Collections.sort(lista, this.comparadorAtual);
		String retorno = "";
		for (Aluno aluno : lista) {			
			retorno += aluno.toString() +", ";
		}
		retorno = retorno.trim();
		return retorno.substring(0, retorno.length()-1);
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		if(!(this.alunos.containsKey(matricula))) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		
		String retorno = "";
		if(atributo.trim().equals("Nome")) {
			retorno = this.alunos.get(matricula).getNome();
		}
		
		else if(atributo.trim().equals("Telefone")) {
			retorno = this.alunos.get(matricula).getTelefone();
		}
		
		else if(atributo.trim().equals("Email")) {
			retorno = this.alunos.get(matricula).getEmail();
		}
		
		return retorno;
		
	}
	
	public Aluno retornaAluno(String matricula) throws Exception {
		if (!this.alunos.containsKey(matricula)) {
			
			throw new Exception("Erro na definicao de papel: Tutor nao encontrado");
		}
		
		Aluno aluno = this.alunos.get(matricula);
		return aluno;
		
	}	
	
	public void validarEmail(String email) {
		String[] partes = email.split("@");
		if (partes.length != 2) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");		
		}
		else if (partes[0].equals("") || partes[1].equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
		
	}
	
	public void alteraComparador(String atributo){
		atributo = atributo.trim();				
		switch (atributo) {
		case "NOME":
			this.comparadorAtual = new AlunoComparatorNome();
			break;
		case "EMAIL":
			this.comparadorAtual = new AlunoComparatorEmail();
			break;		
		case "MATRICULA":
			this.comparadorAtual = new AlunoComparatorMatricula();	
			break;

		default:
			throw new IllegalArgumentException("Estrategia de ordencação inválida");			
		}
	}	
	
	
}