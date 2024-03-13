#include <stdio.h>
#include <stdlib.h>
int damepar();
int main()
{
    int numero;
    printf("escriba la cantidad de numeros pares que quiere: ");
    scanf("%d", &numero);
    int i;
    for (i=0;i<numero;i++)
        printf("%d \n",damepar());
    return 0;
}
int damepar()
{
    static int par=-2;
    par+=2;
    return par;
}
