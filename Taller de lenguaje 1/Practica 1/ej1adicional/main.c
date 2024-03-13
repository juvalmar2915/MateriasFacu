#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,codigo,cantidadespecies,porcentaje=0,min1,min2,minespecies1=3000,minespecies2=3000;
    for(i=1;i<=14;i++){
        printf("ingrese codigo de pais y seguido a ello ingrese cantidad especies:\n");
        scanf(" %d %d", &codigo, &cantidadespecies);
        if (minespecies1>cantidadespecies){
            min2=min1;
            minespecies2=minespecies1;
            min1=codigo;
            minespecies1=cantidadespecies;
        }
        else{
            if (minespecies2>cantidadespecies){
                min2=codigo;
                minespecies2=cantidadespecies;
            }
        }
        if (cantidadespecies>40);
            porcentaje++;
    }
    porcentaje=(100*porcentaje)/14;
    printf("porcentaje de paises con mas de 40 especies: %d \n", porcentaje);
    printf("minimo 1: %d \n", min1);
    printf("minimo 2: %d \n", min2);
    return 0;
}
