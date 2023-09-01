package br.com.sistemaifc.model.vo;

import br.com.sistemaifc.model.vo.Produto;

public class Item {

    private Produto produto;
    private int quantidade;
    private boolean garantia;

    public Item(Produto produto, int quantidade, boolean garantia) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.garantia = garantia;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

}
