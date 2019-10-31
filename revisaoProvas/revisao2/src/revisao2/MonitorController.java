package  revisao2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MonitorController{
		private HashMap<String, Monitor> monitores = new HashMap<>();

	// PASSO 1
	public void cadastrarMonitor(String nome, String email) throws Exception {
		Monitor monitor = new Monitor(nome, email);
		this.monitores.put(email, monitor);
	}

	public String listarMonitores() {
		String retorno = "[";
		if(this.monitores.size() == 0) {
			return retorno = "[]";
		}
		Collection<Monitor> valores = this.monitores.values();
		List<Monitor> lista = new ArrayList<Monitor>(valores);
		ComparaMonitor comparador = new ComparaMonitor();
		Collections.sort(lista, comparador);
		for(Monitor monitor : lista) {
			retorno += monitor.toString() +", ";
		}
		
		return retorno.substring(0, retorno.length()-2) + "]";
	}

	// PASSO 2
	public void cadastrarAC(String email, int horas, int qac) throws Exception {
		this.monitores.get(email).cadastrarAtividadeAC(horas, qac);
	}
	
	public void cadastrarEX(String email, int horas, int qex) throws Exception {
		this.monitores.get(email).cadastrarAtividadeEX(horas, qex);
	}
	
	public void cadastrarPROJ(String email, int horas, int qpro) throws Exception {
		this.monitores.get(email).cadastrarAtividadePROJ(horas, qpro);
	}
	
	public void cadastrarTUTOR(String email, int horas, int qtut) throws Exception {
		this.monitores.get(email).cadastrarAtividadeTUTOR(horas, qtut);
	}

	public String imprimeAtividade(String email, int posicao) throws Exception {		
		return this.monitores.get(email).imprimeAtividades(posicao);
	}
	
	public int totalHorasAtividades(String email) throws Exception {
		return this.monitores.get(email).totalHorasAtividades();
	}

	// PASSO 3
	public double calculaDesempenho(String email) throws Exception {
		return 0.0;
	}


	
	// PASSO 4
	/* Aqui vc que manda. Como deve ser a assinatura do metodo e quais os testes
	que vc faria para essa funcionalidade*/
	

	
}
