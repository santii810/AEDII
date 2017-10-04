/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2_p2;

import arbolBinario.ArbolBinario;

/**
 *
 * @author santi
 */
public class Actividad2_P2 {

    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        } else if (a.esVacio() && !b.esVacio() || !a.esVacio() && b.esVacio()) {
            return false;
        } else {
            return mismaForma(a.hijoDer(), b.hijoDer()) && mismaForma(a.hijoIzq(), b.hijoIzq());
        }
    }

    public static <E extends Comparable<E>> boolean arbolSeleccion(ArbolBinario<E> arbol) {
        ArbolBinario<E> menor = null;
        if (arbol.esVacio()) {
            return true;
        }
        if (arbol.hijoDer().esVacio() && arbol.hijoIzq().esVacio()) {
            return true;
        } else if (arbol.hijoDer().esVacio()) {
            menor = arbol.hijoIzq();
            return (arbol.raiz().equals(menor.raiz())) && arbolSeleccion(menor);
        } else if (arbol.hijoIzq().esVacio()) {
            menor = arbol.hijoDer();
            return (arbol.raiz().equals(menor.raiz())) && arbolSeleccion(menor);
        } else {
            if (arbol.hijoDer().raiz().compareTo(arbol.hijoIzq().raiz()) > 0) {
                menor = arbol.hijoIzq();
            } else {
                menor = arbol.hijoDer();
            }
            return (arbol.raiz().equals(menor.raiz())) && arbolSeleccion(arbol.hijoDer()) && arbolSeleccion(arbol.hijoIzq());
        }

    }

    public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino) {
        System.out.println(camino);
        if (camino.isEmpty()) {
            return true;
        }
        if (!arbol.raiz().equals(camino.charAt(0))) {
            return false;
        } else {
            return esCamino(arbol.hijoDer(), camino.substring(1)) || esCamino(arbol.hijoIzq(), camino.substring(1));
        }
    }
}
