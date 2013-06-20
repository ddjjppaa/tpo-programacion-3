package Principal;
import Implementacion.*;
import TDA.GrafoDirTDA;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		GrafoDirTDA<String> miGrafo = Ejercicios.cargarGrafo();
//		TODO Hay que hacer un grafo ENORME para probar el tiempo que tardan estos métodos...
		
		System.out.println("3.");
		System.out.println("  b)");
		System.out.println("    Floyd Recursivo");
		System.out.println();		
		System.out.println("      * Hora de Inicio: " + dateFormat.format(cal.getTime()));
		Algoritmos.FloydRecursivo(miGrafo);
		System.out.println("      * Hora Finalización: " + dateFormat.format(cal.getTime()));
		System.out.println();
		System.out.println("  c)");
		System.out.println("    Floyd con Programación Dinámica");
		System.out.println();
		System.out.println("      * Hora de Inicio: " + dateFormat.format(cal.getTime()));
		Algoritmos.FloydPD(miGrafo);
		System.out.println("      * Hora Finalización: " + dateFormat.format(cal.getTime()));
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
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd Recursivo es: ");
		System.out.println();
		System.out.print("      * El tiempo demorado por el algoritmo de Floyd con Programación Dinámica es: ");
		System.out.println();
		
		System.out.println("4.");
		System.out.println("  a)");
		System.out.println("    Camino que partiendo de un vértice recorra todo el grafo sin repetición de vértices y su costo sea el especificado como parámetro");
		System.out.println();
		System.out.print("      * ");
		Ejercicios.Ejercicio4(miGrafo, "a", 90);
	
	}

}
