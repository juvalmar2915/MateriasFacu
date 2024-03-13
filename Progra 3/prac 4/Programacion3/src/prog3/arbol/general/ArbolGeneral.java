package prog3.arbol.general;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.Cola;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);

	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaGenericaEnlazada<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());

		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}

	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));

		}

		return lista;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);

			}
		}

	}

	public boolean esHoja() {
		return (this.getDatoRaiz() != null && this.getHijos().elemento(0) == null);
	}

	public boolean esVacia() {
		return (this.getDatoRaiz() == null);
	}

	// sin contadores
	/*
	 * public int altura() { if (this.esHoja()) { return 0; } else { int max = -1;
	 * ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos(); hijos.comenzar();
	 * while (!hijos.fin()) { max = Math.max(hijos.proximo().altura(), max); }
	 * return max + 1; } }
	 */

	// con contadores
	public Integer altura() {
		int contador = 0;
		int[] max = new int[1];
		max[0] = -1;
		altura(contador, max);
		return max[0];
	}

	private void altura(int contador, int[] max) {
		if (this.esHoja()) {
			if (contador > max[0])
				max[0] = contador;
		} else {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				ArbolGeneral<T> a = hijos.proximo();
				a.altura(contador + 1, max);
			}
		}
	}

	public boolean include(T dato) {
		if (this.getDatoRaiz() == dato) {
			return true;
		}
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			ArbolGeneral<T> a = hijos.proximo();
			if (a.include(dato)) {
				return true;
			}
		}
		return false;
	}

	public Integer nivel(T dato) {
		if (this.include(dato)) {
			Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
			cola.encolar(this);
			cola.encolar(null);
			ArbolGeneral<T> arb = new ArbolGeneral<T>();
			int nivel = 0;
			ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
			while (!cola.esVacia()) {
				arb = cola.desencolar();
				if (arb != null) {
					if (arb.getDatoRaiz() == dato) {
						return nivel;
					}
					hijos = arb.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				} else {
					if (!cola.esVacia()) {
						nivel++;
						cola.encolar(null);
					}
				}
			}
		}
		return -1;
	}

	public Integer ancho() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		ArbolGeneral<T> arb = new ArbolGeneral<T>();
		int anchura=0, anchomax=0;
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
		while (!cola.esVacia()) {
			arb = cola.desencolar();
			if (arb != null) {
				hijos = arb.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
				anchura++;
			} else {
				if (anchura>anchomax) {
					anchomax=anchura;
				}
				if (!cola.esVacia()) {
					anchura=0;
					cola.encolar(null);
				}
			}
		}
		return anchomax;
	}

}
