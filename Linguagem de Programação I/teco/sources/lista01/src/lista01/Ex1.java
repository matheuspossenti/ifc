package lista01;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		int a1, a2, a3;
		int l1, l2, l3;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira os ângulos do seu triângulo: ");
		a1 = in.nextInt();
		a2 = in.nextInt();
		a3 = in.nextInt();
		
		System.out.println("Insira os lados do triângulo: ");
		l1 = in.nextInt();
		l2 = in.nextInt();
		l3 = in.nextInt();
		
		System.out.println("Classificação do triangulo: ");
		if((a1 == 90) || (a2 == 90) || (a3 == 90)) {
			System.out.println("Retângulo.");
		} else if(a1 > 90 || a2 > 90 || a3 > 90) {
			System.out.println("Obtusângulo.");
		} else {
			System.out.println("Acutângulo.");
		}
		
		if (l1 == l2 && l2 == l3 && l3 == l1) {
			System.out.println("Equilátero.");
		} else if ((l1 == l2) || (l2 == l3) || (l3 == l1)) {
			System.out.println("Isósceles.");
		} else {
			System.out.println("Escaleno.");
		}
		
		in.close();
		
	}

}
