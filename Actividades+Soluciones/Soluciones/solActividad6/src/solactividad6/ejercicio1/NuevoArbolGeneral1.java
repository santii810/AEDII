
package solactividad6.ejercicio1;

import arbolGeneral.ArbolGeneral;


public class NuevoArbolGeneral1<E> implements ArbolGeneral<E>{
	 	private NodoArbol1<E> nodoRaiz;
	    
	    // constructores
	    public NuevoArbolGeneral1()
	    {
	        nodoRaiz = null;
	    }
	    @SuppressWarnings("unchecked")
            public NuevoArbolGeneral1(E elemRaiz, NuevoArbolGeneral1<E> ... hijos) throws NullPointerException
	    {
	        if (hijos==null)
	            throw new NullPointerException();
	        if (hijos.length == 0)
	            nodoRaiz=new NodoArbol1<>(elemRaiz, null, null, null);
	        else {    
                    int i=0;
	            for (;i<hijos.length-1; i++){
	               hijos[i].nodoRaiz.setHer(hijos[i+1].nodoRaiz);
	            }
	            nodoRaiz=new NodoArbol1<>(elemRaiz, hijos[0].nodoRaiz, null, hijos[i].nodoRaiz);
	        }
	    }
	    private NuevoArbolGeneral1(NodoArbol1<E> raiz)
	    {
	        nodoRaiz = raiz;
	    }    
	    
	    // métodos
                 @Override
	    public boolean esVacio()
	    {
	        return nodoRaiz == null;
	    }
	    
                 @Override
	    public E raiz() throws ArbolVacioExcepcion
	    {
	        if (esVacio())
	            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
	        return nodoRaiz.getElemento();
	    }
	    
                 @Override
	    public boolean esta (E elemento)
	    {  
	        return esta(nodoRaiz, elemento);   
	    }
	    
	    private boolean esta (NodoArbol1<E> raiz, E elemento)
	    {
	        if (raiz == null) return false;
	        if (raiz.getElemento().equals(elemento)) return true;
	        NodoArbol1<E> hijo = raiz.getHijo();
	        while (hijo != null){
	            if (esta(hijo,elemento)) return true;
	            else hijo=hijo.getHer();    
	        }
	        return false;
	     }          

                 @Override
	    public ArbolGeneral<E> hijoMasIzq() throws ArbolVacioExcepcion
	    {
	        if (esVacio())
	            throw new ArbolVacioExcepcion("hijoIzq: Árbol vacío");
	        return new NuevoArbolGeneral1<>(nodoRaiz.getHijo());
	    }    
	    
                 @Override
	    public ArbolGeneral<E> hermanoDer() throws ArbolVacioExcepcion
	    {
	        if (esVacio())
	            throw new ArbolVacioExcepcion("hermanoDer: Árbol vacío");
	        return new NuevoArbolGeneral1<>(nodoRaiz.getHer());
	    }    
	    
                 @Override
	    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion
	    {
	        if (esVacio())
	            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
	        nodoRaiz.setElemento(elemRaiz);
	    }    
	    
                 @Override
	    public void setHijo(ArbolGeneral<E> hijo) throws ArbolVacioExcepcion, NullPointerException
	    {
	        if (hijo==null)
	            throw new NullPointerException();
	        if (esVacio())
	            throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacío");
	        if (hijoMasIzq().esVacio()){
	            nodoRaiz.setHijo(((NuevoArbolGeneral1<E>)hijo).nodoRaiz);
	            nodoRaiz.setUltHijo(((NuevoArbolGeneral1<E>)hijo).nodoRaiz);
	        }
	        else {
	        	nodoRaiz.getUltHijo().setHer(((NuevoArbolGeneral1<E>)hijo).nodoRaiz);
	        	nodoRaiz.setUltHijo(((NuevoArbolGeneral1<E>)hijo).nodoRaiz);
	        }	            
	    }    
	    
                 @Override
	    public void suprimir()
	    {
	        nodoRaiz = null; 
	    } 

}
