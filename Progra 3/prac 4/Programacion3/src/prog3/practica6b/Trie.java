package prog3.practica6b;


import prog3.arbol.general.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Trie{
	
	private NodoGeneral<Character> raiz;
	
	public Trie() {
		this.raiz = new NodoGeneral<Character>(' ');
	}
	
	private NodoGeneral<Character> getRaiz() {
		return this.raiz;
	}
	
	public Character getDatoRaiz() {
		return this.raiz.getDato();
	}
	
	private Trie(NodoGeneral<Character> nodo) {
		this.raiz = nodo;
	}
	
	private Trie(char[] palabra, int pos) {
		this.raiz = new NodoGeneral<Character>(palabra[pos]);
		if (pos+1<palabra.length) {
			this.agregarHijo(new Trie(palabra, pos+1));
		}
	}
	
	public void agregarPalabra(String palabra) {
		agregarPalabra(this, palabra.toCharArray(), 0);
	}
	
	private void agregarPalabra(Trie t, char[] palabra, int pos) {
		if (pos<palabra.length) {
			boolean encontre=false;
			ListaGenerica<Trie> hijos = t.getHijos();
			hijos.comenzar();
			while (!hijos.fin() && !encontre) {
				Trie actual= hijos.proximo();
				if (actual.getDatoRaiz()==palabra[pos]) {
					encontre=true;
					agregarPalabra(actual, palabra, pos+1);
				}
			}
			if (!encontre) {
				t.agregarHijo(new Trie(palabra, pos));
			}
		}
	}
	
	public ListaGenericaEnlazada<String> palabrasQueEmpiezanCon(String prefijo){
		Trie t= palabrasQueEmpiezanCon(this, prefijo.toCharArray(), 0);
		ListaGenericaEnlazada<String> l= new ListaGenericaEnlazada<String>();
		if (t!=null) {
			preorden(t, l, prefijo);
			return l;
		}
		return null;
	}
	
	private void preorden(Trie t, ListaGenericaEnlazada<String> l, String prefijo) {
		ListaGenerica<Trie> hijos= t.getHijos();
		hijos.comenzar();
		if (!hijos.fin()) {
			while (!hijos.fin()) {
				Trie actual= hijos.proximo();
				preorden(actual, l, prefijo + actual.getDatoRaiz());
			}
		}
		else
			l.agregarFinal(prefijo);
	}
	
	private Trie palabrasQueEmpiezanCon(Trie t, char[] palabra, int pos){
		if (pos<palabra.length) {
			ListaGenerica<Trie> hijos = t.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				Trie actual= hijos.proximo();
				if (actual.getDatoRaiz()==palabra[pos])
					return palabrasQueEmpiezanCon(actual, palabra, pos+1);
			}
		}
		else
			return t;
	return null;
	}
	
	public ListaGenerica<Trie> getHijos() {
		ListaGenerica<Trie> lista = new ListaGenericaEnlazada<Trie>();
		ListaGenerica<NodoGeneral<Character>> hijos = (ListaGenerica<NodoGeneral<Character>>) this.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();
		while (!hijos.fin()) {
			lista.agregarFinal(new Trie(hijos.proximo()));
		}
		return lista;
	}
	
	public void agregarHijo(Trie unHijo) {
		NodoGeneral<Character> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}
	
}