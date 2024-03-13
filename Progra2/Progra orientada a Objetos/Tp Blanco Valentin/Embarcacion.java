public class Embarcacion extends Vehiculo
{
    private int REY;
    private String tipoembarcacion;
    private String nombre;
    private double eslora;
    private double tonelaje;
    private double valordeclarado;
    public Embarcacion(int REY,String nombre,String tipoembarcacion,double eslora,double tonelaje,double valordeclarado,int anofabricacion,double importebasico,Propietario propietario)
    {
     super(anofabricacion,importebasico,propietario);
     this.setRey(REY);
     this.setNombre(nombre);
     this.setTipoembarcacion(tipoembarcacion);
     this.setEslora(eslora);
     this.setTonelaje(tonelaje);
     this.setValordeclarado(valordeclarado);
    }
    
    public Embarcacion(){
    }
    
    public void setNombre(String nombre)
    {
     this.nombre=nombre;
    }
    
    public void setRey(int REY)
    {
     this.REY=REY;
    }
    
    public void setTipoembarcacion(String tipoembarcacion)
    {
     this.tipoembarcacion=tipoembarcacion;
    }
    
    public void setEslora(double eslora)
    {
     this.eslora=eslora;
    }
    
    public void setTonelaje(double tonelaje)
    {
     this.tonelaje=tonelaje;
    }
    
    public void setValordeclarado(double valordeclarado)
    {
     this.valordeclarado=valordeclarado;
    }
    
    public String getNombre()
    {
     return nombre;
    }
    
    public int getRey()
    {
     return REY;
    }
    
    public String getTipoembarcacion()
    {
     return tipoembarcacion;
    }
    
    public double getEslora()
    {
     return eslora;
    }
    
    public double getTonelaje()
    {
     return tonelaje;
    }
    
    public double getValordeclarado()
    {
     return valordeclarado;
    }
    
    public String toString()
    {
     String aux;
     aux="Embarcacion de REY: "+getRey()+ ", es un/a: "+getTipoembarcacion()+", de peso: "+getTonelaje();
     return aux;
    }
    
    public double calcularCostos(){
     if (getValordeclarado()<=6000)
      return (getValordeclarado()+(valordeclarado*4)/100);
     else
      if (getValordeclarado()>6000 && getValordeclarado()<=180000)
        return (getValordeclarado()+(valordeclarado*2)/100);
      else
        return (getValordeclarado()+(valordeclarado*5)/100);
    }    
}