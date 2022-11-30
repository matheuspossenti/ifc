package folha.de.pagamento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MensalFixo mf1 = new MensalFixo(1500, 1, "");
        MensalFixo mf2 = new MensalFixo(2000, 2, "");
        Horista h1 = new Horista(50, 100, 1500, 3, "");
        Comissionado c1 = new Comissionado(50000, 0.1, 4, "");
        Comissionado c2 = new Comissionado(100000, 0.1, 5, "");
        ComissionadoEfetivo ce1 = new ComissionadoEfetivo(1500, 50000, 0.1, 6, "");
        Gerente g1 = new Gerente(5000, 2500, 7, "");
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios.add(mf1);
        funcionarios.add(mf2);
        funcionarios.add(h1);
        funcionarios.add(c1);
        funcionarios.add(c2);
        funcionarios.add(ce1);
        funcionarios.add(g1);
        
        
        double folha = FolhaDePagamento.gerarFolha(funcionarios);
        System.out.println("Querido Jandir, sua folha de pagamento foi: R$" + folha);
    }
}
