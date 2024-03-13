import java.util.Scanner;
public class Programa_Ppal
{
    public static void Programa_Ppal(String[] args)
    {
       Scanner in= new Scanner (System.in);
       System.out.println("Entrenador");
       Entrenador entrenador= new Entrenador(in.next(),in.nextDouble(),in.nextInt());
       System.out.println(entrenador.CalcularSueldoACobrar());
       System.out.println(entrenador.toString());
       System.out.println("Jugador");
       Jugador jugador=new Jugador(in.next(),in.nextDouble(),in.nextInt(),in.nextInt());
       System.out.println(jugador.CalcularSueldoACobrar());
       System.out.println(jugador.toString());
    }
}