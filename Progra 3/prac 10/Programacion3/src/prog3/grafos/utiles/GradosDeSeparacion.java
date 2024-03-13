package prog3.grafos.utiles;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.ColaGenerica;

public class GradosDeSeparacion {
	public int maximoGradoDeSeparacion(Grafo<String> grafo){ // Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		int separacion[]=new int[1],separacionmax=0;
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i]) {
				separacion[0]=0;
				this.bfs(i, grafo,separacion); //las listas empiezan en la pos 1
				if (separacion[0]>separacionmax) {
					separacionmax=separacion[0];
				}
			}
		}
		return separacionmax;
	} //es de orden (V+E), E variando de 1 hasta V^2
	
	private void bfs (int i, Grafo<String> grafo,int s[]) {
        ListaGenerica<Arista<String>> ady = null;
        boolean marca2[]=new boolean[grafo.listaDeVertices().tamanio()];
        ColaGenerica<Vertice<String>> q= new ColaGenerica<Vertice<String>>();
        q.encolar(grafo.listaDeVertices().elemento(i));
        marca2[i]=true;
        while (!q.esVacia()) {
            Vertice<String> v= q.desencolar();
            ady= grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista= ady.proximo();
                int j=arista.verticeDestino().posicion();
                if (!marca2[j]) {
                    Vertice<String> w= arista.verticeDestino();
                    marca2[j]=true;
                    q.encolar(w);
                }
            }
            if(!q.esVacia()) {
            	s[0]++;
            }
        }
    }
}
