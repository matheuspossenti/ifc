package ifc.banco;

import java.util.Random;

public class Correntista {
	
	private String nome;
	private String cpf;
	private Double saldo;
	private Integer cc;
	
	public Correntista(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = 0.0;
		this.cc = gerarNumeroConta();
	}
	
	private Integer gerarNumeroConta() {
		Random r = new Random();
		
		return r.nextInt(1000, 9999);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		StringBuilder sb = new StringBuilder(cpf);
		return sb.replace(0, 3, "***").replace(12, 14, "**").toString();
	}
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	public Integer getCC() {
		return this.cc;
	}
	
	public boolean depositar(Double valor) {
		if(valor > 0) {
			this.saldo += valor;
			return true;
		} else
			return false;
	}
	
	public boolean sacar(Double valor) {
		if((valor > 0) && (valor <= saldo)) {
			this.saldo -= valor;
			return true;
		}else
			return false;
	}
	
	public boolean transferir(Double valor, Correntista correntista) {
		if(this.sacar(valor)) {
			correntista.depositar(valor);
			return true;
		}else 
			return false;
	}
	
}










