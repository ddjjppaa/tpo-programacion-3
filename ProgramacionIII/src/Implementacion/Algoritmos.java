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
	public static GrafoDirTDA<String> FloydRecursivo(GrafoDirTDA<String> g) {//O(nö3)
		GrafoDirTDA<String> resultadoParcial = new GrafoDir<String>();
		resultadoParcial.InicializarGrafo();
		resultadoParcial.Vertices();//O(n)
		ConjuntoTDA<String> conj = g.Vertices(); // O(n)

		while (!conj.conjuntoVacio()) {//C
			String elemento = conj.elegir();//C
			conj.sacar(elemento);//C
			resultadoParcial.AgregarVertice(elemento);//C
		}//O(n) sigo sin terminar de entender que hace este metodo, es porque no se puede hacer una copia directa como en 4bis?

		ConjuntoTDA<String> vertices = g.Vertices();//O(n)
		while (!vertices.conjuntoVacio()) {//C * O(n-1)
			int pesoAcum = 0; //C
			String origen = vertices.elegir();//C
			vertices.sacar(origen);//C
			FloydRec(g, origen, origen, g.Adyacentes(origen), pesoAcum,
					resultadoParcial);// O(nö2) + O(n-1) = O(n^2)
		}//n* lo que me de floyd recursivo
		return resultadoParcial;
	}// O(n-1) * O(nö2) = O(nö3)

	static void FloydRec(GrafoDirTDA<String> g, String origen,
			String adyacente, ConjuntoTDA<String> adyacentes, int pesoAcum,
			GrafoDirTDA<String> resultadoParcial) {

		while (!adyacentes.conjuntoVacio()) {//C * O(n-1)
			String vertAdy = adyacentes.elegir();//C
			adyacentes.sacar(vertAdy);//O(n-1)
			int pesoActual = g.PesoArista(adyacente, vertAdy);// O(n)
			pesoAcum = pesoActual + pesoAcum;//C
			System.out.println("Origen: " + origen + " Destino: " + vertAdy
					+ " PesoAcum: " + pesoAcum + " PesoActual: " + pesoActual
					+ " Acumulado hasta: " + adyacente + " --> " + vertAdy);
			if (!resultadoParcial.ExisteArista(origen, vertAdy)) {// O(n)
				resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum);// O(n)
			} else {
				if (pesoAcum < resultadoParcial.PesoArista(origen, vertAdy)) {// O(n)
					resultadoParcial.AgregarArista(origen, vertAdy, pesoAcum);// O(n)
				}
			}

			FloydRec(g, origen, vertAdy, g.Adyacentes(vertAdy), pesoAcum,
					resultadoParcial);// O(n-1) + O(n-1) + O(n)
			pesoAcum = pesoAcum-g.PesoArista(adyacente, vertAdy);//O(n)
		}// O(n-1) * O(n) = O(nö2)

	}
	
	// Ejercicio 3C
	public static GrafoDirTDA<String> FloydPD(GrafoDirTDA<String> g) { // O(n^4)
		ConjuntoTDA<String> conjuntoI, conjuntoJ, conjuntoK;
		String i, j, k;
		GrafoDirTDA<String> r = new GrafoDir<String>();
		r.InicializarGrafo();

		conjuntoK = g.Vertices();// O(n)
		while (!conjuntoK.conjuntoVacio()) { //C * O(n)
			k = conjuntoK.elegir(); // C
			conjuntoK.sacar(k); // O(n)
			r.AgregarVertice(k); // O(n)
		} // O(nö2)

		conjuntoK = g.Vertices(); // O(n)
		while (!conjuntoK.conjuntoVacio()) { //C * O(n)
			k = conjuntoK.elegir(); //C
			conjuntoK.sacar(k); // O(n)
			conjuntoI = g.Adyacentes(k); // O(n)
			while (!conjuntoI.conjuntoVacio()) {// O(n)
				i = conjuntoI.elegir();// O(c)
				conjuntoI.sacar(i); // O(n)
				r.AgregarArista(k, i, g.PesoArista(k, i)); // C
			} //O(nö2)
		} // O(nö3)

		conjuntoK = g.Vertices(); // O(n)
		while (!conjuntoK.conjuntoVacio()) { // C * O(n-1)
			k = conjuntoK.elegir(); //C
			conjuntoK.sacar(k); // O(n)
			conjuntoI = g.Vertices(); // O(n)
			conjuntoI.sacar(k); // O(n)
			while (!conjuntoI.conjuntoVacio()) { // C * O(n)
				i = conjuntoI.elegir(); // C
				conjuntoI.sacar(i); // O(n)
				if (r.ExisteArista(i, k)) { // O(n)
					conjuntoJ = r.Adyacentes(k); // O(n-1)
					conjuntoJ.sacar(i); // O(n)
					while (!conjuntoJ.conjuntoVacio()) { // C * O(n)
						j = conjuntoJ.elegir(); // C
						conjuntoJ.sacar(j); // O(n)
						if (r.ExisteArista(i, j)) { // O(n)
							if (r.PesoArista(i, k) + r.PesoArista(k, j) < r // 3 * O(n)
									.PesoArista(i, j)) {
								r.AgregarArista(i, j,
										r.PesoArista(i, k) + r.PesoArista(k, j));//O(n) + O(n)
							}
						} else {
							r.AgregarArista(i, j,
									r.PesoArista(i, k) + r.PesoArista(k, j));//O(n) + O(n)
						}
					} // O(nö2)
				}
			}// O(nö3)
		} //O(n^4)

		return r;

	}
	
	
}
