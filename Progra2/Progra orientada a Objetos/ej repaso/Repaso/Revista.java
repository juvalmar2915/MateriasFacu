public class Revista extends Ejemplar
{
    String nombre;
    int numvolumen;
    public Revista(int codi,int cantpags,String resumen,int anopublicacion,Responsable responsable,String nombre,int numvolumen)
    {
     super(codi,cantpags,resumen,anopublicacion,responsable);
     this.setNombre(nombre);
     this.setNumvolumen(numvolumen);
    }
    
    public Revista(){
    }
    
    public void setNombre(String nombre)
    {
     this.nombre=nombre;
    }
    
    public String getNombre()
    {
     return nombre;
    }
    
    public void setNumvolumen(int numvolumen){
     this.numvolumen=numvolumen;    
    }
    
    public int getNumvolumen(){
     return numvolumen;    
    }
    public String toString(){
     if (getAnopublicacion()==0)
        this.numvolumen=Generador.getNroVolumen();
     return ("Nombre: "+getNombre()+" num volumen: "+getNumvolumen());
    }
}
