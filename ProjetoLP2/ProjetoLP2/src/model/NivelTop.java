package model;

public class NivelTop implements Nivel{
	
	
	public int calculaComissao(int valor, double notaDoTutor) {
		notaDoTutor = notaDoTutor * 10;
		Double taxaTutor = 90.0 + (notaDoTutor - 45);
		taxaTutor = taxaTutor / 100;
		int totalSistema = (int) Math.ceil((1 - taxaTutor) * valor);
		int totalTutor = valor - totalSistema;
		return totalTutor;
	}
	
	@Override
	public String toString() {
		return "TOP";
	}

}
