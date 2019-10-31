package refazendoProvaLp2162;

import java.util.Comparator;

public class AlunoComparador implements Comparator<Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());

	}

}
