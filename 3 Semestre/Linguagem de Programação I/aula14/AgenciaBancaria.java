package aula14;

public class AgenciaBancaria {
	private static int totalAgencias;
	private int numero;
	
	public AgenciaBancaria(int num) {
		this.totalAgencias++;
		this.numero = num;
	}
	
	public static int getTotal() {
		return totalAgencias;
	}
	
	public int getNumero() {
		return this.numero;
	}
}
