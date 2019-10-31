package lab1;

import java.util.Scanner;
import javax.print.attribute.IntegerSyntax;

public class ListaNotas {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alunoENota = sc.nextLine();
		String[] alunoENotaArray = alunoENota.split(" ");
		String notas = "";
		int somador = 0;
		int cont = 0;
		int media = 0;
		int naMedia = 0;
		int abaixoMedia = 0;
		
		while (!alunoENotaArray[0].equals("-")) {
			int umaNota = Integer.parseInt(alunoENotaArray[1]);
			somador += Integer.parseInt(alunoENotaArray[1]);
			cont += 1;
			notas += alunoENotaArray[1] + " ";
			alunoENota = sc.nextLine();
			alunoENotaArray = alunoENota.split(" ");
			if (umaNota >= 700) {
				naMedia += 1;
			} else if (umaNota < 700) {
				abaixoMedia += 1;
			}
		}
		media = somador/cont;
			//if (Integer.parseInt(nota) > maior) {

		String[] notasArray = notas.split(" ");
		int maior = Integer.parseInt(notasArray[0]);
		int menor = Integer.parseInt(notasArray[0]);
		for (String nota: notasArray) {
			if (nota.equals(" ")) {
				break;
			} else if (Integer.parseInt(nota) > maior) {
				maior = Integer.parseInt(nota);
			} else if(Integer.parseInt(nota) < menor) {
				menor = Integer.parseInt(nota);
				
			}
			
		}
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + naMedia);
		System.out.println("abaixo: " + abaixoMedia);
	}
		
}
