
package Sistema;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import conectar.conectar;   //asi se llama mi carpeta y mi clase de la conexion
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;


public class NvoRegistro extends javax.swing.JFrame {
private SimpleDateFormat f;
private conectar con;  // se crea la variable para poder conectar
private DefaultTableModel tabla;
private ResultSet registross;
private ResultSet rs;

    
    public NvoRegistro() {
         initComponents();
         this.setLocationRelativeTo(null); // poner el formulario al centro de la pantalla
         Calendar cal = Calendar.getInstance();
         String hora = cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND); // Poner la hora del sistema de la conputadora
         jLabel3.setText(hora);//depende de donde se quiera visualizar
         f = new SimpleDateFormat("yyyy-MM-dd"); //FECHA
         jLabel5.setText(f.format(new Date()));//depende de donde se quiera visualizar
         
         tabla=(DefaultTableModel) jTable1.getModel();
         con=new conectar();//conecta con la clase para todos los botones
      
    }
             void limpiar()
                {
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField7.setText("");
                    jDateChooser1.setDate(null);
                    jTextField1.requestFocus();
                }
             
         void modificar(){
          int fila = jTable1.getSelectedRow();
          if(fila>=0)
        {
         jTextField1.setText(jTable1.getValueAt(fila,1).toString());
         jTextField2.setText(jTable1.getValueAt(fila,2).toString());
         jTextField3.setText(jTable1.getValueAt(fila,3).toString());
         jTextField4.setText(jTable1.getValueAt(fila,4).toString());
         jTextField8.setText(jTable1.getValueAt(fila,8).toString());
         jTextField5.setText(jTable1.getValueAt(fila,5).toString());
         jTextField6.setText(jTable1.getValueAt(fila,6).toString());
         jTextField7.setText(jTable1.getValueAt(fila,7).toString());
         // jDateChooser1.setDate(jTable1.getValueAt(fila,7).toString()); 
        }
          else
           {
              JOptionPane.showMessageDialog(rootPane,"Fila no seleccionada");
           }
                 
                 
      }
             
             void buscar(){
                String valor=JOptionPane.showInputDialog(this,"Intruduce el nombre a buscar");        
        
                String []titulos={"id","Nombre","Calle","Calle 2","Calle 3","Monto Pagado","Pago","Cambio","Hora del Pago","Fecha del Pago"};   //nombre de los compos de la jTable1
                String[]datos=new String[10];
                 
                 try {
                     
                     con.conexion();
              rs=con.buscarr(valor); //debe de ser de acuerdo al metodo que se creo en la clase
            
            while(rs.next())
            {
                datos[0]=rs.getString("id_nuvatoma");
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("calle");
                datos[3]=rs.getString("calle2");
                datos[4]=rs.getString("calle3");
                datos[5]=rs.getString("montpg");
                datos[6]=rs.getString("pago");
                datos[7]=rs.getString("cambio");
                datos[8]=rs.getString("hora");
                datos[9]=rs.getString("fecha");
                tabla.addRow(datos);
                
            }
            jTable1.setModel(tabla);
                     
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(rootPane,ex.getMessage());
                 }
                 
             }
             
             
            
             void mostrartabla(){
                 
                 // con = new conectar();  //crear varible
                 con.conexion();
                 registross=con.consultaRegistross(); //registross es por la variable que cree arriba el .con es el nombre de mi conexion
                 
                 
                 try {
                     
                     while (registross.next()){
                          tabla.addRow(new Object[]{
                          registross.getString("id_nuvatoma"),
                          registross.getString("nombre"),
                          registross.getString("calle"),
                          registross.getString("calle2"),
                          registross.getString("calle3"),
                          registross.getDouble("montpg"),
                          registross.getDouble("pago"),
                          registross.getDouble("cambio"),
                          registross.getString("hora"),
                          registross.getString("fecha")
          
                           });
                     }
                     
                     
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                     Logger.getLogger(NvoRegistro.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                
                    
             }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 3, 36)); // NOI18N
        jLabel1.setText("Nuevo Registro Toma De Agua");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 480, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel2.setText("Hora:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 50, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel3.setText("Hora");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 80, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel6.setText("Nombre Del Propietario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 179, -1));

        jLabel7.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel7.setText("Calle");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, -1));

        jLabel8.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel8.setText("Calle 2");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 80, -1));

        jLabel9.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel9.setText("Calle 3");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 80, -1));

        jLabel10.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel10.setText("Persona Originaria Del Pueblo");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 240, -1));

        jLabel11.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel11.setText("Monto A Pagar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, 20));

        jLabel12.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel12.setText("Pago");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 70, 20));

        jLabel13.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel13.setText("Cambio");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 60, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 230, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 300, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 280, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 270, -1));

        jComboBox1.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "SI", "NO" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 100, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 100, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 120, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 110, -1));

        jLabel14.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel14.setText("Hora del Pago");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, -1));

        jLabel15.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel15.setText("Fecha del Pago");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 110, -1));
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 80, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 100, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton1.setText("Realizar Pago");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 21, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton2.setText("Nuevo Registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 53, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton3.setText("Imprimir Recibo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 85, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton6.setText("Menú");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 117, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton9.setText("Actualizar");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton10.setText("Mostrar Pagos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 160, 360));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Calle ", "Calle 2", "Calle 3", "Monto Pagado", "Pago", "Cambio", "Hora del Pago", "Fecha del Pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 750, 130));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesSistema/agua.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.buscar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Menu men = new Menu();
men.setVisible(true);
this.dispose();
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try{   
        String nombre,calle,calle2,calle3,hora,fecha;
        double montpg,pago,cambio;
        nombre=jTextField1.getText();
        calle=jTextField2.getText();
        calle2=jTextField3.getText();
        calle3=jTextField4.getText();
        montpg=Double.parseDouble(jTextField5.getText());
        pago=Double.parseDouble(jTextField6.getText());
        cambio=pago-montpg;
        
        hora=jTextField8.getText();
        fecha=jDateChooser1.getDate().toString();
        
        if(pago>=montpg){
        jTextField7.setText(String.valueOf(cambio));
        JOptionPane.showMessageDialog(rootPane,"El cambio es de : "+ cambio);
        JOptionPane.showMessageDialog(rootPane,"El Pago Se Hecho Correctamente");
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"El pago es insuficiente \nVuelva a intentarlo");
        }
       
   }
 catch(Exception e)
 {
     JOptionPane.showMessageDialog(rootPane,"Alguno De Tus Datos Es Incorrecto \nVerifica Tus Datos");
 }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
double montpg=0;

        Integer indice = jComboBox1.getSelectedIndex();
   switch(indice)
   {
       case 1:
           montpg=3000;
           break;
       case 2:
           montpg=5000;
           break;
       default:
       break;
   }
 jTextField5.setText(String.valueOf(montpg));  
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ReciboNvoRegistro recibo = new ReciboNvoRegistro();
recibo.setVisible(true);
this.dispose();
 ReciboNvoRegistro.jLabel3.setText(jTextField1.getText());  
 ReciboNvoRegistro.jLabel6.setText(jTextField2.getText());
 ReciboNvoRegistro.jLabel8.setText(jTextField3.getText());
 ReciboNvoRegistro.jLabel10.setText(jTextField4.getText());
 ReciboNvoRegistro.jLabel16.setText(jTextField5.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   
        //con = new conectar();  //crear varible
        con.conexion();
         String nombre,calle,calle2,calle3,hora,fecha;
        double montpg,pago,cambio;
       // con.guarda(nombre, calle, calle2, calle3, hora, fecha, WIDTH, ERROR, SOMEBITS);
       // con.guardarr("Pancho","Santa Lucia","San Juan","San Pedro","8 pm","2015-07-15",2000,3000,1000);
   try{ 
       con.guardarr(
         nombre=jTextField1.getText(),
         calle=jTextField2.getText(),
         calle2=jTextField3.getText(),
         calle3=jTextField4.getText(),      
         hora=jTextField8.getText(),
         fecha=f.format(jDateChooser1.getDate()),
         montpg=Double.parseDouble(jTextField5.getText()),
         pago=Double.parseDouble(jTextField6.getText()),
         cambio=Double.parseDouble(jTextField7.getText())
               
       );
       this.mostrartabla();
    }
    catch(NullPointerException nu)   // nu es una variable
        {
            JOptionPane.showMessageDialog(rootPane, "Faltan campos.");
        }
        catch(NumberFormatException num)
        {
            JOptionPane.showMessageDialog(rootPane, "Campos numericos con texto.");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
   this.mostrartabla();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
this.modificar(); // esto es or el metodo q se creo en el constructor
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NvoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NvoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NvoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NvoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NvoRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
