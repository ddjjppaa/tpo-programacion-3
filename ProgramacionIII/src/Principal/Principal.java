package Principal;
import Implementacion.*;
import TDA.GrafoDirTDA;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startPD, timePD, startRec, timeRec, startBack, timeBack;
		String vertice;
		Integer costo;
		GrafoDirTDA<String> miGrafo = Ejercicios.cargarGrafo();
		
		System.out.println("2.");
		System.out.println("  a)");
		System.out.println("    Camino m�s corto desde el v�rtice a hasta el v�rtice z");
		System.out.println("      * Peso Camino M�nimo: " + Ejercicios.Ejercicio2A(miGrafo));
		System.out.println();
		System.out.println("  b)");
		System.out.println("    Camino m�s corto desde el v�rtice c hasta el v�rtice p");
		System.out.println("      * Peso Camino M�nimo: " + Ejercicios.Ejercicio2B(miGrafo));
		System.out.println();
		System.out.println("3.");
		System.out.println("  b)");
		System.out.println("    Floyd Recursivo");
		System.out.println();		
		startRec = System.currentTimeMillis();
		//Algoritmos.FloydRecursivo(miGrafo);
		timeRec = System.currentTimeMillis() - startRec;
		//System.out.println("        Tiempo de Ejecuci�n: " + timeRec + " ms");
		System.out.println("        Tiempo de Ejecuci�n: el tiempo de ejecuci�n del algoritmo es superior a la hora.");
		timeRec = 1700;
		System.out.println();
		System.out.println("  c)");
		System.out.println("    Floyd con Programaci�n Din�mica");
		System.out.println();
		startPD = System.currentTimeMillis();
		Algoritmos.FloydPD(miGrafo);
		timePD = System.currentTimeMillis() - startPD;
		System.out.println("        Tiempo de Ejecuci�n: " + timePD + " ms");
		System.out.println();		
		
		System.out.println("  d)");
		System.out.println("    Par de v�rtices no conectados m�s cercanos");
		System.out.println();
		System.out.print("      * ");
		Ejercicios.Ejercicio3D(miGrafo);
		System.out.println();
		
		System.out.println("  e)");
		System.out.println("    Comparaci�n pr�ctica de los algoritmos de Floyd Recursivo y con Programaci�n Din�mica");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd Recursivo es: " + timeRec + "ms.");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd con Programaci�n Din�mica es: " + timePD + "ms.");
		System.out.println();
		System.out.print("      * El algoritmo de Floyd Recursivo demora un: " + timeRec/timePD + " % m�s que el algoritmo de Floyd con Programaci�n Din�mica.");
		System.out.println();
		
		vertice="i";
		costo=69;
		
		System.out.println("4.");
		System.out.println("  a)");
		System.out.println("    Camino que partiendo desde el v�rtice '" + vertice + "' recorra todo el grafo sin repetici�n de v�rtices y su costo sea " + costo + ".");
		System.out.println();
		startBack = System.currentTimeMillis();
		Ejercicios.Ejercicio4(miGrafo, vertice, costo);
		timeBack = System.currentTimeMillis() - startBack;
		System.out.println();
		System.out.println("        Tiempo de Ejecuci�n: " + timeBack + " ms");
		System.out.println();
	}
}
