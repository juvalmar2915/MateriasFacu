package prog3.practica6b;

import prog3.arbol.general.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class RedDeAguaPotable {
	
	public float devolvermin(ArbolGeneral<Float> config,float n) {
		float [] min=new float[1];
		min[0]=n;
		recumin(config,n,min);
		return min[0];
	}
	
	private void recumin(ArbolGeneral<Float> c,float l, float [] min) {
		if (!c.esHoja()) {
			ListaGenerica<ArbolGeneral<Float>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Float>>();
			hijos=c.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				l=l/hijos.tamanio();
				recumin(hijos.proximo(),l,min);
			}
		}
		else {
			if (l<min[0]) {
				min[0]=l;
			}
		}
	}
	
}
