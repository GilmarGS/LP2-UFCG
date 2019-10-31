package lab3;
import java.util.Scanner;

/**
 * 
 * @author Gilmar Gonzaga
 * @matricula 117210921
 */
public class Menu {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		Scanner sc = new Scanner(System.in);
		final String CADASTRAR = "C";
		final String LISTAR = "L";
		final String EXIBIR = "E";
		final String SAIR = "S";
		String opcao;
		do {
			opcao = chamaMenu(sc);
			switch (opcao) {
			case (CADASTRAR):
				cadastraContato(sc, agenda);
				break;
			case (LISTAR):
				listarContatos(agenda);
			    break;
			case (EXIBIR):
				exibirContato(sc, agenda);
				break;
			case (SAIR):
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");				
			}
		} while (!opcao.equals(SAIR));
	}
	
	/**
	 * Metodo para printar o contato cadastrado no objeto agenda.
	 * @param agenda busca o contato dentro de agenda para printar.
	 */
	private static void listarContatos(Agenda agenda) {
		System.out.println(agenda.listaContatos());
		
	}
	
	/**
	 * 
	 * @param sc
	 * @return
	 */
	private static String chamaMenu(Scanner sc) {
		final String EXIBIRMENU = "(C)adastrar Contato\n" + "(L)istar Contatos\n" + "(E)xibir Contato\n" + "(S)air";

		System.out.println(EXIBIRMENU);
		System.out.print("Opção> ");
		String opcao = sc.nextLine();
		return opcao;
	}
	
	/**
	 * 
	 * @param sc
	 * @param agenda
	 */
	private static void cadastraContato(Scanner sc, Agenda agenda) {
		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		
		System.out.print("Sobrenome: ");
		String sobrenome = sc.nextLine();
		
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		
		Contato contato = new Contato(nome, sobrenome,telefone);
		checaExcecaoObjetoNulo(agenda);
		try {
			agenda.cadastrarContato(contato, posicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("CADASTRO REALIZADO!");		
		
	}
	
	/**
	 * 
	 * @param sc
	 * @param agenda
	 */
	private static void exibirContato(Scanner sc, Agenda agenda) {
		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		sc.nextLine();
		Contato contato;
		try {
			contato = agenda.retornaContato(posicao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(contato.toString());
	}
	
	/**
	 * 
	 * @param obj
	 */
	private static void checaExcecaoObjetoNulo(Object obj){
		if(obj == null){
			throw new NullPointerException("Referencia null!");
		}
	}
}
