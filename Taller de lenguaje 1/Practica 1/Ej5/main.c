#include <stdio.h>
#include <stdlib.h>

int main()
{
    float km,millas;
    printf("ingrese la cantidad de km: ");
    scanf("%f",&km);
    millas=km/1.61;
    printf("la cantidad en millas es de %.2f", millas);
    return 0;
}
