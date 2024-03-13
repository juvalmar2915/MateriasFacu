package parcial;

import prog3.arbol.general.*;
public class prueba {

	public static void main(String[] args) {
		ArbolGeneral<Boolean> e= new ArbolGeneral<Boolean>(false);
        ArbolGeneral<Boolean> e2= new ArbolGeneral<Boolean>(true);
        ArbolGeneral<Boolean> e3= new ArbolGeneral<Boolean>(true);
        e3.agregarHijo(new ArbolGeneral<Boolean>(true));
        e3.agregarHijo(new ArbolGeneral<Boolean>(true));
        e2.agregarHijo(e3);
        e.agregarHijo(new ArbolGeneral<Boolean>(true));
        e.agregarHijo(e2);
        System.out.println(Parcial.resolver(e).toString());
	}

}
