package lista4;

public class Tempo {
	private int hora, minutos, segundos;
	
	public Tempo(int hora, int minutos, int segundos) {
		if(hora > 24 || hora < 0) {
			this.hora = hora;
		} else {
			this.hora = 0;
		}
		if(minutos > 60 || minutos < 0) {
			this.minutos = minutos;
		} else {
			this.minutos = 0;
		}
		if(segundos > 60 || segundos < 0) {
			this.segundos = segundos;
		} else {
			this.segundos = 0;
		}
	}
	
	public Tempo(int minutos, int segundos) {
		if(minutos > 60 || minutos < 0) {
			this.minutos = minutos;
		} else {
			this.minutos = 0;
		}
		if(segundos > 60 || segundos < 0) {
			this.segundos = segundos;
		} else {
			this.segundos = 0;
		}
	}
	
	public Tempo(int segundos) {
		if(segundos > 60 || segundos < 0) {
			this.segundos = segundos;
		} else {
			this.segundos = 0;
		}
	}
	
	public Tempo() {
		this.hora = 0;
		this.minutos = 0;
		this.segundos = 0;
	}
	
	public String toString() {
		return hora + ":" + minutos + ":" + segundos;
	}
	
	public void escreverHora() {
		System.out.println(hora + " " + minutos + " " + segundos);
	}
}
