package buzz;

import java.util.Random;

public class BuzzLightyear {
	private String frases[] = {"Ao infinito e além!", "Saudações, eu sou o Buzz Lightyear e venho em paz!", "Prepare-se para uma aventura!",
							  	"Isto não é voar. Isto é cair, com estilo!", " Preparado para voar!", "Comando estelar, pronto para voar!"};
	private boolean capacete;
	private boolean asa;
	
	public void viverBuzz() {
		capacete = true;
		asa = false;
		
		System.out.println("Buzz Lightyear ligou e está com a asa fechada e capacete aberto!");
	}
	
	public void falarFrase() {
		Random rand = new Random();
		int int_random = rand.nextInt(frases.length);
		
		System.out.println(frases[int_random]);
	}
	
	public void altCapacete(){
		capacete = !capacete;
		if(capacete)
			System.out.println("Buzz Lightyear abriu o capacete");
		else
			System.out.println("Buzz Lightyear fechou o capacete");
	}
	
	public void altAsa(){
		asa = !asa;
		if(asa)
			System.out.println("Buzz Lightyear abriu as asas");
		else
			System.out.println("Buzz Lightyear fechou as asas");
	}
	
	public void disparaLaser() {
		if(!capacete)
			System.out.println("Buzz dispara laser!");
		else
			System.out.println("Buzz somente dispara laser com o capacete fechado");
	}
	
	public void voarBuzz() {
		if(asa)
			System.out.println("Buzz voando!");
		else
			System.out.println("Buzz somente voa com as asas abertas");
	}
	
}
