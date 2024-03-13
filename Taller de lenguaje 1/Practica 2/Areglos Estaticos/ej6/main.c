#include <stdio.h>
#include <stdlib.h>
int main()
{
    int arreglod[10]={0},num,aux;
    printf("escriba un numero entero: ");
    scanf("%d", &num);
    while (num>0){
        aux=num%10;
        arreglod[aux]=arreglod[aux]+1;
        num=num/10;
    }
    for(aux=0;aux<10;aux++)
        printf("el numero %d aparecio: %d \n",aux,arreglod[aux]);
    return 0;
}
