import java.util.Scanner;
public class Ej4
{
    public static void main(String[] args)
    {
     Scanner in= new Scanner(System.in);
     Partido [] partidos= new Partido[325];
     for (int i=0; i<325; i++){
      partidos[i]=new Partido();
      System.out.print("Nombre equipo local:");
      partidos[i].setLocal(in.next());
      System.out.println();
      System.out.print("Nombre equipo visitante:");
      partidos[i].setVisitante(in.next());
      System.out.println();
      System.out.print("Goles Local:");
      partidos[i].setGolesLocal(in.nextInt());
      System.out.println();
      System.out.print("Goles Visitante:");
      partidos[i].setGolesVisitante(in.nextInt());
      System.out.println();
     }
     int ganadosR=0,golesB=0,empate=0;
     for (int i=0; i<325; i++){
      if (partidos[i].getGanador().toLowerCase().equals("river"))
       ganadosR++;
      if (partidos[i].getLocal().toLowerCase().equals("boca"))
       golesB=partidos[i].getGolesLocal()+golesB;
      if (partidos[i].hayEmpate())
       empate++;
     }
     System.out.println("River gano: "+ ganadosR + " partidos");
     System.out.println("Boca de local hizo: "+ golesB + " goles");
     System.out.println("El porcentaje de partidos terminados en empate es de: "+ (double)empate/325);
    }
}
