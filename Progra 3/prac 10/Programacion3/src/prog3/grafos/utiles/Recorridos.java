package prog3.grafos.utiles;
import prog3.listagenerica.*;
import prog3.grafos.*;
import prog3.util.*;

public class Recorridos<T> {
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){ // Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<T>> vertices=new ListaGenericaEnlazada<Vertice<T>>();
		for (int i=1; i<=grafo.listaDeVertices().tamanio();i++){
			if (!marca[i])
				this.dfs(i, grafo, marca,vertices); 
		}
		return vertices;
	} //es de orden (V+E)
	
	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> vertices){
		 marca[i] = true;
		 Vertice<T> v = grafo.listaDeVertices().elemento(i);
		 vertices.agregarFinal(v);
		 ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		 ady.comenzar();
		 while(!ady.fin()){
			 int j = ady.proximo().verticeDestino().posicion();
			 if(!marca[j]){
				 this.dfs(j, grafo, marca,vertices);
			 }
		 }
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){ // Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<T>> vertices=new ListaGenericaEnlazada<Vertice<T>>();
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, marca,vertices); //las listas empiezan en la pos 1
		}
		return vertices;
	} //es de orden (V+E), E variando de 1 hasta V^2
	
	private void bfs (int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> vertices) {
        ListaGenerica<Arista<T>> ady = null;
        ColaGenerica<Vertice<T>> q= new ColaGenerica<Vertice<T>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca[i]=true;
        while (!q.esVacia()) {
            Vertice<T> v= q.desencolar();
            vertices.agregarFinal(v);
            ady= grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<T> arista= ady.proximo();
                int j=arista.verticeDestino().posicion();
                if (!marca[j]) {
                    Vertice<T> w= arista.verticeDestino();
                    marca[j]=true;
                    q.encolar(w);
                }
            }
        }
    }
}
