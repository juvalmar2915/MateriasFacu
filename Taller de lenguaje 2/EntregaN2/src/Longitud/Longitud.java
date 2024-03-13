package Longitud;
import Magnitud.*;

public abstract class Longitud extends Magnitud{
	public abstract double suma(Magnitud m);
	public abstract double resta(Magnitud m);
	public abstract double convertir(String transformar);
	public abstract boolean comparar(Magnitud m);
	
}
