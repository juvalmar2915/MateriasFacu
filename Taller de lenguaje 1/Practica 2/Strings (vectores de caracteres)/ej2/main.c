#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    char palabra[30];
    int termina=0,longitud;
    printf("escriba una palabra: ");
    scanf("%s", palabra);
    while (strcmp(palabra,"XXX")!=0){
        longitud=strlen(palabra)-1;
        if (palabra[longitud]=='o'){
            termina++;
        }
        printf("escriba una palabra: ");
        scanf("%s", palabra);
    }
    printf("las palabras que terminan en o son un total de %d", termina);
    return 0;
}
