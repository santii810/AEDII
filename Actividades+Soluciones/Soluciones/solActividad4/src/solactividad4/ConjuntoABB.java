
package solactividad4;
import arbolBusqueda.*;

public class ConjuntoABB<E extends Comparable<E>> implements Conjunto<E> {
	private ArbolBusqueda<E> elementos;
	
	public ConjuntoABB(){
		elementos = new ArbolBinarioBusqueda<>();
	}
		
	private int cardinal(ArbolBusqueda<E> a){
		if (a.esVacio()) return 0;
		else return 1+ cardinal(a.hijoIzq()) + cardinal(a.hijoDer());
	}
        
        @Override
	public int cardinal(){
		if (elementos.esVacio()) return 0;
		else return cardinal(elementos);
	}
	
        @Override
	public boolean pertenece(E x){
		return elementos.buscar(x);
	}
        
        @Override
	public boolean inserta(E x){
		if(pertenece(x)) return false;
		else {
			elementos.insertar(x);
			return true;
		}
	}
	
        @Override
	public boolean elimina(E x) {
		if (!pertenece(x)) return false;
		else {
			elementos.eliminar(x);
			return true;
		}
	}
	
        @Override
	public E elige() throws IllegalArgumentException{
		if (elementos.esVacio()) throw new IllegalArgumentException();
		else return elementos.raiz();
		
	}
	
	private void recorrer(Conjunto<E> conjunto, ArbolBusqueda<E> arbol){
		if (!arbol.esVacio()){
			conjunto.inserta(arbol.raiz());
			recorrer(conjunto, arbol.hijoIzq());
			recorrer(conjunto, arbol.hijoDer());
		}
	}
        @Override
	public Conjunto<E> union (Conjunto<E> conj){
		Conjunto<E> toRet = new ConjuntoABB<>();
		recorrer(toRet, elementos);
		recorrer(toRet, ((ConjuntoABB<E>)conj).elementos);
		return toRet;
	}
	
	private void recorrer(Conjunto<E> conjunto, ArbolBusqueda<E> arbol1, ArbolBusqueda<E> arbol2){
		if (!arbol1.esVacio()){
			if (arbol2.buscar(arbol1.raiz())) conjunto.inserta(arbol1.raiz());
			recorrer(conjunto, arbol1.hijoIzq(), arbol2);
			recorrer(conjunto, arbol1.hijoDer(), arbol2);
		}
	}
        @Override
	public Conjunto<E> interseccion (Conjunto<E> conj){
		Conjunto<E> toRet = new ConjuntoABB<>();
		recorrer(toRet, elementos, ((ConjuntoABB<E>)conj).elementos);
		return toRet;
	}
	
	private void recorrer2(Conjunto<E> conjunto, ArbolBusqueda<E> arbol1, ArbolBusqueda<E> arbol2){
		if (!arbol1.esVacio()){
			if (!arbol2.buscar(arbol1.raiz())) conjunto.inserta(arbol1.raiz());
			recorrer2(conjunto, arbol1.hijoIzq(), arbol2);
			recorrer2(conjunto, arbol1.hijoDer(), arbol2);
		}
	}
        @Override
	public Conjunto<E> diferencia(Conjunto<E> conj){
		Conjunto<E> toRet = new ConjuntoABB<>();
		recorrer2(toRet, elementos, ((ConjuntoABB<E>)conj).elementos);
		return toRet;
	}
	/*
	public Conjunto<E> union (Conjunto<E> conj){
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toRet = new ConjuntoABB<>();
		
		//Pasa this a toRet
		while (cardinal()!=0){
			E elemento = this.elige();
			elimina(elemento);
			toRet.inserta(elemento);
			aux.inserta(elemento);
		}
		while(aux.cardinal()!=0){
			E elemento = aux.elige();
			aux.elimina(elemento);
			inserta(elemento);
		}
		//Pasa el conj a toRet
		while (conj.cardinal()!=0){
			E elemento = conj.elige();
			conj.elimina(elemento);
			toRet.inserta(elemento);
			aux.inserta(elemento);
		}
		while(aux.cardinal()!=0){
			E elemento = aux.elige();
			aux.elimina(elemento);
			conj.inserta(elemento);
		}
		
		return toRet;
	}
	
	public Conjunto<E> interseccion (Conjunto<E> conj){
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toRet = new ConjuntoABB<>();
		
		//Pasa las comunes de this y conj
		while (cardinal()!=0){
			E elemento = elige();
			elimina(elemento);
			if (conj.pertenece(elemento)) toRet.inserta(elemento);
			aux.inserta(elemento);
		}
		while(aux.cardinal()!=0){
			E elemento = aux.elige();
			aux.elimina(elemento);
			inserta(elemento);
		}
		return toRet;
	}
	
	public Conjunto<E> diferencia(Conjunto<E> conj){
		Conjunto<E> aux = new ConjuntoABB<>();
		Conjunto<E> toRet = new ConjuntoABB<>();
		
		//this - conj
		while (cardinal()!=0){
			E elemento = elige();
			elimina(elemento);
			if (!conj.pertenece(elemento)) toRet.inserta(elemento);
			aux.inserta(elemento);
		}
		while(aux.cardinal()!=0){
			E elemento = aux.elige();
			aux.elimina(elemento);
			conj.inserta(elemento);
		}
		return toRet;
	}
	*/

}

