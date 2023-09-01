package lista01;

import java.util.Scanner;

public class Ex6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int c100 = 0, c50 = 0, c20 = 0, c10 = 0, c5 = 0, c2 = 0;
		double resto = 0;

		System.out.println("Valor 1:");
		double val1 = in.nextDouble();
		System.out.println("Valor 2");
		double val2 = in.nextDouble();

		double troco = val2 - val1;

		do {
			if (troco >= 100) {
				c100 = (int) (troco / 100);
				resto = troco - c100 * 100;
				troco = resto;
			} else if (troco >= 50) {
				c50 = (int) (troco / 50);
				resto = troco - c50 * 50;
				troco = resto;
			} else if (troco >= 20) {
				c20 = (int) (troco / 20);
				resto = troco - c20 * 20;
				troco = resto;
			} else if (troco >= 10) {
				c10 = (int) (troco / 10);
				resto = troco - c10 * 10;
				troco = resto;
			} else if (troco >= 5) {
				c5 = (int) (troco / 5);
				resto = troco - c5 * 5;
				troco = resto;
			} else if (troco >= 2) {
				c2 = (int) (troco / 2);
				resto = troco - c2 * 2;
				troco = resto;
			}

		} while (troco >= 2);

		System.out.println("Notas de 100: " + c100);
		System.out.println("Notas de 50: " + c50);
		System.out.println("Notas de 20: " + c20);
		System.out.println("Notas de 10: " + c10);
		System.out.println("Notas de 5: " + c5);
		System.out.println("Notas de 2: " + c2);
		System.out.println("Total em moedas: " + troco);
	}
}
