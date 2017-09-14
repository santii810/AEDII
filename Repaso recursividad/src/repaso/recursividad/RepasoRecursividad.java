/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso.recursividad;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author santi
 */
public class RepasoRecursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 5;
        int a = 15;
        int b = 25;
        String cadena = "abcdeedcba";
        int enteros[] = new int[]{1, 2, 3, 4, 5, 6};
        Stack<Integer> pila = new Stack<Integer>();
        Stack<Integer> toret = new Stack<Integer>();

        for (int i = 0; i < 10; i++) {
            pila.push(i);
        }

        System.out.println("Factorial de  " + num + ": " + Calcula.factorial(num));
        System.out.println("Cuadrado de " + num + ": " + Calcula.cuadrado(num));
        System.out.println("Suma digitos 1369: " + Calcula.sumaNumeros(1369));
        System.out.println("MCD de " + a + " y " + b + ": " + Calcula.mcd(a, b));
        System.out.println("¿Es palindromo " + cadena + "? " + Calcula.esPalindromo(cadena));
        System.out.println("Sumar array: " + Calcula.sumaArray(enteros, 0));
        System.out.println("Voltear array: " + showArray(Calcula.voltearArray(enteros, new int[enteros.length], 0)));
        System.out.println("Buscar menor:" + Calcula.buscarMenor(enteros, 0));
        System.out.println("Busqueda binaria " + Calcula.busquedaBinaria(enteros, enteros.length / 2, 5));
        System.out.println("Copiar pila" + Calcula.copiarPila(pila, toret, 0));
    }

    public static String showArray(int[] voltearArray) {
        StringBuilder toret = new StringBuilder("[");
        for (int i = 0; i < voltearArray.length; i++) {
            toret.append(voltearArray[i]);
            if (i == voltearArray.length - 1) {
                toret.append("] ");
            } else {
                toret.append(", ");
            }
        }

        return toret.toString();
    }

}
