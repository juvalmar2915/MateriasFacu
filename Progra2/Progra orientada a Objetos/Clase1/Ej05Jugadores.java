import java.util.Scanner;
public class Ej05Jugadores
{
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);
        double [] alturas = new double[15];
        double promedio = 0;
        for (int i=0; i<15; i++)
        {
            alturas[i]= in.nextDouble();
            promedio=promedio + alturas[i];
        }
        promedio=promedio/15;
        int jugadores=0;
        for (int x=0; x<15; x++)
        {
          if (promedio<alturas[x])
           jugadores++;
        }
        System.out.println((double) promedio);
        System.out.println(jugadores);
    }
}
