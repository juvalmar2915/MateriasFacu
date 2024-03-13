package Parcial;
import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial2 {
	public ListaGenericaEnlazada<CiudadCarlos> resolver(Grafo<CiudadCarlos> ciudades, String origen, String destino, int  minFase){
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
		boolean encontre=false;
		int i=0;
        while (i<ciudades.listaDeVertices().tamanio() && !encontre){
            if (ciudades.vertice(i).dato().getNombre().compareTo(origen)==0)
                encontre=true;
            i++;
        }
        int x=0;
        boolean encontre2=false;
        while (x<ciudades.listaDeVertices().tamanio() && !encontre2){
            if (ciudades.vertice(x).dato().getNombre().compareTo(destino)==0)
                encontre2=true;
            x++;
        }
        ListaGenericaEnlazada<CiudadCarlos> l=new ListaGenericaEnlazada<CiudadCarlos>();
        if (encontre && encontre2) {
        	this.dfs(ciudades.vertice(i-1), ciudades, marca, destino, l, new ListaGenericaEnlazada<CiudadCarlos>(),minFase);
		}
        return l;
	}
	
	private void dfs(Vertice<CiudadCarlos> v, Grafo<CiudadCarlos> grafo,boolean[] marca,String destino,ListaGenericaEnlazada<CiudadCarlos> l,ListaGenericaEnlazada<CiudadCarlos> lact,int minfase){
		lact.agregarFinal(v.dato());
		if(v.dato().getNombre().equals(destino)) { 
			l.comenzar();
			while (!l.fin()) {
				l.eliminarEn(0);
			}
			lact.comenzar();
			while (!lact.fin()) {
				l.agregarFinal(lact.proximo());
			}
		}
		else {
			marca[v.posicion()] = true;
			ListaGenerica<Arista<CiudadCarlos>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()){
				Arista<CiudadCarlos> A=ady.proximo();
				if (A.peso()!=0) {
					Vertice<CiudadCarlos> cact=A.verticeDestino(); 
					if(!marca[cact.posicion()] && cact.dato().getFase()>=minfase){
						this.dfs(cact,grafo, marca,destino,l,lact,minfase);
					}
				}
			}
			marca[v.posicion()] = false;
		}
		lact.eliminarEn(lact.tamanio()-1);
	}
}
