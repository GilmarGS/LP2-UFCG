package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Tutor;

public class ControllerTutor {
	private List<Tutor> tutores;
	private ControllerAluno controleAluno;
	private final Double AVALICAOZERO = 0.0;
	private int caixa;
	
	public ControllerTutor(ControllerAluno controleAluno) {
		this.controleAluno = controleAluno;
		this.tutores = new ArrayList<>();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception{
		
		if (proficiencia<1 || proficiencia >5){
			throw new Exception("Erro na definicao de papel: Proficiencia invalida");
		}

		for (Tutor tutor : tutores) {			
			if (tutor.getMatricula().equals(matricula)) {
				if (disciplina.equals(tutor.getDisciplina())){
					throw new Exception("Erro na definicao de papel: Ja eh tutor dessa disciplina");
				}
			}
		}

		Aluno aluno = this.controleAluno.retornaAluno(matricula);		
		Tutor tutor = new Tutor(disciplina, proficiencia, aluno);
		this.tutores.add(tutor);
	}
	public String recuperaTutor(String matricula) throws Exception {
		return recuperaTutorObjeto(matricula).toString();
	}
	
	public Tutor recuperaTutorObjeto(String matricula) throws Exception {
		for (Tutor tutor : tutores) {			
			if (tutor.getMatricula().equals(matricula)) {
				return tutor;
			}
		}
		throw new Exception("Erro na busca por tutor: Tutor nao encontrado");
	}
	
	public String listarTutores() {
		String retorno = "";
		ArrayList<String> matriculasTutores = new ArrayList<String>();
		for (Tutor aluno : tutores) {
			if (!matriculasTutores.contains(aluno.getMatricula()))
				retorno += aluno.toString() +", ";
				matriculasTutores.add(aluno.getMatricula());
		}
		retorno = retorno.trim();
		return retorno.substring(0, retorno.length()-1);
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		validaEmailHorario(email);
		boolean cadastrado = false;
		for (Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				tutor.cadastrarHorario(email, horario, dia);
				cadastrado = true;
			}
		}
		
		if (!cadastrado) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		validaEmailLocalDeAtendimento(email);
		validaLocal(local);
		boolean cadastrado = false;
		for (Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(email)) {
				tutor.cadastrarLocalDeAtendimento(email, local);
				cadastrado = true;
			}
		}
		
		if (!(cadastrado)) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		boolean retorno = false;
		for(Tutor tutor: this.tutores) {			
			// REFATORADO
			if(tutor.consultaHorario(email, horario, dia)) {
				retorno = tutor.consultaHorario(email, horario, dia);
			}
		}
		return retorno;
	}
	
	public boolean consultaLocal(String email, String local) {
		boolean retorno = false;
		for(Tutor tutor: this.tutores) {
			// REFATORADO
			if(tutor.consultaLocal(email, local)) {
				retorno =  tutor.consultaLocal(email, local);
			}	
		}
		return retorno;
	}	
	
	private void validaEmailLocalDeAtendimento(String email) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
	}
	private void validaEmailHorario(String email) {
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
	}
	private void validaLocal(String local) {
		if(local.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		
	}

	public String selecionaTutorParaTutoriaPresencial(String disciplina, String horario, String dia, String localInteresse) {
		String retorno = "";
		Double maiorAvaliacao = AVALICAOZERO;		
		for (Tutor tutor:this.tutores){
			if (tutor.consultaDisciplina(disciplina) && tutor.isProficiente()){
				if (tutor.consultaHorario(tutor.getEmail(), horario, dia) && tutor.consultaLocal(tutor.getEmail(), localInteresse)){
					if (tutor.getAvalicao() > maiorAvaliacao){
						retorno = tutor.getMatricula();
						maiorAvaliacao = tutor.getAvalicao();
						
					}
				}
			}
		}		
		return retorno;
		
	}

	public String selecionaTutorParaTutoriaDistancia(String disciplina) {
		String retorno = "";
		Double maiorAvaliacao = AVALICAOZERO;
		for (Tutor tutor : this.tutores) {
			if (tutor.consultaDisciplina(disciplina) && tutor.isProficiente()) {
				if (tutor.getAvalicao() > maiorAvaliacao) {
					retorno = tutor.getMatricula();
					maiorAvaliacao = tutor.getAvalicao();
				}
			}
		}
		
		return retorno;
	}
	

	private double getNotaTutor(String matricula) {		
		try {
			Tutor tutor = recuperaTutorObjeto(matricula);
			return tutor.getAvalicao();
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na doacao para tutor: Tutor nao encontrado");
			}		
	}
	
	public String pegarNota(String matricula) {
		double nota  =  getNotaTutor(matricula);
		return formataNota(nota);
	}
	
	private String formataNota(double nota) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(nota);
	}
	
	public String getNotaTutorString(String matricula) throws Exception {		
		Tutor tutor = recuperaTutorObjeto(matricula);		
		return tutor.getNivel().toString();	
	}
	
	
	public void adcionarNotaTutor(String matricula, double nota) {
		
		for (Tutor tutor : this.tutores) {
			if (tutor.getMatricula().equals(matricula)) {
				tutor.adcionaNovaAvalicao(nota);
			}
	}
	}
	
	public void doar(String matriculaTutor, int totalCentavos) throws Exception {
		if(totalCentavos < 0) {
			throw new IllegalArgumentException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
		
		try {
			Tutor tutor = recuperaTutorObjeto(matriculaTutor);
			int totalTutor = tutor.adicionarDinheio(totalCentavos);
			int totalSistema = totalCentavos - totalTutor;
			this.caixa += totalSistema;			
		} catch (Exception e) {
			throw new Exception("Erro na doacao para tutor: Tutor nao encontrado");
		}		
		
		
	}
	
	public int totalDinheiroTutor(String emailTutor) {
		
		if (emailTutor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na consulta de total de dinheiro do"
											 + " tutor: emailTutor nao pode ser vazio ou nulo");
		}
		
		for (Tutor tutor : this.tutores) {
			if(tutor.getEmail().equals(emailTutor)) {				
				return tutor.getQtdDinheiro();
				
			}
		}	
		
		throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
				
	}
	
	public int totalDinheiroSistema() {
		return this.caixa;
	}
}
