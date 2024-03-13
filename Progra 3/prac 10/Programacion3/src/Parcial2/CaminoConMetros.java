package Parcial2;

import prog3.listagenerica.ListaGenericaEnlazada;

public class CaminoConMetros {
	private ListaGenericaEnlazada<Local> Camino=new ListaGenericaEnlazada<Local>();
	private int CantMetros;
	
	public void Caminovacio() {
		Camino=null;
	}
	public void setCamino(ListaGenericaEnlazada<Local> l) {
		Camino.comenzar();
		while (!Camino.esVacia()) {
			Camino.eliminarEn(0);
		}
		l.comenzar();
		while (!l.fin()) {
			Camino.agregarFinal(l.proximo());
		}
	}
	public int getCantMetros() {
		return CantMetros;
	}
	public void setCantMetros(int cantMetros) {
		CantMetros = cantMetros;
	}
}
