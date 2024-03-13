#include <stdio.h>
#include <stdlib.h>
float promedio(float [], int);
float minimo(float [], int);
int posicion(float [], int);
int main()
{
    float arreglo[5]={1.5,2.6,4.6,5,1.24};
    printf("el promedio de tu arreglo es: %.2f \n",promedio(arreglo,5));
    printf("el minimo de tu arreglo es: %.2f \n",minimo(arreglo,5));
    printf("la posicion de tu arreglo donde esta el maximo es: %d \n",posicion(arreglo,5));
    return 0;
}
float promedio(float a[], int c){
    float prom=0;
    int i;
    for (i=0;i<c;i++)
        prom=prom+a[i];
    prom=prom/c;
    return prom;
}
float minimo(float a[], int c){
    float min=999;
    int i;
    for (i=0;i<c;i++){
        if (a[i]<min)
            min=a[i];
    }
    return min;
}
int posicion(float a[], int c){
    float max=-1;
    int i,pos;
    for (i=0;i<c;i++){
        if (a[i]>max){
            max=a[i];
            pos=i;
        }
    }
    return pos;
}
