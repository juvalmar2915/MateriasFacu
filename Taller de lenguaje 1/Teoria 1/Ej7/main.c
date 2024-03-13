#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,suma=0;
    for (i=2;i<=230;i+=2)
        suma=suma+i;
    printf("la suma de los numeros pares es: %d", suma);
    return 0;
}
