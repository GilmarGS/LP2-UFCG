package model;

import controller.ControllerAluno;
import controller.ControllerPedidoDeAjuda;
import controller.ControllerTutor;
import easyaccept.EasyAccept;

public class Facade {
	private ControllerAluno controllerAluno = new ControllerAluno();
	private ControllerTutor controllerTutor = new ControllerTutor(controllerAluno);
	private ControllerPedidoDeAjuda controllerPedidos = new ControllerPedidoDeAjuda(controllerTutor);
	
	public static void main(String[] args) {
		args = new String[] {"model.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
							 "acceptance_test/us3_test.txt","acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
							 "acceptance_test/us6_test.txt"};
		EasyAccept.main(args);	
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) throws Exception{
		controllerAluno.cadastrarAluno(nome, matricula, codigoCurso , telefone, email);	
	
	}
	public String recuperaAluno(String matricula) throws Exception{
		return controllerAluno.recuperaAluno(matricula);		
		
	}
	public String listarAlunos() {
		return controllerAluno.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) throws Exception {
		return controllerAluno.getInfoAluno(matricula, atributo);
	}
	public String recuperaTutor(String matricula) throws Exception {
		return controllerTutor.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return controllerTutor.listarTutores();
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) throws Exception {
		controllerTutor.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		controllerTutor.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		controllerTutor.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return controllerTutor.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return controllerTutor.consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return controllerPedidos.pedirAjudaPresencial (matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return controllerPedidos.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) throws Exception{
		return controllerPedidos.pegarTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) throws Exception{
		return controllerPedidos.infoAjuda(idAjuda, atributo);
	}
	
	public String avaliarTutor (int idAjuda, int nota) throws Exception {
		return this.controllerPedidos.avaliarTutor(idAjuda, nota);
	}
	
	public String pegarNota(String matricula) {
		return this.controllerTutor.pegarNota(matricula);
		
	}
	
	public String pegarNivel(String matricula) throws Exception {
		return this.controllerTutor.getNotaTutorString(matricula);
	}
	
	public void doar(String matriculaTutor, int totalCentavos) throws Exception {
		this.controllerTutor.doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) throws Exception {
		return this.controllerTutor.totalDinheiroTutor(emailTutor);
	}
	
	public int totalDinheiroSistema() {
		return this.controllerTutor.totalDinheiroSistema();
	}
	
	// Conforme a descrição, só pode vir NOME, EMAIL OU MATRICULA. 
	public void configurarOrdem(String atributo){
		this.controllerAluno.alteraComparador(atributo);
	}
}
