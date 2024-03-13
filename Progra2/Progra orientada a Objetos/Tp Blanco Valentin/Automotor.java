public class Automotor extends Vehiculo
{
    private String patente;
    private double importeadicional;
    private String descripcion;
    public Automotor(String patente,double importeadicional,String descripcion,int anofabricacion,double importebasico,Propietario propietario)
    {
     super(anofabricacion,importebasico,propietario);
     this.setPatente(patente);
     this.setImporteadicional(importeadicional);
    }
    
    public Automotor(){
    }
    
    public void setPatente(String patente)
    {
     this.patente=patente;
    }
    
    public void setImporteadicional(double importeadicional)
    {
     this.importeadicional=importeadicional;
    }
    
    public String getPatente()
    {
     return patente;
    }
    
    public double getImporteadicional()
    {
     return importeadicional;
    }
    
    public String toString()
    {
     String aux;
     aux="Automotor de patente: "+getPatente()+ ", de año de fabricacion:"+getAnofabricacion();
     return aux;
    }
    
    public double calcularCostos(){
      return(getImportebasico()+getImporteadicional());
    }    
}
