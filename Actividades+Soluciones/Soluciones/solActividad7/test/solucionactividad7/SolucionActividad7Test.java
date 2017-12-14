/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucionactividad7;

import grafo.*;
import java.util.Iterator;
import mapa.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rosalia
 */
public class SolucionActividad7Test {
     private static Grafo<Integer, Integer> g1; 
	
    private static final Vertice<Integer> uno = new Vertice<>(1);
    private static final Vertice<Integer> dos = new Vertice<>(2);
    private static final Vertice<Integer> tres = new Vertice<>(3);
    private static final Vertice<Integer> cuatro = new Vertice<>(4);
    private static final Vertice<Integer> cinco = new Vertice<>(5);
    private static final Vertice<Integer> seis = new Vertice<>(6);

    private static void rellenarGrafoG(){
        g1 = new ListaAdyacencia<>();
        g1.insertarArco(new Arco<>(uno,dos,3));
        g1.insertarArco(new Arco<>(uno,seis,5));
        g1.insertarArco(new Arco<>(dos,tres,7));
        g1.insertarArco(new Arco<>(dos,seis,10));
        g1.insertarArco(new Arco<>(seis,tres,8));
        g1.insertarArco(new Arco<>(seis,cuatro,2));
        g1.insertarArco(new Arco<>(tres,cuatro,5));
        g1.insertarArco(new Arco<>(tres,cinco,1));
        g1.insertarArco(new Arco<>(cuatro,cinco,6)); 
        
        g1.insertarArco(new Arco<>(dos,uno,3));
        g1.insertarArco(new Arco<>(seis,uno,5));
        g1.insertarArco(new Arco<>(tres,dos,7));
        g1.insertarArco(new Arco<>(seis,dos,10));
        g1.insertarArco(new Arco<>(tres,seis,8));
        g1.insertarArco(new Arco<>(cuatro,seis,2));
        g1.insertarArco(new Arco<>(cuatro,tres,5));
        g1.insertarArco(new Arco<>(cinco,tres,1));
        g1.insertarArco(new Arco<>(cinco,cuatro,6));
    }
	
    private static <E,F> boolean mapasIguales(Map<Vertice<E>,F> m1, Map<Vertice<E>, F> m2){
        if (m1.tamaño() == m2.tamaño()){
		Iterator<Vertice<E>> itr = m1.getClaves();
		while(itr.hasNext()){
			Vertice<E> clave = itr.next();
			if (m1.get(clave)==null || !m1.get(clave).equals(m2.get(clave)))
				return false;
		}
		return true;
	}
	return false;
    }
   
    
    @Before
    public void setUp() throws Exception{
        rellenarGrafoG();
    }
    
    
    /**
     * Test of dijkstra method, of class SolucionUsoTablaHash.
     */
    @Test
    public void testDijkstra() {
        System.out.println("dijkstra");
        Map<Vertice<Integer>, Integer> grafoActual = SolucionActividad7.dijkstra(g1, uno); 
	Map<Vertice<Integer>, Integer> expResult= new HashMap<>();
        expResult.insertar(uno, 0);
        expResult.insertar(dos, 3);
        expResult.insertar(tres, 10);
        expResult.insertar(cuatro, 7);
        expResult.insertar(cinco, 11);
        expResult.insertar(seis, 5);
        boolean eq = mapasIguales(grafoActual, expResult);
        assertTrue(eq);
    }

    /**
     * Test of colorearMapa method, of class SolucionUsoTablaHash.
     */
    @Test
    public void testColorearMapa() {
        System.out.println("colorearMapa");
        String [] colores = {"rojo","azul","verde","amarillo"};
        Map<Vertice<Integer>, String> grafoActual = SolucionActividad7.colorearMapa(g1, colores); 
	Map<Vertice<Integer>, String> expResult= new HashMap<>();
        expResult.insertar(uno, "rojo");
        expResult.insertar(dos, "azul");
        expResult.insertar(tres, "rojo");
        expResult.insertar(cuatro, "azul");
        expResult.insertar(cinco, "verde");
        expResult.insertar(seis, "verde");
        boolean eq = mapasIguales(grafoActual, expResult);
        assertTrue(eq);
    }
    
}
