package model;

import java.util.Comparator;

public class AlunoComparatorEmail implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno, Aluno outroAluno) {
		return aluno.getEmail().compareTo(outroAluno.getEmail());
	}	

}