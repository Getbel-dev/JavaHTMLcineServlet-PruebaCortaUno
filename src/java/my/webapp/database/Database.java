/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Administrador
 */
public class Database {
    
    
     Connection conn;

    public Database() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/Cine", "root", "Admin$1234");

        } catch (ClassNotFoundException | SQLException ex) {

            System.getLogger(Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);

        }
    }

    public Connection getConnection() {

        return conn;
    }
    
    public void closed (){
        try{
            
            conn.close();
            
        }catch (SQLException ex){
            
            System.getLogger(Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }         
    }
    
}
