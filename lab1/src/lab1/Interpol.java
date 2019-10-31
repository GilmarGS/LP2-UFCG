package lab1;

import java.util.Scanner;

public class Interpol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nomes = sc.nextLine();
		String[] nomesArray = nomes.split(" ");
		String possivel = "?";
		while (!nomesArray[0].equals("wally")) {
			for (String i : nomesArray) {
				if (i.length() == 5) {
					possivel = i;
				}
			}
			System.out.println(possivel);
			nomes = sc.nextLine();
			nomesArray = nomes.split(" ");
		}

	}
}
