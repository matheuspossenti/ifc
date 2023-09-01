package herança;

public class Vendedor extends Funcionario{
    private double comissao;

    public Vendedor(double comissao, String nome, double salario) {
        super(nome, salario);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public double calcularSalario(){
        return this.salario + this.salario*comissao;
    }

    @Override
    public String toString() {
        return super.toString() + ", comissão = " + comissao*100 + "%, salario completo = " + calcularSalario();
    }
    
    
}
