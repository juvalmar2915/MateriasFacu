package prog3.grafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
public class GuiaDeTurismo {
	public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen,
			String puntoInteresDestino) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		int i = 0;
		grafo.listaDeVertices().comenzar();
		while (i < grafo.listaDeVertices().tamanio() && !grafo.vertice(i).dato().equals(puntoInteresOrigen))
			i++;
		if (i < grafo.listaDeVertices().tamanio())
			caminoConMenorNrodeViajes(grafo, new int[1], Integer.MAX_VALUE, grafo.vertice(i), marca, camino,
					new ListaGenericaEnlazada<String>(), puntoInteresDestino);
		if (camino.esVacia())
			camino = null;
		return camino; // a ciudad en la que estaba parado no la tomo en cuenta
	}

	private void caminoConMenorNrodeViajes(Grafo<String> grafo, int[] tamMax, int tamAct, Vertice<String> ciudad,
			boolean[] marca, ListaGenerica<String> camino, ListaGenerica<String> caminoAct, String puntoD) {
		if (ciudad.dato().equals(puntoD)) {
			if (tamAct > tamMax[0]) {
				while (!camino.esVacia())
					camino.eliminarEn(0);
				caminoAct.comenzar();
				while (!caminoAct.fin())
					camino.agregarFinal(caminoAct.proximo());
				tamMax[0] = tamAct;
			}
		} else {
			marca[ciudad.posicion()] = true;
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(ciudad);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> aAux = ady.proximo();
				Vertice<String> vAct = aAux.verticeDestino();
				if (!marca[vAct.posicion()]) {
					caminoAct.agregarFinal(vAct.dato());
					caminoConMenorNrodeViajes(grafo, tamMax, tamAct < aAux.peso() ? tamAct : aAux.peso(), vAct, marca,
							camino, caminoAct, puntoD);
					caminoAct.eliminarEn(caminoAct.tamanio() - 1);
				}
			}
			marca[ciudad.posicion()] = false;
		}
	}

}
