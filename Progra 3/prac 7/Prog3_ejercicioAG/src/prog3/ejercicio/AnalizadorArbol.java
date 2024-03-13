package prog3.ejercicio;

import prog3.arbol.general.ArbolGeneral;
import prog3.util.*;
import prog3.listagenerica.*;

public class AnalizadorArbol {

	public int cantHijosImpares(ArbolGeneral<Character> arbol) {
		ColaGenerica<ArbolGeneral<Character>> cola = new ColaGenerica<>();
		cola.encolar(arbol);
		cola.encolar(null);
		ArbolGeneral<Character> arb = new ArbolGeneral<>();
		ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<>();
		int impar = 0;
		while (!cola.esVacia()) {
			arb = cola.desencolar();
			if (arb != null) {
				hijos = arb.getHijos();
				hijos.comenzar();
				if((hijos.tamanio()%2)!=0) {
					impar++;
				}
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return impar;
	}

	public static void main(String[] args) {
		// Casos de ejemplo para probar su implementación.
		// Se instancia el siguiente ejemplo:
		//
		// A
		// / \
		// B C
		// / | \ \
		// D E F G
		// \
		// H

		ArbolGeneral<Character> arbolA = new ArbolGeneral<>('A');
		ArbolGeneral<Character> arbolB = new ArbolGeneral<>('B');
		ArbolGeneral<Character> arbolC = new ArbolGeneral<>('C');
		ArbolGeneral<Character> arbolD = new ArbolGeneral<>('D');
		ArbolGeneral<Character> arbolE = new ArbolGeneral<>('E');
		ArbolGeneral<Character> arbolF = new ArbolGeneral<>('F');
		ArbolGeneral<Character> arbolG = new ArbolGeneral<>('G');
		ArbolGeneral<Character> arbolH = new ArbolGeneral<>('H');

		arbolA.agregarHijo(arbolB);
		arbolA.agregarHijo(arbolC);

		arbolB.agregarHijo(arbolD);
		arbolB.agregarHijo(arbolE);
		arbolB.agregarHijo(arbolF);

		arbolC.agregarHijo(arbolG);

		arbolF.agregarHijo(arbolH);

		AnalizadorArbol analizador = new AnalizadorArbol();

		System.out.println("La cantidad de impares de A (deben ser 3): " + analizador.cantHijosImpares(arbolA));
		System.out.println("La cantidad de impares de B (deben ser 2): " + analizador.cantHijosImpares(arbolB));
		System.out.println("La cantidad de impares de F (deben ser 1): " + analizador.cantHijosImpares(arbolF));
		System.out.println("La cantidad de impares de E (deben ser 0): " + analizador.cantHijosImpares(arbolE));
	}

}