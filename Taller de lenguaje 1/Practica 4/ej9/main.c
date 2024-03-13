#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,i,cant=1;
    int *arreglo;
    arreglo=(int *) malloc(sizeof(int));
    printf("escriba un numero del que quiera saber sus divisores: ");
    scanf("%d",&n);
    arreglo[0]=1;
    for (i=2; i<=n; i++){
        if ((n%i)==0){
            cant++;
            arreglo = (int *) realloc(arreglo, cant* sizeof(int));
            arreglo[cant-1]=i;
        }
    }
    printf("numero: %d \n",n);
    printf("divisores: ");
    for (i=0; i<cant; i++){
        printf("%d ",arreglo[i]);
    }
    free(arreglo);
    return 0;
}
