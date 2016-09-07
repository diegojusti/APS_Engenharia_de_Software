/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Justi
 */
public class ProdutoDAO {
    
    public static final int S_CODIGO = 1;
    public static final int S_NOME = 2;
    
    ConnectionDB conDB = new ConnectionDB();
    Connection con;
   
    public ProdutoDAO(){
        con = conDB.ConnectionJDBC();
        if(con == null){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados!");
            System.exit(0);
        }
    }
    
    public int insertProduto(Produto p){
        String query = "INSERT INTO produto (codProduto, nome, marca, tipo, preco, qtd) VALUES "
                + "(" + p.getCodProduto() + ", '" + p.getNome() + "', '" + p.getMarca() + "', '"
                + p.getTipo() + "', " + p.getPreco() + ", " + p.getQtd() + ");";
        
        try {
            Statement st = con.createStatement();
            //JOptionPane.showMessageDialog(null, query);
            st.executeUpdate(query);
        } catch (SQLException ex) {
            if(ex.getMessage().contains("duplicate key"))
                return 0;
            else return -1;
        }
        return 1;
    }
    
    public int updateProduto(Produto p, int oldKey){
        
        String query = "UPDATE produto set codProduto = "
                + p.getCodProduto() + ", nome = '" + p.getNome() + "',"
                + "marca = '" + p.getMarca() + "', tipo = '" + p.getTipo() + "',"
                + "preco = " + p.getPreco() + ", qtd = " + p.getQtd() + " WHERE codProduto = " + oldKey + ";";
        
        try {
            Statement st = con.createStatement();
            //JOptionPane.showMessageDialog(null, query);
            st.executeUpdate(query);
        } catch (SQLException ex) {
            if(ex.getMessage().contains("duplicate key"))
                return 0;
            return -1;
        }
        return 1;       
    }
    
    public int deleteProduto(int CodProduto){
        String query = "DELETE FROM produto WHERE codProduto = " + CodProduto + ";";
        
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            return -1;
        }
        return 1; 
    }
    
    public List<Produto> searchProduto(Produto p, int search_for){
        
        String query1 = "SELECT * FROM produto";
        String query2 = ";";
        Produto pS;
        List<Produto> lp = new ArrayList<>();
           
        switch(search_for){
            case S_CODIGO: query2 = " WHERE codProduto = " + p.getCodProduto() + ";"; break;
            case S_NOME: query2 = " WHERE nome LIKE '%" + p.getNome() + "%';"; break;
        }
        
        try {
            Statement st = con.createStatement();
            //JOptionPane.showMessageDialog(null, query1+query2);
            ResultSet rs = st.executeQuery(query1+query2);
            
            while(rs.next()){
                pS = new Produto(rs.getInt("codProduto"), rs.getString("nome"), 
                        rs.getString("marca"), rs.getString("tipo"), rs.getFloat("preco"), rs.getInt("qtd"));
                
                lp.add(pS);
                //JOptionPane.showMessageDialog(null, pS);
            }        
        } catch (SQLException ex) {
            return null;
        }
       
        return lp;
        
    }
    
    
}
