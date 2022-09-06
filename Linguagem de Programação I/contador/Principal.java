package contador;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Contador c = new Contador();
		
		System.out.println("Com que valor o contador irá começar?");
		c.atribuirValor(in.nextInt());
		
		c.incrementarContador();
		
		System.out.println(c.obterValor());
		
		in.close();
	}

}
