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
            return false;
        } else {
            return esCompleto(nodo.getDer()) && esCompleto(nodo.getIzq());
        }

    }

    public boolean esIdentico(NodoBinario<E> a, NodoBinario<E> b) {
        if (a.esVacio() && b.esVacio()) {
            return true;
        } else if (a.esVacio() || b.esVacio()) {
            return false;
        } else if (a.getElemento() != b.getElemento()) {
            return false;
        } else {
            return esIdentico(a.getDer(), b.getDer()) && esIdentico(a.getIzq(), b.getIzq());
        }

    }

    public int getAltura(NodoBinario<E> arbol) {
        if (arbol.esVacio()) {
            return -1;
        } else if (arbol.getDer().esVacio() && arbol.getIzq().esVacio()) {
            return 0;
        } else {
            return Math.max(getAltura(arbol.getDer()) + 1, getAltura(arbol.getIzq()) + 1);
        }
    }

}
