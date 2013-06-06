package Implementacion;

import Implementaciones.GrafoDir;
import TDA.GrafoDirTDA;

public class Ejercicios {

	// Ejercicio 1
	static GrafoDirTDA<String> cargarGrafo(){
		GrafoDirTDA<String> miGrafo = new GrafoDir<String>();
		miGrafo.InicializarGrafo();
		for (int i = 1; i<=26;i++){
			miGrafo.AgregarVertice(String.valueOf(i + 96));
		};
		miGrafo.AgregarArista("a","b",2);
		miGrafo.AgregarArista("a","c",4);
		miGrafo.AgregarArista("a","d",1);
		miGrafo.AgregarArista("b","c",3);
		miGrafo.AgregarArista("b","e",1);
		miGrafo.AgregarArista("c","e",2);
		miGrafo.AgregarArista("c","f",2);
		miGrafo.AgregarArista("d","f",5);
		miGrafo.AgregarArista("d","g",4);
		miGrafo.AgregarArista("e","h",3);
		miGrafo.AgregarArista("f","g",3);
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
		
		return null;
	}
	
	// Ejercicio 2A
	static int Ejercicio2A(GrafoDirTDA<String> g){

		return 0;
	}
	
	// Ejercicio 2B
	static int Ejercicio2B(GrafoDirTDA<String> g){

		return 0;
	}
	
	static void Ejercicio3D(GrafoDirTDA<String> g){
		
	}
	
	static void Ejercicio4(GrafoDirTDA<String> g, String origen, int valor){
		
	}

	
}
