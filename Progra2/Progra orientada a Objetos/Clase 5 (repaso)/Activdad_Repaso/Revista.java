

public class Revista extends Ejemplar{
 private String nombre;
 private double volumen;
 private int cantArticulos;
 
 public Revista(int codigo,int cantPaginas,String resumen,int añoPublicacion,Responsable resp, String nombre,double volumen,int cantArticulos){
    super(codigo,cantPaginas,resumen,añoPublicacion,resp);
    this.nombre = nombre;
    this.volumen = volumen;
    this.cantArticulos = cantArticulos;
    }
 public Revista(){
     super();
    }
 public void setNombre(String nombre){
     this.nombre = nombre;
    }
 public void setVolumen(double volumen){
     this.volumen = volumen;
    }
 public void setCantArticulos(int cantArticulos){
     this.cantArticulos = cantArticulos;
    }
 public String getNombre(){
     return nombre;
    }
 public double getVolumen(){
     return volumen;
    }
 public int getCantArticulos(){
     return cantArticulos;
    }
 public String toString(){
    return("Nombre: "+nombre+" volumen: "+volumen+" ");
}
 public String toStringAño(){
     volumen = Generador.getNroVolumen();
     return("Nombre: "+nombre+" Volumen: "+volumen);
    }
}
