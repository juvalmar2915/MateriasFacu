package Parcial;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class Test {
	public static void main(String[] args) {
		Grafo<Ciudad> g = new GrafoImplListAdy<>();
        Ciudad d = new Ciudad();
        d.setCiudad("Moreno");
        d.setTiempo(4);
        Vertice<Ciudad> v = new VerticeImplListAdy<>(d);
        d.setCiudad("Quilmes");
        d.setTiempo(3);
        Vertice<Ciudad> v2 = new VerticeImplListAdy<>(d);
        d.setCiudad("Carlos Keen");
        d.setTiempo(5);
        Vertice<Ciudad> v3 = new VerticeImplListAdy<>(d);
        d.setCiudad("Suipacha");
        d.setTiempo(3);
        Vertice<Ciudad> v4 = new VerticeImplListAdy<>(d);
        d.setCiudad("Abasto");
        d.setTiempo(4);
        Vertice<Ciudad> v5 = new VerticeImplListAdy<>(d);
        d.setCiudad("La Plata");
        d.setTiempo(3);

        g.agregarVertice(v);
        g.agregarVertice(v2);
        g.agregarVertice(v3);
        g.agregarVertice(v4);
        g.agregarVertice(v5);
        g.conectar(v, v2, 1);
        g.conectar(v, v3, 1);
        g.conectar(v, v5, 0);
        g.conectar(v2, v4, 1);

        Parcial P = new Parcial();
        System.out.print(P.resolver(g, v.dato().getCiudad(),v.dato().getCiudad(), 6));
	}
}
