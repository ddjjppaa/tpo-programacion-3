package Principal;
import Implementacion.*;
import TDA.GrafoDirTDA;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start, time;
		
		GrafoDirTDA<String> miGrafo = Ejercicios.cargarGrafo();
//		TODO Hay que hacer un grafo ENORME para probar el tiempo que tardan estos m�todos...
		
		System.out.println("3.");
		System.out.println("  b)");
		System.out.println("    Floyd Recursivo");
		System.out.println();		
		start = System.currentTimeMillis();
		//Algoritmos.FloydRecursivo(miGrafo);
		time = System.currentTimeMillis() - start;
		System.out.println("        Tiempo de Ejecuci�n: " + time + " ms");
		System.out.println();
		System.out.println("  c)");
		System.out.println("    Floyd con Programaci�n Din�mica");
		System.out.println();
		start = System.currentTimeMillis();
		//Algoritmos.FloydPD(miGrafo);
		time = System.currentTimeMillis() - start;
		System.out.println("        Tiempo de Ejecuci�n: " + time + " ms");
		System.out.println();		
		
		System.out.println("  d)");
		System.out.println("    Par de v�rtices no conectados m�s cercanos");
		System.out.println();
		System.out.print("      * ");
		//Ejercicios.Ejercicio3D(miGrafo);
		System.out.println();
		
		System.out.println("  e)");
		System.out.println("    Comparaci�n pr�ctica de los algoritmos de Floyd Recursivo y con Programaci�n Din�mica");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd Recursivo es: ");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd con Programaci�n Din�mica es: ");
		System.out.println();
		
		System.out.println("4.");
		System.out.println("  a)");
		System.out.println("    Camino que partiendo de un v�rtice recorra todo el grafo sin repetici�n de v�rtices y su costo sea el especificado como par�metro");
		System.out.println();
		System.out.print("      * ");
		Ejercicios.Ejercicio4(miGrafo, "a", 69);
//		Ejercicios.Ejercicio4(miGrafo, "a", 7);
	}
}
