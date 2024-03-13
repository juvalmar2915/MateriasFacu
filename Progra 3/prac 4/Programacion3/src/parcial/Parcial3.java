package parcial;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
// debe devolver una lista con elementos del arbol sin repetir y sin elementos hijos de una rama con dato -1
public class Parcial3 {
	public ListaGenericaEnlazada<Integer> resolver(ArbolGeneral<Integer> a) {
		ListaGenericaEnlazada<Integer> l = null;
		if (!a.esVacia()) {
			l = new ListaGenericaEnlazada<Integer>();
			resolver(a, l);
		}
		return l;
	}

	private boolean resolver(ArbolGeneral<Integer> a, ListaGenericaEnlazada<Integer> l) {
		boolean terminar = false;
		if (a.getDatoRaiz() != -1) {
			if (l.incluye(a.getDatoRaiz()))
				l.eliminar(a.getDatoRaiz());
			else
				l.agregarFinal(a.getDatoRaiz());
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !terminar) {
				terminar = resolver(hijos.proximo(), l);
			}
		} else
			return true;
		return terminar;
	}
}
