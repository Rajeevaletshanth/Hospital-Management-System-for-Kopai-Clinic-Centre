
package Pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConection {
    Connection conn;
    
    public DBConection ()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopaicliniccentre", "root", "");
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public Connection GetConection()
    {
        return conn;
    }
}
