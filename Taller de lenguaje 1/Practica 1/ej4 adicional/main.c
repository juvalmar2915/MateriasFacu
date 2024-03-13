#include <stdio.h>
#include <stdlib.h>

int main()
{
    int numero,suma,booleana,respaldo;
    printf("escriba un numero distinto de 0: ");
    scanf("%d", &numero);
    while (numero!=0){
        booleana=1;
        suma=0;
        respaldo=numero;
        while (booleana!=0){
            while (respaldo>0){
                suma=suma+respaldo%10;
                respaldo=respaldo/10;
            }
            printf("suma: %d\n",suma);
            if (suma>10){
                respaldo=suma;
                suma=0;
            }
            else
                booleana=0;
        }
        printf("escriba otro numero si quiere salir oprima 0  ");
        scanf("%d", &numero);
    }
    return 0;
}
