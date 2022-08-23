package lista01;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//entrada
		double salarioMinimo, qtdKwh;
		//saída
		double valorKwh, valorConta, valorContaDesconto;
		
		//carregamento das variáveis
		System.out.println("Insira o salaário mínimo: ");
		salarioMinimo = in.nextDouble();
		
		System.out.println("Insira a quantidade de KWh que foi consumida: ");
		qtdKwh = in.nextDouble();
		
		//calculo valor kwh
		
		valorKwh = salarioMinimo / 5;
		
		//valor a ser pago
		
		valorConta = valorKwh * qtdKwh;
		
		//valor a ser pago com 15% de desconto
		
		valorContaDesconto = valorConta * 0.85;
		
		System.out.println("O valor do kWh é: R$ " + valorKwh);
		System.out.println("O valor a ser pago é: R$ " + valorConta);
		System.out.println("O valor a ser pago com 15% de desconto é: " + valorContaDesconto);
		
		in.close();
	}

}
