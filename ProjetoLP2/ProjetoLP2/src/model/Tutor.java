package model;

import java.util.ArrayList;

public class Tutor{
	private String disciplina;
	private int proficiencia;
	private int qtdDinheiro;
	private ArrayList<Horario> horarios;
	private ArrayList<Local> locais;
	private Aluno aluno;
	private double avalicao;
	private final double AVALIACAOINICIAL = 4.0;
	private Nivel nivel;
	
	public Tutor(String disciplina, int proficiencia, Aluno aluno) throws Exception {
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.horarios = new ArrayList<>();
		this.locais = new ArrayList<>();
		this.aluno = aluno;
		this.qtdDinheiro = 0;
		this.avalicao = AVALIACAOINICIAL;
		this.nivel = new NivelAprendiz();
		atualizaNivel();
	}

	private void atualizaNivel() {
		if (this.avalicao > 4.5){
			this.nivel = new NivelTop();			
		} 		
		else if (this.avalicao > 3.0 && this.avalicao <= 4.5){			
			this.nivel = new NivelTutor();
		} 
		else {
			this.nivel = new NivelAprendiz();
		}
		
	}

	public void setAvalicao(double avalicao) {
		this.avalicao = avalicao;
		atualizaNivel();
	}
	
	public void adcionaNovaAvalicao(double avalicao) {
		this.avalicao =  (this.avalicao * 5 + avalicao) / 6;
		atualizaNivel();
	}

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public ArrayList<Local> getLocais() {
		return locais;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public int getQtdDinheiro() {
		return qtdDinheiro;
	}
	
	public int adicionarDinheio(int valor) {
		this.qtdDinheiro += this.nivel.calculaComissao(valor, this.avalicao);		
		return this.nivel.calculaComissao(valor, this.avalicao);
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		Horario novoHorario = new Horario(email, horario, dia);
		this.horarios.add(novoHorario);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Local novoLocal = new Local (email, local);
		this.locais.add(novoLocal);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		Horario novoHorario = new Horario(email, horario, dia);
		boolean retorno = false;
		for(Horario hr : this.horarios) {
			if (novoHorario.equals(hr)) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public boolean consultaLocal(String email, String local) {
		Local novoLocal = new Local(email, local);
		boolean retorno = false;
		for(Local lc : this.locais) {
			if (novoLocal.equals(lc)) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public boolean isProficiente(){
		return this.proficiencia>=1;
	}
	
	public boolean consultaDisciplina(String disciplina){
		return this.disciplina.equals(disciplina);
	}
	
	public String getEmail(){
		return this.aluno.getEmail();
	}
	
	public String getMatricula(){
		return this.aluno.getMatricula();
	}	
	
	public Double getAvalicao() {
		return avalicao;
	}
	
	public String getNivel(){		
		return this.nivel.toString();				
	}

	@Override
	public String toString() {
		return this.aluno.toString();
	}
}

