#include <stdio.h>
/*int main(){
 char a, b;
 printf("Ingrese el primer caracter y el segundo caracter:\n");
 scanf("%c %c", &a, &b);
 printf("Se ley� como primer caracter: %c\n", a);
 printf("Se ley� como segundo caracter: %c\n", b);
 return 0;
}*/
int main(){
    char a, b;
    printf("Ingrese el primer caracter:\n");
    scanf("%c", &a);
    printf("Se ley� el caracter: %c\n", a);
    printf("Ingrese el segundo caracter:\n");
    fflush(stdin);
    scanf("%c", &b);
    printf("Se ley� el caracter: %c\n", b);
    return 0;
}
