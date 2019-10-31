package refazendoProvaLp2162;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SistemaAC implements SistemaACIf {
	private HashMap<String, Aluno> alunos = new HashMap<>();
	
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
		this.alunos.get(matricula).cadastrarAtividade(nomeAtividade, qtdade, tipo);

	}

	@Override
	public List<String> consultaAC(String matricula) {
		return this.alunos.get(matricula).consultaAtividade();
	}

	@Override
	public int calculaCreditos(String matricula) {
		
		return this.alunos.get(matricula).calculaCredito();
	}

	@Override
	public List<String> listaAlunos() {
		List<String> retorno = new ArrayList<String>();
		Collection<Aluno> valores = this.alunos.values();
		ArrayList<Aluno>lista = new ArrayList<Aluno>(valores);
		AlunoComparador comparador = new AlunoComparador();
		Collections.sort(lista, comparador);
		for(Aluno aluno : lista) {
			retorno.add(aluno.toString() + " --- " + aluno.calculaCredito());
		}
		return retorno;
	}

	@Override
	public void defineOrdenacao(String forma) {
		// TODO Auto-generated method stub

	}

}
