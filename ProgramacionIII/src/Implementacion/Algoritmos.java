package Implementacion;

import Implementaciones.Conjunto;
import Implementaciones.GrafoDir;
import Implementaciones.Vector;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;
import TDA.VectorTDA;

public class Algoritmos {

	// Ejercicio 2
		// en r devuelve los caminos y en la salida el valor
		public static GrafoDirTDA<String> Dijkstra(GrafoDirTDA<String> g, String origen, GrafoDirTDA<String> r) throws Exception{
			String vertice, aux_vertice, mejor_vertice, destino = r.Vertices().elegir(); 
			int mejor_distancia;
			
			r.InicializarGrafo();
			r.AgregarVertice(origen);

			ConjuntoTDA<String> vertices = g.Vertices();
			vertices.sacar(origen);

			int tamanioGrafo = 0;
			while(!vertices.conjuntoVacio()){
				tamanioGrafo++;
				vertice = vertices.elegir();
				vertices.sacar(vertice);
				r.AgregarVertice(vertice);
				if(g.ExisteArista(origen, vertice))
					r.AgregarArista(origen, vertice, g.PesoArista(origen, vertice));
			}

			int posicion = 0;
			VectorTDA<String> verticesCaminoV = new Vector<String>();
			verticesCaminoV.inicializarVector(tamanioGrafo + 1);
			verticesCaminoV.agregarElemento(posicion++, origen);
			if(g.ExisteArista(origen, destino))
				verticesCaminoV.agregarElemento(posicion++, destino);

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
					if(r.ExisteArista(origen, aux_vertice) && (mejor_distancia == 0 || (mejor_distancia > r.PesoArista(origen, aux_vertice)))){
						mejor_distancia = r.PesoArista(origen, aux_vertice);
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
							if(!r.ExisteArista(origen, aux_vertice)){
								r.AgregarArista(origen, aux_vertice, r.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice));
								if(aux_vertice == destino){
									verticesCaminoV.agregarElemento(posicion++, vertice);
									verticesCaminoV.agregarElemento(posicion, aux_vertice);
									posicion++;
								}
							} else
								if(r.PesoArista(origen, aux_vertice) > r.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice)){
									r.AgregarArista(origen, aux_vertice, r.PesoArista(origen, vertice) + g.PesoArista(vertice, aux_vertice));
									if(aux_vertice == destino){
										verticesCaminoV.agregarElemento(--posicion, vertice);
//										verticesCaminoV.agregarElemento(posicion, vertice);
										verticesCaminoV.agregarElemento(++posicion, aux_vertice);
										posicion++;
									}
								}
					}
				}
			}

			System.out.println("Distancia de " + origen + " - " + destino + " : " + r.PesoArista(origen, destino));
			ConjuntoTDA<String> verticesCaminoAuxiliar = r.Vertices();
			System.out.println("Camino de " + origen + " - " + destino + " :");
			for(int i = 0; i < verticesCaminoV.capacidadVector(); i++){
				System.out.println(verticesCaminoV.recuperarElemento(i));
				if(verticesCaminoV.recuperarElemento(i) == destino)
					i = verticesCaminoV.capacidadVector();
			}
			
			return r;
		}
	
	// Ejercicio 3B
	
	public static GrafoDirTDA<String> FloydRecursivo(GrafoDirTDA<String> g) {
		GrafoDirTDA<String> resultadoParcial = new GrafoDir<String>();
		resultadoParcial.InicializarGrafo(); // O(n)
		ConjuntoTDA<String> conj = g.Vertices(); // O(n)

		while (!conj.conjuntoVacio()) { // C * O(n) = O(n)
			String elemento = conj.elegir(); // C
			conj.sacar(elemento); // O(n)
			resultadoParcial.AgregarVertice(elemento); // O(n)
		} // O(n^2)

		ConjuntoTDA<String> vertices = g.Vertices(); // O(n)
		
		while (!vertices.conjuntoVacio()) { // C * O(n) = O(n)
			int pesoAcum = 0; // C
			String origen = vertices.elegir(); // C
			vertices.sacar(origen); // O(n)
			FloydRec(g, origen, origen, g.Adyacentes(origen), pesoAcum, resultadoParcial); // O(n) + O(n^2) = O(n^2)
		} // O(n) * O(n^2) = O(n^3)
		return resultadoParcial;
	}// O(n^3)

	static void FloydRec(GrafoDirTDA<String> g, String origen,
			String adyacente, ConjuntoTDA<String> adyacentes, int pesoAcum,
			GrafoDirTDA<String> resultadoParcial) {

		while (!adyacentes.conjuntoVacio()) { // C * O(n) = O(n)
			String vertAdy = adyacentes.elegir(); // C
			adyacentes.sacar(vertAdy); // O(n)
			int pesoActual = g.PesoArista(adyacente, vertAdy); // O(n)
			pesoAcum = pesoActual + pesoAcum; // C
			if (!resultadoParcial.ExisteArista(origen, vertAdy)) { // O(n)
				resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum); // O(n)
			} else {
				if (pesoAcum < resultadoParcial.PesoArista(origen, vertAdy)) { // O(n)
					resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum); // O(n)
				}
			}
			FloydRec(g, origen, vertAdy, g.Adyacentes(vertAdy), pesoAcum, resultadoParcial); // ?
			pesoAcum = pesoAcum-g.PesoArista(adyacente, vertAdy); // O(n)
		}// O(n) * O(n) = O(n^2)

	} // O(n^2)
	
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
				i = conjuntoI.elegir();  // O(c)
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
							if (r.PesoArista(i, k) + r.PesoArista(k, j) < r.PesoArista(i, j)) { // 3 * O(n)	
								r.AgregarArista(i, j, r.PesoArista(i, k) + r.PesoArista(k, j)); // 2 * O(n)
							}
						} else {
							r.AgregarArista(i, j, r.PesoArista(i, k) + r.PesoArista(k, j)); // 2 * O(n)
						}
					} // O(n^2)
				}
			} // O(n^3)
		} // O(n^4)		
		return r;
	} // O(n^4)
}
