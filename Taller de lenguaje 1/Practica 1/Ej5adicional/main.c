#include <stdio.h>
#include <stdlib.h>

int main()
{
    srand(time(NULL));
    int dado1,dado2,suma;
    dado1=rand()%(7);
    dado2=rand()%(7);
    if ((dado1+dado2)==11 | (dado1+dado2)==7)
        printf("usted ha ganado con la suma de: %d", dado1+dado2);
    else
        if ((dado1+dado2)==2 | (dado1+dado2)==12)
            printf("usted ha perdido con la suma de: %d", dado1+dado2);
        else{
            suma=dado1+dado2;
            dado1=rand()%(7);
            dado2=rand()%(7);
            while ((dado1+dado2)!=suma){
                if ((dado1+dado2)==2 | (dado1+dado2)==12){
                    printf("usted ha perdido con la suma de: %d", dado1+dado2);
                    break;
                }
                dado1=rand()%(7);
                dado2=rand()%(7);
            }
            if ((dado1+dado2)==suma)
                printf("usted ha ganado con la suma de: %d", suma);
        }
    return 0;
}
