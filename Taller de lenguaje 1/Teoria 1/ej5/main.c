#include <stdio.h>
#include <stdlib.h>

int main()
{
    int entero, promedio, cant, max;
    cant=0;
    promedio=0;
    max=-100;
    printf("ingrese numero: ");
    scanf("%d", &entero);
    while (entero!=-1){
        max=entero>max?entero:max;
        cant=cant+1;
        promedio=promedio+entero;
        printf("ingrese numero: ");
        scanf("%d", &entero);
    }
    promedio=promedio/cant;
    printf("el promedio es: %d \n", promedio);
    printf("el max es: %d \n", max);
    return 0;
}
