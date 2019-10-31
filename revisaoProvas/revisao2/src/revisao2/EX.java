package  revisao2;

public class EX extends Atividade{
	private int qex;
	public EX(int horas, int qex) {
		super(horas);
		this.qex = qex;
	}
	public int getQex() {
		return qex;
	}
	@Override
	public String toString() {
		return "EX" + super.toString() + " - " + this.qex;
	}
}
