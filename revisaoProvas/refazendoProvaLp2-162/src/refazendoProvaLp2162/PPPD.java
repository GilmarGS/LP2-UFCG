package refazendoProvaLp2162;

public class PPPD extends AtividadeSemestral implements Atividade{

	public PPPD(String nome, int qtdade) {
		super(nome, qtdade, EnumAtividades.PPPD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int converteEmCredito() {
		int retorno = super.getQtdade() * 2;
		return retorno;
	}

}
