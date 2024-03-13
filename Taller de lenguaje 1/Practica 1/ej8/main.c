#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x,y,operacion;
    char c;
    printf("escriba un operador: ");
    scanf("%c", &c);
    printf("escriba un numero: ");
    scanf("%d",&x);
    printf("escriba un segundo numero:");
    scanf("%d",&y);
    switch (c){
    case '+': printf("el resultado es: %d", x+y);break;
    case '-': printf("el resultado es: %d", x-y);break;
    case '*': printf("el resultado es: %d", x*y);break;
    case '/': printf("el resultado es: %d",(float)x/y);break;
    case '%': printf("el resultado es: %d", x%y);break;
    default: printf("error: el caracter no represente un operador valido");
    }
    return 0;
}
