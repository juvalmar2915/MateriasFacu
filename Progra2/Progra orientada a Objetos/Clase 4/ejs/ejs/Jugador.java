public class Jugador extends Empleado
{
    private int partidosjugados;
    private int golesanotados;
    public Jugador(String Nombre,double SueldoBasico,int pj,int ga)
    {
     super(Nombre,SueldoBasico);
     this.setPartidos(pj);
     this.setGoles(ga);
    }
    
    public Jugador(){
    }
    
    public void setPartidos(int pj)
    {
     partidosjugados=pj;
    }
    
    public void setGoles(int ga)
    {
     golesanotados=ga;
    }
    
    public int getPartidos()
    {
     return partidosjugados;
    }
    
    public int getGoles()
    {
     return golesanotados;
    }
    
    public double CalcularSueldoACobrar(){
     if (((double)golesanotados/partidosjugados)>0.5){
      return(getSueldoBasico()+getSueldoBasico());
     }
     else
      return(getSueldoBasico());
    }    
}
