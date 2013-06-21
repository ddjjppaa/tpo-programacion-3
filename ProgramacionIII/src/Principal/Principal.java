package Principal;
import Implementacion.*;
import TDA.GrafoDirTDA;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startPD, timePD, startRec, timeRec;
		
		GrafoDirTDA<String> miGrafo = Ejercicios.cargarGrafo();
		
		System.out.println("2.");
		System.out.println("  a)");
		System.out.println();
		System.out.println("  b)");
		System.out.println();
		System.out.println("3.");
		System.out.println("  b)");
		System.out.println("    Floyd Recursivo");
		System.out.println();		
		startRec = System.currentTimeMillis();
		//TODO Corregir que tira error al agregar caminos en sentido opuesto en Ejercicios.class
		//Algoritmos.FloydRecursivo(miGrafo);
		timeRec = System.currentTimeMillis() - startRec;
		System.out.println("        Tiempo de Ejecución: " + timeRec + " ms");
		System.out.println();
		System.out.println("  c)");
		System.out.println("    Floyd con Programación Dinámica");
		System.out.println();
		startPD = System.currentTimeMillis();
		Algoritmos.FloydPD(miGrafo);
		timePD = System.currentTimeMillis() - startPD;
		System.out.println("        Tiempo de Ejecución: " + timePD + " ms");
		System.out.println();		
		
		System.out.println("  d)");
		System.out.println("    Par de vértices no conectados más cercanos");
		System.out.println();
		System.out.print("      * ");
		Ejercicios.Ejercicio3D(miGrafo);
		System.out.println();
		
		System.out.println("  e)");
		System.out.println("    Comparación práctica de los algoritmos de Floyd Recursivo y con Programación Dinámica");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd Recursivo es: " + timeRec + "ms.");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd con Programación Dinámica es: " + timePD + "ms.");
		System.out.println();
		
		System.out.println("4.");
		System.out.println("  a)");
		System.out.println("    Camino que partiendo de un vértice recorra todo el grafo sin repetición de vértices y su costo sea el especificado como parámetro");
		System.out.println();
		Ejercicios.Ejercicio4(miGrafo, "a", 69);
	}
}
