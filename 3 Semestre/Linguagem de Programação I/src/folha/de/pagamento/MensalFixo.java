package folha.de.pagamento;

public class MensalFixo extends Funcionario{
    
    protected double salarioBase;

    public MensalFixo(double salarioBase, int id, String nome) {
        super(id, nome);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    @Override
    public double calcularSalario() {
        super.salario = this.salarioBase;
        return super.salario;
    }
}
