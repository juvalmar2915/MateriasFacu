import java.util.Scanner;
public class Ej3{
  public static void main(String[] Args){
    Scanner in = new Scanner(System.in);
    System.out.println("Ingrese patente del micro");
    String p = in.next();
    System.out.println("Ingrese destino");
    String d = in.next();
    System.out.println("Ingrese hora de salida");
    int h = in.nextInt();
    Micro m = new Micro(h,p,d);
    System.out.println("Ingrese numero de asiento estimado pasajero");
    int a = in.nextInt();
    while ((a!=-1)&&(m.microLleno()==false)){
      if (m.validarAsiento(a)==true)
      {
        if (m.validarEstado(a)==true){
          m.ocuparAsiento(a);
          System.out.println("Disfrute el viaje");
        }
        else{
          System.out.println("El asiento esta ocupado");
          System.out.println("El proximo asiento vacio es: "+m.primerLibre());
        }
      }
      else{ 
      System.out.println("El asiento ingresado es invalido"); 
      }
    System.out.println("Ingrese numero de asiento estimado pasajero");
    a = in.nextInt();
  }
  System.out.println("Cantidad de asientos ocupados: "+m.asientosOcupados());
 }
}
