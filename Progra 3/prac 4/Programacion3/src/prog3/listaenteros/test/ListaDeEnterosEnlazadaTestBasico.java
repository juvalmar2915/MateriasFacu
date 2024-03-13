package prog3.listaenteros.test;
import prog3.listaenteros.ListaDeEnterosEnlazada;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l= new ListaDeEnterosEnlazada();
		l.agregarInicio(5);
		l.agregarInicio(3);
		l.agregarInicio(2);
		System.out.println(l.toString());
		l.comenzar();
		inverso(l);
	}
	public static void inverso(ListaDeEnterosEnlazada list) {
		if (!list.fin()) {
            int elem=list.proximo();
            inverso(list);
            System.out.println(elem);
		}
	}
}
