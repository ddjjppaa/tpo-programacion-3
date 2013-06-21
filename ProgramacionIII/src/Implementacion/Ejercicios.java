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

	// Ejercicio 3D
	
	public static void Ejercicio3D(GrafoDirTDA<String> g) {
		GrafoDirTDA<String> lcm = Algoritmos.FloydPD(g);

		int distanciaMin = 99999999; // C
		String vertDesde = null; // C
		String vertHasta = null; // C

		ConjuntoTDA<String> conj1 = lcm.Vertices(); // O(n)
		while (!conj1.conjuntoVacio()) { // O(n)
			String elemento = conj1.elegir(); // C
			conj1.sacar(elemento); // O(n)
			ConjuntoTDA<String> conj2 = lcm.Adyacentes(elemento); // O(n)
			while (!conj2.conjuntoVacio()) { // O(n)
				String elemento2 = conj2.elegir(); // C
				conj2.sacar(elemento2); // O(n)
				if (!g.ExisteArista(elemento, elemento2)) { // O(n)
					if (lcm.ExisteArista(elemento, elemento2)) { // O(n)
						if (lcm.PesoArista(elemento, elemento2) < distanciaMin) { // O(n)
							distanciaMin = lcm.PesoArista(elemento, elemento2); // O(n)
							vertDesde = elemento; // C
							vertHasta = elemento2; // C

						}
					}
				}
			} // O(n^2)
		} // O(n^3)
		System.out.println("Desde: " + vertDesde + " Hasta: " + vertHasta
				+ " Distancia: " + distanciaMin);
	} // O(n^3)

	// Ejercicio 4
	
	public static void Ejercicio4(GrafoDirTDA<String> g, String origen, int valor) {
		VectorTDA<String> solucion = new Vector<String>();
		solucion.inicializarVector(1000); // O(n)
		ConjuntoTDA<String> conjuntoVerticesPendientes = new Conjunto<String>(); // C
		conjuntoVerticesPendientes = g.Vertices();  // O(n)
		int etapa = 1; // C
		Ejercicio4Bis(g, origen, valor, conjuntoVerticesPendientes, solucion, etapa);
	}

	static void Ejercicio4Bis (GrafoDirTDA<String> g, String origen, int valor,
		ConjuntoTDA<String> verticesPendientes, VectorTDA<String> solucion, int etapa) {
		
		try {
			solucion.agregarElemento(etapa, origen); // C
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		verticesPendientes.sacar(origen); // O(n)
		
		ConjuntoTDA<String> verticesAdyacentes = new Conjunto<String>(); // C
		verticesAdyacentes = g.Adyacentes(origen); // O(n)
		while (!verticesAdyacentes.conjuntoVacio()) { // C
			String unVerticeAdyacente = verticesAdyacentes.elegir(); // C
			verticesAdyacentes.sacar(unVerticeAdyacente); // O(n)
			
			// Si es factible:
			// * El vértice aún no ha sido visitado.
			// * Al visitarlo no excedo el valor de costo máximo.
			
			if (verticesPendientes.pertenece(unVerticeAdyacente)){ // O(n)
				if (valor - g.PesoArista(origen, unVerticeAdyacente) >= 0) {  // O(n)
					Ejercicio4Bis(g, unVerticeAdyacente, valor- g.PesoArista(origen, unVerticeAdyacente),
							verticesPendientes, solucion, etapa+1);
					
					// Si es final:
					// * Verifica si quedan vértices pendientes de visitar.
					// * Verifica que el recorrido haya costado lo mismo que valor.

					if (verticesPendientes.conjuntoVacio() && (valor - g.PesoArista(origen, unVerticeAdyacente)==0)){ // C && O(n)
						System.out.print("      * ");
						for (int i=1; i<=etapa+1;i++){  // O(n)
							try {
								System.out.print(solucion.recuperarElemento(i) + " ");
							} catch (Exception e) {
								e.printStackTrace();
							}
						};
						System.out.println();
					}
					verticesPendientes.agregar(unVerticeAdyacente); // O(n)
				};
			};
		}; // O(n^2)
	};
}
