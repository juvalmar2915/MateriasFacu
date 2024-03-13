/**
 * Esta clase contiene al Fantasma y todos los metodos y variables del mismo
 * @author Valentin Blanco y Carlos Molinaroli
 *
 */
public abstract class Fantasma extends Personaje{
	/**
	 * variable String para indicar el estado del Fantasma
	 * la misma toma 3 cadenas de caracteres distinta
	 * una para indicar que el fantasma esta en modo persecucion del pacman
	 * otra que indica que estan asustados del mismo
	 * y otra que indica que se estan dispersando
	 */
	private String estado;
	/**
	 * @return retorna el estado que tiene el Fantasma
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado, estado que se le asignara al estado actual
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 *  hace que el fantasma salga de la casa
	 */
	public void revivir() {
	}
	/**
	 *  metodo para alcanzar a Pacman, es implementado de forma distinta en cada subclase
	 *  @return devuelve la direccion calculada
	 */
	public abstract int modoPersecucion();	
	/**
	 * elige una esquina de modo aleatorio y trata de llegar a ella. 
	 * Se activa cuando Pacman come una fruta y tiene una duración de X segundos.
	 * @return devuelve la direccion calculada
	 */
	public int modoAsustado() {
		return 0;
	}	
	/**
	 *   el fantasma tiene una esquina asignada y trata de llegar a ella. 
	 *   Se activa una vez que termina el modo asustado
	 *   @return devuelve la direccion calculada
	 */
	public int modoDispersion() {
		return 0;
	}	
	/**
	 *  posiciona al fantasma en la casa
	 */
	public void morir() {
	}	
	/**
	 *  dependiendo el estado que tenga asignado el fantasma ejecuta el metodo para 
	 *  definir la direccion y lo mueve.
	 */
	@Override
	public void mover() {
	}	
	
}
