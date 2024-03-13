package Parcial2;

public class Local {
	private String tipo;
    private int persona;
    
    public Local(String tipo, int persona) {
		super();
		this.tipo = tipo;
		this.persona = persona;
	}
	public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getPersona() {
        return persona;
    }
    public void setPersona(int persona) {
        this.persona = persona;
    }
}
