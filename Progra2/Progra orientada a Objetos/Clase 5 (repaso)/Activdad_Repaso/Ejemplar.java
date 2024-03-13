

public abstract class Ejemplar{
 private int codigo;
 private int cantPaginas;
 private String resumen;
 private int añoPublicacion;
 private Responsable res;

 public Ejemplar(int codigo,int cantPaginas,String resumen,int añoPublicacion,Responsable resp){
     this.codigo = codigo;
     this.cantPaginas = cantPaginas;
     this.resumen = resumen;
     this.añoPublicacion = añoPublicacion;
     this.res = resp;
    }
 public Ejemplar (){
    }
 public void setCodigo(int codigo){
     this.codigo = codigo;
    }
 public void setCantPaginas(int cantPaginas){
     this.cantPaginas = cantPaginas;
    }
 public void setResumen(String resumen){
     this.resumen = resumen;
    }
 public void setAñoPublicacion(int añoPublicacion){
     this.añoPublicacion = añoPublicacion;
    }
 public void setRes(Responsable resp){
     this.res = resp;
    }
 public int getCodigo(){
     return codigo;
    }
 public int getCantPaginas(){
     return cantPaginas;
    }
 public String getResumen(){
     return resumen;
    }
 public int getAñoPublicacion(){
     return añoPublicacion;
    }
 public int getResponsableDni(){
     return res.getDni();
    }
 public String getResponsableNombre(){
     return res.getNombre();
    }
 public String getResponsableApellido(){
     return res.getApellido();
    }
 public abstract String toString();
 public abstract String toStringAño();
}

