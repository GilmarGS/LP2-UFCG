package lab2;

import java.util.ArrayList;

/**
 * Representa os hor�rios de um conjunto de alunos matriculados em um curso superior. Em que eles
 * poder�o escolher as disciplinas que quer estudar em um semestre, hor�rios de cada uma delas, laborat�rios 
 * dispon�veis para estudo. Al�m disso, tem v�rias op��es de cantinas que poder� escolher em qual
 * delas quer comer.
 * 
 * matricula - 117210921
 * @author Gilmar Gonzaga da Silva
 * 
 */
public class Aluno {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> laboratorios;
	private ArrayList<ContaCantina> cantinas;
	private Saude saude;

	/**
	 * Contr�i as disciplinas, laborat�rios, cantinas e o estado de sa�de dos
	 * alunos.
	 */
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.laboratorios = new ArrayList<ContaLaboratorio>();
		this.cantinas = new ArrayList<ContaCantina>();
		this.saude = new Saude();
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            o aluno cadastra os nomes dos laborat�rios em que poder� estudar,
	 *            pode ter mais de um laborat�rio para cada aluno.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		ContaLaboratorio laboratorioNovo = new ContaLaboratorio(nomeLaboratorio);
		this.laboratorios.add(laboratorioNovo);
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            o aluno cadastra os nomes dos laborat�rios em que poder� estudar,
	 *            pode ter mais de um laborat�rio para cada aluno.
	 * 
	 * @param cota
	 *            o tamanho do espa�o destinado para cada laborat�rio.
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		ContaLaboratorio laboratorioNovo = new ContaLaboratorio(nomeLaboratorio, cota);
		this.laboratorios.add(laboratorioNovo);
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            o aluno cadastra os nomes dos laborat�rios em que poder� estudar,
	 *            pode ter mais de um laborat�rio para cada aluno.
	 * 
	 * @param mbytes
	 *            toda conta do laborat�rio inicia-se vazia, na medida em que o
	 *            aluno usa sua conta vai consumindo espa�o em mbytes at� atingir
	 *            2000mbytes que � a nossa cota.
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		if (isLaboratorioCadastrado(nomeLaboratorio)) {
			ContaLaboratorio laboratorioEncontrato = retornaLaboratorio(nomeLaboratorio);
			laboratorioEncontrato.consomeEspaco(mbytes);
		}
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            o aluno cadastra os nomes dos laborat�rios em que poder� estudar,
	 *            pode ter mais de um laborat�rio para cada aluno.
	 * 
	 * @param mbytes
	 *            toda conta do laborat�rio inicia-se vazia, na medida em que o
	 *            aluno usa sua conta vai consumindo espa�o em mbytes at� atingir
	 *            2000mbytes que � a nossa cota.
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		if (isLaboratorioCadastrado(nomeLaboratorio)) {
			ContaLaboratorio laboratorioEncontrato = retornaLaboratorio(nomeLaboratorio);
			laboratorioEncontrato.liberaEspaco(mbytes);
		}
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            informa o nome de um laborat�rio para verificar se ainda tem
	 *            espa�o dispon�vel.
	 * 
	 * @return retorna verdadeiro caso a conta do aluno no laborat�rio tenha
	 *         atingido um valor iagual ou maior que 2000mbytes e falso caso seja
	 *         menor que 2000mbytes.
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		if (isLaboratorioCadastrado(nomeLaboratorio)) {
			ContaLaboratorio laboratorioEncontrato = retornaLaboratorio(nomeLaboratorio);
			return laboratorioEncontrato.atingiuCota();
		}
		return false;
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            busca dentre a lista de laborat�rios cadastrado o nome de um em
	 *            espec�fico.
	 * 
	 * @return retorna a representa��o em String do nome do laborat�rio encontrado e
	 *         se n�o estiver cadastrado retona a mensagem "Laboratorio nao
	 *         encontrado".
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		if (isLaboratorioCadastrado(nomeLaboratorio)) {
			ContaLaboratorio laboratorioEncontrato = retornaLaboratorio(nomeLaboratorio);
			return laboratorioEncontrato.toString();
		}
		return "Laboratorio nao encontrado";
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            faz o cadastro de uma nova disciplina na lista de disciplinas.
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		Disciplina DisciplinaNova = new Disciplina(nomeDisciplina);
		this.disciplinas.add(DisciplinaNova);
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            procura na lista de disciplinas uma delas para realizar o cadastro
	 *            de horas.
	 * 
	 * @param horas
	 *            cadastra quantas horas o aluno ir� disponibilizar para uma
	 *            disciplina.
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		if (isDisciplinaCadastrado(nomeDisciplina)) {
			Disciplina disciplinaEncontrada = retornaDisciplina(nomeDisciplina);
			disciplinaEncontrada.cadastraHoras(horas);
		}
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            cadastra as disciplinas que os alunos escolheram para cursar.
	 * 
	 * @param nota
	 *            cadastra a quantidade de notas que o aluno ter� durante o semeste
	 *            para cada disciplina.
	 * 
	 * @param valorNota
	 *            informa a nota de cada atividade realizada pelas disciplinas.
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		if (isDisciplinaCadastrado(nomeDisciplina)) {
			Disciplina disciplinaEncontrada = retornaDisciplina(nomeDisciplina);
			disciplinaEncontrada.cadastraNota(nota, valorNota);
		}
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            busca uma cantina cadastrada na matr�cula do aluno.
	 * 
	 * @return retorna verdadeiro se a media do aluno for maior ou igual a 7 e falso
	 *         se for menor que 7.
	 */
	public boolean aprovado(String nomeDisciplina) {
		if (isDisciplinaCadastrado(nomeDisciplina)) {
			Disciplina disciplinaEncontrada = retornaDisciplina(nomeDisciplina);
			return disciplinaEncontrada.aprovado();
		}
		return false;
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            busca uma cantina cadastrada na matr�cula do aluno.
	 * 
	 * @return retorna uma String com o nome de uma disciplina, caso o nome ainda
	 *         n�o esteja cadastrada retorna a mensagem "Disciplina nao encontrada".
	 */
	public String disciplinaToString(String nomeDisciplina) {
		if (isDisciplinaCadastrado(nomeDisciplina)) {
			Disciplina disciplinaEncontrada = retornaDisciplina(nomeDisciplina);
			return disciplinaEncontrada.toString();
		}
		return "Disciplina nao encontrada";
	}

	/**
	 * 
	 * @param nomeCantina
	 *            cadastra o nome das cantinas em que os alunos poder�o comer na
	 *            universidade.
	 */
	public void cadastraCantina(String nomeCantina) {
		ContaCantina cantinaNova = new ContaCantina(nomeCantina);
		this.cantinas.add(cantinaNova);
	}

	/**
	 * 
	 * @param nomeCantina
	 *            informa a cantina que o aluno fez um lanche.
	 * 
	 * @param qtdItens
	 *            diz a quantidade itens, alimentos, que o aluno consumiu.
	 * 
	 * @param valorCentavos
	 *            valor do item que o aluno comeu, para cada item consumido �
	 *            atribu�do um valor em centavos.
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		if (isCantinaCadastrada(nomeCantina)) {
			ContaCantina cantinaEncontrada = retornaCantina(nomeCantina);
			cantinaEncontrada.cadastraLanche(qtdItens, valorCentavos);
		}

	}

	/**
	 * 
	 * @param nomeCantina
	 *            informa a cantina que o aluno fez um lanche.
	 * 
	 * @param valorCentavos
	 *            informa o valor em centavos que o aluno dever� pagar pelos itens
	 *            consumidos.
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		if (isCantinaCadastrada(nomeCantina)) {
			ContaCantina cantinaEncontrada = retornaCantina(nomeCantina);
			cantinaEncontrada.pagaConta(valorCentavos);
		}

	}

	/**
	 * 
	 * @param nomeCantina
	 *            busca uma cantina cadastrada na universidade.
	 * 
	 * @return retorna uma String com o nome de uma cantina, caso o nome ainda n�o
	 *         esteja cadastrada retorna a mensagem "Cantina nao encontrada".
	 */
	public String cantinaToString(String nomeCantina) {
		if (isCantinaCadastrada(nomeCantina)) {
			ContaCantina cantinaEncontrada = retornaCantina(nomeCantina);
			return cantinaEncontrada.toString();
		}
		return "Cantina nao encontrada";
	}

	/**
	 * 
	 * @param valor
	 *            define o estado de sa�de mental do aluno. Pode ser "boa", "ok" ou
	 *            "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}

	/**
	 * 
	 * @param valor
	 *            define o estado de sa�de f�sica do aluno. Pode ser "boa", "ok" ou
	 *            "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}

	/**
	 * 
	 * @return retorna o valor geral de acordo com an�lise da sa�de f�sica e mental.
	 *         Se ambas forem boas o resultado � "boa", se uma delas for fraca o
	 *         resulta � "ok" e se as duas forem fracas o resultado � "fraca".
	 */
	public String geral() {
		return this.saude.geral();
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            verifica se a laborat�rio buscado est� cadastrada na lista de
	 *            laborat�rios.
	 * 
	 * @return retorna o nome do laborat�rio buscado, se n�o estiver cadastrada n�o
	 *         retorna nenhum valor.
	 */
	private ContaLaboratorio retornaLaboratorio(String nomeLaboratorio) {
		for (ContaLaboratorio laboratorio : this.laboratorios) {
			if (laboratorio.getNomeLaboratorio().equals(nomeLaboratorio)) {
				return laboratorio;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param nomeLaboratorio
	 *            verifica se a laborat�rio buscado est� cadastrada na lista de
	 *            laborat�rios.
	 * 
	 * @return retorna verdadeiro se a disciplina estiver cadastrada e falso se n�o
	 *         estiver.
	 */
	private Boolean isLaboratorioCadastrado(String nomeLaboratorio) {
		for (ContaLaboratorio laboratorio : this.laboratorios) {
			if (laboratorio.getNomeLaboratorio().equals(nomeLaboratorio)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            verifica se a disciplina buscada est� cadastrada na lista de
	 *            disciplinas.
	 * 
	 * @return retorna o nome da disciplina buscada, se n�o estiver cadastrada n�o
	 *         retorna nenhum valor.
	 */
	private Disciplina retornaDisciplina(String nomeDisciplina) {
		for (Disciplina disciplina : this.disciplinas) {
			if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
				return disciplina;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param nomeDisciplina
	 *            verifica se a disciplina buscada est� cadastrada na lista de
	 *            disciplinas.
	 * 
	 * @return retorna verdadeiro se a disciplina estiver cadastrada e falso se n�o
	 *         estiver.
	 *
	 */
	private Boolean isDisciplinaCadastrado(String nomeDisciplina) {
		for (Disciplina disciplina : this.disciplinas) {
			if (disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param nomeCantina
	 *            informa o nome de uma cantina.
	 * 
	 * @return retorna o nome da cantina buscada, se n�o estiver cadastrada ele n�o
	 *         retorna nenhum valor.
	 */
	private ContaCantina retornaCantina(String nomeCantina) {
		for (ContaCantina cantina : this.cantinas) {
			if (cantina.getNomeCantina().equals(nomeCantina)) {
				return cantina;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param nomeCantina
	 *            verifica se a cantina buscada est� cadastrada na lista de
	 *            cantinas.
	 * 
	 * @return retorna verdadeiro caso esteja e falso se n�o estiver.
	 */
	private Boolean isCantinaCadastrada(String nomeCantina) {
		for (ContaCantina cantina : this.cantinas) {
			if (cantina.getNomeCantina().equals(nomeCantina)) {
				return true;
			}
		}
		return false;
	}

}
