/**
 * Esta clase contiene la Posicion y todos los metodos y variables del mismo
 * @author Valentin Blanco y Carlos Molinaroli
 *
 */
public class Posicion {
	/**
	 * variable int para indicar la posicion en la coordenada x
	 */
	private int posx;
	/**
	 * variable int para indicar la posicion en la coordenada y
	 */
	private int posy;
	/**
	 * @return retorna la posicion x
	 */
	public int getPosx() {
		return posx;
	}
	/**
	 * @param posx,  que se le asignara a la variable posx
	 */
	public void setPosx(int posx) {
		this.posx = posx;
	}
	/**
	 * @return retorna la posicion y
	 */
	public int getPosy() {
		return posy;
	}
	/**
	 * @param posy,  que se le asignara a la variable posy
	 */
	public void setPosy(int posy) {
		this.posy = posy;
	}
}
