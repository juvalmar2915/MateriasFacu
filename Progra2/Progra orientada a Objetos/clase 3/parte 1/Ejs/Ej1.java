import java.util.Scanner;
public class Ej1
{
    public static void Ej1(String[] args)
    {
       Triangulo trianguilo= new Triangulo();
       Scanner in= new Scanner (System.in);
       trianguilo.setL1(in.nextDouble());
       trianguilo.setL2(in.nextDouble());
       trianguilo.setL3(in.nextDouble());
       trianguilo.setCr(in.next());
       trianguilo.setCl(in.next());
       System.out.println(trianguilo.calcularArea());
       System.out.println(trianguilo.calcularPerimetro());
    }
}
