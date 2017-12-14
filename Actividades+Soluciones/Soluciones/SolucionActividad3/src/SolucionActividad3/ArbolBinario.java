/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolucionActividad3;

/**
 *
 * @author Rosalia
 */
public interface ArbolBinario<E>{
    public boolean esVacio();
    public E raiz() throws ArbolVacioExcepcion;
    public ArbolBinario<E> hijoIzq()throws ArbolVacioExcepcion;
    public ArbolBinario<E> hijoDer()throws ArbolVacioExcepcion;
    public boolean esta(E elemento);
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion;
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException;
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException;
    public void suprimir();
}
