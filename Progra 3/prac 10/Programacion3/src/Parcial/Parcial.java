package Parcial;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class Parcial {
	public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles){
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
		boolean encontre=false;
		int i=0;
        while (i<=ciudades.listaDeVertices().tamanio() && !encontre){
            if (ciudades.vertice(i).dato().getCiudad().compareTo(origen)==0)
                encontre=true;
            i++;
        }
        int x=0;
        boolean encontre2=false;
        while (x<=ciudades.listaDeVertices().tamanio() && !encontre2){
            if (ciudades.vertice(x).dato().getCiudad().compareTo(destino)==0)
                encontre2=true;
            x++;
        }
        int max[]=new int[1];
        max[0]=0;
        if (encontre && encontre2) {
        	this.dfs(ciudades.vertice(i-1), ciudades, marca, destino, max, 0,maxControles);
        	return max[0];
		}
        else {
        	return max[0];
        }
	}
	
	private void dfs(Vertice<Ciudad> v, Grafo<Ciudad> grafo,boolean[] marca,String destino,int max[], int act,int maxControles){
		if(v.dato().getCiudad().equals(destino)) { 
			if(act>max[0]) {
				max[0]=act;
			}
		}
		else {
		marca[v.posicion()] = true;
		ListaGenerica<Arista<Ciudad>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			Arista<Ciudad> A=ady.proximo();
			if (A.peso()<=maxControles) {
				Vertice<Ciudad> cact=A.verticeDestino(); 
				if(!marca[cact.posicion()]){
					this.dfs(cact,grafo, marca,destino,max,act+v.dato().getTiempo(),maxControles);
				}
			}
		}
		marca[v.posicion()] = false;
		}
	}
}
