#include <stdio.h>
#include <stdlib.h>
int * reservamem(int);
void inia(float *, int);
float calculoprom(float *,int);
int main()
{
    srand(time(NULL));
    int num,mayornum=0;
    float *arreglo;
    printf("ingrese un numero para inicializar un arreglo de enteros: ");
    scanf("%d",&num);
    arreglo=reservamem(num);
    inia(arreglo,num);
    printf("el mayor numero del arreglo es %.2f",calculoprom(arreglo,num));
    free(arreglo);
    return 0;
}
int * reservamem(int num){
    return ((int *) malloc(num*sizeof(float)));
}
void inia(float *arreglo, int num){
    int i;
    for (i=0;i<num;i++){
        printf("ingrese un numero floatante: ");
        scanf("%f",&arreglo[i]);
    }
}
float calculoprom(float *arreglo,int num){
    int i;
    float prom=0;
    for (i=0;i<num;i++){
        prom=prom+arreglo[i];
    }
    return (prom/num);
}
