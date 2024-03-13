#include <stdio.h>
#include <stdlib.h>
#include "istack.h"
int main()
{
    int n;
    stack s=s_create();
    printf("escriba un numero a insertar en una pila: ");
    scanf("%d",&n);
    while (n!=0){
        s_push(&s,n);
        printf("escriba un numero a insertar en una pila: ");
        scanf("%d",&n);
    }
    printf("desapilando elementos: ");
    while (!s_empty(&s)){
        printf("%d ", s_pop(&s));
    }
    return 0;
}
