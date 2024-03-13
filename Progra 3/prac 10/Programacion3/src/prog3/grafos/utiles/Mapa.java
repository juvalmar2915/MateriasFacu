package prog3.grafos.utiles;

import prog3.grafos.*;
import prog3.listagenerica.*;

public class Mapa {
	private Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mapa) {
		mapaCiudades = mapa;
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		Vertice<String> origen = null, destino = null;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || destino == null)) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(ciudad1)) {// para saber de donde lanzo la busqueda
				origen = v;
			} else {
				if (v.dato().equals(ciudad2)) {
					destino = v;
				}
			}
		}

		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

		boolean marcados[] = new boolean[vertices.tamanio()];

		this.dfsCamino(origen, destino, camino, marcados);

		return camino;
	}

	private boolean dfsCamino(Vertice<String> vertice, Vertice<String> destino, ListaGenerica<String> camino,
			boolean visitados[]) {

		visitados[vertice.posicion()] = true;
		camino.agregarFinal(vertice.dato());
		if (vertice.dato().equals(destino.dato())) {
			return true;
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice);
			adyacentes.comenzar();
			boolean llegue = false;
			while (!adyacentes.fin() && !llegue) {
				Vertice<String> v = adyacentes.proximo().verticeDestino();
				if (!visitados[v.posicion()]) {
					llegue = dfsCamino(v, destino, camino, visitados);
				}
			}
			if (!llegue) {
				camino.eliminarEn(camino.tamanio() - 1);
			}
			return llegue;
		}

	}

	public ListaGenerica<String> DevolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		Vertice<String> origen = null, destino = null;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || destino == null)) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(ciudad1)) {// para saber de donde lanzo la busqueda
				origen = v;
			} else {
				if (v.dato().equals(ciudad2)) {
					destino = v;
				}
			}
		}

		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

		boolean marcados[] = new boolean[vertices.tamanio()];

		this.dfsCaminoExceptuando(origen, destino, ciudades, camino, marcados);

		return camino;
	}

	private boolean dfsCaminoExceptuando(Vertice<String> vertice, Vertice<String> destino,
			ListaGenerica<String> ciudades, ListaGenerica<String> camino, boolean visitados[]) {

		if (!ciudades.incluye(vertice.dato())) {
			visitados[vertice.posicion()] = true;
			camino.agregarFinal(vertice.dato());
			if (vertice.dato().equals(destino.dato())) {
				return true;
			} else {
				ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice);
				adyacentes.comenzar();
				boolean llegue = false;
				while (!adyacentes.fin() && !llegue) {
					Vertice<String> v = adyacentes.proximo().verticeDestino();
					if (!visitados[v.posicion()])
						llegue = dfsCaminoExceptuando(v, destino,ciudades,  camino, visitados);
				}
				if (!llegue) {
					camino.eliminarEn(camino.tamanio() - 1);
				}
				return llegue;
			}

		} else
			return false;
	}

	public ListaGenerica<String> CaminoMasCorto(String ciudad1, String ciudad2) {
		Vertice<String> origen = null, destino = null;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || destino == null)) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(ciudad1)) {// para saber de donde lanzo la busqueda
				origen = v;
			} else {
				if (v.dato().equals(ciudad2)) {
					destino = v;
				}
			}
		}

		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		ListaGenerica<String> temporal = new ListaGenericaEnlazada<String>();
		boolean marcados[] = new boolean[vertices.tamanio()];
		int pesoMin[] = new int[1];
		pesoMin[0] = 0;
		this.dfsCaminoMasCorto(origen, destino, camino, marcados, temporal, 0, pesoMin);

		return camino;

	}

	private void dfsCaminoMasCorto(Vertice<String> vertice, Vertice<String> destino, ListaGenerica<String> camino,
			boolean visitados[], ListaGenerica<String> temp, int peso, int pesoMin[]) {

		visitados[vertice.posicion()] = true;
		temp.agregarFinal(vertice.dato());
		if (vertice.equals(destino)) {
			if (peso < pesoMin[0]) {
				camino = this.copiar(temp);
				pesoMin[0] = peso;
			}
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice);
			adyacentes.comenzar();
			while (!adyacentes.fin()) {
				Arista<String> arista = adyacentes.proximo();
				dfsCaminoMasCorto(arista.verticeDestino(), destino, camino, visitados, temp, peso + arista.peso(),
						pesoMin);
			}
			visitados[vertice.posicion()] = false;
			temp.eliminar(vertice.dato());
		}
	}

	private ListaGenerica<String> copiar(ListaGenerica<String> lista) {
		ListaGenerica<String> temporal = new ListaGenericaEnlazada<String>();
		temporal.comenzar();
		lista.comenzar();
		while (!lista.fin()) {
			temporal.agregarFinal(lista.proximo());
		}
		return temporal;
	}

	public ListaGenerica<String> CaminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		Vertice<String> origen = null, destino = null;
		ListaGenerica<Vertice<String>> vertices = mapaCiudades.listaDeVertices();
		vertices.comenzar();
		while (!vertices.fin() && (origen == null || destino == null)) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(ciudad1)) {// para saber de donde lanzo la busqueda
				origen = v;
			} else {
				if (v.dato().equals(ciudad2)) {
					destino = v;
				}
			}
		}

		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

		boolean marcados[] = new boolean[vertices.tamanio()];

		this.dfsSinCarga(origen, destino, camino, marcados, tanqueAuto);

		return camino;
	}

	private boolean dfsSinCarga(Vertice<String> vertice, Vertice<String> destino, ListaGenerica<String> camino,
			boolean marcados[], int combustible) {
		marcados[vertice.posicion()] = true;
		camino.agregarFinal(vertice.dato());
		if (vertice.equals(destino)) {
			return true;
		} else {
			ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vertice);
			adyacentes.comenzar();
			boolean llegue = false;
			while ((!adyacentes.fin()) && (!llegue)) {
				Arista<String> arista = adyacentes.proximo();
				if ((combustible - arista.peso() > 0) &&(!marcados[arista.verticeDestino().posicion()])) {
					llegue = dfsSinCarga(arista.verticeDestino(), destino, camino, marcados,
							combustible - arista.peso());
				}
			}

			if (!llegue) {
				camino.eliminarEn(camino.tamanio()-1);
				marcados[vertice.posicion()] = false;
			}
			return llegue;
		}

	}

}
