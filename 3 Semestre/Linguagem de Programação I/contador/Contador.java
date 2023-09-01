package contador;

public class Contador {
	
	private int valorAtual;
	
	public void atribuirValor(int valorInicial) {
		valorAtual = valorInicial;
	}
	
	public void incrementarContador() {
		valorAtual++;
	}
	
	public int obterValor() {
		return valorAtual;
	}
}
