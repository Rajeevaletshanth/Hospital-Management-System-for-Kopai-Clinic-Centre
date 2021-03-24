
package Inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class dbconn {
    
     static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/yarlmothercare";
    static String UN= "root";
    static String PW = "";
    
    public static Connection ConnectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = null;
            System.out.println("Connecting to a DataBase. Please wait..");
            connect = DriverManager.getConnection(DB_URL,UN,PW);
            System.out.println("Connected Successfully");
            return connect;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(dbconn.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }   
}