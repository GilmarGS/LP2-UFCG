package lab1;

import java.util.Scanner;

public class AcimaDaMedia {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numeros = sc.nextLine();
		String[] numerosArray = numeros.split(" ");
			
		int somador = 0;
		
		for (String i : numerosArray) {
			somador += Integer.parseInt(i);			
		}
		
		int media = somador/numerosArray.length;
		String retorno = " ";
				
		for (String numero : numerosArray) {
			if (Integer.parseInt(numero) > media) {
				retorno += numero + " ";
			}		
			
		}
		
		System.out.print(retorno.trim());
		
	}

}
