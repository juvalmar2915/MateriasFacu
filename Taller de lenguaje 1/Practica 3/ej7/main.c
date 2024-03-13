#include <stdio.h>
#include <stdlib.h>
int * reservamem(int);
void inia(int *, int);
int calculomax(int *,int);
int main()
{
    srand(time(NULL));
    int num,mayornum=0;
    int *arreglo;
    printf("ingrese un numero para inicializar un arreglo de enteros: ");
    scanf("%d",&num);
    arreglo=reservamem(num);
    inia(arreglo,num);
    printf("el mayor numero del arreglo es %d",calculomax(arreglo,num));
    free(arreglo);
    return 0;
}
int * reservamem(int num){
    return ((int *) malloc(num*sizeof(int)));
}
void inia(int *arreglo, int num){
    int i;
    for (i=0;i<num;i++){
        arreglo[i]=rand();
    }
}
int calculomax(int *arreglo,int num){
    int i,mayornum;
    for (i=0;i<num;i++){
        if (arreglo[i]>mayornum){
            mayornum=arreglo[i];
        }
    }
    return mayornum;
}
