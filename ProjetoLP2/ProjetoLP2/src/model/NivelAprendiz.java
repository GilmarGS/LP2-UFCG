package model;

public class NivelAprendiz implements Nivel {
		
	public int calculaComissao(int valor, double notaDoTutor) {
		notaDoTutor = notaDoTutor * 10;
		Double taxaTutor = 40.0 + (notaDoTutor - 30);
		taxaTutor = taxaTutor / 100;
		int totalSistema = (int) Math.ceil((1 - taxaTutor) * valor);
		int totalTutor = valor - totalSistema;
		return totalTutor;
	}

	@Override
	public String toString() {
		return "Aprendiz";
	}

}
