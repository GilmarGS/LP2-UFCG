package lab2;

/**
 * 
 * @author Gilmar Gonzaga da Silva
 * matricula - 117210921
 */

public class CoisaLinhaComando {
	public static void main(String[] args) {
		ContaLaboratorio laboratorioBase = new ContaLaboratorio("laboratorio exemplo");
		String comando = args[0];
		String valor = args[1];

		switch (comando) {
		case "CONSOME":
			laboratorioBase.consomeEspaco(Integer.parseInt(valor));
			System.out.println(laboratorioBase.toString());
			break;

		case "LIBERA":
			laboratorioBase.liberaEspaco(Integer.parseInt(valor));
			System.out.println(laboratorioBase.toString());
			break;

		default:
			System.err.print("Comando invalido");
			break;
		}

	}

}
