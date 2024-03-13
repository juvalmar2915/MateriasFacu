#include <stdio.h>
#include <stdlib.h>
#define cant 10
void inicializacion(int[]);
void imprimir(int []);
void ordenar(int []);
int main()
{
    int arreglo[cant]={0};
    inicializacion(arreglo);
    imprimir(arreglo);
    ordenar(arreglo);
    imprimir(arreglo);
    return 0;
}
void inicializacion(int a[]){
    int i;
    srand(time(NULL));
    for (i=0;i<cant;i++){
        a[i]=rand();
    }
}
void imprimir(int a[]){
    int i;
    for (i=0;i<cant;i++){
        printf("a[%d]: %d \n",i,a[i]);
    }
}
void ordenar(int a[]){
    int i, menor,aumento=0, ultimomin=-1;
    int aux[cant]={0};
    while (aumento<cant){
        menor=999999;
        for (i=0;i<cant;i++){
            if ((a[i]<menor) && (a[i]>ultimomin))
                menor=a[i];
        }
        ultimomin=menor;
        aux[aumento]=menor;
        aumento++;
    }
    for (i=0;i<cant;i++){
        a[i]=aux[i];
    }
}
