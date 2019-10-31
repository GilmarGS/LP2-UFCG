package model;

import java.util.Comparator;

public class AlunoComparatorMatricula implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno, Aluno outroAluno) {
		return aluno.getMatricula().compareTo(outroAluno.getMatricula());
	}	

}