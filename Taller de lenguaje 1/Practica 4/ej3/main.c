#include <stdio.h>
#include <stdlib.h>
int ** reservarMemoria(int , int);
void Leer(int **, int, int);
void mostrar3(int ** , int , int );
void liberarMemoria(int ** , int );
int main()
{  int N, M;
   int ** mat;
   printf("Ingrese nro. filas :");
   scanf("%d", &N);
   printf("Ingrese nro. columnas :");
   scanf("%d", &M);
   mat = reservarMemoria(N,M);
   Leer(mat, N, M);
   mostrar3(mat, N, M);
   liberarMemoria(mat, N);

   return(0);
}
int ** reservarMemoria(int N, int M){
    int ** aux, i;
    aux = (int **)malloc(N*sizeof(int*));
    for (i=0; i<N; i++)
        aux[i]= (int *)malloc(M*sizeof(int));

    return(aux);
}
void liberarMemoria(int ** mat, int N){
    int i;
    for (i=0; i<N; i++)
        free(mat[i]);
    free(mat);
}
void Leer(int ** matriz, int FIL, int COL){
   int f,c;
   for (f=0; f<FIL; f++){
    for (c=0; c<COL; c++){
        printf("ingrese un entero: ");
        scanf("%d",&matriz[f][c]);
    }
   }
}

void mostrar3(int ** matriz, int FIL, int COL){
   int f,c;
   for (f=0; f<FIL; f++){
    for (c=0; c<COL; c++){
         if ((matriz[f][c]%3)==0)
            printf("%2d  ", matriz[f][c]);
    }
   }
   printf("\n");
}
