package vero.jogo.br;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao jogo de corrida!");
        System.out.println("Aperte qualquer tecla para começar");
        input.nextLine();
        
        int distanciaTotal = 150;
        int totalVoltas = 3;
        int posicaoJogador = 0;
        int posicaoOponente = 0;
        int voltaJogador = 0;
        int voltaOponente = 0;
        
        while (voltaJogador <= totalVoltas && voltaOponente <= totalVoltas) {
            // Movimento do jogador
            System.out.println("Sua vez de jogar. Digite um número:");
            input.nextLine();
            int jogadaJogador = (int) (Math.random() * 30 + 1);
            posicaoJogador = posicaoJogador + jogadaJogador;
            if(posicaoJogador >= distanciaTotal) {
            	voltaJogador++;
            	posicaoJogador = posicaoJogador - distanciaTotal;
            }
            if(voltaJogador <= totalVoltas) {
            System.out.println("Você avançou " + jogadaJogador + " metros. Sua posição atual é " + posicaoJogador + ". Volta " + voltaJogador +  "/3");
            }
            // Movimento do oponente
            int jogadaOponente = (int) (Math.random() * 30 + 1);
            posicaoOponente = posicaoOponente + jogadaOponente;
            if(posicaoOponente >= distanciaTotal) {
            	voltaOponente++;
            	posicaoOponente = posicaoOponente - distanciaTotal;
            }
            if(voltaOponente <= totalVoltas) {
            System.out.println("Seu oponente avançou " + jogadaOponente + " metros. A posição atual dele é " + posicaoOponente + ". Volta " + voltaOponente +  "/3");
            }
            // Verifica se alguém chegou ao fim
            if (voltaJogador > totalVoltas) {
                System.out.println("Você venceu! Parabéns!");
            } else if (voltaOponente > totalVoltas) {
                System.out.println("Seu oponente venceu! Tente novamente!");
            }
        }
    }
}