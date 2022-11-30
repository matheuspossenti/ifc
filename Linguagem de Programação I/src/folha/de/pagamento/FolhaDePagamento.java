package folha.de.pagamento;

import java.util.List;

public class FolhaDePagamento {
    public static double gerarFolha(List<Funcionario> funcionarios) {
        double totalFolha = 0;
        for (Funcionario f : funcionarios){
            totalFolha += f.calcularSalario();
        }
        
        return totalFolha;
    }
    
}
