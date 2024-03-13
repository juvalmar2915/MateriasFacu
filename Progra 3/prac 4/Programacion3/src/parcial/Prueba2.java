package parcial;

import prog3.arbol.general.ArbolGeneral;

public class Prueba2 {
	public static void main(String[] args)
	{
		ArbolGeneral<Integer> raiz = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> raizHijo1 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> raizHijo2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> raizHijo3 = new ArbolGeneral<Integer>(9);
		raiz.agregarHijo(raizHijo1);
		raiz.agregarHijo(raizHijo2);
		raiz.agregarHijo(raizHijo3);
		ArbolGeneral<Integer> hijo1Hijo1 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> hijo1Hijo2 = new ArbolGeneral<Integer>(6);
		raizHijo1.agregarHijo(hijo1Hijo1);
		raizHijo1.agregarHijo(hijo1Hijo2);
		ArbolGeneral<Integer> hijo1Hijo1Hijo1 = new ArbolGeneral<Integer>(4);
		hijo1Hijo1.agregarHijo(hijo1Hijo1Hijo1);
		ArbolGeneral<Integer> hijo1Hijo1Hijo1Hijo1 = new ArbolGeneral<Integer>(80);
		hijo1Hijo1Hijo1.agregarHijo(hijo1Hijo1Hijo1Hijo1);
		ArbolGeneral<Integer> hijo1Hijo2Hijo1 = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> hijo1Hijo2Hijo2 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> hijo1Hijo2Hijo3 = new ArbolGeneral<Integer>(77);
		hijo1Hijo2.agregarHijo(hijo1Hijo2Hijo1);
		hijo1Hijo2.agregarHijo(hijo1Hijo2Hijo2);
		hijo1Hijo2.agregarHijo(hijo1Hijo2Hijo3);
		ArbolGeneral<Integer> hijo1Hijo2Hijo3Hijo1 = new ArbolGeneral<Integer>(22);
		ArbolGeneral<Integer> hijo1Hijo2Hijo3Hijo2 = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> hijo1Hijo2Hijo3Hijo3 = new ArbolGeneral<Integer>(27);
		ArbolGeneral<Integer> hijo1Hijo2Hijo3Hijo4 = new ArbolGeneral<Integer>(3);
		hijo1Hijo2Hijo3.agregarHijo(hijo1Hijo2Hijo3Hijo1);
		hijo1Hijo2Hijo3.agregarHijo(hijo1Hijo2Hijo3Hijo2);
		hijo1Hijo2Hijo3.agregarHijo(hijo1Hijo2Hijo3Hijo3);
		hijo1Hijo2Hijo3.agregarHijo(hijo1Hijo2Hijo3Hijo4);
		ArbolGeneral<Integer> hijo3Hijo1 = new ArbolGeneral<Integer>(6);
		raizHijo3.agregarHijo(hijo3Hijo1);
		if(Parcial2.resolver(raiz))
		{
			System.out.println("Se repite");
		}
		else
		{
			System.out.println("No se repite");
		}
	}
}
