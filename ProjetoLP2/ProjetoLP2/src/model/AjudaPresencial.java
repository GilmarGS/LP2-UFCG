package model;

public class AjudaPresencial implements Ajuda{
	private int id;
	private String matrAluno;
	private String disciplina;	
	private String matriculaDoTutor;
	private String horario;
	private String dia;
	private String localInteresse;
	private boolean avaliada;
	
	
	public AjudaPresencial(int id, String matrAluno, String disciplina, String horario, String dia, String localInteresse, String matriculaDoTutor) {
		this.id = id;
		this.matrAluno = matrAluno;
		this.disciplina = disciplina;
		this.matriculaDoTutor = matriculaDoTutor;
		this.horario = horario;
		this.dia = dia;
		this.localInteresse = localInteresse;
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
	
	public int getId()	{
		return this.id;
	}

	public String getHorario() {
		return horario;
	}

	public String getDia() {
		return dia;
	}

	public String getLocalInteresse() {
		return localInteresse;
	}	
	
	@Override
	public void avaliada() {
		this.avaliada = true;
		
	}
	@Override
	public String toString() {
		return "Tutor - " + matriculaDoTutor + ", horario - " + horario + ", dia - " + dia + ", local - " + localInteresse + ", disciplina - " + disciplina; 
	}
	
}
