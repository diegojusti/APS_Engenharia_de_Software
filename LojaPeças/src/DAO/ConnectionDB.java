/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Justi
 */
public class ConnectionDB {
    
    private String url, user, password;
    private Connection con;
    
    public Connection ConnectionJDBC(){
        url = "jdbc:postgresql://localhost:5432/lojaPecas";
        user = "postgres";
        password = "0";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Connection ConnectionJDBC(String user, String password){
        url = "jdbc:postgresql://localhost:5432/lojaPecas";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
