package refazendoProvaLp2162;

public class PM extends AtividadeSemestral implements Atividade{

	public PM(String nome, int qtdade) {
		super(nome, qtdade, EnumAtividades.PM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int converteEmCredito() {
		double retorno = super.getQtdade() * 1.5;
		return (int) Math.floor(retorno);
	}

}
