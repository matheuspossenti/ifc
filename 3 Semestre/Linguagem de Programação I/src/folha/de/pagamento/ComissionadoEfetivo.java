package folha.de.pagamento;

public class ComissionadoEfetivo extends Comissionado{
    private double salarioBase;

    public ComissionadoEfetivo(double salarioBase, double totalVendas, double percentual, int id, String nome) {
        super(totalVendas, percentual, id, nome);
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
        super.salario = this.salarioBase + super.calcularSalario();
        return super.salario;
    }
    
    
}
