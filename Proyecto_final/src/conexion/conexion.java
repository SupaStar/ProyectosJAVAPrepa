/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Robert
 */
public class conexion {
    Connection conect=null;
   public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/tesoreria","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
    return conect;
    }
}

