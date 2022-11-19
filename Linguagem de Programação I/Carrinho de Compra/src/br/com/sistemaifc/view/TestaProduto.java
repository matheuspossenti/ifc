
package br.com.sistemaifc.view;

import br.com.sistemaifc.model.dao.ProdutoDAO;
import br.com.sistemaifc.model.vo.Produto;

public class TestaProduto {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        Produto produto = new Produto();
        produto.setIdProduto(3);
        
        produtoDAO.removerProduto(produto);
    }
    
    
}
