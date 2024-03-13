package prog3.grafos.utiles;
import prog3.grafos.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo<String> g=new GrafoImplListAdy<String>();
        Vertice<String> v= new VerticeImplListAdy<String>("Lopez");
        g.agregarVertice(v);
        Vertice<String> v2= new VerticeImplListAdy<String>("Juan");
        Vertice<String> v3= new VerticeImplListAdy<String>("Pedro");
        Vertice<String> v4= new VerticeImplListAdy<String>("Dario");
        Vertice<String> v5= new VerticeImplListAdy<String>("Lisan");
        Vertice<String> v6= new VerticeImplListAdy<String>("Pepe");
        g.agregarVertice(v);
        g.agregarVertice(v2);
        g.agregarVertice(v3);
        g.agregarVertice(v4);
        g.agregarVertice(v5);
        g.agregarVertice(v6);
        g.conectar(v, v2,5);
        g.conectar(v2, v5,8);
        g.conectar(v2, v3,9);
        g.conectar(v3, v4,20);
        g.conectar(v4, v5,4);
        g.conectar(v6, v,23);
        //g.conectar(v5, v2);
        /*Algoritmos<String> a= new Algoritmos<String>();
        System.out.println(a.subGrafoCuadrado(g));
        System.out.println(a.getGrado(g));
        System.out.println(a.tieneCiclo(g));*/
        Delta d=new Delta();
        System.out.println(d.maxIslasDistintas(g));
        System.out.println(d.caminoMasCorto(g, "Pepe", "Dario"));
	}

}
