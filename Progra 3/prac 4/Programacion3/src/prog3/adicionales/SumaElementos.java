package prog3.adicionales;

import prog3.arbol.binario.*;
import prog3.util.Cola;

public class SumaElementos {
	public int sumaelementosn(ArbolBinario<Integer> arbol,int n) {
		Cola<ArbolBinario<Integer>> cola= new Cola<ArbolBinario<Integer>>();
        cola.encolar(arbol);
        cola.encolar(null);
        ArbolBinario<Integer> arb= new ArbolBinario<Integer>();
        int suma=0,profundidad=0;
        while ((!cola.esVacia()) && (profundidad<=n)) {
            arb=cola.desencolar();
            if (arb!=null){
            	suma+=arb.getDatoRaiz();
                if (!arb.getHijoIzquierdo().esVacio()) {
                    cola.encolar(arb.getHijoIzquierdo());
                }
                if (!arb.getHijoDerecho().esVacio()) {
                    cola.encolar(arb.getHijoDerecho());
                }
            }
            else {
            	profundidad++;
            	if (!cola.esVacia()) {
            		cola.encolar(null);
            	}
            }
        }
        return suma;
	}
}
