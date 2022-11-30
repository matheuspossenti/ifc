package folha.de.pagamento;

public class Gerente extends Funcionario{
    private double salarioBase;
    private double participacaoLucro;

    public Gerente(double salarioBase, double participacaoLucro, int id, String nome) {
        super(id, nome);
        this.salarioBase = salarioBase;
        this.participacaoLucro = participacaoLucro;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getParticipacaoLucro() {
        return participacaoLucro;
    }

    public void setParticipacaoLucro(double participacaoLucro) {
        this.participacaoLucro = participacaoLucro;
    }

    @Override
    public double calcularSalario() {
        super.salario = this.salarioBase + this.participacaoLucro;
        return super.salario;
    }
    
    
}
