package solactividad6.ejercicio2;

public class NodoArbol2<E> {
    private E elemento;
    private NodoArbol2<E> hijo;
    private NodoArbol2<E> hermano;
    private boolean esHermano;
	    
    // constructores
    public NodoArbol2(E e, NodoArbol2<E> hi, NodoArbol2<E> he, boolean es)
    {
        elemento = e;
        hijo = hi;
        hermano = he;
        esHermano = es;
    }

    public NodoArbol2()
    {
        this(null, null, null, false);
    }    

    // métodos
    public E getElemento()
    {
        return elemento;
    }

    public NodoArbol2<E> getHijo()
    {
        return hijo;
    }

    public NodoArbol2<E> getHer()
    {
        return hermano;
    }

    public boolean getEsHer(){
        return esHermano;
    }

    public void setElemento(E e)
    {
        elemento = e;
    }

    public void setHijo(NodoArbol2<E> hi)
    {
        hijo = hi;
    }

    public void setHer(NodoArbol2<E> he)
    {
        hermano = he;
    }
    public void setEsHer(boolean es){
        esHermano = es;
    }
}
