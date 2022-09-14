package tv;

import java.util.Iterator;

public class Televisao {
	private boolean[] canais;
	private int canalAtual;
	private int volume;
	private final static int volumeMax = 100;
	private boolean legenda;
	
	public void ligarTV() {
		legenda = false;
		volume = 10;
		canalAtual = 2;
		
		canais = new boolean[10];
		
		for (int i = 0; i < canais.length; i++) {
			canais[i] = true;
		}
		exibirCanal();
	}
	
	public void exibirCanal() {
		System.out.println("Exibindo canal: " + canalAtual);
	}
	
	public void alterarCanal(int canal) {
		if((canal < canais.length) && (canais[canal] == true)) {
			canalAtual = canal;
		} else {
			System.out.println("O canal" + canal + "não está ativo ou não existe.");
		}
		
		exibirCanal();
	}
	
	public void ativarCanal(int canal) {
		if(canal <= canais.length)
			canais[canal] = true;
	}
	
	public void avancarCanal() {
		while(true) {
			canalAtual++;
			if(canalAtual >= canais.length) 
				canalAtual = 0;
			if(canais[canalAtual] == true)
				exibirCanal();
				break;
		}	
	}
	
	public void desativarCanal(int canal) {
		if(canal <= canais.length)
			canais[canal] = false;
	}
	
	public void voltarCanal() {
		while(true) {
			canalAtual--;
			if(canalAtual < 0) 
				canalAtual = canais.length-1;
			if(canais[canalAtual] == true)
				exibirCanal();
				break;
		}	
	}
	
	public void aumentarVolume(){
		volume++;
		if(volume > volumeMax)
			volume = volumeMax;
	}
	
	public void diminuirVolume(){
		volume--;
		if(volume < 0)
			volume = 0;
	}
	
	public void alterarStatusLegenda() {
		if(legenda)
			legenda = false;
		else
			legenda = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
