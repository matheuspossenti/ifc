package herança;

import java.util.Calendar;
import java.util.Date;

public class Diretor extends Funcionario{
    private double participacaoLucros;

    public Diretor(double participacaoLucros, String nome, double salario) {
        super(nome, salario);
        this.participacaoLucros = participacaoLucros;
    }

    public double getParticipacaoLucros() {
        return participacaoLucros;
    }

    public void setParticipacaoLucros(double participacaoLucros) {
        this.participacaoLucros = participacaoLucros;
    }
    
    private int obterMes(){
        Date data = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        return c.get(Calendar.MONTH)+1;
    }
    
    public double calcularSalario(){
        if (obterMes() == 6 || obterMes() == 12)
            return salario + participacaoLucros;
        return salario;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", participação = " + participacaoLucros + ", salario completo = " + calcularSalario();
    }
    
    
}
