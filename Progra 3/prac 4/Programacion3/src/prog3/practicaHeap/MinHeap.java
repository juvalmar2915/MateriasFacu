package prog3.practicaHeap;

public class MinHeap<T> {
		private T[] datos; 
		private int cantEltos;
		
		public MinHeap() {
			this.datos = (T[]) new Comparable[100];
			this.cantEltos = 100;
		}
		
		public MinHeap(T[] datos) {
			this.datos = datos;
		}
		
		
		
}
