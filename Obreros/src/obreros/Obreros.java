
package obreros;

import java.util.Scanner;

/**
 *
 * @author Obed Martinez
 */
public class Obreros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int n,n1=1;
    double h,ht = 0,ph,hn,thx,hx,htt,ht2;
        Scanner entrada =new Scanner(System.in);
        System.out.println("Introduce el numero de obreros");
        n=entrada.nextInt();
        System.out.println("Introduce la paga por hora");
        ph = entrada.nextDouble();
        while(n1<=n)
        {
            System.out.println("Introduce las horas por dia(cada linea es un dia)");
            for ( int b=1;b<=7; b=b+1 )
            {
                h=entrada.nextDouble();
                ht=ht+h;
            }
        if(ht<=40) {
        htt=ht*ph;
        System.out.println("La paga es:"+htt);
        } 
        else if(ht<=48)
        {
            hn=40*ph;
            thx=ht-40;
            hx=(thx*ph)*2;
            htt=hn+hx;
            System.out.println("La paga es:"+htt);
        }
        else{
        hn=40*ph;
        thx=(8*ph)*2;
        hx=ht-48;
        ht2=(hx*ph)*3;
        htt=thx+hn+ht2;
        System.out.println("La paga es:"+htt);
        }
        n1=n1+1;
        }
        System.out.println("Gracias por usar");
        }
    
    }

    
