package prog3.util;

import prog3.listaenteros.ListaDeEnterosConArreglos;

public class UtilitariosLista {

	public static void main(String[] args) {
		ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();
		l.agregarInicio(2);
		l.agregarInicio(25);
		l.agregarInicio(45);
		l.agregarInicio(60);
		l.agregarInicio(88);
		l.agregarInicio(7);
		l.agregarInicio(1);
		System.out.println(l.toString());
		mergeSort(l, 0, l.tamanio()-1);
		System.out.println(l.toString());
	}
	
	public static void mergeSort(ListaDeEnterosConArreglos li, int izq, int der){
        if (izq < der) { 
            int cent = (izq + der) / 2;
            mergeSort(li, izq, cent);
            mergeSort(li, cent + 1, der);
            merge(li, izq, cent, der); 
        }
    }

    public static void merge(ListaDeEnterosConArreglos l, int izq, int c, int der) { // revisar 
        int i, j, k; int[] 
        aux = new int[l.tamanio()]; 
        for (i =izq; i <= der; i++) { // copia ambas mitades en el array auxiliar 
            aux[i] = l.elemento(i); 
        } 
        i = izq; j = c + 1; k = izq; 
        while (i <= c && j <= der) { //copia el siguiente elemento más grande 
            if (aux[i] <= aux[j]) {
                l.eliminarEn(k); 
                l.agregarEn(aux[i++], k++); // a[k++]=b[i++];
            } 
            else {
                l.eliminarEn(k);
                l.agregarEn(aux[j++], k++); // a[k++]=b[j++];
            }
        }
        while (i <= c) { // copia los elementos que quedan de la 
            l.eliminarEn(k);
            l.agregarEn(aux[i++], k++); // primera mitad (si los hay)
        }
    }

	/*public static void mergeSort(ListaDeEnterosConArreglos li, int izq, int der) {
		if (der - izq > 1) {
			int cent = (izq + der) / 2;
			mergeSort(li, izq, cent);
			mergeSort(li, cent, der);
			merge(li, izq, der);
		}
	}

	public static void merge(ListaDeEnterosConArreglos l, int izq, int der) {
		int i, j, k = izq;
		int[] aux = new int[der - izq];
		for (i = 0; i < (der - izq); i++) { // copia ambas mitades en el arraya uxiliar
			aux[i] = l.elemento(k++);
		}
		i = 0;
		j = (der - izq) / 2;
		k = izq;
		while ((i < (der - izq) / 2) && (j < der - izq)) { // copia el siguiente elemento más grande
			if (aux[i] <= aux[j]) {
				l.eliminarEn(k);
				l.agregarEn(aux[i++], k++); // a[k++]=b[i++];
			} else {
				l.eliminarEn(k);
				l.agregarEn(aux[j++], k++); // a[k++]=b[j++];
			}
		}

		while (i < (der - izq) / 2) { // copia los elementos que quedan de la
			l.eliminarEn(k);
			l.agregarEn(aux[i++], k++); // primera mitad (si los hay)
		}

		while (j < der - izq) { // copia los elementos que quedan de la
			l.eliminarEn(k);
			l.agregarEn(aux[j++], k++); // primera mitad (si los hay)
		}
	}*/
}
