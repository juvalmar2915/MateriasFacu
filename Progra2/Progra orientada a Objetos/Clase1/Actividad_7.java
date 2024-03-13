import java.util.Scanner;
public class Actividad_7{
 public static void main(String[] Args){
     int [] operaciones = new int[5];
     int i;
     for(i=0; i<=4; i++){
       operaciones[i]=0;   
     }
     Scanner in = new Scanner(System.in);
     System.out.println("0 - cobro de cheque"); 
     System.out.println("1 - depósito/ extracción en cuenta"); 
     System.out.println("2 - pago de impuestos o servicios");
     System.out.println("3 - cobro de jubilación");
     System.out.println("4 - cobro de planes");
     System.out.println("Ingrese la operacion que desea realizar");
     int op = in.nextInt();
     while((op>4)&&(op!=999)){
         System.out.println("Ingrese un numero valido");
         op = in.nextInt();
     }
     while(op!=999){
       operaciones[op] = operaciones[op]+1;
       System.out.println(" ");
       System.out.println("0 - cobro de cheque"); 
       System.out.println("1 - depósito/ extracción en cuenta"); 
       System.out.println("2 - pago de impuestos o servicios");
       System.out.println("3 - cobro de jubilación");
       System.out.println("4 - cobro de planes");
       System.out.println("Ingrese la operacion que desea realizar");
       op = in.nextInt();
       while((op>4)&&(op!=999)){
         System.out.println("Ingrese un numero valido");
         op = in.nextInt();
        }
     }
     int max = -1;
     int m = 0;
     for(i=0; i<=4; i++){
       System.out.print(operaciones[i] + "  ");
       if(operaciones[i]>max){
           max=operaciones[i];
           m = i;
       }
     }
     System.out.println(" ");
     System.out.println("La operacion mas realizada fue: " + m);
   }
}
