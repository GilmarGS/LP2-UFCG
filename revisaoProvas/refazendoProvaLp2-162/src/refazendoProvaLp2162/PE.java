package refazendoProvaLp2162;

public class PE extends Evento implements Atividade{

	public PE(String nome, int qtdade) {
		super(nome, qtdade, EnumAtividades.PE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int converteEmCredito() {
		int retorno = super.getQtdade();
		return retorno;
	}

}
