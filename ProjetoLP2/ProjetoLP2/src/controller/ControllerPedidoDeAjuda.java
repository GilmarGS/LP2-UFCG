package controller;

import java.util.HashMap;
import java.util.Map;

import model.Ajuda;
import model.AjudaOnline;
import model.AjudaPresencial;
import model.Tutor;

public class ControllerPedidoDeAjuda {
	private Map<Integer, Ajuda> pedidosDeAjuda;
	private ControllerTutor controleTutor;	
	
	public ControllerPedidoDeAjuda(ControllerTutor controleTutor) {
		this.controleTutor = controleTutor;
		this.pedidosDeAjuda = new HashMap<>();
	}

	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		validaMatricula(matrAluno);
		validaDisciplina(disciplina);
		validaLocal(localInteresse);
		validaHorario(horario);
		validaDia(dia);
		String matriculaDoTutorAlocadoParaEssaTutoria = this.controleTutor.selecionaTutorParaTutoriaPresencial(disciplina, horario, dia, localInteresse);
		int id = geraId();
		AjudaPresencial ajuda = new AjudaPresencial(id, matrAluno, disciplina, horario, dia, localInteresse, matriculaDoTutorAlocadoParaEssaTutoria);
		pedidosDeAjuda.put(id , ajuda);
		return id;
	}
	
	private int geraId(){
		return this.pedidosDeAjuda.size() + 1;
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		try {
			validaMatricula(matrAluno);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		
		try {
			validaDisciplina(disciplina);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}		
		
		String matriculaDoTutorAlocadoParaEssaTutoria = this.controleTutor.selecionaTutorParaTutoriaDistancia(disciplina);
		int id = geraId();
		AjudaOnline ajuda = new AjudaOnline(id, matrAluno, disciplina, matriculaDoTutorAlocadoParaEssaTutoria);
		pedidosDeAjuda.put(id , ajuda);
		return id;
	}
	
	private void validaMatricula(String matricula) {
		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
	}

	private void validaHorario(String horario) {
		if(horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
	}

	private void validaLocal(String local) {
		if(local.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
	}

	private void validaDisciplina(String disciplina) {
			if(disciplina.trim().equals("")) {
				throw new IllegalArgumentException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
			}
	}	
	
	private void validaDia(String dia) {
		if(dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
	}

	public String pegarTutor(int idAjuda) throws Exception {
		try {
			validaId(idAjuda);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		
		if (!isIdCadastrado(idAjuda)){
			throw new Exception("Erro ao tentar recuperar tutor : id nao encontrado ");
		}
		return this.pedidosDeAjuda.get(idAjuda).toString();
	}
	
	private boolean isIdCadastrado(int idAjuda){
		return this.pedidosDeAjuda.containsKey(idAjuda);
	}
	
	private void validaId(int id) {
		if(id < 0) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
	}

	public String infoAjuda(int idAjuda, String atributo) throws Exception {
		validaId(idAjuda);
		
		if (!isIdCadastrado(idAjuda)){
			throw new Exception("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		
		if(atributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
				
		String retorno = "";
		if(atributo.trim().equals("disciplina")) {
			retorno = this.pedidosDeAjuda.get(idAjuda).getDisciplina();
		}
		
		else if(atributo.trim().equals("horario")) {
			AjudaPresencial ajuda = (AjudaPresencial) this.pedidosDeAjuda.get(idAjuda);
			retorno = ajuda.getHorario();
		}
		
		else if(atributo.trim().equals("dia")) {
			AjudaPresencial ajuda = (AjudaPresencial) this.pedidosDeAjuda.get(idAjuda);
			retorno = ajuda.getDia();
		}
		
		else if(atributo.trim().equals("localInteresse")) {
			AjudaPresencial ajuda = (AjudaPresencial) this.pedidosDeAjuda.get(idAjuda);
			retorno = ajuda.getLocalInteresse();
		}
		
		else {
			throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
		
		return retorno;
	}
	
	public String avaliarTutor (int idAjuda, int nota) throws Exception {
		
		if (nota < 0) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		else if(nota > 5) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}		
		verificaID(idAjuda);	
		if (!this.pedidosDeAjuda.get(idAjuda).getAvaliada()){			
			String matriculaTutor = this.pedidosDeAjuda.get(idAjuda).getMatriculaDoTutor();
			this.controleTutor.adcionarNotaTutor(matriculaTutor, nota);
			this.pedidosDeAjuda.get(idAjuda).avaliada();			
			return this.controleTutor.getNotaTutorString(matriculaTutor);
			
		}
		throw new Exception("Ajuda já avaliada");
	}
	
	public void verificaID(int id) {
		boolean existeID = false;
		if (!this.pedidosDeAjuda.containsKey(id)) {
			throw new NullPointerException("Erro na avaliacao de tutor: id nao encontrado ");
		}
		else {
			if(this.pedidosDeAjuda.get(id).getAvaliada()) {
				throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
			}
		}
	}
}
	
	
	

	
	


