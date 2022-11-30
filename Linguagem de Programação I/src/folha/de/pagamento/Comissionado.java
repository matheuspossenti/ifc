package folha.de.pagamento;

public class Comissionado extends Funcionario{
    
    private double totalVendas;
    //exemplo: 0.1=10%; 0.25=25%; 0.3=30%
    private double percentualComissao;

    public Comissionado(double totalVendas, double percentual, int id, String nome) {
        super(id, nome);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentual;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        super.salario = this.totalVendas*this.percentualComissao;
        return super.salario;
    }
    
    
}
