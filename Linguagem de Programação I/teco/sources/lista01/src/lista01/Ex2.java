package lista01;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		double salBase, sal;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Qual seu salário: ");
		salBase = in.nextFloat();
		
		sal = salBase * 1.05 * 0.93;
		
		System.out.println("Seu salário total será: " + sal);
		
		in.close();
	}

}
