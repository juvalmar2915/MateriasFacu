#include <stdio.h>
#include <stdlib.h>
void Leer(int *, int, int);
void mostrar(int * , int , int );
int main()
{  int N, M;
   int * matBLOQUE;
   printf("Ingrese nro. filas :");
   scanf("%d", &N);
   printf("Ingrese nro. columnas :");
   scanf("%d", &M);
   matBLOQUE = (int *) malloc(N*M*sizeof(int));
   Leer(matBLOQUE, N, M);
   mostrar(matBLOQUE, N, M);
   free(matBLOQUE);
   return(0);
}

void Leer(int * matriz, int FIL, int COL){
   int f,c;
   for (f=0; f<FIL; f++){
    for (c=0; c<COL; c++){
        printf("ingrese un numero entero:");
        scanf("%d",&matriz[COL * f + c]);
//      scanf("%d",(matriz + COL * f + c));
    }
   }
}
void mostrar(int * matriz, int FIL, int COL){
   int f,c;
   for (f=0; f<FIL; f++){
    for (c=0; c<COL; c++)
         printf("%2d  ", matriz[COL*f + c]);
    printf("\n");
   }
   printf("\n");
}
