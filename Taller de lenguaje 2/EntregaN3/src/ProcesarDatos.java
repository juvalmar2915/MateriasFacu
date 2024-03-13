import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.Arrays;

import listagenerica.*;
public class ProcesarDatos implements Runnable{
	private boolean listo;
	private Thread hilo=null;
	private ListaGenericaEnlazada<Pelicula> listaPeliculas;
	private ListaGenericaEnlazada<Usuario> listaUsuarios;
	private int votos=0;
	private PelisUsuariosVotos[] arregloOrdenado;
	private Thread hiloBarra;
	private BarraProgreso ba;
	private TablaCant t;
	private SelectorCant s;
	private int contador=0;
	private int cant=0;
	public ListaGenericaEnlazada<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public boolean getListo() {
		return listo;
	}

	public void setListo(boolean listo) {
		this.listo = listo;
	}

	public ListaGenericaEnlazada<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public ProcesarDatos(TablaCant t, SelectorCant s,BarraProgreso ba) {
		this.ba=ba;
		this.t=t;
		this.s=s;
		start();
	}
	public ProcesarDatos() {
		
	}
	public void start() {
		if (hilo==null) {
			hilo=new Thread(this);
			hilo.start();
		}
	}
	public void run() {
		try {
			FileInputStream fstream1 = new FileInputStream(Paths.get("src","movies.csv").toString());
			FileInputStream fstream2 = new FileInputStream(Paths.get("src","ratings.csv").toString());
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(fstream1));
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(fstream2));
			while (reader1.readLine()!=null) {
				this.contador++;
			}
			while (reader2.readLine()!=null) {
				this.contador++;
			}
			hiloBarra= new Thread(ba);
			ba.setCont(contador);
			hiloBarra.start();
			fstream1 = new FileInputStream(Paths.get("src","movies.csv").toString());
			fstream2 = new FileInputStream(Paths.get("src","ratings.csv").toString());
			reader1 = new BufferedReader(new InputStreamReader(fstream1));
			reader2 = new BufferedReader(new InputStreamReader(fstream2));
			String linea1, linea2;
			listaPeliculas= new ListaGenericaEnlazada<Pelicula>();
			Pelicula p;
			Usuario u;
			reader1.readLine();
			while ((linea1 = reader1.readLine()) != null) {
				ba.addProgreso();
				p=new Pelicula();
				int i=0;
				int aux1=0;
				while (linea1.charAt(i)!=',') {
					aux1*=10;
					aux1=aux1+(int) linea1.charAt(i) -48;
					i++;
				}
				p.setId(aux1);
				i++;
				String aux2="";
				while (linea1.charAt(i)!=',') {
					aux2=aux2+linea1.charAt(i);
					i++;
				}
				p.setNombre(aux2);
				listaPeliculas.agregarFinal(p);
				Thread.yield();
			}
			reader2.readLine();
			listaUsuarios=new ListaGenericaEnlazada<Usuario>();
			boolean encontre;
			while ((linea2 = reader2.readLine()) != null) {
				ba.addProgreso();
				int i=0;
				int aux1=0;
				votos++;
				while (linea2.charAt(i)!=',') {
					aux1*=10;
					aux1=aux1+(int) linea2.charAt(i) -48;
					i++;
				}
				i++;
				int aux2=0;
				while (linea2.charAt(i)!=',') {
					aux2*=10;
					aux2=aux2+(int) linea2.charAt(i) -48;
					i++;
				}
				float aux3=0;
				i++;
				aux3=aux3+(int) linea2.charAt(i) -48;
				i+=2;
				aux3=aux3+((int) linea2.charAt(i) -48)/10;
				listaUsuarios.comenzar();
				int contador=-1;
				encontre=false;
				while (!(listaUsuarios.fin()) && !encontre) {
					contador++;
					if ((listaUsuarios.proximo().getId()==aux1)) {
						encontre=true;
					}
				};
				if (encontre) {
					listaUsuarios.elemento(contador).getIdPelicula().agregarFinal(aux2);
					listaUsuarios.elemento(contador).getRating().agregarFinal(aux3);
				}
				else {
					u=new Usuario();
					u.setId(aux1);
					ListaGenericaEnlazada<Integer> laux2= new ListaGenericaEnlazada<Integer>();
					laux2.agregarFinal(aux2);
					u.setIdPelicula(laux2);
					ListaGenericaEnlazada<Float> laux3= new ListaGenericaEnlazada<Float>();
					laux3.agregarFinal(aux3);
					u.setRating(laux3);
					listaUsuarios.agregarFinal(u);
				}
				Thread.yield();
			}
			reader1.close();
			reader2.close();
			fstream1.close();
			fstream2.close();
			crearListaOrdenada();
		} catch (FileNotFoundException ef) {
			ef.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public void crearListaOrdenada() {
		t.actualizar(getListaUsuarios().tamanio(),getListaPeliculas().tamanio(),getVotos());
		ListaGenericaEnlazada<Pelicula> laux=getListaPeliculas();
		ListaGenericaEnlazada<Usuario> laux2=getListaUsuarios();
		arregloOrdenado=new PelisUsuariosVotos[getListaPeliculas().tamanio()];
		int tamanioL=0;
		boolean aux;
		laux2.comenzar();
		while (!laux2.fin()) {
			Usuario u1=laux2.proximo();
			u1.getIdPelicula().comenzar();
			u1.getRating().comenzar();
			while (!u1.getIdPelicula().fin()) {
				aux=false;
				int idPel=u1.getIdPelicula().proximo();
				double rat=u1.getRating().proximo();
				for (int x=0;x<tamanioL;x++) {
					if (arregloOrdenado[x].getIdPelicula()==idPel){
						arregloOrdenado[x].setCant(arregloOrdenado[x].getCant()+1);
						arregloOrdenado[x].setRatingTotal(arregloOrdenado[x].getRatingTotal()+rat);
						arregloOrdenado[x].addArregloRating((int) rat);
						aux=true;
					}
					
				}
				if (!aux){
					arregloOrdenado[tamanioL]=new PelisUsuariosVotos(idPel,rat);
					arregloOrdenado[tamanioL].setCant(arregloOrdenado[tamanioL].getCant()+1);
					arregloOrdenado[tamanioL].addArregloRating((int) rat);
					tamanioL++;
				}
			}
		}
		try {
			Thread.sleep(100);
		}catch (InterruptedException off) {
			
		}
		laux.comenzar();
		while (!laux.fin()) {
			aux=false;
			Pelicula p1=laux.proximo();
			for (int x=0;x<tamanioL;x++) {
				if (p1.getId()==arregloOrdenado[x].getIdPelicula()) {
					arregloOrdenado[x].setPelicula(p1.getNombre());
					arregloOrdenado[x].setRatingTotal(arregloOrdenado[x].getRatingTotal()/arregloOrdenado[x].getCant());
					aux=true;
				}
			}
			if (!aux){
				arregloOrdenado[tamanioL]=new PelisUsuariosVotos(p1.getId(),0);
				arregloOrdenado[tamanioL].setPelicula(p1.getNombre());
				tamanioL++;
			}
		}
		Arrays.sort(arregloOrdenado);
		s.casos(arregloOrdenado);
		s.histoTabla(arregloOrdenado);
	}
}



