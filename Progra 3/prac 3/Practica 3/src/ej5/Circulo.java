package ej5;

public class Circulo extends Figura {
	private double radio;

	public Circulo(double radio, String color, boolean relleno) {
		super(relleno, color);
		this.radio = radio;
	}
	
	public Circulo(double radio) {
		this.radio = radio;
	}

	public Circulo() {
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getArea() {
		return (this.radio*this.radio*(Math.PI));
	}
	
	public double getPerimetro() {
		return (this.radio*(Math.PI)*2);
	}
	@Override
	public String toString() {
		return super.toString() + ", radio: " + this.radio;
	}
}
