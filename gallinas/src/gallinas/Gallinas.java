/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinas;

import java.util.Scanner;

/**
 *
 * @author maquina37
 */
public class Gallinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       double pg,ag,cal,pc,prec,ppg = 0;
       int ng,nh,n = 0;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce numero de gallinas");
        ng=entrada.nextInt();
        while (n<=ng){
            System.out.println("Introduce el peso de la gallina");
        pg=entrada.nextDouble();
            System.out.println("Introduce la altura de la gallina");
        ag=entrada.nextDouble();
            System.out.println("Introduce el num de huevos");
        nh=entrada.nextInt();
        cal=pg*ag*nh;
        ppg = ppg+cal;
        pc=ppg/ng;
        if(cal>=15){
            prec=1.2*pc;
        }
        else if(cal>8 && cal<15)
        {
        prec=1.0*pc;    
        }
        else;{
        prec=0.8*pc;
        }
        }
        
        
    }
    
}
