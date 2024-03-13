package prog3.arbol.binariobusqueda.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import prog3.arbol.binariobusqueda.ArbolBinarioDeBusqueda;


public class ArbolBinarioDeBusquedaTest {

	ArbolBinarioDeBusqueda<String> arbol;
	ArbolBinarioDeBusqueda<String> arbolVacio;
	@Before
	public void setUp(){
		arbol = new ArbolBinarioDeBusqueda<String>(null);
		arbolVacio = new ArbolBinarioDeBusqueda<String>(null);
	}
	
	@Test
	public void creacion() {
		assertTrue(arbolVacio.esVacio());
	}
	
	@Test
	public void creacionConElemento(){
		arbol = new ArbolBinarioDeBusqueda<String>("hola");

		assertFalse(arbol.esVacio());
		assertTrue(arbol.getHijoDerecho().esVacio());
		assertTrue(arbol.getHijoIzquierdo().esVacio());
	}
	
	@Test
	public void carga(){
		arbol = new ArbolBinarioDeBusqueda<String>("hola");
		arbol.agregar("mundo");
		
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		
		arbol.agregar("otro");
		//mantiene la posicion del anterior
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		//agrego el nuevo al final de la rama derecha
		assertEquals("otro", arbol.getHijoDerecho()
						.getHijoDerecho().getDatoRaiz());
		
		arbol.agregar("al comienzo");
		assertEquals("al comienzo", arbol.getHijoIzquierdo().getDatoRaiz());
	}
	
	@Test
	public void busqueda(){
		arbol.agregar("hola");
		arbol.agregar("otro");
		arbol.agregar("mundo");

		assertTrue(arbol.incluye("hola"));
		assertTrue(arbol.incluye("otro"));
		assertTrue(arbol.incluye("mundo"));
		
		assertEquals("mundo", arbol.buscar("mundo"));
		assertNull(arbol.buscar("no esta"));
		
		assertFalse(arbol.incluye("al comienzo"));
		assertFalse(arbol.incluye("zz fin"));
	}
	
	@Test
	public void eliminacion(){
		
		arbol.agregar("hola");
		arbol.agregar("otro");
		arbol.agregar("mundo");
		arbol.agregar("zzz");
		
		arbol.eliminar("no esta");

		
		arbol.eliminar("otro");
		assertEquals("hola", arbol.getDatoRaiz());
		assertEquals("mundo", arbol.getHijoDerecho().getDatoRaiz());
		
		arbol.eliminar("hola");
		assertEquals("mundo",arbol.getDatoRaiz());
		assertEquals("zzz", arbol.getHijoDerecho().getDatoRaiz());
	}
	
	
}
