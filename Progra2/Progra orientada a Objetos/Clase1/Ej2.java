import java.util.Scanner;
public class Ej2
{
      public static void main(String[] args)
  {
      Scanner in= new Scanner(System.in);
      int auto= in.nextInt(), total= 0, entraron= 0;
      while (auto != 0)
      {
          total++;
          if ((auto % 2) == 0)
            entraron++;
          auto= in.nextInt();   
      }
      System.out.println((double) entraron/total * 100 + '%');
  }

}
