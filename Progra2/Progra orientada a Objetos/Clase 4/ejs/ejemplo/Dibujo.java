public class Dibujo {
    private String titulo;
    private String autor;
    private int cantFiguras=0;
    
    public Dibujo(String titulo, String autor){
       this.setTitulo(titulo);
       this.setAutor(autor);
    }
    
    public Dibujo(){
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public int getCantFiguras(){
        return cantFiguras;
    }
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    
    public void setAutor(String autor){
        this.autor=autor;
    }
    
    public void AniadirFigura(){
        cantFiguras++;
    }
    
    public boolean estaLleno(int max){
        return cantFiguras==max;
    }
    
    public String mostrar(){
        return ("El titulo es " + titulo + " el autor es " + autor + " cantidad de figuras " + cantFiguras);
    }
}