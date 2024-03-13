public class Cuadrado extends Figura{
    private double l1;
    
    public Cuadrado(double l1, String nuevoCR, String nuevoCL, Punto unPunto){
        super(nuevoCR,nuevoCL,unPunto);
        this.setLado1(l1);
    }
    
    public double getLado1(){
        return l1;
    }
    
    public void setLado1(double l1){
        this.l1 = l1;
    }
    
    public double calcularArea(){
        return l1*l1;
    }
    
    public double calcularPerimetro(){
        return l1*4;
    }
    
    public String dibujar(){
     return ("Cuadrado: "+super.dibujar()+" Lado: " + l1);
    }
}