import java.util.Scanner;
public class ProgramPrin{
  public static void main(String[] Args){
    Scanner in = new Scanner(System.in);
    String p,d;
    int h;
    Flota f = new Flota();
    System.out.println("Ingrese patente del micro");
    p = in.next();
    while ((p.equals("zzz")==false) && (f.estaCompleta()==false)){
      System.out.println("Ingrese destino");
      d = in.next();
      System.out.println("Ingrese hora de salida");
      h = in.nextInt();
      f.agregarMicro(new Micro(h,p,d));
      System.out.println("Ingrese patente del micro");
      p = in.next();
    }
    System.out.println("Micros ingresados");
    f.imprimirFlota();
    System.out.println("Ingrese la patente del micro que desea eliminar");
    p = in.next();
    if (f.buscarMicroPorPatente(p)!=null){
      f.eliminarMicro(p);
      System.out.println("Micro borrado con exito");
      f.imprimirFlota();
    }
    else 
      System.out.println("No se encuentra el micro ingresado");
    System.out.println("Ingrese su destino"); 
    d = in.next();
    if (f.buscarMicroPorDestino(d)!=null){
      System.out.println("Debe tomar el micro "+f.buscarMicroPorDestino(d).getPatente());
      System.out.println("Hora de salida "+f.buscarMicroPorDestino(d).getHoraSalida());
    }
    else 
      System.out.println("Ningun colectivo va a esa direccion");
  }
}
