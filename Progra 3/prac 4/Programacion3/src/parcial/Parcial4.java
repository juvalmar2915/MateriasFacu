package parcial;

/*
Parcial: 
resolver(ArbolGeneral<Integer> arbol): boolean 

que devuelve true si el árbol enviado como argumento posee dos caminos DESDE LA RAÍZ A LAS HOJAS que suman el mismo valor.

Tenga en cuenta las siguientes condiciones:

Debe realizar un recorrido preorden 

No puede recorrer 2 veces la estructura  de aŕbol general

Debe terminar la ejecución una vez que encuentra que los dos caminos suman el mismo valor (no debe recorrer todo el árbol innecesariamente)
*/
import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial4 {
	public static boolean resolver(ArbolGeneral<Integer> arbol) {
		if (!arbol.esVacia()) {
			boolean resol[] = new boolean[1];
			recuresolver(arbol, new ListaGenericaEnlazada<Integer>(), new ListaGenericaEnlazada<Integer>(), resol);
			return resol[0];
		} else {
			return false;
		}
	}

	private static void recuresolver(ArbolGeneral<Integer> arbol, ListaGenericaEnlazada<Integer> l,
			ListaGenericaEnlazada<Integer> ls, boolean r[]) {
		if (r[0] == false) {
			if (!arbol.esHoja()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
				hijos = arbol.getHijos();
				hijos.comenzar();
				l.comenzar();
				l.agregarFinal(arbol.getDatoRaiz());
				while (!hijos.fin()) {
					recuresolver(hijos.proximo(), l, ls, r);
				}
				l.eliminar(arbol.getDatoRaiz());
			} else {
				int sumat = 0;
				l.comenzar();
				while (!l.fin()) {
					sumat = l.proximo();
				}
				if (ls.incluye(sumat)) {
					r[0] = true;
				} else {
					ls.agregarFinal(sumat);
				}
			}
		}
	}
}
