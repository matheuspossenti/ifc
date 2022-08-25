package lista1;

import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		int idade, altura;
		float peso;
		
		//contadores
		int i = 0, j = 0;
		int contIdade = 0, contPeso = 0;
		int totalIdade = 0, totalAltura = 0, percPeso = 0;
		float mediaIdade = 0, mediaAltura = 0;
		
		Scanner in = new Scanner(System.in);
		
		for(i = 0; i < 5; i++) {
			for(j = 0; j < 11; j++) {
				//entrada dos dados
				System.out.println("Insira a idade, o peso e a altura do jogador: ");
				idade = in.nextInt();
				peso = in.nextFloat();
				altura = in.nextInt();
				
				//processamento contagem de jogadores com idade menor que 18 anos
				
				if(idade < 18) {
					contIdade++;
				}
				
				//processamento media das idades dos 11 jogadores
				totalIdade+=idade;
				
				//processamento media altura dos 11 jogadores
				totalAltura+=altura;
				
				//contagem jogadores com mais de 80kg;
				if(peso > 80) {
					contPeso++;
				}
			}
			
			mediaIdade = totalIdade / 11;
			System.out.println("Média da idade dos jogadores do Time " + (i + 1) + " é: " + mediaIdade + " anos");
		}
		
		mediaAltura = totalAltura / 55;
		percPeso = ((contPeso * 100) / 55);
		System.out.println(contIdade + " jogadores com menos de 18 anos.");
		System.out.println("Média das alturas do jogadores: " + mediaAltura + " cm");
		System.out.println("Porcentagem de jogadores com mais de 80 kg: " + percPeso + "%");
		
	}

}
