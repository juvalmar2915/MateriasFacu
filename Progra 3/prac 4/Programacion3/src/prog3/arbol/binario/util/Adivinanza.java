package prog3.arbol.binario.util;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.arbol.binario.ArbolBinario;

public class Adivinanza {

	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario){
        ListaGenericaEnlazada<String> maximo= new ListaGenericaEnlazada<String>();
        int arry[]= new int[1];
        recurSec(abinario, new ListaGenericaEnlazada<String>(), maximo, 0, arry);
        return maximo;
    }

    private void recurSec(ArbolBinario<String> arbol, ListaGenericaEnlazada<String> lAct, ListaGenericaEnlazada<String> lMax, int nivAct, int nivMax[]) {
        if(!arbol.esVacio()) {
            lAct.agregarFinal(arbol.getDatoRaiz()); // agrego la pregunta a la lista
            if (arbol.esHoja() && nivMax[0]<nivAct) {
                for (int i=0; i<lMax.tamanio(); i++){
                    lMax.eliminarEn(0);
                }
                lAct.comenzar();
                for (int i=0; i<lAct.tamanio(); i++){
                    lMax.agregarFinal(lAct.proximo());
                }
                nivMax[0]=nivAct;
            }
            else {
                if (arbol.getHijoIzquierdo()!=null) {
                    lAct.agregarFinal("SI");
                    recurSec(arbol.getHijoIzquierdo(), lAct, lMax, nivAct+1, nivMax);
                    lAct.eliminarEn(lAct.tamanio()-1); //elimina el valor del hijo izquierdo (en la lista auxiliar)
                    lAct.eliminarEn(lAct.tamanio()-1); //elimino el valor de si (en la lista auxiliar)
                }
                if (arbol.getHijoDerecho()!=null) {
                    lAct.agregarFinal("NO");
                    recurSec(arbol.getHijoDerecho(), lAct, lMax, nivAct+1, nivMax);
                    lAct.eliminarEn(lAct.tamanio()-1); //elimina el valor del hijo derecho (en la lista auxiliar)
                    lAct.eliminarEn(lAct.tamanio()-1); //elimino el valor de no (en la lista auxiliar)
                }
            }
        }
    }
    
    public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario){
        ListaGenericaEnlazada<ListaGenericaEnlazada<String>> maximo= new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
        int arry[]= new int[1];
        recurSec2(abinario, new ListaGenericaEnlazada<String>(), maximo, 0, arry);
        return maximo;
    }

    private void recurSec2(ArbolBinario<String> arbol, ListaGenericaEnlazada<String> lAct, ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lMax, int nivAct, int nivMax[]) {
        if(!arbol.esVacio()) {
            lAct.agregarFinal(arbol.getDatoRaiz());
            if (arbol.esHoja() && nivMax[0]<=nivAct) {
                if (nivMax[0]<nivAct)
                    while(lMax.tamanio()>0)
                        lMax.eliminarEn(0);
                lMax.agregarFinal(new ListaGenericaEnlazada<String>());
                lAct.comenzar();
                for (int i=0; i<lAct.tamanio(); i++){
                    lMax.elemento(lMax.tamanio()-1).agregarFinal(lAct.proximo());
                }
                nivMax[0]=nivAct;
            }
            else {
                if (arbol.getHijoIzquierdo()!=null) {
                    lAct.agregarFinal("SI");
                    recurSec2(arbol.getHijoIzquierdo(), lAct, lMax, nivAct+1, nivMax);
                    lAct.eliminarEn(lAct.tamanio()-1);
                    lAct.eliminarEn(lAct.tamanio()-1);
                }
                if (arbol.getHijoDerecho()!=null) {
                    lAct.agregarFinal("NO");
                    recurSec2(arbol.getHijoDerecho(), lAct, lMax, nivAct+1, nivMax);
                    lAct.eliminarEn(lAct.tamanio()-1);
                    lAct.eliminarEn(lAct.tamanio()-1);
                }
            }
        }
    }
}
