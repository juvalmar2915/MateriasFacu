import java.util.Scanner;
public class ProgramaArba
{
 public static void main(String[] args){
  Vehiculo [] vehiculos=new Vehiculo[1000];
  Scanner in=new Scanner(System.in);
  boolean salir=false;
  int i=0;
  int z;
  while (i<1000 && salir==false){
   System.out.println("1:automotor");
   System.out.println("2:embarcacion");
   System.out.println("3:salir");
   z=in.nextInt();
   if (z==1){
    System.out.println("Ingrese datos del propietario: 1ro el CIT, 2do el Nombre y para finalizar el Apellido");
    Propietario p=new Propietario(in.nextInt(),in.next(),in.next());
    System.out.println("Ingrese datos del Automotor: la patente, el importeadicional, la descripcion, el año de fabricacion y el importebasico todo en su respectivo orden");
    vehiculos[i]=new Automotor(in.next(),in.nextDouble(),in.next(),in.nextInt(),in.nextDouble(),p);
    i++;
   }
   if (z==2){
    System.out.println("Ingrese datos del propietario: 1ro el CIT, 2do el Nombre y para finalizar el Apellido");
    Propietario p=new Propietario(in.nextInt(),in.next(),in.next());
    System.out.println("Ingrese datos de la Embarcacion: Su REY,el nombre,el tipoembarcacion,el eslora,su tonelaje,el valordeclarado,el año de fabricacion y el importebasico todo en su respectivo orden");
    vehiculos[i]=new Embarcacion(in.nextInt(),in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextDouble(),in.nextInt(),in.nextDouble(),p);
    i++;   
   }
   if (z==3){
    salir=true;
   }
   }
  for (int x=0; x<i;x++){
   System.out.println(vehiculos[x].toString()+", y el costo del impuesto a pagar por el mes de diciembre de 2019 es de: "+vehiculos[x].calcularCostos());
  }
  }
 }