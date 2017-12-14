/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucionactividad7;

import grafo.*;
import java.util.Iterator;
//import java.util.Map;
import mapa.*;




public class Prueba {

	
    public static void main(String[] args) {
		
        Grafo <Integer, Integer> g1;
        g1 = new ListaAdyacencia<>();
        Vertice<Integer> uno = new Vertice<>(1);
        Vertice<Integer> dos = new Vertice<>(2);
        Vertice<Integer> tres = new Vertice<>(3);
        Vertice<Integer> cuatro = new Vertice<>(4);
        Vertice<Integer> cinco = new Vertice<>(5);
        Vertice<Integer> seis = new Vertice<>(6);
        
        Arco<Integer,Integer> a1= new Arco<>(uno,dos,3);
        Arco<Integer,Integer> a2= new Arco<>(uno,seis,5);
        Arco<Integer,Integer> a3= new Arco<>(dos,tres,7);
        Arco<Integer,Integer> a4= new Arco<>(dos,seis,10);
        Arco<Integer,Integer> a5= new Arco<>(seis,tres,8);
        Arco<Integer,Integer> a6= new Arco<>(seis,cuatro,2);
        Arco<Integer,Integer> a7= new Arco<>(tres,cuatro,5);
        Arco<Integer,Integer> a8= new Arco<>(tres,cinco,1);
        Arco<Integer,Integer> a9= new Arco<>(cuatro,cinco,6); 
        Arco<Integer,Integer> a10= new Arco<>(dos,uno,3);
        Arco<Integer,Integer> a11= new Arco<>(seis,uno,5);
        Arco<Integer,Integer> a12= new Arco<>(tres,dos,7);
        Arco<Integer,Integer> a13= new Arco<>(seis,dos,10);
        Arco<Integer,Integer> a14= new Arco<>(tres,seis,8);
        Arco<Integer,Integer> a15= new Arco<>(cuatro,seis,2);
        Arco<Integer,Integer> a16= new Arco<>(cuatro,tres,5);
        Arco<Integer,Integer> a17= new Arco<>(cinco,tres,1);
        Arco<Integer,Integer> a18= new Arco<>(cinco,cuatro,6);
        g1.insertarArco(a1);
        g1.insertarArco(a2);
        g1.insertarArco(a3);
        g1.insertarArco(a4);
        g1.insertarArco(a5);
        g1.insertarArco(a6);
        g1.insertarArco(a7);
        g1.insertarArco(a8);
        g1.insertarArco(a9); 
        g1.insertarArco(a10);
        g1.insertarArco(a11);
        g1.insertarArco(a12);
        g1.insertarArco(a13);
        g1.insertarArco(a14);
        g1.insertarArco(a15);
        g1.insertarArco(a16);
        g1.insertarArco(a17);
        g1.insertarArco(a18); 
        Map<Vertice<Integer>, Integer> map;
        map = SolucionActividad7.dijkstra(g1,uno);
        
        Iterator<Vertice<Integer>> claves = map.getClaves();
        
        System.out.println("\n------ Algoritmo de Dijkstra ----------");
        
        while (claves.hasNext())
        {
            Vertice<Integer> c = claves.next();
            System.out.println("Vertice : " + c + " valor : " + map.get(c));
        }
        
        String [] colores={"rojo","azul","verde","amarillo"};
        
       Map<Vertice<Integer>, String> map2;
       map2= SolucionActividad7.colorearMapa(g1,colores);
        
       Iterator<Vertice<Integer>> claves2 = map2.getClaves();
        
        System.out.println("\n------ Teorema de los 4 colores ----------");
        
        while (claves2.hasNext())
        {
            Vertice<Integer> c = claves2.next();
            System.out.println("Vertice : " + c + " valor : " + map2.get(c));
        }
         
        
       }
}