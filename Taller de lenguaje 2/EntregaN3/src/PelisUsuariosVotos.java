import listagenerica.ListaGenericaEnlazada;

public class PelisUsuariosVotos implements Comparable<PelisUsuariosVotos>{
	private String pelicula;
	private int idPelicula=0;
	private int cant=0;
	private double ratingTotal=0;
	private int [] arregloRating=new int[6];
	public int[] getArregloRating() {
		return arregloRating;
	}
	public void addArregloRating(int pos) {
		this.arregloRating[pos]++;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public int getCant() {
		return cant;
	}
	public PelisUsuariosVotos(int idPelicula,double ratingTotal) {
		this.idPelicula = idPelicula;
		this.ratingTotal = ratingTotal;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public double getRatingTotal() {
		return ratingTotal;
	}
	public void setRatingTotal(double ratingTotal) {
		this.ratingTotal = ratingTotal;
	}
	 @Override
     public int compareTo(PelisUsuariosVotos p) {
         if (cant < p.cant) {
             return 1;
         }
         if (cant > p.cant) {
             return -1;
         }
         return 0;
     }
}
