/**
 * Esta clase contiene al Personaje y todos los metodos y variables del mismo
 * @author Valentin Blanco y Carlos Molinaroli
 *
 */
public abstract class Personaje {
	/**
	 * variable Posicion para indicar la posicion en la que se encuentra el personaje
	 */
	private Posicion posicion;
	/**
	 * @return retorna la posicion del personaje
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion, posicion que se modificara a la variable posicion
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public abstract void mover();
	
}
