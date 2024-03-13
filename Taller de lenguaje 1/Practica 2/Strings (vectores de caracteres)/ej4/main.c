#include <stdio.h>
#include <stdlib.h>
int strlongitud(char []);
int main()
{
    char palabra[100]="hola";
    printf("la cantidad de caracteres de la palabra es de: %d",strlongitud(palabra));
    return 0;
}
int strlongitud(char p[]){
    int i,cant=0;
    for (i=0;p[i]!='\0';i++) //el  \0 significa salto de linea
        cant++;
    return cant;
}
