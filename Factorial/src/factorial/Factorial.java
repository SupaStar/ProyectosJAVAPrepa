/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author Obed Martinez
 */
public class Factorial {

   
    public static void main(String[] args) {
        double n,n2,n3 = 0,vu;
        Scanner entrada=new Scanner(System.in);
               System.out.println("Introduce el numero");
               n=entrada.nextDouble();
               vu=n;
               for(n2=vu-1;n2==1;n2=-1)
               {
               n3=n*n2;
    }  
               System.out.println("El factorial es:"+n3);
}
}