package Parcial;
import prog3.listagenerica.*;
import prog3.grafos.*;
public class ParcialCarlos {
	ListaGenerica<String> resolver(Grafo<CiudadCarlos> ciudades,String Origen, String Destino){
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
		boolean encontre=false;
		int i=0;
        while (i<ciudades.listaDeVertices().tamanio() && !encontre){
            if (ciudades.vertice(i).dato().getNombre().compareTo(Origen)==0)
                encontre=true;
            i++;
        }
        int x=0;
        boolean encontre2=false;
        while (x<ciudades.listaDeVertices().tamanio() && !encontre2){
            if (ciudades.vertice(x).dato().getNombre().compareTo(Destino)==0)
                encontre2=true;
            x++;
        }
        ListaGenericaEnlazada<String> Ciudadesposibles=new ListaGenericaEnlazada<String>();
        if (encontre && encontre2) {
        	boolean v[]=new boolean [1];
        	this.dfs(ciudades.vertice(i-1),ciudades, marca,Ciudadesposibles,new ListaGenericaEnlazada<String>(),Destino,v);
        }
        else {
        	Ciudadesposibles=null;
        }
        return Ciudadesposibles;
	}
	
	private void dfs(Vertice<CiudadCarlos> v, Grafo<CiudadCarlos> grafo,boolean[] marca, ListaGenerica<String> caminos,ListaGenericaEnlazada<String> lact,String Destino,boolean verdad[]){
		if(!v.dato().getNombre().equals(Destino)) {
			marca[v.posicion()] = true;
			lact.agregarFinal(v.dato().getNombre());
			ListaGenerica<Arista<CiudadCarlos>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()){
				Arista<CiudadCarlos> A=ady.proximo();
				if (A.peso()!=0) {
					Vertice<CiudadCarlos> cact=A.verticeDestino(); 
					if(!marca[cact.posicion()] && cact.dato().getFase()!=1){
							this.dfs(cact,grafo, marca, caminos,lact,Destino,verdad);
					}
				}
			}
			lact.eliminarEn(lact.tamanio()-1);
			marca[v.posicion()] = false;
		}
		else {
			lact.comenzar();
			while (!lact.fin()) {
				String aux=lact.proximo();
				if (!caminos.incluye(aux))
					caminos.agregarFinal(aux);
			}
			if (verdad[0]==false) {
				verdad[0]=true;
				caminos.agregarFinal(Destino);
			}
		}
	}
}
