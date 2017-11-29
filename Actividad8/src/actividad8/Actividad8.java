/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad8;

import grafo.*;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author santi
 */
public class Actividad8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
    }

        public static <E,T> boolean hayCaminoEntreDos (Grafo<E,T> g, Vertice<E> v1, Vertice<E> v2){
            Vector<Vertice<E>> visitados = new Vector<>();
            return caminoEntreDos(visitados, g,v1,v2);
        } 

        private static <E,T> boolean caminoEntreDos ( Vector<Vertice<E>> visitados, Grafo<E,T> g,Vertice<E> v1, Vertice<E> v2){
            boolean encontrado=false;
            
            
            visitados.add(v1);
            if (v1.equals(v2))
                return true;
            else {
                Iterator<Vertice<E>> adys = g.adyacentes(v1);
                while (adys.hasNext()&& !encontrado){
                    Vertice<E> w = adys.next();
                    if (!visitados.contains(w))
                      return caminoEntreDos(visitados, g, w, v2);
                }
               return false;
            }
        }




    }
    
