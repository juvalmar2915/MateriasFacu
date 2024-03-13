#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    int i;
    for(i=1; i<=10; i++){
        printf("la raiz cuadrada de %d es: %.2f\n", i,sqrt(i));
        printf("el cuadrado de %d es: %d\n",i , (int) pow(i,2)); //puede ser que sean operaciones solamente flotantes
        printf("el cubo de %d es: %d\n",i , (int) pow(i,3));
    }
    return 0;
}
