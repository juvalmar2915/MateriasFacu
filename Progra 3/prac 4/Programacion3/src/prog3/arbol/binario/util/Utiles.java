package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;
import prog3.util.Cola;
import prog3.listagenerica.*;

public class Utiles {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		System.out.println(sumaMaximaVertical(arbolBinarioB));
		System.out.println(sumaMaximaHorizontal(arbolBinarioB));
		trayectoriaPesada(arbolBinarioB);
	}
	
	public static int sumaMaximaVertical(ArbolBinario<Integer> arbol){
        int suma=0;
        int arry[]=new int[1];
        recurVertic(arbol, suma, arry);
        return arry[0];
    }
	
    private static void recurVertic(ArbolBinario<Integer> arbol, int suma, int max[]) { //si se pasa por valor cuando vuelve tiene el valor de antes de la llamada
        if(!arbol.esVacio()) {
            suma+=arbol.getDatoRaiz();
            if (arbol.esHoja()) {
                if (max[0]<suma)
                    max[0]=suma;
            }
            else {
            	if (!arbol.getHijoIzquierdo().esVacio()) {
            		recurVertic(arbol.getHijoIzquierdo(), suma, max);
            	}
            	if (!arbol.getHijoDerecho().esVacio()) {
            		recurVertic(arbol.getHijoDerecho(), suma, max);
            	}
            }
        }
    }
    
    public static int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
        Cola<ArbolBinario<Integer>> cola= new Cola<ArbolBinario<Integer>>();
        cola.encolar(arbol);
        cola.encolar(null);
        ArbolBinario<Integer> arb= new ArbolBinario<Integer>();
        int suma=0, maximo=0 ;
        while (!cola.esVacia()) {
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
            	if (!cola.esVacia()) { // en el ultimo caso voy a tener que preguntar por la ultima suma
            		if (suma>maximo) {
            			maximo=suma;
            		}
            		suma=0;
            		cola.encolar(null);
            	}
            }
        }
        if (suma>maximo) {
			maximo=suma;
		}
        return maximo;
    }  
    
    public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> abinario){
        ListaGenericaEnlazada<Integer> resul= new ListaGenericaEnlazada<Integer>();
        recurTrayec(abinario, 0, resul, 0);
        System.out.println(resul.toString());
        return resul;
    }
    
   private static void recurTrayec(ArbolBinario<Integer> ab,int nivact,ListaGenericaEnlazada<Integer> l, int suma) {
    	if(!ab.esVacio()) {
    		suma+=ab.getDatoRaiz()*nivact;
            if (ab.esHoja()) {
                l.agregarFinal(suma);
            }
            if (!ab.getHijoIzquierdo().esVacio()) {
                recurTrayec(ab.getHijoIzquierdo(), nivact+1, l,suma);
            }
            if (!ab.getHijoDerecho().esVacio()) {
                recurTrayec(ab.getHijoDerecho(), nivact+1, l,suma);
            }
            
        }
    }
    
}
