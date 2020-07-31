
package proyectofinal;


import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;


public class hilo extends Thread{

    JProgressBar B;

     private static int retraso=5;
      public hilo(JProgressBar B)
     {
         
         this.B=B;
     }
    @Override
         public void run()
   {
       int maximo=B.getMaximum();
       int minimo=B.getMinimum();
       Runnable ejecutor = new Runnable() {
           @Override
           public void run() {
              int valorActual=B.getValue();
              B.setValue(valorActual+1);
           }
           
       };
    for (int i=minimo;i<maximo;i++)
    {
        try 
           {
               EventQueue.invokeAndWait(ejecutor);
               Thread.sleep(retraso);
               
           } catch (InterruptedException ex){
       }
           catch (InvocationTargetException ex) {
               
           }
    }
   }
         
     
    
}
