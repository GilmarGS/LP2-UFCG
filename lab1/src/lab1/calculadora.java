package lab1;

import java.util.Scanner;

public class calculadora {
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);	
	final String SOMA = "+";
	final String SUBTRACAO = "-";
	final String DIVISAO = "/";
	final String MULTIPLICACAO = "*";
	String operacoes = sc.nextLine();
	double num1;
	double num2;
	double resultado;
	
	switch (operacoes) {
	case SOMA:
		resultado = lerDouble() + lerDouble();
		System.out.println("RESULTADO: " + resultado);
		break;
	case SUBTRACAO:
		resultado = lerDouble() - lerDouble();
		System.out.println("RESULTADO: " + resultado);
		break;
	case DIVISAO:
		num1 = lerDouble();
		num2 = lerDouble();
		if (num2 == 0) {
			System.out.println("ERRO");
			break;
		} 
		resultado = num1/num2;
		System.out.println("RESULTADO: " + resultado);
		break;
	case MULTIPLICACAO:
		resultado = lerDouble() * lerDouble();
		System.out.println("RESULTADO: " + resultado);
		break;
		
	default:
		System.out.println("ENTRADA INVALIDA");
		break;
	}		

	}
	
	public static double lerDouble() {
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextDouble();
		return num1;
	}

}
