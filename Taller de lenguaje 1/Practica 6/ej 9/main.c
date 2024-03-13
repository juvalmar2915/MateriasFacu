#include <stdio.h>
#include <stdlib.h>
#include "imath.h"
int main()
{
    int num;
    printf("escriba un numero: ");
    scanf("%d",&num);
    while (num!=0){
        if (par(num)){
            printf("el cuadrado del numero %d es: %d \n",num, cuadrado(num));
            printf("el cubo del numero %d es: %d \n",num, cubo(num));
        }
        else{
            printf("el factorial del numero %d es: %d \n",num,factorial(num));
        }
        printf("escriba un numero: ");
        scanf("%d",&num);
    }
    return 0;
}
