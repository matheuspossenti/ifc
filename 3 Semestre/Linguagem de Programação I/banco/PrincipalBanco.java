package ifc.banco;

public class PrincipalBanco {

	public static void main(String[] args) {

		Correntista cliente1 = new Correntista("Vinicius Slongo", "111.222.333-44");
		
		System.out.println(cliente1.getCpf());
		System.out.println(cliente1.getSaldo());
		cliente1.depositar(-80.0);
		System.out.println(cliente1.getSaldo());
		cliente1.depositar(10.0);
		System.out.println(cliente1.getSaldo());
		cliente1.depositar(80.0);
		System.out.println(cliente1.getSaldo());
		cliente1.sacar(100.0);
		System.out.println(cliente1.getSaldo());
		cliente1.sacar(86.0);
		System.out.println(cliente1.getSaldo());

		Correntista cliente2 = new Correntista("Thiago Trzcinski", "666.777.888-99");
		
		cliente2.depositar(5000.0);
		System.out.println(cliente2.getSaldo());
		
		cliente1.transferir(5.0, cliente2);
		
		System.out.println(cliente1.getSaldo());
		System.out.println(cliente2.getSaldo());

	}

}
