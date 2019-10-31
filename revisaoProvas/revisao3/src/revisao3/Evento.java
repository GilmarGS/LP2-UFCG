package revisao3;

public class Evento {
	private String nome;
	private int qtadade;
	private TipoAtividade tipo;
	
	public Evento(String nome, int qtadade, TipoAtividade tipo) {
		this.nome = nome;
		this.qtadade = qtadade;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public TipoAtividade getTipo() {
		return tipo;
	}

	public int getQtadade() {
		return qtadade;
	}
	
	public String toString() {
		return "EVENTO: " + this.nome;
	}
	
}
