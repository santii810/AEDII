/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad5;

import static actividad5.Actividad5.grado;
import arbolGeneral.ArbolGeneral;
import arbolGeneral.EnlazadoArbolGeneral;
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
public class Actividad5Test {

    ArbolGeneral<Integer> arbol1 = new EnlazadoArbolGeneral<>(4, new EnlazadoArbolGeneral<>(2));
    ArbolGeneral<Integer> arbol2 = new EnlazadoArbolGeneral<>(3, new EnlazadoArbolGeneral<>(1));
    ArbolGeneral<Integer> arbol3 = new EnlazadoArbolGeneral<>(6, arbol1, arbol2, new EnlazadoArbolGeneral<>(5));
    ArbolGeneral<Integer> arbol4 = new EnlazadoArbolGeneral<>(7, arbol3);

    ArbolGeneral<Integer> arbolDos = new EnlazadoArbolGeneral<>(1, new EnlazadoArbolGeneral<>(2), new EnlazadoArbolGeneral<>(1));
    ArbolGeneral<Integer> arbolTres = new EnlazadoArbolGeneral<>(1, arbolDos, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5));
    ArbolGeneral<Integer> arbol = new EnlazadoArbolGeneral<>(4, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5), new EnlazadoArbolGeneral<>(6));
    ArbolGeneral<Integer> arbolCuatro = new EnlazadoArbolGeneral<>(4, arbol, new EnlazadoArbolGeneral<>(3), new EnlazadoArbolGeneral<>(5), new EnlazadoArbolGeneral<>(6));

    public Actividad5Test() {
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
     * Test of grado method, of class SolActividad5.
     */
    @Test
    public void testGradoUno() {
        System.out.println("grado");
        int expResult = 1;
        int result = grado(arbol1);
        assertEquals(expResult, result);
    }

    @Test
    public void testGradoTres() {
        System.out.println("grado");
        int expResult = 3;
        int result = grado(arbol4);
        assertEquals(expResult, result);
    }

}
