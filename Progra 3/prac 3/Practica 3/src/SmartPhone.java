
public class SmartPhone extends Mobile{
	private int numero;
	public SmartPhone() {
	}
	public SmartPhone(int numero,String marca, String sistemaOperativo, String modelo, double costo) {
		super(marca,sistemaOperativo,modelo,costo);
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean equals(Object o) {
		boolean result=false;  
		if ((o!=null) && (o instanceof Tablet)){   
			SmartPhone s=(SmartPhone)o;   
			if ((s.getNumero()==this.getNumero()) && (s.getCosto()==super.getCosto())
					&&(s.getMarca()==super.getMarca()) && (s.getModelo()==super.getModelo())
					&&(s.getSistemaOperativo()==super.getSistemaOperativo()))  
				result=true;  
			}  
		return result; 
		}
		public String toString() {
			return super.devolverDatos()+"numero: "+this.numero;
		}
}
