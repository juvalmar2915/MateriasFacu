package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class Algoritmos<T> {
	public boolean subGrafoCuadrado(Grafo<T> grafo) {
        ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        boolean si = false;
        ListaGenerica<Vertice<T>> lista = grafo.listaDeVertices();
        lista.comenzar();
        while (!lista.fin()) {
                int longitud = 0;
                Vertice<T> v = lista.proximo();
                if (marca[v.posicion()] == false && si == false) {
                        si = dfs(v, marca, grafo, l, longitud);
                }
        }
        return si;
	}

	private boolean dfs(Vertice<T> v, boolean[] marca, Grafo<T> grafo, ListaGenerica<T> l, int longitud) {
        marca[v.posicion()] = true;
        l.agregarFinal(v.dato());
        boolean si = false;
        
        ListaGenerica<Arista<T>> lista = grafo.listaDeAdyacentes(v);
        lista.comenzar();
        while (!lista.fin() && !si) {
                Vertice<T> w = lista.proximo().verticeDestino();
                if (marca[w.posicion()] == false && longitud<3) {
                	si = dfs(w, marca, grafo, l, longitud + 1);
                } else {
                        if (l.elemento(0).equals(w.dato()) && longitud == 3)
                                return true;
                }
        }
        
        
        // A -> B -> C -> D -> A   ok, es subgrafo cuadrado
        // A -> B -> C -> D -> B  
        
        marca[v.posicion()] = false;
        l.eliminar(v.dato());
        return si;
	}
	
	public boolean subgrafoCuadrado(Grafo<T> grafo) {
        int[] marca = new int[grafo.listaDeVertices().tamanio()];
        boolean[] marca2 = new boolean[grafo.listaDeVertices().tamanio()];
        boolean[] encuentra= new boolean[1];
        for(int i=0; i<grafo.listaDeVertices().tamanio();i++){
            if (!(marca2[i]))
                this.subgrafoCuadrado(grafo, encuentra, grafo.vertice(i), marca, marca2, 1);
        }
        return encuentra[0];
    }

    private void subgrafoCuadrado(Grafo<T> grafo, boolean[] encuentra, Vertice<T> c, int[] marca, boolean[] marca2, int i) {
        marca[c.posicion()] = i;
        marca2[c.posicion()] = true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(c);
        ady.comenzar();
        while(!ady.fin()){
            Vertice<T> cAux=ady.proximo().verticeDestino();
            if(marca[cAux.posicion()]==0){
                this.subgrafoCuadrado(grafo, encuentra, cAux, marca, marca2, i+1);
                if (encuentra[0]) break;
            }
            else if ((i-marca[cAux.posicion()])==3){
                encuentra[0]=true;
                break;
            }
        }
        // A -> B -> C -> D -> A   ok, es subgrafo cuadrado
        // A -> B -> C -> D -> B  
        marca[c.posicion()] = 0;
    }
	
	/*public int getGrado(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int[] gradoVertices = new int[grafo.listaDeVertices().tamanio()];
        int maxGrado = 0;
        for(int i=0; i<grafo.listaDeVertices().tamanio();i++){
                if (!marca[i]) {
                        this.dfsGrados(i, grafo, gradoVertices, marca); 
                        }
        }
        for(int i=0; i<grafo.listaDeVertices().tamanio();i++) {
                if(gradoVertices[i]>maxGrado) 
                	maxGrado=gradoVertices[i];
        }
        return maxGrado;
	}

	private void dfsGrados(int i,Grafo<T> grafo,int[] gradoVertices,boolean[] marca){
        marca[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        //agrego los vertices que salen de el
        gradoVertices[i] += ady.tamanio();
        while(!ady.fin()){
                int j = ady.proximo().verticeDestino().posicion();
                gradoVertices[j]++; //incremento en 1 porque le incide una arista
                if (!marca[j]){
                	this.dfsGrados(j, grafo, gradoVertices,marca);
                }
        }
	}*/
	
	public int getGrado(Grafo<T> grafo) {
        int grado = 0;
        int[] marca = new int[grafo.listaDeVertices().tamanio()];
        for(int i=0; i<grafo.listaDeVertices().tamanio();i++){
            if (marca[i]==0)
                this.getGrado(grafo, grafo.vertice(i), marca);
        }
        for (int i=0; i<grafo.listaDeVertices().tamanio(); i++) {
            grado = marca[i] > grado ? marca[i] : grado;
        }
        return grado;
    }

    private void getGrado(Grafo<T> grafo, Vertice<T> c, int[] marca) {
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(c);
        marca[c.posicion()]+=ady.tamanio();
        ady.comenzar();
        while(!ady.fin()){
            Vertice<T> cAux=ady.proximo().verticeDestino();
            if(marca[cAux.posicion()]==0)
                this.getGrado(grafo, cAux, marca);
            marca[cAux.posicion()]++;
        }
    }

    public boolean tieneCiclo(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        boolean[] marca2 = new boolean[grafo.listaDeVertices().tamanio()];
        boolean encontre[] = new boolean[1];
        for(int i=0; i<grafo.listaDeVertices().tamanio();i++){
            if (!(marca2[i]))
                this.tieneCiclo(grafo, grafo.vertice(i), marca, marca2, encontre);
        }
        return encontre[0];
    }

    private void tieneCiclo(Grafo<T> grafo, Vertice<T> c, boolean[] marca, boolean[] marca2, boolean[] encontre) {
        marca[c.posicion()]=true;
        marca2[c.posicion()]=true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(c);
        ady.comenzar();
        while(!ady.fin() && !encontre[0]){
            Vertice<T> cAux=ady.proximo().verticeDestino();
            if(marca[cAux.posicion()])
                encontre[0]=true;
            else 
            	if (!marca2[cAux.posicion()])
            		this.tieneCiclo(grafo, cAux, marca, marca2, encontre);
        }
        marca[c.posicion()]=false;
    }
}
