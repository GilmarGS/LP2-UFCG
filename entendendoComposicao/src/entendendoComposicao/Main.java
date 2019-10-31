package entendendoComposicao;

public class Main {
	public static void main(String[] args) throws Exception {
		Sistema sistema = new Sistema();
		sistema.cadastraAluno("gilmar", "123");
		sistema.cadastraDisciplina("p2", "12", 40);
		sistema.matriculaAluno("123", "12");
		System.out.println(sistema.exibirDisciplina("12"));
	}
		
	
}
