package parcial;
import prog3.arbol.general.*;
import prog3.listagenerica.*;
// debe devolver una lista con los niveles donde sea false y todos los hijos sean true
public class Parcial {
	public static ListaGenerica<Integer> resolver(ArbolGeneral<Boolean> arbol){
		ListaGenericaEnlazada<Integer> lista=new ListaGenericaEnlazada<Integer>();
		lista.comenzar();
		if (!arbol.esVacia())
			recuresolver(arbol,lista,false,0,true,0);
		return lista;
	}
	private static void recuresolver(ArbolGeneral<Boolean> a, ListaGenericaEnlazada<Integer> l,boolean condicion,int nivel,boolean esultimohijo, int nivact) {
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Boolean>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Boolean>>();
			hijos=a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				if ((condicion==false) && (a.getDatoRaiz()==false)) {
					recuresolver(hijos.proximo(),l,true,nivel,hijos.fin()==true,nivact+1);
				}
				else {
					if ((condicion==true) && (a.getDatoRaiz()==true)) {
						recuresolver(hijos.proximo(),l,true,nivel,hijos.fin()==true,nivact+1);
					}
					else {
						if ((condicion==false) && (a.getDatoRaiz()==true)) {
							recuresolver(hijos.proximo(),l,false,nivel,hijos.fin()==true,nivact+1);
						}
						else {
							recuresolver(hijos.proximo(),l,true,nivact,hijos.fin()==true,nivact+1);
						}
					}
				}
			}
		}
		else {
			if ((condicion==true) && (esultimohijo==true) && (a.getDatoRaiz()!=false)){
				l.agregarInicio(nivel);
			}
		}
	}
	private static boolean recuresolver2(ArbolGeneral<Boolean> a,ListaGenericaEnlazada<Integer> l, int niv) {
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Boolean>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Boolean>>();
			hijos=a.getHijos();
			hijos.comenzar();
			boolean condicion=true;
			while (!hijos.fin()) {
				condicion=(recuresolver2(hijos.proximo(),l,niv+1) && condicion);
			}
			if ((a.getDatoRaiz()==false) && (condicion==true)) {
				l.agregarFinal(niv);
			}
			return (condicion && a.getDatoRaiz());
		}
		else {
			return (a.getDatoRaiz());
		}
	}
	
}
