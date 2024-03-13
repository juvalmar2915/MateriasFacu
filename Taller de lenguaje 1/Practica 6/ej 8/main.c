#include <stdio.h>
#include <stdlib.h>
#define DEBUG 0
int busqueda(int [],int);
int main()
{
    srand(time(NULL));
    int num[1000],i;
    for (i=0;i<1000;i++){
        num[i]=rand();
    }
    int n;
    printf("escriba un numero a buscar: ");
    scanf("%d",&n);
    printf("el numero %d se encuentra en la posicion: %d",n,busqueda(num,n));
}
int busqueda(int n[],int numero){
    int i;
    for (i=0;i<1000;i++){
        if (n[i]==numero){
            break;
        }
    }
    #if DEBUG
        printf("se accedio a %d elementos \n",i);
    #endif // DEBUG
    if (i==1000){
        i=-1;
    }
    return i;
}
//c) difieren ya que en uno se habilita la impresion extra de una linea
