package decisao;

public class TesteVazio {

	public static void main(String[] args) {
		
		String s = "IFC";
		
		if (s.isEmpty()) {
			System.out.println("É vazia!");
		}else 
		if (s.equals("IFC")){
			System.out.println("É IFC!");
		}else {
			
			System.out.println("É outra coisa");
		}
			

	}

}