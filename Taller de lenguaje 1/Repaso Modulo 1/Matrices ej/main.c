#include <stdio.h>
#include <stdlib.h>

#define FIL 3
#define COL 4

int sumaUltimaFila(int *, int, int);

int main()
{
    int  V[FIL][COL] = {0}, *ptr;
    int * m=(int*) calloc(FIL*COL,sizeof(int));
    printf("%d   %d\n", sizeof(V), sizeof(m));
    V[1][1]=10;
    ptr = &V[1][0];
    *(ptr-2)=21;
    *(m+5)=21;
    *(ptr+5)=22;
    *(m+12*COL/4-1)=22;
    printf("La suma de los nros. ");
    printf("de la ultima fila de m es = \n");
    printf("%d\n",sumaUltimaFila(m, FIL, COL));
    printf("La suma de los nros. ");
    printf("de la ultima fila de V es = \n");
    printf("%d",sumaUltimaFila(V, FIL, COL));
    free(m);
    free(V);
    return 0;
}
sumaUltimaFila(int *m, int f, int c){
int i, suma=0;
for (i=0; i<c; i++){
    suma+=m[c*(f-1)+i];
}
return suma;
}
