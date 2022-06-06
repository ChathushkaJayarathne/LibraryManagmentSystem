/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author U S E R
 */

//database connector method 
public class DatabaseConnector {
    public static int loginAttempt = 0;
        public static Connection c;

    public static Connection getCon() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                c = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "");
            }
            catch (SQLException e) {
                System.out.println("Authentication or JDBC failure");
            }          
        }        
        return c;
    }
    
    
    public static void  closeConnection() throws SQLException{        
        if (c != null) {        
            c.close();
            System.out.println("connection closed");            
        }            
    }    
}