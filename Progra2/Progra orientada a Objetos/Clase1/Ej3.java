import java.util.Scanner;
public class Ej3
{
      public static void main(String[] args)
  {
      Scanner in= new Scanner(System.in);
      int i1,i2=1;
      do{
       i1= in.nextInt();
      }while(i1<=0);
      for (i1=i1 ; i1>0 ; i1--)
      {
       i2=i1*i2;
      }
      System.out.println(i2);
  }

}
