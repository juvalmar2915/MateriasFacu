package prog3.practica6b;

import prog3.arbol.general.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.*;

public class Empresa {
	private ArbolGeneral<Empleado> Empleados = new ArbolGeneral<Empleado>();

	public int empleadosPorCategoria(int categoria) {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(Empleados);
		cola.encolar(null);
		ArbolGeneral<Empleado> arb = new ArbolGeneral<Empleado>();
		int anchocat = 0, nivel=1;
		ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		while (!cola.esVacia() && nivel!=categoria) {
			arb = cola.desencolar();
			if (arb != null) {
				hijos = arb.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
			}
		}
		while (!cola.esVacia()) {
            arb=cola.desencolar();
            if (arb!=null)
                anchocat++;
        }
		return anchocat;
	}
	
	public int categoriaConMasEmpleados() {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(Empleados);
		cola.encolar(null);
		ArbolGeneral<Empleado> arb = new ArbolGeneral<Empleado>();
		int categoriaMax=0,categoria=0,ancho=0, anchomax=0;
		ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		while (!cola.esVacia()) {
			arb = cola.desencolar();
			if (arb != null) {
				hijos = arb.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
				ancho++;
			} else {
				categoria++;
				if (ancho>anchomax) {
					anchomax=ancho;
					categoriaMax=categoria;
				}
				if (!cola.esVacia()) {
					ancho=0;
					cola.encolar(null);
				}
			}
		}
		return categoriaMax;
	}
	
	public int  cantidadTotalDeEmpleados() {
		Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
		cola.encolar(Empleados);
		cola.encolar(null);
		ArbolGeneral<Empleado> arb = new ArbolGeneral<Empleado>();
		int cant=0;
		ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		while (!cola.esVacia()) {
			arb = cola.desencolar();
			if (arb != null) {
				hijos = arb.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
				cant++;
			} else {
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return cant;
	}
	
	public void reemplazarPresidente(){
		Empleados=reemplazarRec(Empleados);
    }

    private ArbolGeneral<Empleado> reemplazarRec(ArbolGeneral<Empleado> empleados) {
        if (!empleados.esHoja()) {
            ListaGenerica<ArbolGeneral<Empleado>> hijos;
            hijos=empleados.getHijos();
            int i=0, j=0, antiguedadMax=0;
            Empleado aux;
            hijos.comenzar();
            while (i<hijos.tamanio()) {
                aux=hijos.proximo().getDatoRaiz();
                if (aux.getAntiguedad()>antiguedadMax) {
                    antiguedadMax=aux.getAntiguedad();
                    j=i;
                }
                i++;
            }
            aux=hijos.elemento(j).getDatoRaiz();
            hijos.agregarEn(reemplazarRec(hijos.elemento(j)), j);
            hijos.eliminarEn(j+1);
            if (hijos.elemento(j)==null)
                hijos.eliminarEn(j);
            ArbolGeneral<Empleado> a= new ArbolGeneral<Empleado>(aux, hijos);
            return a;
        }
        return null;
    }
	
}
