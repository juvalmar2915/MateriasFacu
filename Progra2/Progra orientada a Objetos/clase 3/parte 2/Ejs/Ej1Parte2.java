import java.util.Scanner;
public class Ej1Parte2
{
    public static void Ej1Parte2(String[] args)
    {
       Scanner in= new Scanner (System.in);
       Triangulo triangulo1= new Triangulo(in.nextDouble(),in.nextDouble(),in.nextDouble(),in.next(),in.next());
       Triangulo triangulo2= new Triangulo();
       triangulo2.setL1(in.nextDouble());
       triangulo2.setL2(in.nextDouble());
       triangulo2.setL3(in.nextDouble());
       triangulo2.setCr(in.next());
       triangulo2.setCl(in.next());
       System.out.println(triangulo1.calcularArea());
       System.out.println(triangulo1.calcularPerimetro());
    }
}
