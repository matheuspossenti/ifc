package herança;

public class Main {
    public static void main(String[] args) {
        Funcionario roberto = new Funcionario("Thiago", 2);
        Gerente marcos = new Gerente("Vendas", "Chrismene", 0.50);
        Vendedor jonathan = new Vendedor(0.3, "Vini", 2000);
        Diretor manasses = new Diretor(6000, "Manasses", 12000);
        
        System.out.println(roberto);
        System.out.println(marcos);
        System.out.println(jonathan);
        System.out.println(manasses);
    }
}
