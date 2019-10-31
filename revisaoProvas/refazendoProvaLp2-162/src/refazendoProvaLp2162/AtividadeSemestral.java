package refazendoProvaLp2162;

public class AtividadeSemestral {
	private String nome;
	private int qtdade;
	private EnumAtividades tipo;
	
	public AtividadeSemestral(String nome, int qtdade, EnumAtividades tipo) {
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

	public EnumAtividades getTipo() {
		return tipo;
	}
	
	public String toString() {
		return this.nome + " - " + this.qtdade + " " + "semestre(s)" + " - " + this.tipo;
	}
}
