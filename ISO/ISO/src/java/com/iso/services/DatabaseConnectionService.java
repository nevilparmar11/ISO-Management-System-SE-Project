/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iso.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nitant
 */
public class DatabaseConnectionService {
    
    static Connection con;
    
    public static Connection getConnection(){
        if(con!=null){
            return con;
        }else{
            try {  
                Logger.getLogger(DatabaseConnectionService.class.getName()).log(Level.ALL, "I am here");
                Class.forName("com.mysql.jdbc.Driver");
               
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iso?autoReconnect=true&useSSL=false","root","");
                
                return con;
            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseConnectionService.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(DatabaseConnectionService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public static boolean closeConnection(){
        if(con!=null){
            try {
                con.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnectionService.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }else{
            return false;
        }
    }
}
