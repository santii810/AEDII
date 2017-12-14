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
public class EnlazadoArbolBinario<E> implements ArbolBinario<E>
{
    private NodoBinario<E> r;
    
    // constructores
    public EnlazadoArbolBinario()
    {
        r = null;
    }
    
    public EnlazadoArbolBinario(E elemRaiz, EnlazadoArbolBinario<E> hi, EnlazadoArbolBinario<E> hd)
    {
        r = new NodoBinario<>(elemRaiz, hi.r, hd.r);
    }
    
    private EnlazadoArbolBinario(NodoBinario<E> raiz)
    {
        r = raiz;
    }    
    
    // métodos
    public boolean esVacio()
    {
        return r == null;
    }
    
    public E raiz() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        return r.getElemento();
    }
    
    public boolean esta(E elemento){
        return esta(r,elemento);
    }
    private boolean esta(NodoBinario<E> raiz, E elemento){
        if (raiz==null) return false;
        if (raiz.getElemento().equals(elemento)) return true;
        boolean temp = esta(raiz.getIzq(),elemento);
        if (!temp) return esta(raiz.getDer(),elemento);
        return temp;
    }
    
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("hijoIzq: Árbol vacío");
        return new EnlazadoArbolBinario<>(r.getIzq());
    }    
    
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("hijoDer: Árbol vacío");
        return new EnlazadoArbolBinario<>(r.getDer());
    }    
    
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        r.setElemento(elemRaiz);
    }    
    
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException
    {
		if (hi==null) throw new NullPointerException();
		if (esVacio())
                        throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacío");
        r.setIzq(((EnlazadoArbolBinario<E>) hi).r);
    }    
    
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException
    {
		if (hd==null) throw new NullPointerException();
		if (esVacio())
                        throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacío");
        r.setDer(((EnlazadoArbolBinario<E>) hd).r);
    }    
    
    public void suprimir()
    {
		r=null;
    }    
    
} 
