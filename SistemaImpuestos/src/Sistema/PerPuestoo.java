package Sistema;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import conectar.conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PerPuestoo extends javax.swing.JFrame {
    
    private SimpleDateFormat f;
    private conectar con;
    private DefaultTableModel tabla;
    private ResultSet registrossssss;
    private ResultSet rs;

    public PerPuestoo() {
        initComponents();
        this.setLocationRelativeTo(null); // poner el formulario al centro de la pantalla
        Calendar cal = Calendar.getInstance();
        String hora = cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND); // Poner la hora del sistema de la conputadora
        jLabel3.setText(hora);//depende de donde se quiera visualizar
        f = new SimpleDateFormat("yyyy-MM-dd"); //FECHA
        jLabel5.setText(f.format(new Date()));//depende de donde se quiera visualizar
        
         tabla=(DefaultTableModel) jTable1.getModel();
         con = new conectar();  //crear varible
        
    }
    void limpiar()
                    {
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jDateChooser1.setDate(null);
                    jTextField1.requestFocus();
                  }
    
    void modificar(){
        int fila = jTable1.getSelectedRow();
       if(fila>=0)
       {
         jTextField1.setText(jTable1.getValueAt(fila,1).toString());
         jTextField2.setText(jTable1.getValueAt(fila,2).toString());
         jTextField6.setText(jTable1.getValueAt(fila,6).toString());
         jTextField3.setText(jTable1.getValueAt(fila,3).toString());
         jTextField4.setText(jTable1.getValueAt(fila,4).toString());
         jTextField5.setText(jTable1.getValueAt(fila,5).toString());
         // jDateChooser1.setDate(jTable1.getValueAt(fila,7).toString()); 
       }
       else
       {
         JOptionPane.showMessageDialog(rootPane,"Fila no seleccionada");
       }
          
    }
    
    void buscar(){
         String valor=JOptionPane.showInputDialog(this,"Intruduce el nombre a buscar");        
        
        String []titulos={"id","Nombre","Producto","Monto Pagado","Pago","Cambio","Hora del Pago","Fecha del Pago"};   //nombre de los compos de la jTable1
        String[]datos=new String[8];
        
        try {
            con.conexion();
              rs=con.buscarrrrr(valor);
            
            while(rs.next())
            {
                datos[0]=rs.getString("id_puest");
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("producto");
                datos[3]=rs.getString("montpg");
                datos[4]=rs.getString("pago");
                datos[5]=rs.getString("cambio");
                datos[6]=rs.getString("hora");
                datos[7]=rs.getString("hora");
                tabla.addRow(datos);
                
            }
            jTable1.setModel(tabla);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
    }
    
    
    
    void mostrartabla(){
        
                 
                 con.conexion();
                 registrossssss=con.consultaRegistrosssss();
                 
                  try {
                     
                     while (registrossssss.next()){
                          tabla.addRow(new Object[]{
                          registrossssss.getString("id_puest"),    
                          registrossssss.getString("nombre"),
                          registrossssss.getString("producto"),
                          registrossssss.getDouble("montpg"),
                          registrossssss.getDouble("pago"),
                          registrossssss.getDouble("cambio"),
                          registrossssss.getString("hora"),
                          registrossssss.getString("fecha")
          
                           });
                     }
                     
                     
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, ex);
                     Logger.getLogger(PerPuestoo.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
    }

   
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 3, 36)); // NOI18N
        jLabel1.setText("Permisos Poner Un Puesto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 420, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel2.setText("Hora:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 50, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel3.setText("Hora");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 90, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 80, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel6.setText("Nombre Del Propietario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 179, -1));

        jLabel7.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel7.setText("Producto A Vender");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 160, -1));

        jLabel8.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel8.setText("Metros A Ocupar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 130, -1));

        jLabel9.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Monto A Pagar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 120, -1));

        jLabel10.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pago");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 70, -1));

        jLabel11.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cambio");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 80, 20));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 190, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 140, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 100, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 90, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 90, -1));

        jComboBox1.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 100, -1));

        jLabel13.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Hora del Pago");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 120, -1));

        jLabel14.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fecha del Pago");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 110, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-d");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 120, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton2.setText("Nuevo Pago");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 53, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton3.setText("Imprimir Recibo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 85, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton4.setText("Menú");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 117, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 149, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton10.setText("Mostrar Pagos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton9.setText("Actualizar");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 150, 380));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Producto", "Monto Pagado", "Pago", "Cambio", "Hora del Pago", "Fecha del Pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 740, 120));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesSistema/puesttt.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        double montpg=0;

        Integer indice = jComboBox1.getSelectedIndex();
        switch(indice)
        {
            case 1:
            montpg=15;
             jTextField3.setText(String.valueOf(montpg));
            break;
            case 2:
            montpg=30;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 3:
            montpg=45;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 4:
            montpg=60;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 5:
            montpg=75;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 6:
            montpg=90;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 7:
            montpg=105;
            jTextField3.setText(String.valueOf(montpg));
            break;
            case 8:
            montpg=120;
            jTextField3.setText(String.valueOf(montpg));
            break;
            default:
            break;
        }
       
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String nombre,producto,hora,fecha;
            double montpg,pago,cambio;
            nombre=jTextField1.getText();
            producto=jTextField2.getText();
            montpg=Double.parseDouble(jTextField3.getText());
            pago=Double.parseDouble(jTextField4.getText());
            cambio=pago-montpg;
            
            
            hora=jTextField6.getText();
            fecha=jDateChooser1.getDate().toString();
            
           if(pago>=montpg){ 
               jTextField5.setText(String.valueOf(cambio));
               JOptionPane.showMessageDialog(rootPane,"El cambio es de : "+ cambio);
               JOptionPane.showMessageDialog(rootPane,"El Pago Se Hecho Correctamente");
            
             }
           else{
                JOptionPane.showMessageDialog(rootPane,"El pago es insuficiente \nVuelva a intentarlo");
           }
        }    
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Alguno De Tus Datos Es Incorrecto \nVerifica Tus Datos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ReciboPerPuestoo recibo = new ReciboPerPuestoo();
recibo.setVisible(true);
this.dispose();
ReciboPerPuestoo.jLabel3.setText(jTextField1.getText());
ReciboPerPuestoo.jLabel6.setText(jTextField2.getText());
ReciboPerPuestoo.jLabel15.setText(jTextField3.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
this.buscar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      //con = new conectar();  //crear varible
        con.conexion();
        
            String nombre,producto,hora,fecha;
            double montpg,pago,cambio;
        // con.guardarrrrr(nombre, producto, hora, fecha, montpg, pago, cambio);
      try  {
           con.guardarrrrr(
                   
            nombre=jTextField1.getText(),
            producto=jTextField2.getText(),
            hora=jTextField6.getText(),
            fecha=f.format(jDateChooser1.getDate()),
            montpg=Double.parseDouble(jTextField3.getText()),
            pago=Double.parseDouble(jTextField4.getText()),
            cambio=Double.parseDouble(jTextField5.getText())
           
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
            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Menu men = new Menu();
men.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.mostrartabla();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
this.modificar();
    }//GEN-LAST:event_jButton8ActionPerformed

   
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
            java.util.logging.Logger.getLogger(PerPuestoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerPuestoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerPuestoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerPuestoo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerPuestoo().setVisible(true);
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
    // End of variables declaration//GEN-END:variables
}
