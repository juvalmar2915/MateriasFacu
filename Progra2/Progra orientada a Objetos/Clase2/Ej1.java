import java.util.Scanner;
public class Ej1
{
    public static void main(String[] args)
    {
    Scanner in= new Scanner(System.in);
    Persona persona1=new Persona();
    System.out.println("Nombre:");
    persona1.setNombre(in.next());
    System.out.println("DNI:");
    persona1.setDNI(in.nextInt());
    System.out.println("Edad:");
    persona1.setEdad(in.nextInt());
    System.out.print(persona1.toString());
    }
}
