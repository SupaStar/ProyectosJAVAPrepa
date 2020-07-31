
package conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class conectar {
    
    Connection con=null;
    public Connection conexion(){
        try{
            //cargar el driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema","root","");
            System.out.println("Conexion establecida");
            JOptionPane.showMessageDialog(null, "Conexion establecida");
        } catch (SQLException e){
            System.out.println("Error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion" + e);
        }
        catch(ClassNotFoundException concec)  //conect es una variable
        {
            JOptionPane.showMessageDialog(null,"Diver no encontrado");
        }
        return con;
        }
    //Panta Toma De Agua
    public void guardar(String notoma,String nombre,String calle,String hora,String fecha,double montpg,double pago,double cambio)   // public void y despues una variable y el nombre de los campos a los cuales se ve a agregar los datos 
    {
        String sql = "INSERT INTO tomaagua(no_toma,nombre,calle,montpg,pago,cambio,hora,fecha) values (?,?,?,?,?,?,?,?);";  //igual se puede hacer en el boton donde se ingrese, la cantidad de ? va a variar dependiendo 
       
        try {
             PreparedStatement pst =con.prepareStatement(sql);   // pst es una variable // la variable sql es la de arriba y con es mi variable con la cual establesco mi conexion
             pst.setString(1,notoma);   //pst es el nombre de la variable
             pst.setString(2,nombre);
             pst.setString(3,calle);
             pst.setDouble(4,montpg);
             pst.setDouble(5,pago);
             pst.setDouble(6,cambio);
             pst.setString(7,hora);
             pst.setString(8,fecha);
            
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro exitoso");
             con.close();  //cierra la conexion
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema al registrar\n"+e.getMessage()+"\n"+e.getErrorCode());
        }
        
       
        
        /*public void cerrarConexion() throws ConnectionException {
	  	try {
		   con.close();
		}catch (SQLException  sqle) {
			throw new ConnectionException("Ha ocurrido un error al intentar cerrar la conexion con Oracle. Error:" + sqle.getMessage());                                   
		}
	} */
      //Pantalla Nueva Toma De Agua
    }
     public void guardarr (String nombre,String calle,String calle2,String calle3,String hora,String fecha,double montpg,double pago,double cambio)
        {
            String sql = "INSERT INTO nvatoma(nombre,calle,calle2,calle3,montpg,pago,cambio,hora,fecha) values (?,?,?,?,?,?,?,?,?);";
            
        try {
             PreparedStatement pst =con.prepareStatement(sql);   // pst es una variable // la variable sql es la de arriba y con es mi variable con la cual establesco mi conexion
             pst.setString(1,nombre);   //pst es el nombre de la variable
             pst.setString(2,calle);
             pst.setString(3,calle2);
             pst.setString(4,calle3);
             pst.setDouble(5,montpg);
             pst.setDouble(6, pago);
             pst.setDouble(7,cambio);
             pst.setString(8,hora);
             pst.setString(9,fecha);
            
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro exitoso");
             con.close();
             
         
          } 
             catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema al registrar\n"+e.getMessage()+"\n"+e.getErrorCode());
            }
        
        }
     
       //Pantalla Alumbrado Publico
      public void guardarrr (String nombre,String calle,String hora,String fecha,double montpg,double pago,double cambio)
        {
            String sql = "INSERT INTO alumbrado(nombre,calle,montpg,pago,cambio,hora,fecha) values (?,?,?,?,?,?,?);";
            
             try {
             PreparedStatement pst =con.prepareStatement(sql);   // pst es una variable // la variable sql es la de arriba y con es mi variable con la cual establesco mi conexion
             pst.setString(1,nombre);   //pst es el nombre de la variable
             pst.setString(2,calle);
             pst.setDouble(3,montpg);
             pst.setDouble(4,pago);
             pst.setDouble(5,cambio);
             pst.setString(6,hora);
             pst.setString(7,fecha);
            
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro exitoso");
             con.close();   
             
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema al registrar\n"+e.getMessage()+"\n"+e.getErrorCode());
        }
      }

         
          //Pantalla Permiso Eventos
          
      public void guardarrrr (String nombre,String direc,String fech,String hora1,String hora2,String hora,String fecha,double montpg,double pago,double cambio)
        {
            String sql = "INSERT INTO eventos(nombre,direccion,fecha_evento,hora_inicio,hora_termino,montpg,pago,cambio,hora,fecha) values (?,?,?,?,?,?,?,?,?,?);";
            
             try {
             PreparedStatement pst =con.prepareStatement(sql);   // pst es una variable // la variable sql es la de arriba y con es mi variable con la cual establesco mi conexion
             pst.setString(1,nombre);   //pst es el nombre de la variable
             pst.setString(2,direc);
             pst.setString(3,fech);
             pst.setString(4,hora1);
             pst.setString(5,hora2);
             pst.setDouble(6,montpg);
             pst.setDouble(7,pago);
             pst.setDouble(8,cambio);
             pst.setString(9,hora);
             pst.setString(10,fecha);
             
            
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro exitoso");
             con.close();
             
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema al registrar\n"+e.getMessage()+"\n"+e.getErrorCode());
        }
      }
      
      //Pantalla Permisos Puesto
      
      public void guardarrrrr (String nombre,String producto,String hora,String fecha,double montpg,double pago,double cambio)
        {
            String sql = "INSERT INTO puesto(nombre,producto,montpg,pago,cambio,hora,fecha) values (?,?,?,?,?,?,?);";
            
             try {
             PreparedStatement pst =con.prepareStatement(sql);   // pst es una variable // la variable sql es la de arriba y con es mi variable con la cual establesco mi conexion
             pst.setString(1,nombre);   //pst es el nombre de la variable
             pst.setString(2,producto);
             pst.setDouble(3,montpg);
             pst.setDouble(4,pago);
             pst.setDouble(5,cambio);
             pst.setString(6,hora);
             pst.setString(7,fecha);
             
             
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Registro exitoso");
             con.close();
             
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema al registrar\n"+e.getMessage()+"\n"+e.getErrorCode());
        }
      } 

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PreparedStatement PreparedStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    // tabla de toma de agua
    public ResultSet consultaRegistros()
    {
        ResultSet registros=null; // productos es variable
        String tomaagua="select * from tomaagua order by id_toma asc;";
        
        try {
            PreparedStatement pagos=this.con.prepareStatement(tomaagua);
            registros=pagos.executeQuery();  // los dtos se alamacenan en la variable registros
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al consultar tabla:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
        }
        return registros;
        
    }
    
    // tabla nueva toma
    
     public ResultSet consultaRegistross()
    {
        ResultSet registross=null; // registros es variable
        String nvatoma="select * from nvatoma order by id_nuvatoma asc;";
        
        try {
            PreparedStatement pagoss=this.con.prepareStatement(nvatoma);
            registross=pagoss.executeQuery();  // los dtos se alamacenan en la variable registros
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al consultar tabla:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
        }
        return registross;
        
    }
    
    //tabla alumbrado publico
     
      public ResultSet consultaRegistrosss()
    {
        ResultSet registrosss=null; // registros es variable
        String alumb="select * from alumbrado order by id_alum asc;";
        
        try {
            PreparedStatement pagosss=this.con.prepareStatement(alumb);
            registrosss=pagosss.executeQuery();  // los dtos se alamacenan en la variable registros
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al consultar tabla:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
        }
        return registrosss;
        
    }
      
      //tabla permisos eventos sociales
      
        public ResultSet consultaRegistrossss()
    {
        ResultSet registrossss=null; // registros es variable
        String event="select * from eventos order by id_evento asc;";
        
        try {
            PreparedStatement pagossss=this.con.prepareStatement(event);
            registrossss=pagossss.executeQuery();  // los dtos se alamacenan en la variable registros
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al consultar tabla:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
        }
        return registrossss;
        
    }
        //tabla poner un puesto
        
             public ResultSet consultaRegistrosssss()
    {
        ResultSet registrosssss=null; // registros es variable
        String puestt="select * from puesto order by id_puest asc;";
        
        try {
            PreparedStatement pagosssss=this.con.prepareStatement(puestt);
            registrosssss=pagosssss.executeQuery();  // los dtos se alamacenan en la variable registros
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al consultar tabla:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
        }
        return registrosssss;
        
    }
     //Buscador pantalla Toma De Agua
     
     public  ResultSet buscar(String valor){
        ResultSet buscarr=null;
        String mostrar="SELECT * FROM tomaagua WHERE CONCAT(id_toma,no_toma,nombre,calle,montpg,pago,cambio,hora,fecha)LIKE '%" +valor+ "%';";
         System.out.println(""+mostrar);
        
         try {
              PreparedStatement busqueda=this.con.prepareStatement(mostrar);
              buscarr=busqueda.executeQuery();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
         }
        
        return buscarr;
     }
     
     //Buscador pantalla Nueva Toma De Agua
     
     public  ResultSet buscarr(String valor){
        ResultSet buscarrr=null;
        String mostrar="SELECT * FROM nvatoma WHERE CONCAT(id_nuvatoma,nombre,calle,calle2,calle3,montpg,pago,cambio,hora,fecha)LIKE '%" +valor+ "%';";
         System.out.println(""+mostrar);
        
         try {
              PreparedStatement busqueda=this.con.prepareStatement(mostrar);
              buscarrr=busqueda.executeQuery();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
         }
        
        return buscarrr;
     }
     
     //Buscador pantalla Alumbrado Publico
     
      public  ResultSet buscarrr(String valor){
        ResultSet buscarrrr=null;
        String mostrar="SELECT * FROM alumbrado WHERE CONCAT(id_alum,nombre,calle,montpg,pago,cambio,hora,fecha)LIKE '%" +valor+ "%';";
         System.out.println(""+mostrar);
        
         try {
              PreparedStatement busqueda=this.con.prepareStatement(mostrar);
              buscarrrr=busqueda.executeQuery();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
         }
        
        return buscarrrr;
     }
     
      
      //Buscador pantalla Permiso Eventos Sociales
      
       public  ResultSet buscarrrr(String valor){
        ResultSet buscarrrrr=null;//solo para consultar
        String mostrar="SELECT * FROM eventos WHERE CONCAT(id_evento,nombre,direccion,fecha_evento,hora_inicio,hora_termino,montpg,pago,cambio,hora,fecha)LIKE '%" +valor+ "%';";
         System.out.println(""+mostrar);
        
         try {
              PreparedStatement busqueda=this.con.prepareStatement(mostrar);
              buscarrrrr=busqueda.executeQuery();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
         }
        
        return buscarrrrr;
     }
       
       //Buscador pantalla Permisos Poner Un Puesto
       
       public  ResultSet buscarrrrr(String valor){
        ResultSet buscarrrrrr=null;
        String mostrar="SELECT * FROM puesto WHERE CONCAT(id_puest,nombre,producto,montpg,pago,cambio,hora,fecha)LIKE '%" +valor+ "%';";
         System.out.println(""+mostrar);
        
         try {
              PreparedStatement busqueda=this.con.prepareStatement(mostrar);
              buscarrrrrr=busqueda.executeQuery();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al buscar:\n"+ex.getErrorCode()+"\n"+ex.getMessage());
             
         }
        
        return buscarrrrrr;
     }
       
       //eliminar Pantalla Toma de Agua
       
       public void eliminar(int id_toma){
          PreparedStatement eliminarr = null;           
           try {
               PreparedStatement pps =con.prepareStatement("DELETE FROM tomaagua WHERE id_toma=?;");  
               pps.setInt(1,id_toma);
               pps.execute();
             JOptionPane.showMessageDialog(null, "El pago se elimino");
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Dato no eliminado\n"+ex.getErrorCode()+"\n"+ex.getMessage());
           }       
             
       }
       
       }
      
     