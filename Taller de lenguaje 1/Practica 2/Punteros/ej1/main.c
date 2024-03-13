#include <stdio.h>
#include <stdlib.h>
void promminypos(float[],int,float *,float *, int *);
int main(){
    float arreglo[]={2.3,5.6,7.3,8.7,5};
    float ptrmin=999, ptrprom=0;
    int ptrpos;
    promminypos(arreglo,5,&ptrprom,&ptrmin,&ptrpos);
    printf("el minimo del arreglo es: %.2f \n",ptrmin);
    printf("el promedio del arreglo es: %.2f \n",ptrprom);
    printf("la posicion del maximo del arreglo es: %d \n",ptrpos);
    return 0;
}
void promminypos(float a[],int dim,float *pprom, float *pmin,int *ppos){
    int i;
    float max=0;
    for (i=0;i<dim;i++){
        if (a[i]<*pmin)
            *pmin=a[i];
        if (a[i]>max){
            max=a[i];
            *ppos=i+1;
        }
        *pprom=*pprom+a[i];
    }
    *pprom=*pprom/dim;
}
