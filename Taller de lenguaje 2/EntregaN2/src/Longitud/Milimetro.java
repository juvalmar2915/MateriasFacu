package Longitud;
import Magnitud.Conversoraotrosist;
import Magnitud.Magnitud;
public class Milimetro extends LongInt{
	public double convertir(String transformar) {
		switch (transformar) {
		case "km":
			return (this.getCifra()/1000000);
		case "cm":
			return (this.getCifra()/10);
		case "m":
			return (this.getCifra()/1000);
		default:
			return this.getCifra();
		}
	};
	public double suma(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongIng) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("pie",m.convertir("pie"));
				this.setCifra(this.getCifra()+aux*1000);
			}
			else 
				this.setCifra(this.getCifra()+m.convertir("mm"));
		}
		return 0;
	};
	public double resta(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongIng) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("pie",m.convertir("pie"));
				this.setCifra(this.getCifra()-aux*1000);
			}
			else 
				this.setCifra(this.getCifra()-m.convertir("mm"));
		}
		return 0;
	};
	public boolean comparar(Magnitud m) {
		if (m instanceof Longitud){
			if (m instanceof LongIng) {
				double aux; 
				aux= Conversoraotrosist.cambiarSistemaLong("pie",m.convertir("pie"));
				if ((aux*1000) == this.getCifra())
					return true;
			}
			else
				if (this.getCifra() == m.convertir("mm"))
					return true;
		}
		return false;
	};
}
