/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vsanz
 */
public abstract class Figura extends Dibujo {
    private String colorRelleno;
    private String colorLinea;
    private Punto punto;
    
    public Figura(String colorR, String colorL, Punto p){
        this.setColorRelleno(colorR);
        this.setColorLinea(colorL);
        this.setPunto(p);
    }
    
    public Figura(){
    }
    
    public String getColorRelleno(){
        return colorRelleno;
    }
    
    public void setColorRelleno(String nuevoColor){
        colorRelleno = nuevoColor;
    }
    
    public String getColorLinea(){
        return colorLinea;
    }
    
    public void setColorLinea(String nuevoColor){
        colorLinea = nuevoColor;
    }
    
    public void setPunto(Punto nuevoPunto){
        punto=nuevoPunto;
    }
    
    public Punto getPunto(){
        return punto;
    }
    public String dibujar(){
        return ("Color de Linea: " + this.getColorLinea()+"Color de Relleno: " + this.getColorRelleno()+"Ubicación: " + this.getPunto().toString());
    }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
}
