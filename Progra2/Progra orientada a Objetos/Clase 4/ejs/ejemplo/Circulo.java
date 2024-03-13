/*
 * @author vsanz
 */
public class Circulo extends Figura{
    
    private double radio;
 
    
       /* AÑADIDO TEMA 4 */
    public Circulo(double nuevoRadio, String nuevoCR, String nuevoCL, Punto unPunto){
        super(nuevoCR,nuevoCL,unPunto);
        radio= nuevoRadio;   
    } 
    
    public Circulo(){
    }
    
    public double getRadio(){
        return radio;       
    }
  
    public void setRadio(double nuevoRadio){
        radio=nuevoRadio;
    }
  
    public double calcularArea(){
       return (Math.PI*radio*radio);
    }
    
    public double calcularPerimetro(){
       return (2*Math.PI*radio);
    }
    
    public String dibujar(){
        return ("Circulo: "+super.dibujar()+" Radio: " + radio);
    }

}
