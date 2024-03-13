#include <stdio.h>
#include <stdlib.h>
int ** reservarMemoria(int);
void Cargar(int **, int);
void mostrar(int ** , int);
void liberarMemoria(int ** , int );
int main()
{  int N;
   int ** mat;
   printf("Ingrese nro. filas y columnas:");
   scanf("%d", &N);
   mat = reservarMemoria(N);
   Cargar(mat, N);
   mostrar(mat, N);
   liberarMemoria(mat, N);
   return(0);
}
int ** reservarMemoria(int N){
    int ** aux, i;
    aux = (int **)malloc(N*sizeof(int*));
    for (i=0; i<N; i++)
        aux[i]= (int *)malloc(N*sizeof(int));

    return(aux);
}
void liberarMemoria(int ** mat, int N){
    int i;
    for (i=0; i<N; i++)
        free(mat[i]);
    free(mat);
}
void Cargar(int ** matriz, int FILyCOL){
   int f,c,suma, col=0;
   for (f=0; f<FILyCOL; f++){
    for (c=0; c<=col; c++){
        if ((c==0) || (c==col)){
            matriz[f][c]=1;
        }
        else{
            if ((c>0) && (c<f)){
                suma=matriz[f-1][c-1]+matriz[f-1][c];
                matriz[f][c]=suma;
            }
        }
    }
   col++;
   }
}
void mostrar(int ** matriz, int FILyCOL){
   int f,c;
   for (f=0; f<FILyCOL; f++){
    for (c=0; c<FILyCOL; c++){
        if ((c>=0) && (c<=f))
            printf("  %2d  ", matriz[f][c]);
    }
    printf("\n");
   }
   printf("\n");
}
