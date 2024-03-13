import java.util.Scanner;
public class Ej6
{
    public static void main(String[] args)
    {
        int [][] matriz = new int[10][10];
        int [] vector= new int[10];
        int i, j;
        for (i=0;i<10;i++)
           for (j=0;j<10;j++)
             matriz[i][j]=i*20+j*2;
        for (i=0;i<10;i++)
           for (j=0;j<10;j++)  
             System.out.println(matriz[i][j]);
        int suma=0;
        for (i=2;i<=9;i++)
           for (j=0;j<=3;j++)  
             suma=suma+matriz[i][j];
        System.out.println(suma);
        for (i=0;i<10;i++)
           vector[i]=0;
        for (i=0;i<10;i++)
           for (j=0;j<10;j++)  
             vector[i]=vector[i]+matriz[j][i];
        Scanner in= new Scanner(System.in);
        int valor=in.nextInt();
        boolean buscar=false;
        i=0;
        j=0;
        while ((buscar==false) &&(i!=10))
        {
             j=0;
             while ((buscar==false) &&(i!=10)&&(j!=10))
             {
               if (valor==matriz[i][j])
                 buscar=true;
               j++;
             }
             i++;
         }
        if (buscar==true)
          System.out.println ("se encontro elemento en fila " + i + " y en la columna" + j);
        else
          System.out.println ("no se encontro el elemento");
    }
}
