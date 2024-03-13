import listagenerica.ListaGenericaEnlazada;

public class Usuario {
	private int id;
	private ListaGenericaEnlazada<Float> rating;
	private ListaGenericaEnlazada<Integer> idPelicula;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ListaGenericaEnlazada<Float> getRating() {
		return rating;
	}
	public void setRating(ListaGenericaEnlazada<Float> rating) {
		this.rating = rating;
	}
	public ListaGenericaEnlazada<Integer> getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(ListaGenericaEnlazada<Integer> idPelicula) {
		this.idPelicula = idPelicula;
	}
}
