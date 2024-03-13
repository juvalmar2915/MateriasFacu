import java.util.Scanner;
public class Ej2
{
    public static void Ej1(String[] args)
    {
     double peso;
     Balanza ba=new Balanza();
     Scanner in= new Scanner (System.in);
     ba.iniciarCompra();
     System.out.println("Ingrese peso en kg y luego precio ");
     peso=in.nextDouble();
     while (peso!=0)
     {
      ba.registrarProducto(peso,in.nextDouble());
      System.out.println("Ingrese peso en kg y luego precio ");
      peso=in.nextDouble();
     }
     System.out.println(ba.devolverResumenDeCompra());
    }
}
