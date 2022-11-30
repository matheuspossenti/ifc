package folha.de.pagamento;

public abstract class Funcionario {
    private int id;
    private String nome; 
    protected double salario;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }
    
    public abstract double calcularSalario();
    
    
}
