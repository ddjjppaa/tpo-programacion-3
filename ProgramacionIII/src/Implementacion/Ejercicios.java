package Implementacion;

import Implementaciones.Cola;
import Implementaciones.Conjunto;
import Implementaciones.GrafoDir;
import TDA.ColaTDA;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;

public class Ejercicios {

	// Ejercicio 1
	public static GrafoDirTDA<String> cargarGrafo() {
		GrafoDirTDA<String> miGrafo = new GrafoDir<String>();
		miGrafo.InicializarGrafo();
		// for (int i = 1; i<=26;i++){
		// String caracter = String.valueOf(i+96);
		// miGrafo.AgregarVertice(String.valueOf(i + 96));
		// };

		miGrafo.AgregarVertice("a");
		miGrafo.AgregarVertice("b");
		miGrafo.AgregarVertice("c");
		miGrafo.AgregarVertice("d");
		
		miGrafo.AgregarArista("a", "b", 1);
		miGrafo.AgregarArista("b", "c", 2);
		miGrafo.AgregarArista("a", "c", 5);		
		miGrafo.AgregarArista("b", "d", 5);
		miGrafo.AgregarArista("d", "b", 1);
		miGrafo.AgregarArista("d", "c", 1);
		
//		miGrafo.AgregarVertice("a");
//		miGrafo.AgregarVertice("b");
//		miGrafo.AgregarVertice("c");
//		miGrafo.AgregarVertice("d");
//		miGrafo.AgregarVertice("e");
//		miGrafo.AgregarVertice("f");
//		miGrafo.AgregarVertice("g");
//		miGrafo.AgregarVertice("h");
		// miGrafo.AgregarVertice("i");
		// miGrafo.AgregarVertice("j");
		// miGrafo.AgregarVertice("k");
		// miGrafo.AgregarVertice("l");
		// miGrafo.AgregarVertice("m");
		// miGrafo.AgregarVertice("n");
		// miGrafo.AgregarVertice("o");
		// miGrafo.AgregarVertice("p");
		// miGrafo.AgregarVertice("q");
		// miGrafo.AgregarVertice("r");
		// miGrafo.AgregarVertice("s");
		// miGrafo.AgregarVertice("t");
		// miGrafo.AgregarVertice("u");
		// miGrafo.AgregarVertice("v");
		// miGrafo.AgregarVertice("w");
		// miGrafo.AgregarVertice("x");
		// miGrafo.AgregarVertice("y");
		// miGrafo.AgregarVertice("z");

//		miGrafo.AgregarArista("a", "b", 2);
//		miGrafo.AgregarArista("a", "c", 4);
//		miGrafo.AgregarArista("a", "d", 1);
//		miGrafo.AgregarArista("b", "c", 3);
//		miGrafo.AgregarArista("b", "e", 1);
//		miGrafo.AgregarArista("c", "e", 2);
//		miGrafo.AgregarArista("c", "f", 2);
//		miGrafo.AgregarArista("d", "f", 5);
//		miGrafo.AgregarArista("d", "g", 4);
//		miGrafo.AgregarArista("e", "h", 3);
//		miGrafo.AgregarArista("f", "g", 3);
		// miGrafo.AgregarArista("f","h",3);
		// miGrafo.AgregarArista("f","i",2);
		// miGrafo.AgregarArista("f","j",4);
		// miGrafo.AgregarArista("g","k",2);
		// miGrafo.AgregarArista("h","l",1);
		// miGrafo.AgregarArista("h","o",8);
		// miGrafo.AgregarArista("i","j",3);
		// miGrafo.AgregarArista("i","l",3);
		// miGrafo.AgregarArista("i","m",2);
		// miGrafo.AgregarArista("j","k",6);
		// miGrafo.AgregarArista("j","m",6);
		// miGrafo.AgregarArista("j","n",3);
		// miGrafo.AgregarArista("k","n",4);
		// miGrafo.AgregarArista("k","r",2);
		// miGrafo.AgregarArista("l","m",3);
		// miGrafo.AgregarArista("l","o",6);
		// miGrafo.AgregarArista("m","o",4);
		// miGrafo.AgregarArista("m","p",2);
		// miGrafo.AgregarArista("m","n",5);
		// miGrafo.AgregarArista("n","q",2);
		// miGrafo.AgregarArista("n","r",1);
		// miGrafo.AgregarArista("o","p",2);
		// miGrafo.AgregarArista("o","s",6);
		// miGrafo.AgregarArista("p","s",2);
		// miGrafo.AgregarArista("p","t",1);
		// miGrafo.AgregarArista("p","q",1);
		// miGrafo.AgregarArista("q","t",3);
		// miGrafo.AgregarArista("q","r",8);
		// miGrafo.AgregarArista("s","z",2);
		// miGrafo.AgregarArista("t","z",8);

		
		return miGrafo;
	}

