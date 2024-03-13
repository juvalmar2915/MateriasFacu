package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Cola<T> {

	ListaGenericaEnlazada<T> d=new ListaGenericaEnlazada<T>();

	public Cola() {
		
	}

	public void encolar(T elem) {
		d.agregarEn(elem,0);
	}

	public T desencolar() {
		T aux= d.elemento(d.tamanio()-1); //comienza en la pos 0
		d.eliminarEn(d.tamanio()-1);
		return aux;
	}

	public T tope() {
		return d.elemento(0);
	}

	public boolean esVacia() {
		return d.tamanio()==0;
	}
}
