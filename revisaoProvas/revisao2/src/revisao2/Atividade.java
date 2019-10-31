package  revisao2;

public class Atividade {
	private int horas;
	
	public Atividade(int horas) {
		this.horas = horas;
	}
	
	public int getHoras() {
		return this.horas;
	}
	
	public String toString() {
		return " - " + this.horas;
	}
}
