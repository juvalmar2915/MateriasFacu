package prog3.grafos.utiles;
import prog3.listagenerica.*;
public class RutaMinima {
		private ListaGenericaEnlazada<String> caminomascorto;
		boolean unicoboleto;
		public RutaMinima() {
			this.caminomascorto=new ListaGenericaEnlazada<String>();
			this.unicoboleto=true;
		}
		public void setCaminomascorto(ListaGenericaEnlazada<String> lista) {
			this.caminomascorto.comenzar();
			while(!this.caminomascorto.fin()) {
				this.caminomascorto.eliminarEn(0);
			}
			lista.comenzar();
			while(!lista.fin()) {
				this.caminomascorto.agregarFinal(lista.proximo());
			}
		}
		public void setNounicoboleto(String muelle) {
			if (this.caminomascorto.incluye(muelle))
				this.unicoboleto=false;
		}
		public String toString() {
			return(this.caminomascorto.toString()+this.unicoboleto);
		}
}
