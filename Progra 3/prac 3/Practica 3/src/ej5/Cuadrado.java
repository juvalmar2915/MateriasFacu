package ej5;

public class Cuadrado extends Rectangulo{
	public Cuadrado() {
	}
	public Cuadrado(double lado) {
		super(lado,lado);
	}
	public Cuadrado(double lado,String color,boolean relleno) {
		super(lado,lado,color,relleno);
	}
	public double getLado() {
		return super.getLargo();
	}
	public void setLado(double lado) {
		super.setAncho(lado);
		super.setLargo(lado);
	}
	public void setAncho(double lado){
		super.setAncho(lado);
	}
	public void setLargo(double lado){
		super.setLargo(lado);
	}
	public String toString() {
		return super.toString();
	}
}
