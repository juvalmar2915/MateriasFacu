public class Micro
{ 
    private boolean[] ocupado = new boolean[20];
    private int horasalida;
    private String patente;
    private String destino;
    public String getPatente()
    {
     return patente;
    }
    
    public String getDestino()
    {
     return destino;
    }
    
    public double getHoraSalida()
    {
     return horasalida;
    }
   
    public void setHoraSalida(int horasalida)
    {
     this.horasalida=horasalida;
    }
    
    public void setPatente(String patente)
    {
     this.patente=patente;
    }
    
    public void setDestino(String destino)
    {
     this.destino=destino;
    }
    
    public Micro( int horasalida,String patente, String destino){
         this.horasalida= horasalida;
         this.patente= patente; 
         this.destino= destino;
         int i;
         for (i=0; i<20; i++){
          ocupado[i]=false;
         }
    }
    
    public Micro(){
    }

    public int asientosOcupados()
    {
        int i;
        int cant=0;
        for (i=0; i<20; i++){
          if(ocupado[i]==true)
            cant++;
        }
        return cant;
    }
    
    public boolean microLleno()
    {
        return (asientosOcupados()==20); 
    }
    
    public boolean validarAsiento(int i)
    {
     return (i>=1 && i<=20);
    }
    
    public boolean validarEstado(int i)
    {
     boolean estalibre=true;
     if (ocupado[i]==true)
      estalibre=false;
     return estalibre;
    }
    
    public void ocuparAsiento(int i){
        ocupado[i] = true;
    }
    
    public void liberarAsiento(int i){
        ocupado[i] = false;
    }
    
    public int primerLibre(){
        int i=0;
        while ((ocupado[i]==true)&&(i<20))
          i++;
        if (i!=20) 
          return i;
        else return 21;  
    }
}
