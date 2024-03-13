#include <stdio.h>
#include <stdlib.h>
double * reservamem(int);
void inia(double *, int);
double calculoprom(double *,int);
void inia2(double *, int);
double calculoprom2(double *,int);
int main()
{
    int num;
    printf("ingrese un numero para inicializar un arreglo de reales: ");
    scanf("%d",&num);
    double *arreglo=reservamem(num);
    inia2(arreglo,num);
    printf("el mayor numero del arreglo es %.2f",calculoprom2(arreglo,num));
    free(arreglo);
    return 0;
}
double * reservamem(int num){
    return ((double *) malloc(num*sizeof(double)));
}
void inia(double *arreglo, int num){
    int i;
    for (i=0;i<num;i++){
        printf("ingrese un numero real: ");
        scanf("%lf",&arreglo[i]);
    }
}
double calculoprom(double *arreglo,int num){
    int i;
    float prom=0;
    for (i=0;i<num;i++){
        prom=prom+arreglo[i];
    }
    return (prom/num);
}

void inia2(double *arreglo, int num){
    int i;
    for (i=0;i<num;i++){
        printf("ingrese un numero real: ");
        scanf("%lf",arreglo++);
    }
}
double calculoprom2(double *arreglo,int num){
    int i;
    float prom=0;
    for (i=0;i<num;i++){
        prom=prom+*arreglo;
        arreglo++;
    }
    return (prom/num);
}
