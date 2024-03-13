public class Ej4
{
      public static void main(String[] args)
  {
      int i1, i2, i3;
      for (i1=1 ; i1<10 ; i1++)
      {
       i2=1;
       for (i3=i1; i3>0; i3--)
        i2=i3*i2;
       System.out.println(i2);
      }
      for (i1=1 ; i1<10 ; i1+=2)
      {
       i2=1;
       for (i3=i1; i3>0; i3--)
        i2=i3*i2;
       System.out.println(i2);
      }
  }

}
