
package ecuacion;


public class Ecuacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int i,suma = 0;
       for(i=100; i>=0; i=-2){
           suma=suma+i;           
       }
       System.out.println("Suma es="+suma);
    
    }
    
}
