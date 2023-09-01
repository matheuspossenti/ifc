package lista01;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		float hrsTrabalhadas;
		float salMinimo;
		float valHora;
		float salBruto;
		float imposto;
		float salLiquido;

		System.out.println("quantas horas vc trabalhou nesse mês? ");
		hrsTrabalhadas = in.nextFloat();
		System.out.println("qual o valor so salário mínimo? ");
		salMinimo = in.nextFloat();

		valHora = (salMinimo / 2);
		salBruto = (hrsTrabalhadas * valHora);
		imposto = ((salBruto / 100) * 3);
		salLiquido = (salBruto - imposto);

		System.out.println("O seu salário liquido esse mês ficou em: R$" + salLiquido);

		in.close();
	}
}
