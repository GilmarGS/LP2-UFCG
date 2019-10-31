package model;

public class NivelTutor implements Nivel {
	private final double TAXATUTOR = 0.8;
	
	public int calculaComissao(int valor, double notaDoTutor) {
		int totalSistema = (int) Math.ceil((1 - TAXATUTOR) * valor);		
		int totalTutor = valor - totalSistema;
		return totalTutor;
	}
	
	@Override
	public String toString() {
		return "Tutor";
	}

}
