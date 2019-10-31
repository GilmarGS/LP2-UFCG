package model;

import java.util.Comparator;

public class AlunoComparatorNome implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno, Aluno outroAluno) {
		return aluno.getNome().compareTo(outroAluno.getNome());
	}	

}
