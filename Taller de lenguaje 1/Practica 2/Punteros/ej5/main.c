#include <stdio.h>
#include <stdlib.h>
void invertir(int [],int);
void swap(int *, int *);
int main()
{
    int arreglo[]={1,2,3,4};
    invertir(arreglo,4);
    int x;
    for (x=0;x<4;x++){
        printf("%d", arreglo[x]);
    }
    return 0;
}
void invertir(int a[],int dim){
    int i;
    for (i=0;i<dim;i++,dim--){
        swap(&a[i],&a[dim-1]);
    }
}
void swap(int *a, int *b) {
    int tmp;
    tmp = *a; // guarda el valor de a
    *a = *b;   // almacena b en a
    *b = tmp; // almacena a en b
}
