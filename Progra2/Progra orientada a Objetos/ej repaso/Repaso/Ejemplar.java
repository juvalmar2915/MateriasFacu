public abstract class Ejemplar
{
    private int codi;
    private int cantpags;
    private String resumen;
    private int anopublicacion=0;
    private Responsable responsable;
    public Ejemplar(int codi,int cantpags,String resumen,int anopublicacion,Responsable responsable)
    {
     this.setCodi(codi);
     this.setCantpags(cantpags);
     this.setResumen(resumen);
     this.setAnopublicacion(anopublicacion);
     this.responsable=responsable;
    }
    
    public Ejemplar(){
    }
    
    public void setCodi(int codi)
    {
     this.codi=codi;
    }
    
    public void setCantpags(int cantpags)
    {
     this.cantpags=cantpags;
    }
    
    public void setResumen(String resumen)
    {
     this.resumen=resumen;
    }
    
    public void setAnopublicacion(int anopublicacion)
    {
     this.anopublicacion=anopublicacion;
    }
    
    public int getCodi()
    {
     return codi;
    }
    
    public int getCantpags()
    {
     return cantpags;
    }
    
    public String getResumen()
    {
     return resumen;
    }
    
    public int getAnopublicacion()
    {
     return anopublicacion;
    }
    
    public String getNombreResp()
    {
        return responsable.getNombre();
    }
    
    public abstract String toString();
}
