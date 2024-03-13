package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
public class Delta {
	public int maxIslasDistintas(Grafo<String> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0]=true;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(grafo.vertice(0)); //isla principal
        ady.comenzar();
        int[] cant = new int[1];
        int max=0;
        while (!ady.fin()) {
            Vertice<String> v = ady.proximo().verticeDestino();
            maxIslasDistintas(grafo, v, cant, marca);
            max = max < cant[0] ? cant[0] : max;
            cant[0]=0;
        }
        return ++max; //tomo en cuenta la isla principal
    }
	
	private void maxIslasDistintas(Grafo<String> grafo,Vertice<String> v,int [] cant,boolean[] marca){
		marca[v.posicion()] = true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			Vertice<String> cact=ady.proximo().verticeDestino(); //cuando vuelve de la recursion esta en el valor de esa recursion
			if(!marca[cact.posicion()]){
				cant[0]++;
				this.maxIslasDistintas(grafo,cact, cant, marca);
			}
		}
		marca[v.posicion()] = false; //de esta manera se desamarcan todos no solamente los hijos que eso pasaria de ser cact
	}
	
	public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		RutaMinima r=new RutaMinima();
		boolean encontre=false;
		int i=0;
        while (i<=grafo.listaDeVertices().tamanio() && !encontre){
            if (grafo.vertice(i).dato().compareTo(islaO)==0)
                encontre=true;
            i++;
        }
        int min[]=new int[1];
        min[0]=Integer.MAX_VALUE;
        if (encontre)
        	this.dfs(grafo.vertice(i-1),grafo, marca,new ListaGenericaEnlazada<String>(),islaD,r,min,0);
		r.setNounicoboleto(grafo.vertice(0).dato());
        return r;
	}
	private void dfs(Vertice<String> v, Grafo<String> grafo,boolean[] marca, ListaGenerica<String> camino,String islaD, RutaMinima r,int min[], int act){
		if(v.dato().equals(islaD)) { // Esto se hace para recorrer todos los caminos posibles ya que si pusieramos el break adentro del while !ady.fin terminaria ese while y nos quedarian caminos por recorrer
			if(act<min[0]) {
				min[0]=act;
				r.setCaminomascorto((ListaGenericaEnlazada<String>)camino);
			}
		}
		else {
		marca[v.posicion()] = true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			Arista<String> A=ady.proximo();
			Vertice<String> cact=A.verticeDestino(); //cuando vuelve de la recursion esta en el valor de esa recursion
			if(!marca[cact.posicion()]){
				camino.agregarFinal(cact.dato());
				this.dfs(cact,grafo, marca, camino,islaD,r,min,act+A.peso());	
				camino.eliminarEn(camino.tamanio()-1);
			}
		}
		marca[v.posicion()] = false; //de esta manera se desamarcan todos no solamente los hijos que eso pasaria de ser cact
		}
	}
}
