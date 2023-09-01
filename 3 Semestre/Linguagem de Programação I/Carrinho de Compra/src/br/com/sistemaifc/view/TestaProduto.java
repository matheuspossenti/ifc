
package br.com.sistemaifc.view;

import br.com.sistemaifc.model.dao.ProdutoDAO;
import br.com.sistemaifc.model.vo.Produto;
import java.util.ArrayList;

public class TestaProduto {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        ArrayList<Produto> produtos = produtoDAO.consultarProduto();
        
        
        
    }
    
    
}
