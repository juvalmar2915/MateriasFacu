package ej5;

public class Rectangulo extends Figura{
	private double ancho;
	private double largo;
	
	public Rectangulo() {
	}
	public Rectangulo(double ancho, double largo) {
		this.ancho = ancho;
		this.largo = largo;
	}
	public Rectangulo(double ancho, double largo,String color, boolean relleno) {
		super(relleno, color);
		this.ancho = ancho;
		this.largo = largo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getArea() {
		return (this.ancho*this.largo);
	}
	public double getPerimetro() {
		return(2*this.ancho+2*this.largo);
	}
	public String toString() {
		return super.toString() +", ancho: "+this.ancho+", largo: "+this.largo;
	}
}