
/**
 * Esta clase contiene al Pacman y todos los metodos y variables del mismo
 * @author Valentin Blanco y Carlos Molinaroli
 *
 */
public class Pacman extends Personaje{
	/**
	 * variable String para indicar nombre del jugador
	 */
	private String nombre;
	/**
	 * variable entera para indicar la cantidad de vidas 
	 */
	private int vidas;
	/**
	 * variable entera para indicar la direccion a la que se desplaza
	 * la misma toma valores de  0 a 3 0 indicando izquierda y finalizando con 3 hacia abajo
	 */
	private int direccion;
	/**
	 * variable de la clase Jugador que contiene los datos del mismo
	 */
	private Jugador jugador;
	
	/**
	 * @return retorna el nombre del jugadoractual
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre, nombre del jugador que se le asignara a la variable nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return retorna la cantidad de vidas
	 */
	public int getVidas() {
		return vidas;
	}
	/**
	 * @param vidas, vidas del jugador que se le asignara a la variable vidas
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	/**
	 * @return retorna la direccion a la que se desplaza pacman
	 */
	public int getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion, direccion del jugador que se le asignara a la variable direccion
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return retorna el jugador con su cantidad de puntos
	 */
	public Jugador getJugador() {
		return jugador;
	}
	/**
	 * @param jugador, jugador que se le asignara a la variable jugador
	 */
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	/**
	 * a la variable vidas la disminuye en 1
	 */
	public void restarVida() {
	}
	/**
	 * aumenta el puntaje a la clase jugador, cambia el estado de los fantasmas a asustado y
	 * borra la entidad fruta del mapa en la posicion ya que la misma es publica
	 */
	public void comerFruta() {
	}
	/**
	 * aumenta el puntaje a la clase jugador y borra la entidad fruta del mapa en la posicion
	 */
	public void comerBolita() {
	}
	/**
	 * verifica las colisiones en la posicion a la que se dirige (direccion) el pacman y tambien en 
	 * la actual dependiendo del caso(tunel,bolita,fruta,fantasma,casa,obstaculo) pierde vida, come 
	 * fruta, come bolita, se detiene o se desplaza a otra parte del mapa, y en caso de no ser casa
	 * ni obstaculo se desplaza a dicha direccion
	 */
	@Override
	public void mover() {
	}
	
}
