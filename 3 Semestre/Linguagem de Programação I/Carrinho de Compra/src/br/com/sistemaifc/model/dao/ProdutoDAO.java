package br.com.sistemaifc.model.dao;

import br.com.sistemaifc.model.vo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    
    private Connection con;
    
    public ProdutoDAO(){
        this.con = ConexaoBD.conectar();
    }
    
    //cadastrar produto
    public boolean cadastrarProduto(Produto produto){
        try{
            String sql = "insert into produto (nome, valor, frete) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setDouble(3, produto.getFrete());
            
            return stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //remover produto
    public boolean removerProduto(Produto produto){
        try{
            String sql = "delete from produto where idproduto=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getIdProduto());
            
            return stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //atualizar produto
    public boolean atualizarProduto(Produto produto){
        try{
            String sql = "update produto set nome=?, valor=?, frete=? where idproduto=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setDouble(3, produto.getFrete());
            stmt.setInt(4, produto.getIdProduto());
            
            return stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    //consultar produto
    public ArrayList<Produto> consultarProduto(){
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from produto");

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setValor(rs.getDouble("frete"));
            
            produtos.add(produto);
        }

        stmt.close();
        rs.close();
        } catch (SQLException e) {
               e.printStackTrace();
        }
        return produtos;
    }
    
    public ArrayList<Produto> consultarProdutoPorNome(String nome){
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from produto where nome like '%"+nome+"%'");

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setValor(rs.getDouble("frete"));
            
            produtos.add(produto);
        }

        stmt.close();
        rs.close();
        } catch (SQLException e) {
               e.printStackTrace();
        }
        return produtos;
    }
    
    public ArrayList<Produto> consultarProdutoLimit(int qtd){
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from produto limit 0," + qtd);

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setValor(rs.getDouble("frete"));
            
            produtos.add(produto);
        }

        stmt.close();
        rs.close();
        } catch (SQLException e) {
               e.printStackTrace();
        }
        return produtos;
    }
    
    public ArrayList<Produto> consultarProdutoAleatorios(int qtd){
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from produto order by rand() limit 0," + qtd);

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setValor(rs.getDouble("frete"));
            
            produtos.add(produto);
        }

        stmt.close();
        rs.close();
        } catch (SQLException e) {
               e.printStackTrace();
        }
        return produtos;
    }
}