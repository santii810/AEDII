/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2;

/**
 *
 * @author santi
 */
public class EnlazadoArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;

    public EnlazadoArbolBinario() {
        nodoRaiz = null;
    }

    public boolean esCompleto(NodoBinario<E> nodo) {
        if (nodo.esVacio()) {
            return true;
        }
        if (nodo.getDer().esVacio() && nodo.getIzq().esVacio()) {
            return true;
        } else if (nodo.getDer().esVacio() || nodo.getIzq().esVacio()) {
            return true;
        } else {
            return esCompleto(nodo.getDer()) && esCompleto(nodo.getIzq());
        }

    }

   
}
