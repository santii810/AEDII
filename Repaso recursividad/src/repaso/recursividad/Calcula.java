/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso.recursividad;

import java.util.Stack;

/**
 *
 * @author santi
 */
public class Calcula {

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * (factorial(num - 1));
        }
    }

    public static int cuadrado(int num) {
        if (num == 1) {
            return 1;
        } else {
            return cuadrado(num - 1) + 2 * num - 1;
        }
    }

    public static int sumaNumeros(int num) {

        if ((float) (num / 10) < 1) {
            return num;
        } else {
            return num % 10 + sumaNumeros(num / 10);
        }
    }

    public static int mcd(int a, int b) {
        if (a == b) {
            return a;
        } else {
            return mcd(Integer.max(a, b) - Integer.min(a, b), Integer.min(a, b));
        }
    }

    public static boolean esPalindromo(String cadena) {
        if (cadena.length() <= 1) {
            return true;
        } else {
            if (cadena.charAt(0) == cadena.charAt(cadena.length() - 1)) {
                return esPalindromo(cadena.substring(1, cadena.length() - 1));
            } else {
                return false;
            }
        }
    }

    public static int sumaArray(int[] enteros, int cont) {
        if (cont == enteros.length - 1) {
            return enteros[cont];
        } else {
            return enteros[cont] + sumaArray(enteros, ++cont);
        }
    }

    public static int buscarMenor(int[] enteros, int pos) {
        if (pos == enteros.length - 1) {
            return enteros[pos];
        } else {
            return Math.min(enteros[pos], buscarMenor(enteros, ++pos));
        }
    }

    static int[] voltearArray(int[] array, int[] toret, int pos) {
        if (pos == array.length) {
            return toret;
        } else {
            toret[array.length-1-pos] = array[pos];
            return voltearArray(array, toret, ++pos);
        }
    }

    static int busquedaBinaria(int[] enteros, int pos, int buscado) {
        if (enteros[pos] == buscado) {
            return pos;
        } else {
            if (pos == 0 || pos == enteros.length - 1) {
                return -1;
            }
            if (enteros[pos] < buscado) {
                pos += (enteros.length - pos) / 2;
            } else {
                pos -= (enteros.length - pos) / 2;
            }
            return busquedaBinaria(enteros, pos, buscado);
        }
    }

    static Stack<Integer> copiarPila(Stack<Integer> pila, Stack<Integer> toret, int pos) {
        if (pos == pila.size()) {
        return toret;
        }else{
            toret.push(pila.get(pos));
            return copiarPila(pila, toret, ++pos);
        }
    }

}
