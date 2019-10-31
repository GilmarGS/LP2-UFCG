package lab04;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe main, responsavel por realizar o controle de cadastro de aluno, exibir
 * os alunos alunos cadastrados, criar grupo de estudos, cadastrar alunos nos
 * grupos de estudos, imprimir os alunos que participam dos grupos e registrar
 * alunos que responderam questoes e exibi-los.
 * 
 * @author Gilmar Gonzaga
 *
 */
public class Sistema {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ArrayList<Aluno> alunosQueResponderamExercicos = new ArrayList<>();
		GrupoDeEstudos mapaCadastraAluno = new GrupoDeEstudos();
		AlunosCadastrados alunos = new AlunosCadastrados();

		final String CADASTRAR = "C";
		final String EXIBIR = "E";
		final String NOVOGRUPO = "N";
		final String ALOCAROUIMPRIMIR = "A";
		final String REGISTRARRESPOSTA = "R";
		final String IMPRIMIR = "I";
		final String FECHAR = "O";
		String opcao;
		do {
			opcao = chamaMenu(sc);
			switch (opcao) {
			case CADASTRAR:
				cadastraAluno(sc, alunos);
				break;
			case EXIBIR:
				exibeAluno(sc, alunos);
				break;
			case NOVOGRUPO:
				cadastraGrupo(sc, mapaCadastraAluno);
				break;
			case ALOCAROUIMPRIMIR:
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String opcoes = sc.nextLine();
				if (opcoes.equals("A")) {
					alocarAluno(sc, mapaCadastraAluno, alunos);
				} else if (opcoes.equals("I")) {
					imprimeAlunos(sc, mapaCadastraAluno, alunos);
				}

				break;
			case REGISTRARRESPOSTA:
				cadastraAlunoRespondeuQuestao(sc, alunosQueResponderamExercicos, alunos);
				break;
			case IMPRIMIR:
				imprimirAlunoQueRespondeuExercicio(alunosQueResponderamExercicos);
				break;
			case FECHAR:
				break;
			default:
				System.out.println("ENTGRADA INVALIDA!");
				System.out.println();

			}

		} while (!opcao.equals("O"));
	}

	private static void imprimirAlunoQueRespondeuExercicio(ArrayList<Aluno> alunosQueResponderamExercicos) {
		System.out.println("Alunos:");
		for (int i = 0; i < alunosQueResponderamExercicos.size(); i++) {
			System.out.println(i + 1 + "." + " " + alunosQueResponderamExercicos.get(i).toString());
		}
	}

	private static void imprimeAlunos(Scanner sc, GrupoDeEstudos mapaCadastraAluno, AlunosCadastrados alunos) {
		System.out.print("Grupo:");
		String tema = sc.nextLine();
		System.out.println("Alunos do grupo " + tema + ":");
		try {
			System.out.println(mapaCadastraAluno.imprimirAluno(tema));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void alocarAluno(Scanner sc, GrupoDeEstudos mapaCadastraAluno, AlunosCadastrados alunos) {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();

		try {
			Aluno aluno = alunos.retornaAluno(matricula);
			mapaCadastraAluno.cadastrarAlunoNoGrupo(aluno, grupo);
			System.out.println("ALUNO ALOCADO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void cadastraAlunoRespondeuQuestao(Scanner sc, ArrayList<Aluno> alunosQueResponderamExercicios,
			AlunosCadastrados alunos) throws Exception {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();

		if (!alunos.isAlunoCadastrado(matricula)) {
			throw new Exception("Aluno não cadastrado.");
		}
		Aluno aluno = alunos.retornaAluno(matricula);
		alunosQueResponderamExercicios.add(aluno);
		System.out.println("ALUNO REGISTRADO!");
	}

	private static void cadastraGrupo(Scanner sc, GrupoDeEstudos mapaCadastraGrupo) {
		System.out.print("Grupo: ");
		String tema = sc.nextLine();
		try {
			mapaCadastraGrupo.cadastrarTema(tema);
			System.out.println("CADASTRO REALIZADO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void exibeAluno(Scanner sc, AlunosCadastrados alunos) {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();

		try {
			System.out.println("Aluno: " + alunos.exibirAluno(matricula));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	private static void cadastraAluno(Scanner sc, AlunosCadastrados alunos) {
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();

		Aluno aluno = new Aluno(matricula, nome, curso);

		try {
			alunos.cadastrarAluno(aluno);
			System.out.println("CADASTRO REALIZADO!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	private static String chamaMenu(Scanner sc) {
		final String EXIBIRMENU = "(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Imprimir Grupos\n" + "(R)egistrar Resposta de Aluno\n"
				+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!";
		System.out.println(EXIBIRMENU);
		System.out.println();
		System.out.print("Opcao> ");
		String opcao = sc.nextLine();
		return opcao;
	}

}
