#include <stdio.h>
#include <stdlib.h>
/*a) int main()
{
    int num,i,resultado=1;
    printf("Escriba un numero natural: ");
    scanf("%d", &num);
    for (i=1;num>=i;i++){
        resultado=resultado*i;
    }
    printf("el resultado factorial de %d es: %d", num, resultado);
    return 0;
}*/
unsigned int factorial(unsigned int);
int main()
{
    unsigned int num;
    printf("Escriba un numero natural: ");
    scanf("%d", &num);
    printf("el factorial de %d es: %d", num,factorial(num));
}
unsigned int factorial(unsigned int n)
{
    if (n==0 || n==1)
        return 1;
    else return (n*factorial(n-1));
}
