package  revisao2;

public class AC extends Atividade{
	private int qac;

	public AC(int horas, int qac) {
		super(horas);
		this.qac = qac;
	}

	public int getQac() {
		return qac;
	}
	public String toString() {
		return "AC" + super.toString() + " - " + this.qac;
	}
	
}
