/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad3_arbolesbinarios;

/**
 *
 * @author santi
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz;

    public EnlazadoArbolBinario() {
        nodoRaiz = null;
    }

    private EnlazadoArbolBinario(NodoBinario<E> nodo) {
        this.nodoRaiz = nodo;
    }

    public EnlazadoArbolBinario(E elem, EnlazadoArbolBinario<E> hi, EnlazadoArbolBinario<E> hd) throws NullPointerException {
        if (hi == null || hd == null) {
            throw new NullPointerException();
        }

        nodoRaiz = new NodoBinario(elem, hi.nodoRaiz, hd.nodoRaiz);

    }

    @Override
    public boolean esVacio() {
        return nodoRaiz == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return nodoRaiz.getElemento();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario(nodoRaiz.getIzq());
    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario(nodoRaiz.getDer());
    }

    @Override
    public boolean esta(E elem) {
        return esta(elem, nodoRaiz);
    }

    public boolean esta(E elem, NodoBinario<E> nodo) {
        if (nodoRaiz == null) {
            return false;
        } else if (nodoRaiz.getElemento().equals(elem)) {
            return true;
        } else {
            return esta(elem, nodo.getDer()) || esta(elem, nodo.getIzq());
        }
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        nodoRaiz.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario hi) throws ArbolVacioExcepcion, NullPointerException {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        if (hi == null) {
            throw new NullPointerException();
        }
        nodoRaiz.setIzq((NodoBinario<E>) hi);
    }

    @Override
    public void setHijoDer(ArbolBinario hd) throws ArbolVacioExcepcion, NullPointerException {
        if (esVacio()) {
            throw new ArbolVacioExcepcion();
        }
        if (hd == null) {
            throw new NullPointerException();
        }
        nodoRaiz.setIzq((NodoBinario<E>) hd);

    }

    @Override
    public void suprimir() {
        nodoRaiz = null;
    }

}
