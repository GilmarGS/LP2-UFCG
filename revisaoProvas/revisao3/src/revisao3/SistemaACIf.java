package revisao3;

import java.util.List;

public interface SistemaACIf {

	void cadastraAluno(String matricula, String nome, String periodo);

	String buscaAluno(String matricula);

	void cadastraAC(String matricula, String nomeAtividade, String tipo, int qtdade);

	List<String> consultaAC(String matricula);

	int calculaCreditos(String matricula);

	List<String> listaAlunos();

	void defineOrdenacao(String forma);

}
