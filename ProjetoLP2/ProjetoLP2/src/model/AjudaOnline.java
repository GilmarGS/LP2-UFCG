package model;

public class AjudaOnline implements Ajuda {
	private int id;
	private String matrAluno;
	private String disciplina;	
	private String matriculaDoTutor;
	private boolean avaliada;
	
	public AjudaOnline(int id, String matrAluno, String disciplina, String matriculaDoTutor)  {
		this.id = id;
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.matriculaDoTutor = matriculaDoTutor;
		this.avaliada = false;
	}

	public boolean getAvaliada() {
		return avaliada;
	}	

	public String getMatrAluno() {
		return matrAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getMatriculaDoTutor() {
		return matriculaDoTutor;
	}

	public int getId() {
		return id;
	}
	
	 
	@Override
	public String toString() {
		return "Tutor - " + matriculaDoTutor + ", disciplina - " + disciplina;
	}

	@Override
	public void avaliada() {
		this.avaliada = true;
		
	}

	
	
}
