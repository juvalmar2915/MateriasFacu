public class Libro extends Ejemplar
{
    private String titulo;
    private int cantcaps;
    private boolean esbolsillo;

    public Libro(int codi,int cantpags,String resumen,int anopublicacion,Responsable responsable,String titulo,int cantcaps,boolean esbolsillo)
    {
     super(codi,cantpags,resumen,anopublicacion,responsable);
     this.setTitulo(titulo);
     this.setCantcaps(cantcaps);
     this.setEsbolsillo(esbolsillo);
    }
    
    public Libro(){
    }
    
    public void setTitulo(String titulo)
    {
     this.titulo=titulo;
    }
    
    public void setCantcaps(int cantcaps)
    {
     this.cantcaps=cantcaps;
    }
    
    public void setEsbolsillo(boolean esbolsillo)
    {
     this.esbolsillo=esbolsillo;
    }
    
     public String getTitulo()
    {
     return titulo;
    }
    
     public int getCantcaps()
    {
     return cantcaps;
    }
    
    public boolean getEsbolsillo()
    {
     return esbolsillo;
    }
    
    public String toString(){
     if (getAnopublicacion()==0){
     if  (getEsbolsillo()==true)
      setTitulo(getTitulo()+"-De bolsillo");
     }
     return ("Codigo identificatorio: "+getCodi()+". Titulo: "+getTitulo()+". Nombre del responsable:"+getNombreResp());
    }
}
