package br.com.sistemaifc.model.vo;

public class Produto {

    private int idProduto;
    private String nome;
    private double valor;
    private double frete;

    
    
    public Produto() {
        this.idProduto = 0;
        this.nome = "";
        this.valor = 0;
        this.frete = 0;
    }

    public Produto(int idProduto, String nome, double valor, double frete) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.frete = frete;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    @Override
    public String toString(){
        return nome;
    }
}
