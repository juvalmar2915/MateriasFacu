import java.util.Scanner;
public class Ej1
{
      public static void main(String[] args)
  {
      Scanner in= new Scanner(System.in);
      double d1= in.nextDouble(), d2= in.nextDouble(), d3= in.nextDouble();
      if ((d1 < d2 + d3) && (d2 < d1 + d3) && (d3 < d1 + d2))
       System.out.println(d1+d2+d3);
      in.close();
  }

}
