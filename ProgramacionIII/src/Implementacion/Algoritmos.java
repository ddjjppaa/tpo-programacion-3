package Implementacion;

import TDA.GrafoDirTDA;

public class Algoritmos {

	// Ejercicio 2
	// en r devuelve los caminos y en la salida el valor
	static GrafoDirTDA<String> Dijkstra(GrafoDirTDA<String> g, String origen, GrafoDirTDA<String> r){
		
		return null;
	}
	
	// Ejercicio 3B
	static GrafoDirTDA<String> FloydRecursivo(GrafoDirTDA<String> g){
		
		return null;
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
