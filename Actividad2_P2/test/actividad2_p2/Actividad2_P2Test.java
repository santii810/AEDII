/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad2_p2;

import static actividad2_p2.Actividad2_P2.arbolSeleccion;
import static actividad2_p2.Actividad2_P2.esCamino;
import static actividad2_p2.Actividad2_P2.mismaForma;
import arbolBinario.ArbolBinario;
import arbolBinario.EnlazadoArbolBinario;
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
public class Actividad2_P2Test {

    private static final ArbolBinario<Integer> vacio = new EnlazadoArbolBinario<>();
    private static final ArbolBinario<Integer> hoja1 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final ArbolBinario<Integer> hoja11 = new EnlazadoArbolBinario<>(3, vacio, vacio);
    private static final ArbolBinario<Integer> hoja2 = new EnlazadoArbolBinario<>(5, vacio, vacio);
    private static final ArbolBinario<Integer> hoja3 = new EnlazadoArbolBinario<>(7, vacio, vacio);
    private static final ArbolBinario<Integer> nodo1 = new EnlazadoArbolBinario<>(11, hoja1, hoja2);
    private static final ArbolBinario<Integer> nodo2 = new EnlazadoArbolBinario<>(3, hoja1, hoja2);
    private static final ArbolBinario<Integer> raiz = new EnlazadoArbolBinario<>(7, nodo1, hoja3);
    private static final ArbolBinario<Integer> selec = new EnlazadoArbolBinario<>(3, nodo2, hoja3);
    private static final ArbolBinario<Integer> degen = new EnlazadoArbolBinario<>(1, new EnlazadoArbolBinario<>(13, vacio, hoja3), vacio);
    private static final ArbolBinario<Integer> nodoSinHojas = new EnlazadoArbolBinario<>(11, vacio, vacio);
    private static final ArbolBinario<Integer> raizSinHojas = new EnlazadoArbolBinario<>(7, nodoSinHojas, vacio);
    private static final ArbolBinario<Integer> raizHasta1 = new EnlazadoArbolBinario<>(7, nodoSinHojas, hoja3);

    private static final ArbolBinario<Character> vacioChar = new EnlazadoArbolBinario<>();
    private static final ArbolBinario<Character> hoja1Char = new EnlazadoArbolBinario<>('3', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja2Char = new EnlazadoArbolBinario<>('5', vacioChar, vacioChar);
    private static final ArbolBinario<Character> hoja3Char = new EnlazadoArbolBinario<>('2', vacioChar, vacioChar);
    private static final ArbolBinario<Character> nodo1Char = new EnlazadoArbolBinario<>('6', hoja1Char, hoja2Char);
    private static final ArbolBinario<Character> arbolCamino = new EnlazadoArbolBinario<>('7', nodo1Char, hoja3Char);

    public Actividad2_P2Test() {
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
     * Ejercicio 7 Test of mismaForma method, of class 
     */
    @Test
    public void testVacioMismaForma() {
        System.out.println("misma forma vacíos");
        boolean expResult = true;
        boolean result = mismaForma(vacio, new EnlazadoArbolBinario<>());
        assertEquals(expResult, result);
    }

    @Test
    public void testHojasMismaForma() {
        System.out.println("misma forma hojas");
        boolean expResult = true;
        boolean result = mismaForma(hoja1, hoja11);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoMismaForma() {
        System.out.println("no misma forma");
        boolean expResult = false;
        boolean result = mismaForma(raiz, nodo2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMismaForma() {
        System.out.println("mismaForma");
        boolean expResult = true;
        boolean result = mismaForma(nodo1, nodo2);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 8 Test of arbolSeleccion method, of class 
     */
    @Test
    public void testVacioArbolSeleccion() {
        System.out.println("arbolSeleccionVacio");
        boolean expResult = true;
        boolean result = arbolSeleccion(vacio);
        assertEquals(expResult, result);

    }

    @Test
    public void testHojaArbolSeleccion() {
        System.out.println("arbolSeleccion hoja");
        boolean expResult = true;
        boolean result = arbolSeleccion(hoja1);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoArbolSeleccion() {
        System.out.println("arbolSeleccion no");
        boolean expResult = false;
        boolean result = arbolSeleccion(raiz);
        assertEquals(expResult, result);
    }

    @Test
    public void testArbolSeleccion() {
        System.out.println("arbolSeleccion");
        boolean expResult = true;
        boolean result = arbolSeleccion(selec);
        assertEquals(expResult, result);
    }

    /**
     * Ejercicio 9 Test of esCamino method, of class 
     */
    @Test
    public void testVacioEsCamino() {
        System.out.println("esCamino vacio");
        boolean expResult = true;
        boolean result = esCamino(vacio, "");
        assertEquals(expResult, result);
    }

    @Test
    public void testNoEsCamino() {
        System.out.println("esCamino no");
        boolean expResult = false;
        boolean result = esCamino(arbolCamino, "5");
        assertEquals(expResult, result);
    }

    @Test
    public void testEsCamino() {
        System.out.println("esCamino");
        boolean expResult = true;
        boolean result = esCamino(arbolCamino, "763");
        assertEquals(expResult, result);
    }

}
