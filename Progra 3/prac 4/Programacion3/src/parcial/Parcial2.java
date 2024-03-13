package parcial;

import prog3.arbol.general.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
//debe devolver true si existen dos valores repetidos en una misma rama
public class Parcial2 {
	public static boolean resolver(ArbolGeneral<Integer> arbol){
		if (!arbol.esVacia()) {
			boolean[] resol=new boolean [1];
			resol[0]=false;
			recuresolver(arbol,new ListaGenericaEnlazada<Integer>(),resol);
			return resol[0];
		}
		else {
			return false;
		}
	}
	
	private static void recuresolver(ArbolGeneral<Integer> arbol, ListaGenericaEnlazada<Integer> l,boolean []r) {
		if (r[0]==false) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
			hijos=arbol.getHijos();
			hijos.comenzar();
			l.comenzar();
			if (l.incluye(arbol.getDatoRaiz())) {
				r[0]=true;
			}
			l.agregarFinal(arbol.getDatoRaiz());
			while (!hijos.fin()) {
				recuresolver(hijos.proximo(),l,r);
			}
			l.eliminar(arbol.getDatoRaiz());
		}
	}
}
