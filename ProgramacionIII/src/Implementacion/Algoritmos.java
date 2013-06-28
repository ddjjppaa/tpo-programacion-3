package Implementacion;

import Implementaciones.Conjunto;
import Implementaciones.GrafoDir;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;
import TDA.VectorTDA;

public class Algoritmos {

	public static boolean CaminoDijkstra (GrafoDirTDA<String> g, String origen, String destino, ConjuntoTDA<String> verticesPendientes, VectorTDA<String> solucion, int etapa) throws Exception {

		boolean haySolucion=false;
		solucion.agregarElemento(etapa, origen);		
		verticesPendientes.sacar(origen); // O(n)
		ConjuntoTDA<String> verticesAdyacentes = new Conjunto<String>(); // C
		verticesAdyacentes = g.Adyacentes(origen); // O(n)
		
		while (!verticesAdyacentes.conjuntoVacio() && !haySolucion) { // C
			String unVerticeAdyacente = verticesAdyacentes.elegir(); // C
			verticesAdyacentes.sacar(unVerticeAdyacente); // O(n)
			
			// Si es factible:
			// * El vértice aún no ha sido visitado.
			if (verticesPendientes.pertenece(unVerticeAdyacente)){ // O(n)
				
				haySolucion = CaminoDijkstra(g, unVerticeAdyacente, destino, verticesPendientes, solucion, etapa+1);

				// Si es final:
				// * Verifica si llegué al destino.

				if (unVerticeAdyacente==destino){ // C && O(n)
					haySolucion=true;
				}
				verticesPendientes.agregar(unVerticeAdyacente); // O(n)
			};
		}; // O(n^2)
		return haySolucion;
	};
	
	// Ejercicio 2
	// en r devuelve los caminos y en la salida el valor

