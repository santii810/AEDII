/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad5;

import arbolGeneral.ArbolGeneral;

/**
 *
 * @author santi
 */
public class Actividad5 {

    /**
     * @param args the command line arguments
     */
        public static <E> int grado(ArbolGeneral<E> a){
     if (a.esVacio())
         return 0;
     else {
         int num=0;
         ArbolGeneral<E> hijo=a.hijoMasIzq();
         while (!hijo.esVacio()){
             num++;
             hijo=hijo.hermanoDer();                
         }
         int maxGrado=num;
         hijo=a.hijoMasIzq();
         while (!hijo.esVacio()){
             int gradoAct=grado(hijo);
             if (gradoAct>maxGrado)
                 maxGrado=gradoAct;
             hijo=hijo.hermanoDer();
         }
         return maxGrado;
     }
 }
    
}
