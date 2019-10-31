package model;

public class main {
	public static void main(String[] args) throws Exception {
		Facade aluno = new Facade();
		aluno.cadastrarAluno("gi", "123", 1, "", "aaa@gi");
		aluno.cadastrarAluno("gil", "12", 1, "", "gil@gil");
		aluno.cadastrarAluno("abrao", "001", 1, "", "abr@gmail");
		aluno.configurarOrdem("EMAIL");
		System.out.println(aluno.listarAlunos());
	}
}