	// Ejercicio 2A
	static int Ejercicio2A(GrafoDirTDA<String> g) {

		return 0;
	}

	// Ejercicio 2B
	static int Ejercicio2B(GrafoDirTDA<String> g) {

		return 0;
	}

	public static void Ejercicio3D(GrafoDirTDA<String> g) {
		GrafoDirTDA<String> lcm = Algoritmos.FloydPD(g);

		int distanciaMin = 99999999;
		String vertDesde = null;
		String vertHasta = null;

		ConjuntoTDA<String> conj1 = lcm.Vertices();
		while (!conj1.conjuntoVacio()) {
			String elemento = conj1.elegir();
			conj1.sacar(elemento);
			ConjuntoTDA<String> conj2 = lcm.Adyacentes(elemento);
			while (!conj2.conjuntoVacio()) {
				String elemento2 = conj2.elegir();
				conj2.sacar(elemento2);
				if (!g.ExisteArista(elemento, elemento2)) {
					if (lcm.ExisteArista(elemento, elemento2)) {
						if (lcm.PesoArista(elemento, elemento2) < distanciaMin) {
							distanciaMin = lcm.PesoArista(elemento, elemento2);
							vertDesde = elemento;
							vertHasta = elemento2;

						}
					}
				}
			}

		}
		System.out.println("Desde: " + vertDesde + " Hasta: " + vertHasta
				+ " Distancia: " + distanciaMin);
	}

	public static void Ejercicio4(GrafoDirTDA<String> g, String origen, int valor) {
		ColaTDA<String> solucion = new Cola<String>();
		solucion.inicializarCola();
		
		ConjuntoTDA<String> conjuntoVerticesPendientes = new Conjunto<String>();
		conjuntoVerticesPendientes = g.Vertices();
		int etapa = 1;
		Ejercicio4Bis(g, origen, valor, conjuntoVerticesPendientes, solucion, etapa);
	}

	static void Ejercicio4Bis(GrafoDirTDA<String> g, String origen, int valor,
			ConjuntoTDA<String> conjuntoVerticesPendientes,
			ColaTDA<String> solucion, int etapa) {
		// Creo que faltaría pasar como parámetro un booleano que diga que
		// encontro la solución para que se detenga todo.
		ColaTDA<String> miSolucionEtapa = new Cola<String>();		
		miSolucionEtapa = solucion;
		conjuntoVerticesPendientes.sacar(origen);
		solucion.acolar(origen);
		ConjuntoTDA<String> conjuntoVerticesAdyacentes = new Conjunto<String>();
		conjuntoVerticesAdyacentes = g.Adyacentes(origen);
		while (!conjuntoVerticesAdyacentes.conjuntoVacio()) {
			String unVerticeAdyacente = conjuntoVerticesAdyacentes.elegir();
			conjuntoVerticesAdyacentes.sacar(unVerticeAdyacente);
			// Si es factible:
			// * El vértice aún no ha sido visitado.
			// * Al visitarlo no excedo el valor de costo máximo.
			if (valor - g.PesoArista(origen, unVerticeAdyacente) >= 0) {
				valor = valor - g.PesoArista(origen, unVerticeAdyacente);
				Ejercicio4Bis(g, unVerticeAdyacente, valor,
						conjuntoVerticesPendientes, miSolucionEtapa, etapa+1);
			}
			;
		}
		;
		// Si es final:
		// * Verifica si quedan vértices pendientes de visitar.
		// * Verifica que el recorrido haya costado lo mismo que valor.
		if (conjuntoVerticesPendientes.conjuntoVacio()) {
			if (valor == 0) {
				System.out.println("Se pudo encontrar una solución");
				// Hacer impresion de elementos de cola.
				while (!miSolucionEtapa.colaVacia()) {
					System.out.println(miSolucionEtapa.primero());
					miSolucionEtapa.desacolar();
				}
			}
			;
		}
		;
	}
}
