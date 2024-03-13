package prog3.listaenteros.test;

import prog3.listaenteros.ListaDeEnterosEnlazada;

public class TestOrdenamientos {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada l2= new ListaDeEnterosEnlazada();
		l.agregarInicio(17);
		l.agregarInicio(66);
		l.agregarInicio(33);
		l.agregarInicio(42);
		l.agregarInicio(22);
		System.out.println(l.toString());
		l2=l.ordenar();
		System.out.println(l2.toString());
		ListaDeEnterosEnlazada l3= new ListaDeEnterosEnlazada();
		l3.agregarInicio(77);
		l3.agregarInicio(45);
		l3.agregarInicio(40);
		l3.agregarInicio(12);
		System.out.println(l3.toString());
		l3=l2.combinarOrdenado(l3);
		System.out.println(l3.toString());
	}

}
