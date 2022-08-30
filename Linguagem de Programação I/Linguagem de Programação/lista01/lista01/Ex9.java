package lista01;

import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		int num, num2;
		int f;

		Scanner in = new Scanner(System.in);

		System.out.println("Insira o valor 1: ");
		num = in.nextInt();

		System.out.println("Insira o valor 2: ");
		num2 = in.nextInt();

		if (num2 < num) { // Inverte caso num1 seja maior que num2
			f = num2;
			num2 = num;
			num = f;
		}

		int i;

		String msg = "";
		for (i = num; i <= num2; i++) {
			msg += "Fatorial de " + i + ": \n";
			int fatorial = 1;
			num = i;
			while (num > 0) {
				fatorial *= num;
				num--;
			}
			msg += fatorial + "\n";
		}
		System.out.println(msg);
	}

}
