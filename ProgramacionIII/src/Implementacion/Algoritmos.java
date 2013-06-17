package Implementacion;

import Implementaciones.GrafoDir;
import TDA.ConjuntoTDA;
import TDA.GrafoDirTDA;

public class Algoritmos {

	// Ejercicio 2
	// en r devuelve los caminos y en la salida el valor
	static GrafoDirTDA<String> Dijkstra(GrafoDirTDA<String> g, String origen, GrafoDirTDA<String> r){
		
		return null;
	}
	
	// Ejercicio 3B
	public static GrafoDirTDA<String> FloydRecursivo(GrafoDirTDA<String> g) {
		GrafoDirTDA<String> resultadoParcial = new GrafoDir<String>();
		resultadoParcial.InicializarGrafo();
		resultadoParcial.Vertices();//para que es este metodo?
		ConjuntoTDA<String> conj = g.Vertices();

		while (!conj.conjuntoVacio()) {
			String elemento = conj.elegir();
			conj.sacar(elemento);
			resultadoParcial.AgregarVertice(elemento);//hay que validar que no exista ya en solucion parcial
		}

		ConjuntoTDA<String> vertices = g.Vertices();
		while (!vertices.conjuntoVacio()) {
			int pesoAcum = 0;
			String origen = vertices.elegir();
			vertices.sacar(origen);
			FloydRec(g, origen, origen, g.Adyacentes(origen), pesoAcum,
					resultadoParcial);
		}
		return resultadoParcial;
	}

	static void FloydRec(GrafoDirTDA<String> g, String origen,
			String adyacente, ConjuntoTDA<String> adyacentes, int pesoAcum,
			GrafoDirTDA<String> resultadoParcial) {

		while (!adyacentes.conjuntoVacio()) {
			String vertAdy = adyacentes.elegir();
			adyacentes.sacar(vertAdy);
			int pesoActual = g.PesoArista(adyacente, vertAdy);
			pesoAcum = pesoActual + pesoAcum;
			System.out.println("Origen: " + origen + " Destino: " + vertAdy
					+ " PesoAcum: " + pesoAcum + " PesoActual: " + pesoActual
					+ " Acumulado hasta: " + adyacente + " --> " + vertAdy);
			if (!resultadoParcial.ExisteArista(origen, vertAdy)) {
				resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum);
			} else {
				if (pesoAcum < resultadoParcial.PesoArista(origen, vertAdy)) {
					resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum);//
				}
			}

			FloydRec(g, origen, vertAdy, g.Adyacentes(vertAdy), pesoAcum,
					resultadoParcial);
			pesoAcum = 0;
		}

	}
	
	// Ejercicio 3C
	public static GrafoDirTDA<String> FloydPD(GrafoDirTDA<String> g) {
		ConjuntoTDA<String> conjuntoI, conjuntoJ, conjuntoK;
		String i, j, k;
		GrafoDirTDA<String> r = new GrafoDir<String>();
		r.InicializarGrafo();

		conjuntoK = g.Vertices();
		while (!conjuntoK.conjuntoVacio()) {
			k = conjuntoK.elegir();
			conjuntoK.sacar(k);
			r.AgregarVertice(k);
		}

		conjuntoK = g.Vertices();
		while (!conjuntoK.conjuntoVacio()) {
			k = conjuntoK.elegir();
			conjuntoK.sacar(k);
			conjuntoI = g.Adyacentes(k);
			while (!conjuntoI.conjuntoVacio()) {
				i = conjuntoI.elegir();
				conjuntoI.sacar(i);
				r.AgregarArista(k, i, g.PesoArista(k, i));
			}
		}

		conjuntoK = g.Vertices();
		while (!conjuntoK.conjuntoVacio()) {
			k = conjuntoK.elegir();
			conjuntoK.sacar(k);
			conjuntoI = g.Vertices();
			conjuntoI.sacar(k);
			while (!conjuntoI.conjuntoVacio()) {
				i = conjuntoI.elegir();
				conjuntoI.sacar(i);
				if (r.ExisteArista(i, k)) {
					conjuntoJ = r.Adyacentes(k);
					conjuntoJ.sacar(i);
					while (!conjuntoJ.conjuntoVacio()) {
						j = conjuntoJ.elegir();
						conjuntoJ.sacar(j);
						if (r.ExisteArista(i, j)) {
							if (r.PesoArista(i, k) + r.PesoArista(k, j) < r
									.PesoArista(i, j)) {
								r.AgregarArista(i, j,
										r.PesoArista(i, k) + r.PesoArista(k, j));
							}
						} else {
							r.AgregarArista(i, j,
									r.PesoArista(i, k) + r.PesoArista(k, j));
						}
					}
				}
			}
		}

		return r;

	}
	
	
}
