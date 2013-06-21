package Implementacion;

import Implementaciones.Conjunto;
import Implementaciones.GrafoDir;
import Implementaciones.Vector;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;
import TDA.VectorTDA;

public class Ejercicios {

	// Ejercicio 1
	public static GrafoDirTDA<String> cargarGrafo() {
		GrafoDirTDA<String> miGrafo = new GrafoDir<String>();
		miGrafo.InicializarGrafo();
		
		// for (int i = 1; i<=26;i++){
		// String caracter = String.valueOf(i+96);
		// miGrafo.AgregarVertice(String.valueOf(i + 96));
		// };

//		miGrafo.AgregarVertice("a");
//		miGrafo.AgregarVertice("b");
//		miGrafo.AgregarVertice("c");
//		miGrafo.AgregarVertice("d");
//		
//		miGrafo.AgregarArista("a", "b", 1);
//		miGrafo.AgregarArista("b", "c", 2);
//		miGrafo.AgregarArista("a", "c", 5);		
//		miGrafo.AgregarArista("b", "d", 5);
//		miGrafo.AgregarArista("d", "b", 1);
//		miGrafo.AgregarArista("d", "c", 1);
//		miGrafo.AgregarArista("c", "d", 1);
		
		miGrafo.AgregarVertice("a");
		miGrafo.AgregarVertice("b");
		miGrafo.AgregarVertice("c");
		miGrafo.AgregarVertice("d");
		miGrafo.AgregarVertice("e");
		miGrafo.AgregarVertice("f");
		miGrafo.AgregarVertice("g");
		miGrafo.AgregarVertice("h");
		miGrafo.AgregarVertice("i");
		miGrafo.AgregarVertice("j");
		miGrafo.AgregarVertice("k");
		miGrafo.AgregarVertice("l");
		miGrafo.AgregarVertice("m");
		miGrafo.AgregarVertice("n");
		miGrafo.AgregarVertice("o");
		miGrafo.AgregarVertice("p");
		miGrafo.AgregarVertice("q");
		miGrafo.AgregarVertice("r");
		miGrafo.AgregarVertice("s");
		miGrafo.AgregarVertice("t");
		miGrafo.AgregarVertice("z");

		miGrafo.AgregarArista("a", "b", 2);
		miGrafo.AgregarArista("a", "c", 4);
		miGrafo.AgregarArista("a", "d", 1);
		miGrafo.AgregarArista("b", "c", 3);
		miGrafo.AgregarArista("b", "e", 1);
		miGrafo.AgregarArista("c", "e", 2);
		miGrafo.AgregarArista("c", "f", 2);
		miGrafo.AgregarArista("d", "f", 5);
		miGrafo.AgregarArista("d", "g", 4);
		miGrafo.AgregarArista("e", "h", 3);
		miGrafo.AgregarArista("f", "g", 3);
		miGrafo.AgregarArista("f","h",3);
		miGrafo.AgregarArista("f","i",2);
		miGrafo.AgregarArista("f","j",4);
		miGrafo.AgregarArista("g","k",2);
		miGrafo.AgregarArista("h","l",1);
		miGrafo.AgregarArista("h","o",8);
		miGrafo.AgregarArista("i","j",3);
		miGrafo.AgregarArista("i","l",3);
		miGrafo.AgregarArista("i","m",2);
		miGrafo.AgregarArista("j","k",6);
		miGrafo.AgregarArista("j","m",6);
		miGrafo.AgregarArista("j","n",3);
		miGrafo.AgregarArista("k","n",4);
		miGrafo.AgregarArista("k","r",2);
		miGrafo.AgregarArista("l","m",3);
		miGrafo.AgregarArista("l","o",6);
		miGrafo.AgregarArista("m","o",4);
		miGrafo.AgregarArista("m","p",2);
		miGrafo.AgregarArista("m","n",5);
		miGrafo.AgregarArista("n","q",2);
		miGrafo.AgregarArista("n","r",1);
		miGrafo.AgregarArista("o","p",2);
		miGrafo.AgregarArista("o","s",6);
		miGrafo.AgregarArista("p","s",2);
		miGrafo.AgregarArista("p","t",1);
		miGrafo.AgregarArista("p","q",1);
		miGrafo.AgregarArista("q","t",3);
		miGrafo.AgregarArista("q","r",8);
		miGrafo.AgregarArista("s","z",2);
		miGrafo.AgregarArista("t","z",8);
		
		// Agrego caminos en sentido opuesto
		
		miGrafo.AgregarArista("b", "a", 2);
		miGrafo.AgregarArista("c", "a", 4);
		miGrafo.AgregarArista("d", "a", 1);
		miGrafo.AgregarArista("c", "b", 3);
		miGrafo.AgregarArista("e", "b", 1);
		miGrafo.AgregarArista("e", "c", 2);
		miGrafo.AgregarArista("f", "c", 2);
		miGrafo.AgregarArista("f", "d", 5);
		miGrafo.AgregarArista("g", "d", 4);
		miGrafo.AgregarArista("h", "e", 3);
		miGrafo.AgregarArista("g", "f", 3);
		miGrafo.AgregarArista("h", "f",3);
		miGrafo.AgregarArista("i", "f",2);
		miGrafo.AgregarArista("j", "f",4);
		miGrafo.AgregarArista("k", "g",2);
		miGrafo.AgregarArista("l", "h",1);
		miGrafo.AgregarArista("o", "h",8);
		miGrafo.AgregarArista("j", "i",3);
		miGrafo.AgregarArista("l", "i",3);
		miGrafo.AgregarArista("m", "i",2);
		miGrafo.AgregarArista("k", "j",6);
		miGrafo.AgregarArista("m", "j",6);
		miGrafo.AgregarArista("n", "j",3);
		miGrafo.AgregarArista("n", "k",4);
		miGrafo.AgregarArista("r", "k",2);
		miGrafo.AgregarArista("m", "l",3);
		miGrafo.AgregarArista("o", "l",6);
		miGrafo.AgregarArista("o", "m",4);
		miGrafo.AgregarArista("p", "m",2);
		miGrafo.AgregarArista("n", "m",5);
		miGrafo.AgregarArista("q", "n",2);
		miGrafo.AgregarArista("r", "n",1);
		miGrafo.AgregarArista("p", "o",2);
		miGrafo.AgregarArista("s", "o",6);
		miGrafo.AgregarArista("s", "p",2);
		miGrafo.AgregarArista("t", "p",1);
		miGrafo.AgregarArista("q", "p",1);
		miGrafo.AgregarArista("t", "q",3);
		miGrafo.AgregarArista("r", "q",8);
		miGrafo.AgregarArista("z", "s",2);
		miGrafo.AgregarArista("z", "t",8);

		
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

	// Ejercicio 4
	
	public static void Ejercicio4(GrafoDirTDA<String> g, String origen, int valor) {
		VectorTDA<String> solucion = new Vector<String>();
		solucion.inicializarVector(1000);
		ConjuntoTDA<String> conjuntoVerticesPendientes = new Conjunto<String>();
		conjuntoVerticesPendientes = g.Vertices();
		int etapa = 1;
		Ejercicio4Bis(g, origen, valor, conjuntoVerticesPendientes, solucion, etapa);
	}

	static void Ejercicio4Bis (GrafoDirTDA<String> g, String origen, int valor,
		ConjuntoTDA<String> verticesPendientes, VectorTDA<String> solucion, int etapa) {
		
		try {
			solucion.agregarElemento(etapa, origen);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
//		try {
//			System.out.println();
//			System.out.println("Etapa: "+etapa+" => " +solucion.recuperarElemento(etapa) + " Costo Restante: "+valor);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			System.out.println();
		
		verticesPendientes.sacar(origen);
		
		ConjuntoTDA<String> verticesAdyacentes = new Conjunto<String>();
		verticesAdyacentes = g.Adyacentes(origen);
		while (!verticesAdyacentes.conjuntoVacio()) {
			String unVerticeAdyacente = verticesAdyacentes.elegir();
			verticesAdyacentes.sacar(unVerticeAdyacente);
			// Si es factible:
			// * El vértice aún no ha sido visitado.
			// * Al visitarlo no excedo el valor de costo máximo.
			if (verticesPendientes.pertenece(unVerticeAdyacente)){
				if (valor - g.PesoArista(origen, unVerticeAdyacente) >= 0) {
					Ejercicio4Bis(g, unVerticeAdyacente, valor- g.PesoArista(origen, unVerticeAdyacente),
							verticesPendientes, solucion, etapa+1);
					// Si es final:
					// * Verifica si quedan vértices pendientes de visitar.
					// * Verifica que el recorrido haya costado lo mismo que valor.

					if (verticesPendientes.conjuntoVacio() && (valor - g.PesoArista(origen, unVerticeAdyacente)==0)){
						verticesPendientes.agregar(unVerticeAdyacente);
						System.out.println();
						System.out.println("Ejercicio 4:");
						System.out.print("Se pudo encontrar una solución: ");
						for (int i=1; i<=etapa+1;i++){
							try {
								System.out.print(solucion.recuperarElemento(i) + " ");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						};
						//Termina el backtracking.
						System.out.println("Terminar Backtracking");
					}else{
						verticesPendientes.agregar(unVerticeAdyacente);
					}
				};
			};
		};
	}
}
