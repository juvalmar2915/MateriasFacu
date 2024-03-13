package Magnitud;

public abstract class Magnitud{
	private double cifra;
	public abstract double suma(Magnitud m); //retorna las suma de las dos magnitudes en la unidad del sistema internacional principal (longitud: metro , masa: kilogramo, tiempo: segundo)
	public abstract double resta(Magnitud m) ; //retorna las resta de las dos magnitudes en la unidad del sistema internacional principal (longitud: metro , masa: kilogramo, tiempo: segundo)
	public abstract double convertir(String transformar);
	public abstract boolean comparar(Magnitud m); //comparacion interpretada como si las dos magnitudes luego de la conversion son iguales (siempre hablando en el mismo sistema) y en caso de no serlo o pertenecer a otro sist devuelve false
	public double getCifra() {
		return cifra;
	}
	public void setCifra(double cifra) {
		this.cifra = cifra;
	}
}
