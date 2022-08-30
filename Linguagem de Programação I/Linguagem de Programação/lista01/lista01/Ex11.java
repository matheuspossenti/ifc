package lista01;

import java.util.Scanner;


public class Ex11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int totalPrimos = 0;
		int i;
		int j;
		int num;
		
		for (i = 0; i < 10; i++) {
			System.out.println("Informe o numero " + (i + 1));
			num = in.nextInt();
			
			boolean primo = true;
			for (j = 2; j <= (num / 2); j++) {
				if (num % j == 0) {
					primo = false;
					break;
				}
			}
			if (primo)
				totalPrimos++;
		}

		System.out.println("Total de primos: " + totalPrimos);
	}

}
