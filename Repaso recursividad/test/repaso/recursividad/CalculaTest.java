/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso.recursividad;

import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santi
 */
public class CalculaTest {

    public CalculaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of factorial method, of class Calcula.
     */
    @Test
    public void testFactorial() {
        System.out.println("factorial");
        int num = 3;
        int expResult = 6;
        int result = Calcula.factorial(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of cuadrado method, of class Calcula.
     */
    @Test
    public void testCuadrado() {
        System.out.println("cuadrado");
        int num = 4;
        int expResult = 16;
        int result = Calcula.cuadrado(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumaNumeros method, of class Calcula.
     */
    @Test
    public void testSumaNumeros() {
        System.out.println("sumaNumeros");
        int num = 12345;
        int expResult = 15;
        int result = Calcula.sumaNumeros(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcd method, of class Calcula.
     */
    @Test
    public void testMcd() {
        System.out.println("mcd");
        int a = 20;
        int b = 15;
        int expResult = 5;
        int result = Calcula.mcd(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of esPalindromo method, of class Calcula.
     */
    @Test
    public void testEsPalindromo() {
        System.out.println("esPalindromo");
        String cadena = "hola";
        boolean expResult = false;
        boolean result = Calcula.esPalindromo(cadena);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumaArray method, of class Calcula.
     */
    @Test
    public void testSumaArray() {
        System.out.println("sumaArray");
        int[] enteros = new int[]{1, 2, 3};
        int cont = 0;
        int expResult = 6;
        int result = Calcula.sumaArray(enteros, cont);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarMenor method, of class Calcula.
     */
    @Test
    public void testBuscarMenor() {
        System.out.println("buscarMenor");
        int[] enteros = new int[]{2, 3, 5, 7, 4, 1};
        int pos = 0;
        int expResult = 1;
        int result = Calcula.buscarMenor(enteros, pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of voltearArray method, of class Calcula.
     */
    @Test
    public void testVoltearArray() {
        System.out.println("voltearArray");
        int[] array = new int[]{2, 3, 5, 7, 4, 1};
        int[] toret = new int[array.length];
        int pos = 0;
        int[] expResult = new int[]{1, 4, 7, 5, 3, 2};
        int[] result = Calcula.voltearArray(array, toret, pos);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of busquedaBinaria method, of class Calcula.
     */
    @Test
    public void testBusquedaBinaria() {
        System.out.println("busquedaBinaria");
        float[] numReales = new float[]{1, 2, 3, 4, 5, 6};
        int pos = numReales.length / 2;
        float buscado = 2;
        int expResult = 1;
        int result = Calcula.busquedaBinaria(numReales, 0,numReales.length, buscado);
        assertEquals(expResult, result);
    }

    /**
     * Test of busquedaBinaria method, of class Calcula.
     */
    @Test
    public void testBusquedaBinaria01() {
        System.out.println("busquedaBinaria");
        float[] numReales = new float[]{1.5F, 2, 3, 3.5F, 5, 5.5F};
        int pos = numReales.length / 2;
        float buscado = 1.5F;
        int expResult = 0;
        int result = Calcula.busquedaBinaria(numReales, 0,numReales.length, buscado);
        assertEquals(expResult, result);
    }

    /**
     * Test of copiarPila method, of class Calcula.
     */
    @Test
    public void testCopiarPila() {
        System.out.println("copiarPila");
        Stack<Integer> pila = new Stack<>();
        pila.add(1);
        pila.add(3);
        pila.add(5);
        Stack<Integer> toret = new Stack<>();
        int pos = 0;
        Stack<Integer> expResult = new Stack<>();
        expResult.add(1);
        expResult.add(3);
        expResult.add(5);
        Stack<Integer> result = Calcula.copiarPila(pila, toret, pos);
        assertEquals(expResult, result);
    }

}
