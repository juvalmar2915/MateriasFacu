package Adicionales;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;

public class Empresas {
	public String [] mayorcantidaddeempresas5(Grafo<String> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0]=true;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(grafo.vertice(0)); 
        ady.comenzar();
        int[] cant = new int[1];
        int max[]=new int [5];
        String vmax[]=new String [5];
        while (!ady.fin()) {
            Vertice<String> v = ady.proximo().verticeDestino();
            dfs(grafo, v, cant, marca);
            if (cant[0]>max[0]) {
            	max[4]=max[3];
            	vmax[4]=vmax[3];
            	max[3]=max[2];
            	vmax[3]=vmax[2];
            	max[2]=max[1];
            	vmax[2]=vmax[1];
            	max[1]=max[0];
            	vmax[1]=vmax[0];
            	max[0]=cant[0];
            	vmax[0]=v.dato();
            }
            else {
            	if (cant[0]>max[1]) {
            		max[4]=max[3];
                	vmax[4]=vmax[3];
                	max[3]=max[2];
                	vmax[3]=vmax[2];
                	max[2]=max[1];
                	vmax[2]=vmax[1];
                	max[1]=cant[0];
                	vmax[1]=v.dato();
            	}
            	else {
            		if (cant[0]>max[2]){
            			max[4]=max[3];
                    	vmax[4]=vmax[3];
                    	max[3]=max[2];
                    	vmax[3]=vmax[2];
            			max[2]=cant[0];
                    	vmax[2]=v.dato();
            		}
            		else {
            			if (cant[0]>max[3]){
            				max[4]=max[3];
                        	vmax[4]=vmax[3];
            				max[3]=cant[0];
                        	vmax[3]=v.dato();
            			}
            			else {
                			max[4]=cant[0];
                            vmax[4]=v.dato();
            			}
            		}
            	}
            }
            cant[0]=0;
        }
        return vmax; 
    }
	
	private void dfs(Grafo<String> grafo,Vertice<String> v,int [] cant,boolean[] marca){
		marca[v.posicion()] = true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			Vertice<String> cact=ady.proximo().verticeDestino(); //cuando vuelve de la recursion esta en el valor de esa recursion
			if(!marca[cact.posicion()]){
				cant[0]++;
				this.dfs(grafo,cact, cant, marca);
			}
		}
		marca[v.posicion()] = false; //de esta manera se desamarcan todos no solamente los hijos que eso pasaria de ser cact
	}
}
