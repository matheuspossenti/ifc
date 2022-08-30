package lista01;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num;
		int i;
		boolean primo = true;

		System.out.println("Insira um numero: ");
		num = in.nextInt();

		for (i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				primo = false;
				break;
			}
		}
		if (primo) {
			System.out.println("Primo");
		}else {
			System.out.println("Não eh primo");
		}
		
		in.close();
	}
}