package Parcial;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial3 {
	public int [] resolver(Grafo<CiudadCarlos> ciudades, String origen, String destino){
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
        int [] fases= new int[5];
        if (encontre && encontre2) {
        	this.dfs(ciudades.vertice(i-1), ciudades, marca, destino, fases,new ListaGenericaEnlazada<CiudadCarlos>(), new ListaGenericaEnlazada<CiudadCarlos>());
		}
        return fases;
	}
	
	private void dfs(Vertice<CiudadCarlos> v, Grafo<CiudadCarlos> grafo,boolean[] marca,String destino,int fases[],ListaGenericaEnlazada<CiudadCarlos> lact, ListaGenericaEnlazada<CiudadCarlos> l){
		lact.agregarFinal(v.dato());
		if(v.dato().getNombre().equals(destino)) {
			lact.comenzar();
			CiudadCarlos aux=new CiudadCarlos();
			while (!lact.fin()) {
				aux=lact.proximo();
				if (!l.incluye(aux)) {
					l.agregarFinal(aux);
					fases[aux.getFase()]++;
				}
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
					if(!marca[cact.posicion()]){
						this.dfs(cact,grafo, marca,destino,fases,lact,l);
					}
				}
			}
			marca[v.posicion()] = false;
		}
		lact.eliminarEn(lact.tamanio()-1);
	}
}
