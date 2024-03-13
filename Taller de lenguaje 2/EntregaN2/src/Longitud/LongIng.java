package Longitud;
import Magnitud.Magnitud;

public abstract class LongIng extends Longitud{
	public abstract double suma(Magnitud m);
	public abstract double resta(Magnitud m);
	public abstract double convertir(String transformar);
	public abstract boolean comparar(Magnitud m);
}
