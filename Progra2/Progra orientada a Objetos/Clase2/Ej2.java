import java.util.Scanner;
public class Ej2
{
    public static int get65(Persona [] personas){
     int viejardos=0;
     for (int x=0; x<15; x++){
      if (personas[x].getEdad()>65)
       viejardos++;
     }
     return viejardos;
    }
    public static String getMenorDNI(Persona [] personas){
     int menordni=2140000000;
     String representacion=new String();
     for (int x=0; x<15; x++){
      if (personas[x].getDNI()<menordni){
       menordni=personas[x].getDNI();
       representacion=personas[x].toString();
      }
     }
     return representacion;
    }
    public static void main(String[] args)
    {
     Persona [] personas= new Persona[15];
     Scanner in= new Scanner(System.in);
     for (int i=0;i<15;i++){
      personas[i]=new Persona();
      System.out.println("Nombre:");
      personas[i].setNombre(in.next());
      System.out.println("DNI:");
      personas[i].setDNI(in.nextInt());
      System.out.println("Edad:");
      personas[i].setEdad(in.nextInt());
     }
     System.out.println("Hay " + get65(personas) + " mayores de 65");
     System.out.println(getMenorDNI(personas));
    }
    
}
