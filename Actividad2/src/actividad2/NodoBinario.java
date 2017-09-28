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
public class NodoBinario<E> {

    private E elemento; // referencia al elemento del nodo
    private NodoBinario<E> izq; // referencia al nodo izquierdo
    private NodoBinario<E> der; // referencia al nodo derecho

    public NodoBinario(E e, NodoBinario<E> hi, NodoBinario<E> hd) {
        elemento = e;
        izq = hi;
        der = hd;
    }
 public boolean esVacio() {
        return elemento == null;
    }
    public E getElemento() {
        return elemento;
    }

    public NodoBinario<E> getIzq() {
        return izq;
    }

    public NodoBinario<E> getDer() {
        return der;
    }

    public void setElemento(E e) {
        elemento = e;
    }

    public void setIzq(NodoBinario<E> hi) {
        izq = hi;
    }

    public void setDer(NodoBinario<E> hd) {
        der = hd;
    }
}
