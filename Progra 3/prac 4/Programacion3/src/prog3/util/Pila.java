package prog3.util;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Pila<T>{
	ListaGenericaEnlazada<T> datos=new ListaGenericaEnlazada<T>();

	public Pila() {
		
	}

	public void apilar(T elem) {
		datos.agregarEn(elem, 0);
	}

	public T desapilar() {
		T aux= datos.elemento(0);
		datos.eliminarEn(0);
		return aux;
	}

	public T tope() {
		return datos.elemento(0);
	}

	public boolean esVacia() {
		return datos.tamanio()==0;
	}

}
