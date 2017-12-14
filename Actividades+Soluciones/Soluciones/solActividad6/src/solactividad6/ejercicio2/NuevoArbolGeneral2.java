
package solactividad6.ejercicio2;

public class NuevoArbolGeneral2<E> implements ArbolGeneral<E> {
    private NodoArbol2<E> r;
	    
    // constructores
    public NuevoArbolGeneral2()
    {
        r = null;
    }
    public NuevoArbolGeneral2(E elemRaiz, NuevoArbolGeneral2<E> ... hijos) throws NullPointerException
    {
        if (hijos==null)
            throw new NullPointerException();
        if (hijos.length == 0)
            r=new NodoArbol2<>(elemRaiz, null, null, false);
        else {    
            for (int i=0; i<hijos.length-1; i++){
                hijos[i].r.setHer(hijos[i+1].r);
                hijos[i].r.setEsHer(true);
            }
            r=new NodoArbol2<>(elemRaiz, hijos[0].r, null, false);
            hijos[hijos.length-1].r.setHer(r);
            hijos[hijos.length-1].r.setEsHer(false);
        }
    }
    private NuevoArbolGeneral2(NodoArbol2<E> raiz)
    {
        r = raiz;
    }    

    // métodos
    @Override
    public boolean esVacio()
    {
        return r == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        return r.getElemento();
    }

    @Override
    public boolean esta (E elemento)
    {  
        return esta(r, elemento);   
    }

    private boolean esta (NodoArbol2<E> raiz, E elemento)
    {
        if (raiz == null) return false;
        if (raiz.getElemento().equals(elemento)) return true;
        NodoArbol2<E> hijo = raiz.getHijo();
        while (hijo != null){
            if (esta(hijo,elemento)) return true;
            else if (!hijo.getEsHer()) return false;
            else hijo=hijo.getHer();    
        }
        return false;
     }          

    @Override
    public ArbolGeneral<E> hijoMasIzq() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("hijoIzq: Árbol vacío");
        return new NuevoArbolGeneral2<>(r.getHijo());
    }    

    @Override
    public ArbolGeneral<E> hermanoDer() throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("hermanoDer: Árbol vacío");
        else if (r.getEsHer()==false) return new NuevoArbolGeneral2<>();
        return new NuevoArbolGeneral2<>(r.getHer());
    }    

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion
    {
        if (esVacio())
            throw new ArbolVacioExcepcion("raiz: Árbol vacío");
        r.setElemento(elemRaiz);
    }    

    @Override
    public void setHijo(ArbolGeneral<E> hijo) throws ArbolVacioExcepcion, NullPointerException
    {
        if (hijo==null)
            throw new NullPointerException();
        if (esVacio())
            throw new ArbolVacioExcepcion("setHijoIzq: Árbol vacío");
        if (hijoMasIzq().esVacio()){
            r.setHijo(((NuevoArbolGeneral2<E>)hijo).r);
            ((NuevoArbolGeneral2<E>)hijo).r.setHer(r);
            ((NuevoArbolGeneral2<E>)hijo).r.setEsHer(false);            
        }
        else{
            NodoArbol2<E> aux=r.getHijo();
            while (aux.getEsHer())
                aux=aux.getHer();
            aux.setHer(((NuevoArbolGeneral2<E>)hijo).r);
            aux.setEsHer(true);
            ((NuevoArbolGeneral2<E>)hijo).r.setHer(r);
        }
    }    

    @Override
    public void suprimir()
    {
        r = null; 
    } 
}
