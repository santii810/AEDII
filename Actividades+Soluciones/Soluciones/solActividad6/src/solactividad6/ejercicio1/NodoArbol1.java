
package solactividad6.ejercicio1;

public class NodoArbol1<E> {
	
	private E elemento;	
	private NodoArbol1 <E> hijoMasIzq, hermano, ultimoHijo;	

	public NodoArbol1 (E e, NodoArbol1 <E> hijo, NodoArbol1 <E> her, NodoArbol1<E> ultimo){
		elemento = e;
		hijoMasIzq = hijo;
		hermano = her;
		ultimoHijo = ultimo;
	}
	public E getElemento(){
		return elemento;
	}
	public NodoArbol1 <E> getHijo(){
		return hijoMasIzq;
	}
	public NodoArbol1 <E> getHer(){
		return hermano;
	}
	public NodoArbol1 <E> getUltHijo(){
		return ultimoHijo;
	}
	public void setElemento(E e){
		elemento = e;
	}
	public void setHijo(NodoArbol1 <E> hijo){
		hijoMasIzq = hijo;
	}
	public void setHer(NodoArbol1 <E> her){
		hermano = her;
	}
	public void setUltHijo(NodoArbol1 <E> ultHijo){
		ultimoHijo = ultHijo;
	}

}
