package revisao3;

public class AtividadeSemestral {
	private String nome;
	private int qtdade;
	private TipoAtividade tipo;
	
	public AtividadeSemestral(String nome, int qtdade, TipoAtividade tipo) {
		this.nome = nome;
		this.qtdade = qtdade;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getQtdade() {
		return qtdade;
	}

	public TipoAtividade getTipo() {
		return tipo;
	}
	
	public String toString() {
		return this.nome + " - " + this.qtdade + " " + "semestre(s)" + " - " + this.tipo;
	}
}
