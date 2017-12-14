
package solactividad4;

import java.util.Scanner;
public class SolActividad4 {
	
	
	public static <E extends Comparable<E>> void visualizar(Conjunto<E> conj){
		Conjunto<E> aux = new ConjuntoABB<>();
		while (conj.cardinal()!=0){
			E elemento = conj.elige();
			System.out.print(elemento);
			conj.elimina(elemento);
			aux.inserta(elemento);
		}
		while(aux.cardinal()!=0){
			E elemento = aux.elige();
			aux.elimina(elemento);
			conj.inserta(elemento);
		}		
	}
	
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		
		//Crea el conjunto 1
		System.out.print("Introduce los elementos del conjunto 1: ");
		Conjunto<Integer> conj1 = new ConjuntoABB<>();
		for (int i=1; i<=5; i++)
			conj1.inserta(entrada.nextInt());
		System.out.print("Conjunto 1: ");
		visualizar(conj1);
		System.out.println();
		
		//Crea el conjunto 2
		System.out.print("Introduce los elementos del conjunto 2: ");
		Conjunto<Integer> conj2 = new ConjuntoABB<>();
		for (int i=1; i<=5; i++)
			conj2.inserta(entrada.nextInt());
		System.out.print("Conjunto 2: ");
		visualizar(conj2);
		System.out.println();
		
		//unión 
		Conjunto<Integer> union = conj1.union(conj2);
		System.out.print("Unión: ");
		visualizar(union);
		System.out.println();
		
		//intersección 
		Conjunto<Integer> interseccion = conj1.interseccion(conj2);
		System.out.print("Intersección: ");
		visualizar(interseccion);
		System.out.println();
		
		//diferencia
		Conjunto<Integer> diferencia = conj1.diferencia(conj2);
		System.out.print("Diferencia: ");
		visualizar(diferencia);
		System.out.println();
	}

}
