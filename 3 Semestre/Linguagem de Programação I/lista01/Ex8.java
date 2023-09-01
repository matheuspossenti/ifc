package lista01;

import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		int f;

		System.out.println("Insira o valor a ser calculado o fatorial: ");
		num = in.nextInt();
		f = num;
		while (num > 1) {
			f = f * (num - 1);
			num--;
		}

		System.out.println("Resultado do fatorial: " + f);

		in.close();
	}

}
