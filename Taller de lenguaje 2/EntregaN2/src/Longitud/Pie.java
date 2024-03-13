package Longitud;
import Magnitud.Conversoraotrosist;
import Magnitud.Magnitud;

public class Pie extends LongIng{
	public double convertir(String transformar) {
		switch (transformar) {
		case "pulgada":
			return (this.getCifra()*12);
		case "yarda":
			return (this.getCifra()/3);
		default:
			return this.getCifra();
		}
	};
	public double suma(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				this.setCifra(this.getCifra()+aux);
			}
			else 
				this.setCifra(this.getCifra()+m.convertir("pie"));
		}
		return 0;
	};
	public double resta(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				this.setCifra(this.getCifra()-aux);
			}
			else 
				this.setCifra(this.getCifra()-m.convertir("pie"));
		}
		return 0;
	};
	public boolean comparar(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				if (aux == this.getCifra())
					return true;
			}
			else
				if (this.getCifra() == m.convertir("pie"))
					return true;
		}
		return false;
	};
}
