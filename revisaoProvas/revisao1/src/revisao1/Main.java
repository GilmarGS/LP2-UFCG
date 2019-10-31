package revisao1;

public class Main {
	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		sistema.cadastrarAluno("gilmar", "123");
		sistema.cadastrarAtividade("123", "blabla", "naninha do forro");
		sistema.cadastrarAtividade("123", "secsuGostosu", "gleyser na cama comigo");
		System.out.println(sistema.exibeAtividades("123"));
	}
}
