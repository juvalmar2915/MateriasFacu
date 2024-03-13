package prog3.adicionales;

import prog3.arbol.binario.*;

public class RedBinariaCompleta {
	public int mayorRetardo(ArbolBinario<Integer> redbancaria) {
		int max[]=new int [1];
		recuRetardo(redbancaria,0,max);
		return max[0];
	}
	private void recuRetardo(ArbolBinario<Integer> rb,int suma,int [] max) {
		if (!rb.esVacio()) {
			suma+=rb.getDatoRaiz();
			if (rb.esHoja()) {
				if(suma>max[0]) {
					max[0]=suma;
				}
			}
			else {
				if (!rb.getHijoIzquierdo().esVacio()) {
					recuRetardo(rb.getHijoIzquierdo(),suma,max);
				}
				if (!rb.getHijoDerecho().esVacio()) {
					recuRetardo(rb.getHijoDerecho(),suma,max);
				}
			}
		}
	}
}
