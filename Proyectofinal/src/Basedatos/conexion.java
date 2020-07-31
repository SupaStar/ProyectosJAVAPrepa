
package Basedatos;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Obed Martinez
 */
public class conexion {
    
    Connection conect=null;
   public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_final","root","");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
    return conect;
    }

}
