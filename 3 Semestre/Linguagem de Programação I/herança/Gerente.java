
package herança;

public class Gerente extends Funcionario{
    private String departamento;

    public Gerente(String departamento, String nome, double salario) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {    
        return super.toString() + ", departamento = " + departamento;
    }
    
}
