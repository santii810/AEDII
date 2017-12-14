/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucionactividad7;
import grafo.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import mapa.*;


public class SolucionActividad7 {
 
public static <E> Map<Vertice<E>,Integer> dijkstra(Grafo<E,Integer> g, Vertice<E> v)
{
	     final Integer INFINITO = Integer.MAX_VALUE;
	     Map<Vertice<E>,Integer> distancia = new HashMap<>();
	     Set<Vertice<E>> porVisitar = new HashSet<>(); 
	     
	     Iterator<Vertice<E>> it_v = g.vertices();
	     
	     while (it_v.hasNext())
	     {
	         Vertice<E> vert = it_v.next();
	         distancia.insertar(vert,INFINITO);
	         porVisitar.add(vert);
	     }
             
             distancia.insertar(v,0);
	        
	     while (!porVisitar.isEmpty())
	     {
	           Vertice<E> vMinimo = minimo(distancia,porVisitar.iterator());
	           porVisitar.remove(vMinimo);
	           Integer dis_vMinimo;
                   dis_vMinimo = distancia.get(vMinimo);
	           
	           if (!dis_vMinimo.equals(INFINITO))
	           {
	            Iterator<Arco<E,Integer>> arc = g.arcos();
	            Integer pesoArcoElegido = 0;
	            while (arc.hasNext()) 
	            {
	                Arco<E,Integer> a1 = arc.next();
                        Vertice<E> wDestino = a1.getDestino();
	                if (a1.getOrigen().equals(vMinimo) && porVisitar.contains(wDestino)){
	                   pesoArcoElegido = a1.getEtiqueta();   
	                
	                   Integer dw = distancia.get(wDestino);
	                   if ( dis_vMinimo+pesoArcoElegido < dw){
	                           distancia.insertar(wDestino,dis_vMinimo+pesoArcoElegido);
	                    }  
	               }
	            }
                  }
             }
	     return distancia;   
	    }

/*public static <E> Map<Vertice<E>,Integer> dijkstra2(Grafo<E,Integer> g, Vertice<E> v)
{
 final Integer INFINITO = Integer.MAX_VALUE;
 Map<Vertice<E>,Integer> distancia = new HashMap<>();
 Set<Vertice<E>> porVisitar = new HashSet<>(); 

 Iterator<Vertice<E>> it_v = g.vertices();

 while (it_v.hasNext())
 {
     Vertice<E> vert = it_v.next();
     distancia.insertar(vert,INFINITO);
     porVisitar.add(vert);
 }

 distancia.insertar(v,0);

 while (!porVisitar.isEmpty())
 {
       Vertice<E> vMinimo = minimo(distancia,porVisitar.iterator());
       porVisitar.remove(vMinimo);
       Integer dis_vMinimo;
       dis_vMinimo = distancia.get(vMinimo);

       if (!dis_vMinimo.equals(INFINITO))
       {
           Iterator<Vertice<E>> adys = g.adyacentes(vMinimo);
           while (adys.hasNext()){
            Vertice<E> vAdy = adys.next();
            if (porVisitar.contains(vAdy)){
                Iterator<Arco<E,Integer>> arc = g.arcos();
                Integer pesoArcoElegido = 0;
                while (arc.hasNext()) 
                {
                    Arco<E,Integer> a1 = arc.next();
                    if (a1.getOrigen().equals(vMinimo) && a1.getDestino().equals(vAdy)){
                       pesoArcoElegido = a1.getEtiqueta();   
                       Integer dw = distancia.get(vAdy);
                       if ( dis_vMinimo+pesoArcoElegido < dw){
                               distancia.insertar(vAdy,dis_vMinimo+pesoArcoElegido);
                        }  
                   }
                }
            }
          }
        }
 }
 return distancia;   
}*/

	private static <E> Vertice<E> minimo (Map<Vertice<E>,Integer> d, Iterator<Vertice<E>> iPorVisitar)
	    {
	        Vertice<E> v, minV = iPorVisitar.next();
	        Integer c, minD = d.get(minV);
	        
	        while (iPorVisitar.hasNext())
	        {
	            v = iPorVisitar.next();
	            c = d.get(v);
	            if (c < minD)
	            {
	                minV = v;
	                minD = c;
	            }
	        }
	        
	        return minV;
	        
	        
	    }
        
public static <E> Map<Vertice<E>,String> colorearMapa (Grafo<E,Integer> g, String [] colores)
{
             Map<Vertice<E>,String> mapaColores = new HashMap<>();
	     	     
	     Iterator<Vertice<E>> it_v = g.vertices();
             
	     
	     while (it_v.hasNext())
	     {
	         Vertice<E> vert = it_v.next();
	         mapaColores.insertar(vert,new String());
             }
                 
             it_v = g.vertices();
	        
	     while (it_v.hasNext())
	     {
                   Vertice<E> vActual = it_v.next();
	           String colorAdecuado = seleccionarColor(mapaColores,colores,vActual,g);
                   mapaColores.insertar(vActual,colorAdecuado);      
	     }
	     return mapaColores;   
	    }
	    
	    
private static <E> String seleccionarColor (Map<Vertice<E>,String> d, String []c, Vertice<E> v,Grafo<E,Integer> g)
{
    int i = 0;
    String color = c[i];
    boolean fin = false;

    while (i<c.length && !fin){
        fin = true;
        color = c[i];
        Iterator<Vertice<E>> it_ady = g.adyacentes(v);
        while (it_ady.hasNext() && fin){
            Vertice<E> vAct = it_ady.next();
            if (d.get(vAct).equals(color)){
                i++;
                fin = false;
        }
    }  
   }
    return color;    
} 
}
