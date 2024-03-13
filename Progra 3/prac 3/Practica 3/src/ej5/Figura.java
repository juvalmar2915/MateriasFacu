package ej5;

public abstract class Figura {
	private boolean relleno;
	private String color;

	public Figura(boolean relleno, String color) {
		this.relleno = relleno;
		this.color = color;
	}

	public Figura() {
	}

	public boolean isRelleno() {
		return relleno;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	abstract double getArea();

	abstract double getPerimetro();

	@Override
	public String toString() {
		return "relleno: " + relleno + ", color: " + color;
	}
}