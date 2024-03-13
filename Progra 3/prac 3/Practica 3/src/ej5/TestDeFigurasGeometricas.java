package ej5;

public class TestDeFigurasGeometricas {

	public static void main(String[] args) {
		Figura[] fig=new Figura[3];
		fig[0]=new Circulo(4,"rojo",true);
		fig[1]=new Rectangulo(5,7,"verde",false);
		fig[2]=new Cuadrado(6,"rosa",true);
		for(Figura x:fig) {
			System.out.println(x.toString()+", area: "+x.getArea()+", perimetro: "+x.getPerimetro());
		}
	}
}
