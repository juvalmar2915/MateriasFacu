package Parcial2;

import prog3.arbol.general.ArbolGeneral;

public class prueba {
	public static void main(String[] args) {
		ArbolGeneral<Integer> e= new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> e2= new ArbolGeneral<Integer>(1);
        ArbolGeneral<Integer> e3= new ArbolGeneral<Integer>(25);
        ArbolGeneral<Integer> e4= new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> e5= new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> e6= new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> e7= new ArbolGeneral<Integer>(1);
        e7.agregarHijo(new ArbolGeneral<Integer>(33));
        e7.agregarHijo(new ArbolGeneral<Integer>(20));
        e7.agregarHijo(new ArbolGeneral<Integer>(27));
        e7.agregarHijo(new ArbolGeneral<Integer>(90));
        e6.agregarHijo(new ArbolGeneral<Integer>(80));
        e5.agregarHijo(new ArbolGeneral<Integer>(3));
        e5.agregarHijo(new ArbolGeneral<Integer>(60));
        e5.agregarHijo(e7);
        e4.agregarHijo(e6);
        e4.agregarHijo(new ArbolGeneral<Integer>(1));
        e3.agregarHijo(new ArbolGeneral<Integer>(17));
        e2.agregarHijo(e4);
        e2.agregarHijo(e5);
        e.agregarHijo(e2);
        e.agregarHijo(new ArbolGeneral<Integer>(8));
        e.agregarHijo(e3);
        System.out.println(Parcial.resolver(e,15).toString());
	}
}
