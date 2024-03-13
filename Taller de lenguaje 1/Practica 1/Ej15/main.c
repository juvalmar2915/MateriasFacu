#include <stdio.h>
#include <stdlib.h>
int mayorymenor(int,float *, float *);
int main()
{
    int num;
    float may,men;
    may=-1;
    men=9999;
    printf("Escriba la cantidad de numeros flotantes a leer: ");
    scanf("%d",&num);
    mayorymenor(num,&may,&men);
    printf("el mayor numero leido fue: %.2f \n", may);
    printf("el menor numero leido fue: %.2f \n", men);
    return 0;
}
int mayorymenor(int n,float *mayor,float *menor){
    int i;
    float flotante;
    for (i=1;i<=n;i++){
        printf("escriba un numero flotante: ");
        scanf("%f",&flotante);
        if (flotante<*menor)
            *menor=flotante;
        if (flotante>*mayor)
            *mayor=flotante;
    }
    return 0;
}
