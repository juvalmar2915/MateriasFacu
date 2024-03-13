package Longitud;
import Magnitud.Conversoraotrosist;
import Magnitud.Magnitud;

public class Yarda extends LongIng{
	public double convertir(String transformar) {
		switch (transformar) {
		case "pie":
			return (this.getCifra()*3);
		case "pulgada":
			return (this.getCifra()*36);
		default:
			return this.getCifra();
		}
	};
	public double suma(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				this.setCifra(this.getCifra()+aux/3);
			}
			else 
				this.setCifra(this.getCifra()+m.convertir("yarda"));
		}
		return 0;
	};
	public double resta(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				this.setCifra(this.getCifra()-aux/3);
			}
			else 
				this.setCifra(this.getCifra()-m.convertir("yarda"));
		}
		return 0;
	};
	public boolean comparar(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongInt) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("metro",m.convertir("m"));
				if ((aux/3) == this.getCifra())
					return true;
			}
			else
				if (this.getCifra() == m.convertir("yarda"))
					return true;
		}
		return false;
	};
}
