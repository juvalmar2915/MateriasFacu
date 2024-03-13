package Magnitud;

public class Conversoraotrosist {
	public static double cambiarSistemaLong(String unidad,double cifra) { //conversor podria haber realizado todas las conversiones pero se nos ocurrio despues de la implementacion
		if (unidad.equals("pie")) {
			return (cifra/3.28084); //paso a metro el pie recibido
		}
		return (cifra*3.28084); // paso a pie el metro recibido
	};
	public static double cambiarSistemaMasa(String unidad,double cifra) {
		return 0; //no se implemento ya que solo fue requerido longitud
	};
}
