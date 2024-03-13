

public class Libro extends Ejemplar{
   private String titulo;
   private int cantCapitulos;
   private boolean edicionBolsillo;
   
  public Libro(int codigo,int cantPaginas,String resumen,int añoPublicacion,Responsable resp,String titulo,int cantCapitulos,Boolean edicionBolsillo){
      super(codigo,cantPaginas,resumen,añoPublicacion,resp);
      this.titulo = titulo;
      this.cantCapitulos = cantCapitulos;
      this.edicionBolsillo = edicionBolsillo;
    }
  public Libro(){
      super();
    }
  public void setTitulo(String titulo){
      this.titulo = titulo;
    }
  public void setCantCapitulos(int cantCapitulos){
      this.cantCapitulos = cantCapitulos;
    }
  public void setEdicionBolsillo(boolean edicionBolsillo){
      this.edicionBolsillo = edicionBolsillo;
    }
  public String getTitulo(){
      return titulo;
    }
  public int getCantCapitulos(){
      return cantCapitulos;
    }
  public boolean getEdicionBolsillo(){
      return edicionBolsillo;
    }
  public String toString(){
      return("Codigo: "+super.getCodigo()+" Titulo:  "+titulo+" Nombre del responsable:  "+super.getResponsableNombre());
    }
  public String toStringAño(){
      if(edicionBolsillo == true){
          return("Titulo: "+ titulo+" - De Bolsillo");
        } else {
            return(" ");
        }
    }
}
