/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Justi
 */
public class ClienteDAO {
    
    public static final int S_CPF_CNPJ = 1;
    public static final int S_NOME = 2;
    public static final int S_RAZAO_SOCIAL = 3;
    
    ConnectionDB conDB = new ConnectionDB();
    Connection con;
   
    public ClienteDAO(){
        con = conDB.ConnectionJDBC();
        if(con == null){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados!");
            System.exit(0);
        }
    }
    
    public int insertCliente(Cliente c){
        String query = "INSERT INTO cliente "
                + "(cpf_cnpj, rg_ie, nome, razaoSocial, endereco, numero, complemento, cep, "
                + "bairro, cidade, estado, telefone1, telefone2, email) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";      
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, c.getCpf_cnpj());
            st.setString(2, c.getRg_ie());
            st.setString(3, c.getNome());
            st.setString(4, c.getRazaoSocial());
            st.setString(5, c.getEndereco());
            st.setString(6, c.getNumero());
            st.setString(7, c.getComplemento());
            st.setString(8, c.getCep());
            st.setString(9, c.getBairro());
            st.setString(10, c.getCidade());
            st.setString(11, c.getEstado());
            st.setString(12, c.getTelefone1());
            st.setString(13, c.getTelefone2());
            st.setString(14, c.getEmail());
            //JOptionPane.showMessageDialog(null, query);
            st.executeUpdate();
        } catch (SQLException ex) {
            if(ex.getMessage().contains("duplicate key"))
                return 0;
            else return -1;
        }
        return 1;
    }
    
    public int updateCliente(Cliente c, String oldKey){
        
        String query = "UPDATE cliente set cpf_cnpj = ?, rg_ie = ?, nome = ?, razaoSocial = ?,"
                + " endereco = ?, numero = ?, complemento = ?, cep = ?,"
                + " bairro = ?, cidade = ?, estado = ?, telefone1 = ?, telefone2 = ?,"
                + " email = ? WHERE cpf_cnpj = ?";
        
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, c.getCpf_cnpj());
            st.setString(2, c.getRg_ie());
            st.setString(3, c.getNome());
            st.setString(4, c.getRazaoSocial());
            st.setString(5, c.getEndereco());
            st.setString(6, c.getNumero());
            st.setString(7, c.getComplemento());
            st.setString(8, c.getCep());
            st.setString(9, c.getBairro());
            st.setString(10, c.getCidade());
            st.setString(11, c.getEstado());
            st.setString(12, c.getTelefone1());
            st.setString(13, c.getTelefone2());
            st.setString(14, c.getEmail());
            
            st.setString(15, oldKey);
            
            //JOptionPane.showMessageDialog(null, query);
            st.executeUpdate();
        } catch (SQLException ex) {
            if(ex.getMessage().contains("duplicate key"))
                return 0;
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return -1;
        }
        return 1;       
    }
    
    public int deleteCliente(String cpf_cnpj){
        String query = "DELETE FROM cliente WHERE cpf_cnpj = ?";
        
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, cpf_cnpj);
            st.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return -1;
        }
        return 1; 
    }
    
    public List<Cliente> searchCliente(Cliente c, int search_for){
        
        String query1 = "SELECT * FROM cliente";
        String query2 = ";";
        Cliente cS;
        List<Cliente> lc = new ArrayList<>();
           
        switch(search_for){
            case S_CPF_CNPJ: query2 = " WHERE cpf_cnpj = ?"; break;
            case S_NOME: query2 = " WHERE nome ILIKE ?"; break;
        }
        
        try {
            PreparedStatement st = con.prepareStatement(query1+query2);
            switch(search_for){
                case S_CPF_CNPJ: st.setString(1, c.getCpf_cnpj()); break;
                case S_NOME: st.setString(1, c.getNome() + "%"); break;
            }
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                cS = new Cliente(rs.getString("cpf_cnpj"), rs.getString("rg_ie"), 
                        rs.getString("nome"), rs.getString("razaoSocial"), 
                        rs.getString("endereco"), rs.getString("numero"),
                        rs.getString("complemento"), rs.getString("cep"),
                        rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"),
                        rs.getString("telefone1"), rs.getString("telefone2"),
                        rs.getString("email"));
                
                lc.add(cS);
                //JOptionPane.showMessageDialog(null, pS);
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
       
        return lc;
        
    }
    
    
}
