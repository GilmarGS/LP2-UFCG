package  revisao2;

public class TUTOR extends Atividade{
	private int qtut;
	
	public TUTOR(int horas, int qtut) {
		super(horas);
		this.qtut = qtut;
	}

	public int getQtut() {
		return qtut;
	}
	
	public String toString() {
		return "TUTOR" + super.toString() + " - " + this.qtut;
	}
	
}
