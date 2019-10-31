package revisao3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAC implements SistemaACIf {
	private Map<String, Aluno> alunos = new HashMap<String, Aluno>();
	
	@Override
	public void cadastraAluno(String matricula, String nome, String periodo) {
		Aluno aluno = new Aluno(matricula, nome, periodo);
		this.alunos.put(matricula, aluno);
	}

	@Override
	public String buscaAluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}

	@Override
	public void cadastraAC(String matricula, String nomeAtividade, String tipo, int qtdade) {
		this.alunos.get(matricula).cadastrarAC(nomeAtividade, tipo, qtdade);

	}

	@Override
	public List<String> consultaAC(String matricula) {		
		return alunos.get(matricula).consultaAC();
	}

	@Override
	public int calculaCreditos(String matricula) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listaAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void defineOrdenacao(String forma) {
		// TODO Auto-generated method stub

	}

}
