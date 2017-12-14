/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4;

import arbolBusqueda.*;

class ConjuntoABB<T extends Comparable<T>> implements Conjunto<T> {

    ArbolBusqueda<T> conjunto;

    public ConjuntoABB() {
        this.conjunto = new ArbolBinarioBusqueda<>();
    }

    private int cardinal(ArbolBusqueda<T> arbol) {
        if (arbol.esVacio()) {
            return 0;
        } else {
            return 1 + cardinal(arbol.hijoIzq()) + cardinal(arbol.hijoDer());
        }
    }

    @Override
    public int cardinal() {
        if (conjunto.esVacio()) {
            return 0;
        } else {
            return cardinal(conjunto);
        }
    }

    @Override
    public boolean pertenece(T x) {
        return conjunto.buscar(x);
    }

    @Override
    public boolean inserta(T x) {
        if (!pertenece(x)) {
            conjunto.insertar(x);
            return true;
        }
        return false;
    }

    @Override
    public boolean elimina(T x) {
        if (!pertenece(x)) {
            return false;
        } else {
            conjunto.eliminar(x);
            return true;
        }

    }

    @Override
    public T elige() throws IllegalArgumentException {
        if (conjunto.esVacio()) {
            throw new IllegalArgumentException();
        } else {
            return conjunto.raiz();
        }

    }

    @Override
    public Conjunto<T> union(Conjunto<T> conj) {
        Conjunto<T> toret = new ConjuntoABB<T>();
        recorrer(toret, conjunto);
        recorrer(toret, ((ConjuntoABB<T>) conj).conjunto);
        return toret;
    }

    @Override
    public Conjunto<T> interseccion(Conjunto<T> conj) {
        Conjunto<T> toret = new ConjuntoABB<T>();
        recorrerIntersec(toret, ((ConjuntoABB<T>) conj).conjunto, conjunto);
        return toret;
    }

    @Override
    public Conjunto<T> diferencia(Conjunto<T> conj) {
        Conjunto<T> toret = new ConjuntoABB<T>();
        recorrerDif(toret, conjunto, ((ConjuntoABB<T>) conj).conjunto);
        return toret;
    }

    private void recorrer(Conjunto<T> toret, ArbolBusqueda<T> arbol) {
        if (!arbol.esVacio()) {
            toret.inserta(arbol.raiz());
            recorrer(toret, arbol.hijoIzq());
            recorrer(toret, arbol.hijoDer());
        }
    }

    private void recorrerIntersec(Conjunto<T> toret, ArbolBusqueda<T> a, ArbolBusqueda<T> b) {
        if (!a.esVacio() && !b.esVacio()) {
            if (a.buscar(b.raiz())) {
                toret.inserta(b.raiz());
            }
            recorrerIntersec(toret, a, b.hijoDer());
            recorrerIntersec(toret, a, b.hijoIzq());
        }
    }

    private void recorrerDif(Conjunto<T> toret, ArbolBusqueda<T> a, ArbolBusqueda<T> b) {
        if (!a.esVacio() && !b.esVacio()) {
            if (!b.buscar(a.raiz())) {
                toret.inserta(a.raiz());
            }
            recorrerDif(toret, a.hijoDer(), b);
            recorrerDif(toret, a.hijoIzq(), b);
        }
    }

}
