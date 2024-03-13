package Parcial2;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial {
	public static ListaGenerica<Integer> resolver(ArbolGeneral<Integer> arbol, int minimo) {
		ListaGenericaEnlazada<Integer> l = null;
		if (!arbol.esVacia()) {
			l = new ListaGenericaEnlazada<Integer>();
			resolver(arbol, l,minimo);
		}
		return l;
	}

	private static Integer resolver(ArbolGeneral<Integer> a, ListaGenericaEnlazada<Integer> l,int minimo) {
		int suma = 0;
		if (!a.esHoja()){
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				suma+=resolver(hijos.proximo(), l,minimo);
			}
			if ((suma>minimo) && (!l.incluye(a.getDatoRaiz()))) {
				l.agregarFinal(a.getDatoRaiz());
			}
			return (a.getDatoRaiz());
		} 
		else {
			if ((suma>minimo) && (!l.incluye(a.getDatoRaiz()))) {
				l.agregarFinal(a.getDatoRaiz());
			}
			return a.getDatoRaiz();
		}
	}
}
