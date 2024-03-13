import java.util.Scanner;
public class ProgramPrinEj2
{
   
     public static void main(String[] args){
         
         Scanner in = new Scanner(System.in);
        System.out.println("Ingresar Nombre");
        String n = in.nextLine();
        System.out.println("Ingresar Sueldo");
        double s = in.nextDouble();
        System.out.println("Ingresar Campeonatos Ganados");
        int c = (in.nextInt());
        Entrenador E = new Entrenador(n,s,c);
        System.out.println(E.toString());
        
    }
}