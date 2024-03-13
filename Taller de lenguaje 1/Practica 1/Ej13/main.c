#include <stdio.h>
#include <stdlib.h>
int invertir(int);
int main()
{
    int num;
    printf("escriba un numero: ");
    scanf("%d", &num);
    printf("el numero invertido es: %d", invertir(num));
    return 0;
}
int invertir(int n)
{
    int inverso=0;
    while (n>=10){
        inverso=inverso+n%10;
        n=n/10;
        inverso=inverso*10;
    }
    inverso=inverso+n;
    return inverso;
}
