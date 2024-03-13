#include <stdio.h>
#include <stdlib.h>

int main()
{
    int farenheit, c;
    printf("Ingrese temperatura en farenheit: ");
    scanf("%d", &farenheit);
    c= ((float) 5/9)*(farenheit-32);
    printf("la temperatura en celcius es %d \n", c);
    return 0;
}
