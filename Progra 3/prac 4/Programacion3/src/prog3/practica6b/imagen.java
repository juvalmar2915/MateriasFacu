package prog3.practica6b;

import prog3.listagenerica.*;
import prog3.arbol.general.*;;

public class imagen {
	private boolean imagen[][];

	public imagen(int pixeles) {
		this.imagen= new boolean[pixeles][pixeles];
	}
	
	public boolean igualColor() {
		int i,x;
		boolean primero=imagen[0][0];
		for (i=0;i<this.dimension();i++) {
			for (x=0;x<this.dimension();x++) {
				if(this.imagen[i][x]!=primero) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean color() {
		return(imagen[0][0]);
	}
	
	public int dimension() {
		return imagen[0].length;
	}
	
	
	
	public ListaGenerica<imagen> dividirEnSubimagenes(){
        ListaGenerica<imagen> l= new ListaGenericaEnlazada<imagen>();
        int d=dimension()/2;
        imagen aux;
        for (int a=0; a<2; a++) {
            for (int b=0; b<2; b++) {
                aux= new imagen(d);
                for (int i=0; i<d; i++) {
                    for (int j=0; j<d; j++) {
                        if (imagen[i+b][j+a]) {
                            aux.setImagen(i, j);
                        }
                    }
                }
                l.agregarFinal(aux);
            }
        }
        return l;
    }
	
	public ArbolGeneral<Boolean> imagenComprimida(){
        ArbolGeneral<Boolean> arbol;
        if (this.igualColor()) {
            arbol= new ArbolGeneral<Boolean>(this.color());
        }
        else {
            arbol= new ArbolGeneral<Boolean>();
            imagenComprimida(this, arbol);
        }
        return null;
    }

    private void imagenComprimida(imagen i, ArbolGeneral<Boolean> a) {
        ListaGenerica<imagen> l= i.dividirEnSubimagenes();
        l.comenzar();
        while (!l.fin()) {
            imagen aux=l.proximo();
            if (!aux.igualColor()) {
                ArbolGeneral<Boolean> arbAux= new ArbolGeneral<Boolean>();
                imagenComprimida(aux, arbAux);
                a.agregarHijo(arbAux);
            }
            else{
                a.agregarHijo(new ArbolGeneral<Boolean>(aux.color()));
            }
        }
    }

	public boolean getImagen(int pos1, int pos2) {
		return imagen[pos1][pos2];
	}

	public void setImagen(int pos1, int pos2) {
		this.imagen[pos1][pos2] = !imagen[pos1][pos2];
	}
	
}
