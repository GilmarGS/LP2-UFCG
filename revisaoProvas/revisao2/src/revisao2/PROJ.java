package  revisao2;

public class PROJ extends Atividade{
	private int qpro;
	
	public PROJ(int horas, int qpro) {
		super(horas);
		this.qpro = qpro;
	}

	public int getQpro() {
		return qpro;
	}
	@Override
	public String toString() {
		return "PROJ" + super.toString() + " - " + this.qpro;
	}
}
