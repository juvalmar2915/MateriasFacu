public class Flota{
  private Micro [] flota = new Micro[15];
  private int cantidadMicros;
  
  public Flota(){ 
    cantidadMicros=0;    
  }
  public boolean estaCompleta(){
    return (cantidadMicros==14);    
  }
  public void agregarMicro(Micro m){
    if (cantidadMicros<15){
      flota[cantidadMicros]=m;
      cantidadMicros++;
    }
  }
  public void eliminarMicro(String pat){
    int i=0;
    while ((i<cantidadMicros)&&(flota[i].getPatente().equals(pat)==false)){
      i++;    
    }
    for (int c=i; c<cantidadMicros;c++){
      flota[c]=flota[c+1];      
    }
    cantidadMicros--;
  }
  public Micro buscarMicroPorPatente(String pat){
    int i=0;
    while ((i<cantidadMicros)&&(flota[i].getPatente().equals(pat)==false)){
      i++;    
    }
    if (i==15)
      return null;
    else {
      return flota[i];}
  }
  public Micro buscarMicroPorDestino(String des){
      int i=0;
      while ((i<cantidadMicros)&&(flota[i].getDestino().equals(des)==false)){
        i++;    
      }
      if (i==15)
        return null;
      else 
        return flota[i];         
  }
  public void imprimirFlota(){
    for (int i=0; i<cantidadMicros;i++)
      System.out.println(flota[i].getPatente()+" ");    
  }
}