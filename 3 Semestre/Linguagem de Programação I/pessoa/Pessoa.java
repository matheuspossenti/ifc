package pessoa;

public class Pessoa {
	private String nome, cpf;
	private int anoNasc;
	
	public Pessoa() {
		this.nome = "";
		this.cpf = "";
		this.anoNasc = 0;
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.cpf = "";
		this.anoNasc = 0;
	}
	
	public Pessoa(String nome, String cpf, int anoNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoNasc = anoNasc;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setAnoNasc(int anoNasc) {
		this.anoNasc = anoNasc;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public int getAnoNasc() {
		return this.anoNasc;
	}
	
}
