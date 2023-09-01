package folha.de.pagamento;

public class Horista extends MensalFixo{
    
    private double horasTrabalhadas;
    private double valorHora;

    public Horista(double horasTrabalhadas, double valorHora, double salarioBase, int id, String nome) {
        super(salarioBase, id, nome);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        if(this.horasTrabalhadas>40)
            super.salario = super.salarioBase + (this.horasTrabalhadas-40)*this.valorHora;
        else
            super.calcularSalario();
        return super.salario;
    }
    
    
}
