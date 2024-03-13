package Parcial2;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial {
	public CaminoConMetros resolver(Grafo<Local> locales, String origen, String destino){
		boolean[] marca = new boolean[locales.listaDeVertices().tamanio()];
		boolean encontre=false;
		int i=0;
        while (i<locales.listaDeVertices().tamanio() && !encontre){
            if (locales.vertice(i).dato().getTipo().compareTo(origen)==0)
                encontre=true;
            i++;
        }
        int x=0;
        boolean encontre2=false;
        while (x<locales.listaDeVertices().tamanio() && !encontre2){
            if (locales.vertice(x).dato().getTipo().compareTo(destino)==0)
                encontre2=true;
            x++;
        }
        CaminoConMetros c=new CaminoConMetros();
        if (encontre && encontre2) {
        	ListaGenericaEnlazada<Local> l=new ListaGenericaEnlazada<Local>();
        	int max[]=new int[1];
            int metrosmax[]=new int[1];
        	this.dfs(locales.vertice(i-1), locales, marca, destino, max, 0,l,new ListaGenericaEnlazada<Local>(),metrosmax,0);
        	c.setCamino(l);
        	c.setCantMetros(metrosmax[0]);
        	return c;
		}
        else {
        	c.Caminovacio();
        	c.setCantMetros(0);
        	return c;
        }
	}
	
	private void dfs(Vertice<Local> v, Grafo<Local> grafo,boolean[] marca,String destino,int max[], int act,ListaGenericaEnlazada<Local> l, ListaGenericaEnlazada<Local> lact,int []metrosmax,int metrosact){
		lact.agregarFinal(v.dato());
		if(v.dato().getTipo().equals(destino)) { 
			if(act>max[0]) {
				max[0]=act;
				metrosmax[0]=metrosact;
				l.comenzar();
				while (!l.esVacia()) {
					l.eliminarEn(0);
				}
				lact.comenzar();
				while (!lact.fin()) {
					l.agregarFinal(lact.proximo());
				}
			}
			else {
				if (act==max[0] && metrosact>metrosmax[0]) {
					metrosmax[0]=metrosact;
					l.comenzar();
					while (!l.fin()) {
						l.eliminarEn(0);
					}
					lact.comenzar();
					while (!lact.fin()) {
						l.agregarFinal(lact.proximo());
					}
				}
			}
		}
		else {
			marca[v.posicion()] = true;
			ListaGenerica<Arista<Local>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()){
				Arista<Local> A=ady.proximo();
				Vertice<Local> cact=A.verticeDestino(); 
				if(!marca[cact.posicion()]){
					this.dfs(cact,grafo, marca,destino,max,act+1,l,lact,metrosmax,metrosact+A.peso());	
				}
			}
			marca[v.posicion()] = false;
		}
		lact.eliminarEn(lact.tamanio()-1);
	}
}
