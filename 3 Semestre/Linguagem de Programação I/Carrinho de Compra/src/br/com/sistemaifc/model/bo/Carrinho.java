package br.com.sistemaifc.model.bo;

import br.com.sistemaifc.model.vo.Item;
import br.com.sistemaifc.model.vo.Produto;
import java.util.ArrayList;

public class Carrinho {

    private ArrayList<Item> ItensCompra;

    public Carrinho() {
        this.ItensCompra = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade, boolean garantia) {
        Item item = new Item(produto, quantidade, garantia);
        this.ItensCompra.add(item);

    }

    public ArrayList<Item> getItensCompra() {
        return ItensCompra;
    }

    public void removerItem(Item item) {
        this.ItensCompra.remove(item);
    }

    public void removerItem(int i) {
        this.ItensCompra.remove(i);
    }

    public void alterarQuantidade(int i, int quantidade) {
        Item item = this.ItensCompra.get(i);
        item.setQuantidade(quantidade);

    }

    public double totalizarCompra() {
        double total = 0;
        for (Item item : ItensCompra) {
            double parcial = item.getProduto().getValor() * item.getQuantidade() + item.getProduto().getFrete();
            total += parcial;
        }

        return total;
    }
}
