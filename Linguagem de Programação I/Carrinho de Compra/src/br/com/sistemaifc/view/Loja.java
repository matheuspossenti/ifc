package br.com.sistemaifc.view;

import br.com.sistemaifc.model.bo.Carrinho;
import br.com.sistemaifc.model.vo.Item;
import br.com.sistemaifc.model.vo.Produto;
import java.util.ArrayList;

public class Loja {

    public static void main(String[] args) {
        Produto p1 = new Produto(0, "Tv CCE 14", 3000, 100);
        Produto p2 = new Produto(1, "Celular Xingling ABC", 1500, 50);
        Produto p3 = new Produto(2, "Tudo Sobre Java", 150, 0);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem(p3, 2, false);
        carrinho.adicionarItem(p2, 3, true);

        ArrayList<Item> itens = carrinho.getItensCompra();

        int c = 0;
        for (Item item : itens) { 
            c++;
            System.out.println("Produto " + c);
            System.out.println(item.getProduto().getNome() + ": R$ " + item.getProduto().getValor() + " Qtdade: " + item.getQuantidade());

        }
        System.out.println("Total: R$ " + carrinho.totalizarCompra());
        // teste remoção
        //Item itemR = itens.get(1);
        //carrinho.removerItem(0);

        //teste de alteração
        carrinho.alterarQuantidade(1, 1);

        c = 0;
        for (Item item : itens) {
            c++;
            System.out.println("Produto " + c);
            System.out.println(item.getProduto().getNome() + ": R$ " + item.getProduto().getValor() + " Qtdade: " + item.getQuantidade());

        }

    }
}
