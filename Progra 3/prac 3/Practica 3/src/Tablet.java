
public class Tablet extends Mobile{
	private int pulgadas;
	public Tablet() {
	}
	public Tablet(int pulgadas,String marca, String sistemaOperativo, String modelo, double costo) {
		super(marca,sistemaOperativo,modelo,costo);
		this.pulgadas = pulgadas;
	}
	public int getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	public boolean equals(Object o) {
		boolean result=false;  
		if ((o!=null) && (o instanceof Tablet)){   
			Tablet t=(Tablet)o;   
			if ((t.getPulgadas()==this.getPulgadas()) && (t.getCosto()==super.getCosto())
					&&(t.getMarca()==super.getMarca()) && (t.getModelo()==super.getModelo())
					&&(t.getSistemaOperativo()==super.getSistemaOperativo()))  
				result=true;  
			}  
		return result; 
		}
	public String toString() {
		return super.devolverDatos()+"pulgadas: "+this.pulgadas;
	}
}
