package Parcial2;
import prog3.grafos.*;
public class Test {
	public static void main(String[] ars){
		Grafo<Local> grafoNuevo = new GrafoImplListAdy<Local>();
		Vertice<Local> vert1 = new VerticeImplListAdy<Local>(new Local("legis",0));
		grafoNuevo.agregarVertice(vert1);
		Vertice<Local> vert2 = new VerticeImplListAdy<Local>(new Local("in4",20));
		grafoNuevo.agregarVertice(vert2);
		Vertice<Local> vert3 = new VerticeImplListAdy<Local>(new Local("bar2",50));
		grafoNuevo.agregarVertice(vert3);
		Vertice<Local> vert4 = new VerticeImplListAdy<Local>(new Local("res2",40));
		grafoNuevo.agregarVertice(vert4);
		Vertice<Local> vert5 = new VerticeImplListAdy<Local>(new Local("in1",20));
		grafoNuevo.agregarVertice(vert5);
		Vertice<Local> vert6 = new VerticeImplListAdy<Local>(new Local("in2",10));
		grafoNuevo.agregarVertice(vert6);
		Vertice<Local> vert7 = new VerticeImplListAdy<Local>(new Local("in3",25));
		grafoNuevo.agregarVertice(vert7);
		Vertice<Local> vert8 = new VerticeImplListAdy<Local>(new Local("bar1",30));
		grafoNuevo.agregarVertice(vert8);
		Vertice<Local> vert9 = new VerticeImplListAdy<Local>(new Local("muni",0));
		grafoNuevo.agregarVertice(vert9);
		Vertice<Local> vert10 = new VerticeImplListAdy<Local>(new Local("res1",15));
		grafoNuevo.agregarVertice(vert10);
		conectarNoDirigido(grafoNuevo,vert1,vert2,30);
		conectarNoDirigido(grafoNuevo,vert2,vert3,50);
		conectarNoDirigido(grafoNuevo,vert3,vert1,40);
		conectarNoDirigido(grafoNuevo,vert1,vert6,80);
		conectarNoDirigido(grafoNuevo,vert6,vert5,30);
		conectarNoDirigido(grafoNuevo,vert3,vert5,90);
		conectarNoDirigido(grafoNuevo,vert3,vert4,200);
		conectarNoDirigido(grafoNuevo,vert8,vert5,20);
		conectarNoDirigido(grafoNuevo,vert4,vert5,40);
		conectarNoDirigido(grafoNuevo,vert4,vert9,10);
		conectarNoDirigido(grafoNuevo,vert9,vert8,100);
		conectarNoDirigido(grafoNuevo,vert9,vert10,30);
		conectarNoDirigido(grafoNuevo,vert10,vert7,20);
		Parcial respuesta = new Parcial();
		CaminoConMetros c = new CaminoConMetros();
		c=respuesta.resolver(grafoNuevo, "muni", "legis");
		System.out.println(c.getCantMetros());
		}
		private static void conectarNoDirigido(Grafo<Local> graph, Vertice<Local> v1, Vertice<Local> v2,int peso) {
			graph.conectar(v1,v2,peso);
			graph.conectar(v2,v1,peso);
		}
}

