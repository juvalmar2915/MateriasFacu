#include <stdio.h>
#include <stdlib.h>
int * reservarmem(int);
void Cargar(int *, int);
void mostrar(int * , int);
void liberarmem(int *);
int main(){
   srand(time(NULL));
   int N;
   int * matBLOQUE;
   printf("Ingrese nro. filas y columnas:");
   scanf("%d", &N);
   matBLOQUE = reservarmem(N);
   Cargar(matBLOQUE, N);
   mostrar(matBLOQUE, N);
   liberarmem(matBLOQUE);
   return(0);
}

int * reservarmem(int FILyCOL){
    return (int *) malloc(FILyCOL*FILyCOL*sizeof(int));
}
void Cargar(int * matriz, int FILyCOL){
   int f,c;
   for (f=0; f<FILyCOL; f++){
    for (c=0; c<FILyCOL; c++){
        if (c<=f)
            matriz[FILyCOL * f + c]=rand()%20;
    }
   }
}
void mostrar(int * matriz, int FILyCOL){
   int f,c;
   for (f=0; f<FILyCOL; f++){
    for (c=0; c<FILyCOL; c++){
        if (c<=f)
            printf("%2d  ", matriz[FILyCOL*f + c]);
    }
    printf("\n");
   }
   printf("\n");
}
void liberarmem(int * matriz){
    free(matriz);
}
