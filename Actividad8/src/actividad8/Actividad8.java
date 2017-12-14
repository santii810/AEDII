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

    public static <E, T> boolean hayCaminoEntreDos(Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2) {
        Vector<Vertice<E>> visitados = new Vector<>();
        return caminoEntreDos(visitados, g, v1, v2);
    }

    private static <E, T> boolean caminoEntreDos(Vector<Vertice<E>> visitados, Grafo<E, T> g, Vertice<E> v1, Vertice<E> v2) {
        visitados.add(v1);
        if (v1.equals(v2)) {
            return true;
        } else {
            Iterator<Vertice<E>> itAdyacentes = g.adyacentes(v1);
            while (itAdyacentes.hasNext()) {
                Vertice<E> verticeAnalizar = itAdyacentes.next();
                if (!visitados.contains(verticeAnalizar)) {
                    return caminoEntreDos(visitados, g, verticeAnalizar, v2);
                }
            }
            return false;
        }
    }
    
    
    
    
        //Ejercicio 5
        
        private static <E,T> int size(Iterator<Vertice<E>> i){
            int cont = 0;
            while(i.hasNext()){
                    cont++;
                    i.next();
            }
            return cont;
	}
        
        //recorrido en profundidad
	public static <E,T> void profundidad (Grafo<E,T> g, Vertice<E> v) {
		Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
		profundidad(g, v, visitados);
	}
	private static <E,T> void profundidad(Grafo<E,T> g, Vertice<E> v, Vector<Vertice<E>> visitados)
	{   
		visitados.add(v);
		Iterator<Vertice<E>> adys = g.adyacentes(v);
		while (adys.hasNext()){
			Vertice<E> w = adys.next();
			if (!visitados.contains(w))
				profundidad(g, w, visitados);
		}
	} 
        
	public static <E,T> Vertice<E> esArborescencia (Grafo<E,T> g){
            Iterator<Vertice<E>> ver = g.vertices();
            while(ver.hasNext()){
                    Vector<Vertice<E>> visitados = new Vector<>();
                    Vertice<E> v = ver.next();
                    profundidad(g,v,visitados);
                    //comparar el conjunto de visitados con el conjunto de vértices del grafo
                    if (size(visitados.iterator())==size(g.vertices())) return v;
            }
            return null;
	} 

}