	public static GrafoDirTDA<String> Dijkstra(GrafoDirTDA<String> g, String origen, GrafoDirTDA<String> r){
		String vertice, aux_vertice, aux_aux_vertice, mejor_vertice;
		int mejor_distancia;
		GrafoDirTDA<String> rAux = new GrafoDir<String>();
		rAux.InicializarGrafo();
		rAux.AgregarVertice(origen);

		r.InicializarGrafo();
		r.AgregarVertice(origen);

		ConjuntoTDA<String> vertices = g.Vertices();
		vertices.sacar(origen);

		while(!vertices.conjuntoVacio()){
			vertice = vertices.elegir();
			vertices.sacar(vertice);
			r.AgregarVertice(vertice);
			rAux.AgregarVertice(vertice);
			if(g.ExisteArista(origen, vertice)){
				r.AgregarArista(origen, vertice, g.PesoArista(origen, vertice));
				rAux.AgregarArista(origen, vertice, g.PesoArista(origen, vertice));
			}
		}

		ConjuntoTDA<String> pendientes = g.Vertices();
		pendientes.sacar(origen);
		ConjuntoTDA<String> aux_pendientes = new Conjunto<String>();
		aux_pendientes.inicializarConjunto();

		while(!pendientes.conjuntoVacio()){
			mejor_distancia = 0;
			mejor_vertice = origen;
			while(!pendientes.conjuntoVacio()){
				aux_vertice = pendientes.elegir();
				pendientes.sacar(aux_vertice);
				aux_pendientes.agregar(aux_vertice);
				if(rAux.ExisteArista(origen, aux_vertice) && (mejor_distancia == 0 || (mejor_distancia > rAux.PesoArista(origen, aux_vertice)))){
					mejor_distancia = rAux.PesoArista(origen, aux_vertice);
					mejor_vertice = aux_vertice;
				}
			}
			vertice = mejor_vertice ;
			if(!vertice.equals(origen)){
				aux_pendientes.sacar(vertice);
				while(!aux_pendientes.conjuntoVacio()){
					aux_vertice = aux_pendientes.elegir();
					aux_pendientes.sacar(aux_vertice);
					pendientes.agregar(aux_vertice);
					if(g.ExisteArista(vertice, aux_vertice))
						if(!rAux.ExisteArista(origen, aux_vertice)){
							rAux.AgregarArista(origen, aux_vertice, rAux.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice));
							r.AgregarArista(vertice, aux_vertice, g.PesoArista(vertice, aux_vertice));
						} else
							if(rAux.PesoArista(origen, aux_vertice) > rAux.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice)){
								rAux.AgregarArista(origen, aux_vertice, rAux.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice));
								ConjuntoTDA<String> verticesR = r.Vertices();
								while(!verticesR.conjuntoVacio()){
									aux_aux_vertice = verticesR.elegir();
									verticesR.sacar(aux_aux_vertice);
									r.EliminarArista(aux_aux_vertice, aux_vertice);
								}
								r.AgregarArista(vertice, aux_vertice, g.PesoArista(vertice, aux_vertice));
							}
				}
			}
		}

		return rAux;
	}

	// Ejercicio 3B

	public static GrafoDirTDA<String> FloydRecursivo(GrafoDirTDA<String> g) {

		GrafoDirTDA<String> resultadoParcial = new GrafoDir<String>();
		resultadoParcial.InicializarGrafo(); // O(n)
		ConjuntoTDA<String> intermedios = new Conjunto<String>();
		intermedios.inicializarConjunto(); // O(n)

		// Cargo Vertices Grafo solucion
		ConjuntoTDA<String> vertices = g.Vertices(); // O(n)
		while (!vertices.conjuntoVacio()) { // C * O(n) = O(n)
			String unElemento = vertices.elegir(); // C
			vertices.sacar(unElemento);
			resultadoParcial.AgregarVertice(unElemento); // O(n)
		}

		// Cargo Aristas Directas Grafo solucion
		ConjuntoTDA<String> verticesDesde = g.Vertices(); // O(n)
		while (!vertices.conjuntoVacio()) { // O(n) * O(n) = O(n^2)
			String unElemento = verticesDesde.elegir();// C
			verticesDesde.sacar(unElemento); // O(n)

			ConjuntoTDA<String> adyacentes = g.Adyacentes(unElemento); // O(n)
			while (!adyacentes.conjuntoVacio()) { // O(n)
				String unAdyacente = adyacentes.elegir(); // C
				adyacentes.sacar(unAdyacente); // O(n)
				resultadoParcial.AgregarArista(unElemento, unAdyacente, // O(n) + O(n) = 2 0(n) = 0(n)
						g.PesoArista(unElemento, unAdyacente));
			}
		}

		ConjuntoTDA<String> conjDesde = g.Vertices(); // O(n)
		while (!conjDesde.conjuntoVacio()) { //O(n^2 3^n/2) --> Complejidad total
			String elementoDesde = conjDesde.elegir(); // C
			conjDesde.sacar(elementoDesde); // O(n)
			ConjuntoTDA<String> conjHasta = g.Vertices(); // O(n)
			while (!conjHasta.conjuntoVacio()) { // O(n 3^n/2)
				String elementoHasta = conjHasta.elegir(); // C
				conjHasta.sacar(elementoHasta); // O(n)

				intermedios = g.Vertices(); // O(n)

				if (elementoDesde != elementoHasta) {
					resultadoParcial = FloydRec2(g, resultadoParcial,
							elementoDesde, elementoHasta, intermedios); // O(3^n/2)

				}
			}
		}
		return resultadoParcial;

	}

	static GrafoDirTDA<String> FloydRec2(GrafoDirTDA<String> g,
			GrafoDirTDA<String> resultadoParcial, String desde, String hasta,
			ConjuntoTDA<String> intermedios) {

		if (intermedios.conjuntoVacio() && g.ExisteArista(desde, hasta)) {
			if (resultadoParcial.ExisteArista(desde, hasta)) { // O(n)
				if (resultadoParcial.PesoArista(desde, hasta) > g.PesoArista(
						desde, hasta)) {

					resultadoParcial.EliminarArista(desde, hasta); // O(n)

					resultadoParcial.AgregarArista(desde, hasta, // O(n)
							g.PesoArista(desde, hasta));
				}
			} else {
				resultadoParcial.AgregarArista(desde, hasta, // O(n)
						g.PesoArista(desde, hasta));
			}

		} else if (intermedios.conjuntoVacio() && !g.ExisteArista(desde, hasta) // O(n)
				&& !resultadoParcial.ExisteArista(desde, hasta)) {
			resultadoParcial.AgregarArista(desde, hasta, 99999); // O(n)

		} else {

			if (!intermedios.conjuntoVacio()) {
				String unIntermedio = intermedios.elegir(); // C
				intermedios.sacar(unIntermedio); // 0(n)

				int distancia1 = FloydRec2(g, resultadoParcial, desde, hasta,
						intermedios).PesoArista(desde, hasta);

				int distancia2 = FloydRec2(g, resultadoParcial, desde,
						unIntermedio, intermedios).PesoArista(desde,
						unIntermedio)
						+ FloydRec2(g, resultadoParcial, unIntermedio, hasta,
								intermedios).PesoArista(unIntermedio, hasta);

				if (distancia1 < distancia2) {
					resultadoParcial.EliminarArista(desde, hasta); // 0(n)
					resultadoParcial.AgregarArista(desde, hasta, distancia1); // O(n)

				} else {
					resultadoParcial.EliminarArista(desde, hasta); // 0(n)
					resultadoParcial.AgregarArista(desde, hasta, distancia2); // 0(n)
				}

				intermedios.agregar(unIntermedio); // C
			}
		}
		return resultadoParcial;
	}

	// Ejercicio 3C
	
	public static GrafoDirTDA<String> FloydPD(GrafoDirTDA<String> g) {
		ConjuntoTDA<String> conjuntoI, conjuntoJ, conjuntoK; // C * 3 = C
		String i, j, k; // C * 3 = C
		GrafoDirTDA<String> r = new GrafoDir<String>();
		r.InicializarGrafo(); // O(n)

		conjuntoK = g.Vertices(); // O(n)
		while (!conjuntoK.conjuntoVacio()) { // C * O(n) = O(n)
			k = conjuntoK.elegir(); // C
			conjuntoK.sacar(k); // O(n)
			r.AgregarVertice(k); // O(n)
		} // O(n^2)

		conjuntoK = g.Vertices(); // O(n)
		while (!conjuntoK.conjuntoVacio()) { // C * O(n) = O(n)
			k = conjuntoK.elegir(); // C
			conjuntoK.sacar(k); // O(n)
			conjuntoI = g.Adyacentes(k); // O(n)
			while (!conjuntoI.conjuntoVacio()) { // C * O(n) = O(n)
				i = conjuntoI.elegir(); // O(c)
				conjuntoI.sacar(i); // O(n)
				r.AgregarArista(k, i, g.PesoArista(k, i)); // O(n)
			} // O(n) * O(n) = O(n^2)
		} // O(n^3)

		conjuntoK = g.Vertices(); // O(n)
		while (!conjuntoK.conjuntoVacio()) { // C * O(n) = O(n)
			k = conjuntoK.elegir(); // C
			conjuntoK.sacar(k); // O(n)
			conjuntoI = g.Vertices(); // O(n)
			conjuntoI.sacar(k); // O(n)
			while (!conjuntoI.conjuntoVacio()) { // C * O(n) = O(n)
				i = conjuntoI.elegir(); // C
				conjuntoI.sacar(i); // O(n)
				if (r.ExisteArista(i, k)) { // O(n)
					conjuntoJ = r.Adyacentes(k); // O(n)
					conjuntoJ.sacar(i); // O(n)
					while (!conjuntoJ.conjuntoVacio()) { // C * O(n) = O(n)
						j = conjuntoJ.elegir(); // C
						conjuntoJ.sacar(j); // O(n)
						if (r.ExisteArista(i, j)) { // O(n)
							if (r.PesoArista(i, k) + r.PesoArista(k, j) < r
									.PesoArista(i, j)) { // 3 * O(n)
								r.AgregarArista(i, j,
										r.PesoArista(i, k) + r.PesoArista(k, j)); // 2
																					// *
																					// O(n)
							}
						} else {
							r.AgregarArista(i, j,
									r.PesoArista(i, k) + r.PesoArista(k, j)); // 2
																				// *
																				// O(n)
						}
					} // O(n^2)
				}
			} // O(n^3)
		} // O(n^4)
		return r;
	} // O(n^4)
}
