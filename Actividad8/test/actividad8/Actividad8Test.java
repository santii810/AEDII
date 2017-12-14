
package actividad8;

import static actividad8.Actividad8.*;
import grafo.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class Actividad8Test {
    
    private static Grafo<String, Integer> g; 
    private static final Grafo<String, Integer> gVacio = new ListaAdyacencia<>();

    private static final Vertice<String> v1 = new Vertice<>("Coruña");
    private static final Vertice<String> v2 = new Vertice<>("Lugo");
    private static final Vertice<String> v3 = new Vertice<>("Ourense");
    private static final Vertice<String> v4 = new Vertice<>("Pontevedra");

    private static void rellenarGrafoG(){
        g = new ListaAdyacencia<>();
        g.insertarArco(new Arco<>(v2, v1, 10));
        g.insertarArco(new Arco<>(v1, v3, 20));
        g.insertarArco(new Arco<>(v2, v4, 115));
        g.insertarArco(new Arco<>(v3, v4, 100));
        g.insertarArco(new Arco<>(v2, v3, 100));
        g.insertarArco(new Arco<>(v4, v2, 120));
        g.insertarArco(new Arco<>(v4, v3, 120));
    }
    @Before
    public void setUp() throws Exception {
            rellenarGrafoG();
    }
    
   
//    /**
//     * Test of predecesores method, of class SolActividad8.
//     */
//    @Test
//    public void testPredecesores() {
//        System.out.println("predecesores");
//        Iterator<Vertice<String>> itPred = predecesores(g, v4);
//        List<String> result = new ArrayList<>();
//        while (itPred.hasNext()) {
//            result.add(itPred.next().getEtiqueta());
//        }
//        List<String> expResult = new ArrayList<>();
//        expResult.add("Lugo");
//        expResult.add("Ourense");
//        assertArrayEquals(expResult.toArray(), result.toArray());
//    }
//
//    /**
//     * Test of sumidero method, of class SolActividad8.
//     */
//    @Test
//    public void testSumideroVacio() {
//        System.out.println("sumidero");
//        boolean result = sumidero(gVacio, v3);
//        assertFalse(result);
//    }
//    @Test
//    public void testNoSumidero() {
//        System.out.println("sumidero");
//        boolean result = sumidero(g, v3);
//        assertFalse(result);
//    }
//    @Test
//    public void testSumidero() {
//        System.out.println("sumidero");
//        g.eliminarArco(new Arco<>(v3,v4, 100));
//        boolean result = sumidero(g,v3);
//        assertTrue(result);
//    }
//
//    /**
//     * Test of regular method, of class SolActividad8.
//     */
//    @Test
//    public void testVacioRegular() {
//        System.out.println("regular");
//        boolean expResult = true;
//        boolean result = regular(gVacio);
//        assertEquals(expResult, result);
//    }
//    @Test
//    public void testNORegular() {
//        System.out.println("regular");
//        boolean expResult = false;
//        boolean result = regular(g);
//        assertEquals(expResult, result);
//    }
//    @Test
//    public void testSiRegular() {
//        System.out.println("regular");
//        g.eliminarArco(new Arco<>(v2,v4, 115));
//	g.insertarArco(new Arco<>(v1, v4, 200));
//	g.insertarArco(new Arco<>(v3, v1, 120));
//        boolean expResult = true;
//        boolean result = regular(g);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of hayCaminoEntreDos method, of class SolActividad8.
     */
    @Test
    public void testHayCaminoEntreDos() {
        System.out.println("hayCaminoEntreDos");
        boolean expResult = false;
        boolean result = hayCaminoEntreDos(gVacio, v1, v2);
        assertEquals(expResult, result);   
    }

    /**
     * Test of esArborescencia method, of class SolActividad8.
     */
    @Test
    public void testEsArborescencia() {
        System.out.println("esArborescencia");
        Vertice<String> expResult = v2;
        Vertice<String> result = esArborescencia(g);
        assertEquals(expResult, result);   
    }
    @Test
    public void testNoEsArborescencia() {
        g.eliminarArco(new Arco<>(v4, v2, 120));
	g.eliminarArco(new Arco<>(v4, v3, 120));
        g.eliminarArco(new Arco<>(v2, v3, 100));
        g.eliminarArco(new Arco<>(v2, v1, 10));
        System.out.println("noEsArborescencia");
        Vertice<String> expResult = null;
        Vertice<String> result = esArborescencia(g);
        assertEquals(expResult, result);   
    }

    
    
}
