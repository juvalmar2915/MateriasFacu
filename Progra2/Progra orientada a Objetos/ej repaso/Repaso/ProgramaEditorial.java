import java.util.Scanner;
public class ProgramaEditorial
{
 public static void main(String[] args){
  Ejemplar [] ejemplar=new Ejemplar[1000];
  Scanner in=new Scanner(System.in);
  boolean salir=false;
  int i=0;
  int z;
  while (i<1000 && salir==false){
   System.out.println("1:libro");
   System.out.println("2:revista");
   System.out.println("3:salir");
   z=in.nextInt();
   if (z==1){
    Responsable r=new Responsable(in.nextInt(),in.next(),in.next());
    ejemplar[i]=new Libro(in.nextInt(),in.nextInt(),in.next(),in.nextInt(),r,in.next(),in.nextInt(),in.nextBoolean());
    i++;
   }
   if (z==2){
    Responsable r=new Responsable(in.nextInt(),in.next(),in.next());
    ejemplar[i]=new Revista(in.nextInt(),in.nextInt(),in.next(),in.nextInt(),r,in.next(),in.nextInt());
    i++;   
   }
   if (z==3){
    salir=true;
   }
   }
  for (int x=0; x<i;x++){
   System.out.println(ejemplar[x].toString());
  }
  for (int x=0; x<i;x++){
   if (ejemplar[x].getAnopublicacion()==0){
    ejemplar[x].setAnopublicacion(2019);
    System.out.println(ejemplar[x].toString());
   }
  }
 }
}
