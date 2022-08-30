package lista01;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int codigoProduto;
		int qtdProduto;
		float valorDesconto;
		float valorNota;
		float valorProduto;
		float valorTotal;

		System.out.println("Digite o código do produto que deseja comprar, sendo entre 1 - 40: ");
		codigoProduto = in.nextInt();
		System.out.println("Qual a quantidade desse produto que vc deseja comprar? ");
		qtdProduto = in.nextInt();

		if (codigoProduto >= 1 && codigoProduto <= 10) {
			valorProduto = 10;
			System.out.println("O valor unitário é R$" + valorProduto);
			valorNota = (qtdProduto * valorProduto);
			if (valorNota <= 250) {
				valorDesconto = ((valorNota / 100) * 5);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota <= 500) {
				valorDesconto = ((valorNota / 100) * 10);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota > 500) {
				valorDesconto = ((valorNota / 100) * 15);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);
			}

		} else if (codigoProduto >= 11 && codigoProduto <= 20) {
			valorProduto = 15;
			System.out.println("O valor unitário é R$" + valorProduto);
			valorNota = (qtdProduto * valorProduto);
			if (valorNota <= 250) {
				valorDesconto = ((valorNota / 100) * 5);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota <= 500) {
				valorDesconto = ((valorNota / 100) * 10);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota > 500) {
				valorDesconto = ((valorNota / 100) * 15);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);
			}
		} else if (codigoProduto >= 21 && codigoProduto <= 30) {
			valorProduto = 20;
			System.out.println("O valor unitário é R$" + valorProduto);
			valorNota = (qtdProduto * valorProduto);
			if (valorNota <= 250) {
				valorDesconto = ((valorNota / 100) * 5);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota <= 500) {
				valorDesconto = ((valorNota / 100) * 10);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota > 500) {
				valorDesconto = ((valorNota / 100) * 15);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);
			}
		} else if (codigoProduto >= 31 && codigoProduto <= 40) {
			valorProduto = 40;
			System.out.println("O valor unitário é R$" + valorProduto);
			valorNota = (qtdProduto * valorProduto);
			if (valorNota <= 250) {
				valorDesconto = ((valorNota / 100) * 5);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota <= 500) {
				valorDesconto = ((valorNota / 100) * 10);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);

			} else if (valorNota > 500) {
				valorDesconto = ((valorNota / 100) * 15);
				valorTotal = (valorNota - valorDesconto);
				System.out.println("o valor do desconto é: " + valorDesconto);
				System.out.println("o valor total de sua compra é: " + valorTotal);
			}
		}

	}
}
