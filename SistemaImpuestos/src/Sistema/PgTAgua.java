package Sistema;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import conectar.conectar; 
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import java.lang.String;


public class PgTAgua extends javax.swing.JFrame {
private SimpleDateFormat f;
private conectar con;
private DefaultTableModel tabla;
private ResultSet registross;
private ResultSet rs;
private PreparedStatement elim;

    
    public PgTAgua() {
        initComponents();
        this.setLocationRelativeTo(null); // poner el formulario al centro de la pantalla
        Calendar cal = Calendar.getInstance();
        String hora = cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND); // Poner la hora del sistema de la conputadora
        jLabel3.setText(hora);//depende de donde se quiera visualizar
        f = new SimpleDateFormat("yyyy-MM-dd"); //FECHA
        jLabel5.setText(f.format(new Date()));//depende de donde se quiera visualizar
        
        double montpg=100;
        jTextField4.setText(String.valueOf(montpg));   
        
        tabla=(DefaultTableModel) jTable1.getModel();
        
        con=new conectar();//conecta con la clase para todos los botones
        
    }
    
    void limpiar()
                {
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField1.requestFocus();
                    jDateChooser1.setDate(null);
                }
    
    void modificar(){
        int fila = jTable1.getSelectedRow();
       if(fila>=0)
       {
         jTextField1.setText(jTable1.getValueAt(fila,1).toString());
         jTextField2.setText(jTable1.getValueAt(fila,2).toString());
         jTextField3.setText(jTable1.getValueAt(fila,3).toString());
         jTextField7.setText(jTable1.getValueAt(fila,7).toString());
         //jDateChooser1.setDate(jTable1.getValueAt(fila,6).toString()));
         jTextField4.setText(jTable1.getValueAt(fila,4).toString());
         jTextField5.setText(jTable1.getValueAt(fila,5).toString());
         jTextField6.setText(jTable1.getValueAt(fila,6).toString());
         // jDateChooser1.setDate(jTable1.getValueAt(fila,7).toString()); 
       }
       else
       {
         JOptionPane.showMessageDialog(rootPane,"Fila no seleccionada");
       }
    }
    
    void buscar(){
        
        String valor=JOptionPane.showInputDialog(this,"Intruduce el nombre a buscar");        
        
        String []titulos={"id","no_toma","Nombre","Calle","Monto Pagado","Pago","Cambio","Hora del Pago","Fecha del Pago"};   //nombre de los compos de la jTable1
        String[]datos=new String[9];
        //tabla=new DefaultTableModel(null,titulos);
        
          try {
              //con=new conectar();
              con.conexion();
              rs=con.buscar(valor);
            
            while(rs.next())
            {
                datos[0]=rs.getString("id_toma");
                datos[1]=rs.getString("no_toma");
                datos[2]=rs.getString("nombre");
                datos[3]=rs.getString("calle");
                datos[4]=rs.getString("montpg");
                datos[5]=rs.getString("pago");
                datos[6]=rs.getString("cambio");
                datos[7]=rs.getString("hora");
                datos[8]=rs.getString("fecha");
                tabla.addRow(datos);
                
            }
            jTable1.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
         
        
    }
    
    void mostrartabla()
    {
        //String [] titulos={"no_toma","nombre","calle","hora","fecha"};
         // double [] title={"montpg","pago","cambio"};
        
         
        //String sql = "SELECT * FROM tomaagua;";
        
       // con = new conectar();  //crear varible
        con.conexion();
        registross=con.consultaRegistros(); //registross es por la variable que cree arriba el .con es el nombre de mi conexion
          
          try
          {
               /*
            Statement st= con.createStatement();
           // DefaultTableModel model = new DefaultTableModel(null,titulos); //
            
            ResultSet  rs= st.executeQuery(sql); */
    
         //String [] registros=new String [4];
        
          while (registross.next()){
          /*registros[0]=registross.getString("no_toma");
          registros[1]=registross.getString("calle");
          registros[2]=registross.getString("hora");
          registros[3]=registross.getString("fecha");*/
          //tabla.addRow(registros);
          tabla.addRow(new Object[]{
          registross.getString("id_toma"),
          registross.getString("no_toma"),
          registross.getString("nombre"),
          registross.getString("calle"),
          registross.getDouble("montpg"),
          registross.getDouble("pago"),
          registross.getDouble("cambio"),
          registross.getString("hora"),
          registross.getString("fecha")
          
          });
          
    }
              //jTable1.setModel(tabla);

    } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        Logger.getLogger(PgTAgua.class.getName()).log(Level.SEVERE, null, ex);
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
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Garamond", 3, 36)); // NOI18N
        jLabel1.setText("Pago Toma De Agua");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 321, -1));

        jLabel2.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel2.setText("Hora:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 50, -1));

        jLabel3.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel3.setText("Hora");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        jLabel4.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 80, -1));

        jLabel6.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel6.setText("Numero Toma De Agua");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, -1));

        jLabel7.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel7.setText("Nombre Del Propietario");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 179, -1));

        jLabel8.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel8.setText("Nombre De La Calle");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 179, -1));

        jLabel9.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel9.setText("Monto A Pagar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 148, -1));

        jLabel10.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel10.setText("Pago");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 100, -1));

        jLabel11.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel11.setText("Cambio");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 115, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 129, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 200, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 230, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 110, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 80, -1));

        jLabel13.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel13.setText("Hora Del Pago");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, -1));

        jLabel14.setFont(new java.awt.Font("Garamond", 3, 18)); // NOI18N
        jLabel14.setText("Fecha Del Pago");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, -1));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 120, -1));

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 120, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Heading", 3, 10))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton1.setText("Realizar Pago");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton2.setText("Nuevo Pago");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 52, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton3.setText("Imprimir Recibo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 84, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton5.setText("Menú");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton6.setText("Guardar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton8.setText("Modifiar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton9.setText("Actualizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Sitka Heading", 3, 14)); // NOI18N
        jButton10.setText("Mostrar Pagos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 150, 360));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "no_toma", "Nombre", "Calle", "Monto Pagado", "Pago", "Cambio", "Hora del Pago", "Fecha del Pago"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 750, 120));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesSistema/agua-3.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
Menu men = new Menu();
men.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.limpiar();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

      //  con = new conectar();  //crear varible
        con.conexion();
       
   String notoma,nombre,calle,hora,fecha;   
    double montpg,pago,cambio;
    
        //con. es el nombre de mi conexion y .guardar es por la variable que cree
        // con.guardar("tom","Gabriel","San Pedro","10 pm","2016-07-16",200,500,300);
        try
        {
            con.guardar(
            notoma = jTextField1.getText(),
            nombre = jTextField2.getText(),
            calle=jTextField3.getText(), 
            hora=jTextField7.getText(),
            fecha=f.format(jDateChooser1.getDate()),  //reseteamos la fecha
            montpg=Double.parseDouble(jTextField4.getText()),
            pago=Double.parseDouble(jTextField5.getText()),
            cambio=Double.parseDouble(jTextField6.getText())
            
            );
        }
        catch(NullPointerException nu)   // nu es una variable
        {
            JOptionPane.showMessageDialog(rootPane, "Faltan campos.");
        }
        catch(NumberFormatException num)
        {
            JOptionPane.showMessageDialog(rootPane, "Campos numericos con texto.");
        }
      
 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try{  
    String notoma,nombre,calle,hora,fecha;   
    double montpg,pago,cambio;
    
    notoma = jTextField1.getText();
    nombre = jTextField2.getText();
    calle=jTextField3.getText();
    montpg=Double.parseDouble(jTextField4.getText());
    pago=Double.parseDouble(jTextField5.getText());
    cambio=pago-montpg;
    
    hora=jTextField7.getText();
    fecha=jDateChooser1.getDate().toString();
    if(pago>=montpg){
        jTextField6.setText(String.valueOf(cambio));   
    JOptionPane.showMessageDialog(rootPane,"El cambio es de : "+ cambio);
    JOptionPane.showMessageDialog(rootPane,"El Pago Se Ha Hecho Correctamente");
    }
    else{
        JOptionPane.showMessageDialog(rootPane,"El pago es insuficiente \nVuelva a intentarlo");
    } 
   }
 catch(Exception e){
     JOptionPane.showMessageDialog(rootPane,"Alguno De Tus Datos Es Incorrecto \nVerifica Tus Datos");
 }
    
   
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ReciboPgTAgua recibo = new ReciboPgTAgua();
recibo.setVisible(true);
this.dispose();
ReciboPgTAgua.jLabel3.setText(jTextField2.getText());
ReciboPgTAgua.jLabel6.setText(jTextField3.getText());
ReciboPgTAgua.jLabel13.setText(jTextField1.getText());
ReciboPgTAgua.jLabel15.setText(jTextField4.getText());
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
this.buscar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

   //    con = new conectar();  //crear varible
              
int fila=this.jTable1.getSelectedRow();

 String  valor = jTable1.getValueAt(fila,0).toString();
    
if(fila>=0){
    
     int eliminar=JOptionPane.showConfirmDialog(null,"¿Desea Eliminar el Pago","Mensaje",JOptionPane.YES_NO_OPTION);
     if(eliminar==0)
     {
         this.con.conexion();
         this.con.eliminar(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()));
         int id=(int) jTable1.getValueAt(jTable1.getSelectedRow(),0);
       
      }
    
    
           
    }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
this.mostrartabla();   
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
this.modificar();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
  /*PreparedStatement pps = con.PreparedStatement("UPDATE tomaagua SET no_toma='"+jTextField1.getText()+"',Nombre='"
                    +jTextField2.getText()+"',Calle='"+jTextField3.getText()+"',Hora del Pago='"+jTextField7.getText()+"'"
                   /* + ", Fecha='"+txtFecha.getText()+"' );*/
  
  
  
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(PgTAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PgTAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PgTAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PgTAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PgTAgua().setVisible(true);
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
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
