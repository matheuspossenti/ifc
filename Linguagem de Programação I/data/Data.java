package data;

public class Data {
	private int dia, mes, ano;
	
	public Data(int d, int m, int a) {
		if(validarData(dia, mes)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		} else {
			this.dia = 20;
			this.mes = 9;
			this.ano = 2022;
			
		}
	}
	
	public void alterarData(int d) {
		if(validarData(d))
			this.dia = d;
	}
	
	public void alterarData(int d, int m) {
		if(validarData(d, m))
			this.dia = d; 
			this.mes = m;
	}
	
	public void alterarData(int d, int m, int a) {
		this.dia = d; this.mes = m; this.ano = a;
	}
	
	public void imprimirData() {
		System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
	}
	
	private boolean validarData(int d, int m) {
		if((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12))
			return true;
		else
			return false;
	}
	
	private boolean validarData(int d) {
		if((dia >= 1 && dia <= 31))
			return true;
		else
			return false;
	}
	
	
	
}