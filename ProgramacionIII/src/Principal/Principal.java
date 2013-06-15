package Principal;
import Implementacion.*;
import Implementaciones.Cola;
import TDA.ColaTDA;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GrafoDirTDA<String> miEjercicio = Ejercicios.cargarGrafo();
		
		ConjuntoTDA<String> vertices = miEjercicio.Vertices();

//		while (!vertices.conjuntoVacio()) {
//			String k = vertices.elegir();
//			vertices.sacar(k);
//			ConjuntoTDA<String> ady = miEjercicio.Adyacentes(k);
//			while (!ady.conjuntoVacio()) {
//				String i = ady.elegir();
//				ady.sacar(i);
//				System.out.println(k + "-->" + i + " Peso: "
//						+ miEjercicio.PesoArista(k, i));
//			}
//
//		}
		
	
		Ejercicios.Ejercicio4(miEjercicio, "a", 9);
	
	}

}
