import Magnitud.*;
import Longitud.*;
import listagenerica.*;

public class Test {

	public static void main(String[] args) {
		ListaGenericaEnlazada<Centimetro> l= new ListaGenericaEnlazada<Centimetro>();
		Centimetro m=new Centimetro();
		m.setCifra(5);
		l.agregarFinal(m);
		Centimetro m2=new Centimetro();
		m2.setCifra(1);
		l.agregarFinal(m2);
		Centimetro m3=new Centimetro();
		m3.setCifra(9);
		l.agregarFinal(m3);
		Centimetro m4=new Centimetro();
		m4.setCifra(7);
		l.agregarFinal(m4);
		Centimetro m5=new Centimetro();
		m5.setCifra(3);
		l.agregarFinal(m5);
		SondaEspacial<Yarda> s= new SondaEspacial<Yarda>();
		double aux;
		Pie p= new Pie();
		Yarda y;
		l.comenzar();
		while (!l.fin()) {
			aux= Conversoraotrosist.cambiarSistemaLong("metro",l.proximo().convertir("m"));
			System.out.println(aux);// conversion de cm a metro y metro a pie
			p.setCifra(aux);
			y= new Yarda();
			y.setCifra(p.convertir("yarda")); 
			System.out.println(y.getCifra());//imprimo la conversion de pie a yarda
			s.imprimir(y);
		}
	}

}
