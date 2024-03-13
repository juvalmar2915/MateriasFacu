import java.util.Scanner;
public class Ej3
{
    public static void Ej3(String[] args)
    {
       Entrenador entrenador= new Entrenador();
       Scanner in= new Scanner (System.in);
       entrenador.setNombre(in.next());
       entrenador.setSueldo(in.nextDouble());
       entrenador.setCampeonatos(in.nextInt());
       System.out.println(entrenador.getNombre());
       System.out.println(entrenador.getSueldo());
       System.out.println(entrenador.getCampeonatos());
       System.out.println(entrenador.calcularSueldoACobrar());
    }
}
