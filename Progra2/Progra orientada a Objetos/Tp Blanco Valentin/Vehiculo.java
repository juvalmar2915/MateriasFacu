public abstract class Vehiculo
{
    private double importebasico;
    private int anofabricacion;
    private Propietario propietario;
    public Vehiculo(int anofabricacion,double importebasico,Propietario propietario)
    {
     this.setImportebasico(importebasico);
     this.setAnofabricacion(anofabricacion);
     this.propietario=propietario;
    }
    
    public Vehiculo(){
    }
    
    public void setImportebasico(double importebasico)
    {
     this.importebasico=importebasico;
    }
    
    public void setAnofabricacion(int anofabricacion)
    {
     this.anofabricacion=anofabricacion;
    }
    
    public double getImportebasico()
    {
     return importebasico;
    }
    
    public int getAnofabricacion()
    {
     return anofabricacion;
    }
    
    public String getNombreResp()
    {
        return propietario.getNombre();
    }
    
    public abstract String toString();
    public abstract double calcularCostos();
}
