public abstract class Empleado
{
    private String Nombre;
    private double SueldoBasico;
    public Empleado(String Nombre,double SueldoBasico){
    this.setNombre(Nombre);
    this.setSueldoBasico(SueldoBasico);
    }
    
    public Empleado(){
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public double getSueldoBasico(){
        return SueldoBasico;
    }
    
    public void setNombre(String n){
        this.Nombre=n;
    }
    
    public void setSueldoBasico(double s){
        this.SueldoBasico=s;
    }
    
    public abstract double CalcularSueldoACobrar();
    
    public String toString(){
    return"El Empleado "+Nombre+",cobra $"+CalcularSueldoACobrar();
    }
}
