package prog3.arbol.binario;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.Cola;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario(){		
		this.raiz = null;
	}
	
	public ArbolBinario(T dato){		
		this.raiz = new NodoBinario<T>(dato);
	}	
	
	private ArbolBinario(NodoBinario<T> nodo){		
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){		
		return raiz;
	}
	
	public T getDatoRaiz(){
		if (this.getRaiz() != null){
			return this.getRaiz().getDato();
		}else{
			return null;
		}
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){		
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}
	
	public ArbolBinario<T> getHijoDerecho(){		
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}	
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){		
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo){		
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}	
	
	public void eliminarHijoIzquierdo(){		
		this.raiz.setHijoIzquierdo(new NodoBinario<T>(null));
	}
	
	public void eliminarHijoDerecho(){		
		this.raiz.setHijoDerecho(new NodoBinario<T>(null));
	}	
	
	public boolean esVacio(){
		return this.raiz==null;
	}
	
	public boolean esHoja(){
		return this.getDatoRaiz()!=null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	
	public void printPreorden() {    
		System.out.println(this.getDatoRaiz());    
		if (!this.getHijoIzquierdo().esVacio()) {     
			this.getHijoIzquierdo().printPreorden();     
		}    
		if (!this.getHijoDerecho().esVacio()){     
			this.getHijoDerecho().printPreorden();    
		}
	}
	
	public void printInorden() {  
		if (!this.getHijoIzquierdo().esVacio()) {     
			this.getHijoIzquierdo().printPreorden();     
			}
		System.out.println(this.getDatoRaiz());  
		if (!this.getHijoDerecho().esVacio()){     
			this.getHijoDerecho().printPreorden();    
			}  
	}
	
	public void printPostorden() {  
		if (!this.getHijoIzquierdo().esVacio()) {     
			this.getHijoIzquierdo().printPreorden();     
			} 
		if (!this.getHijoDerecho().esVacio()){     
			this.getHijoDerecho().printPreorden();    
			}
		System.out.println(this.getDatoRaiz()); 
	}
	
	/*public ListaGenericaEnlazada<T> recursion(ArbolBinario<T> a,ListaGenericaEnlazada<T> l){ otra forma de hacer la recursion de frontera
		if (a.getDatoRaiz()!=null) {
			if (a.esHoja())
				l.agregarFinal(a.getDatoRaiz());
			recursion(a.getHijoIzquierdo(),l);
			recursion(a.getHijoDerecho(),l);
		}
		if (l.tamanio()>=1)
			return l;
		return null;
	}*/
	
	private void preordenFrontera(ListaGenerica<T>  l, ArbolBinario<T> ab) {    
		if (ab.esHoja()) {      
			l.agregarFinal(ab.getDatoRaiz());    
			}    
		if (!ab.getHijoIzquierdo().esVacio()) {      
			ab.getHijoIzquierdo().preordenFrontera(l, ab.getHijoIzquierdo());
		}    
		if (!ab.getHijoDerecho().esVacio()) {      
			ab.getHijoDerecho().preordenFrontera(l, ab.getHijoDerecho());    
		}  
	}
	
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l=new ListaGenericaEnlazada<T>();
		this.preordenFrontera(l,this);
		return l;
	}
	
	public boolean lleno() { 
		ArbolBinario<T> arbol = null; 
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>(); 
		boolean lleno = true;
		cola.encolar(this); 
		int cant_nodos=0;
		cola.encolar(null); 
		int nivel= 0; 
		while (!cola.esVacia() && lleno) { 
			 arbol = cola.desencolar(); 
			 if (arbol != null) { 
				 System.out.print(arbol.getDatoRaiz());
				 if (!arbol.getHijoIzquierdo().esVacio()) { 
					 cola.encolar(arbol.getHijoIzquierdo());
					 cant_nodos++;
				 }
				 if (!(arbol.getHijoDerecho().esVacio())) { 
					 cola.encolar(arbol.getHijoDerecho());
					 cant_nodos++;
				 }
			 }
			 else
				 if (!cola.esVacia()) {
					 if (cant_nodos == Math.pow(2, ++nivel)){ 
						 cola.encolar(null); 
						 cant_nodos=0;
						 System.out.println(); 
					 }
				 	 else lleno=false;
				}
		}
		return lleno;
	}
	
	public boolean completo() { 
		/*la logica seria hacer recorrido por niveles hasta h-1 y despues verifico si un hijo es vacio todos los siguientes deben serlo en ese misma altura.
		  distintos casos(un arbol que no tiene hijos izquierdos y adelante de eso ninguno del los arboles tendra hijos derecho y todo lo demas ser hoja)
		  (encuentro uno que es hoja todo lo que sigue tiene que ser hoja)
		  (si tiene solo hijo derecho devuelve falso)
		*/
        return true;
    }
}