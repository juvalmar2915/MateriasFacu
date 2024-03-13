#include <stdio.h>
#include <stdlib.h>
char *copstring(char [],char []);
int main()
{
    char palabra1[100]="hola todo bien",palabra2[50]="todo mal",palabra3[100];
    copstring(palabra1,palabra2);
    printf("%s",palabra1);
    return 0;
}
char *copstring(char p1[],char p2[]){
    int i;
    for(i=0;i<strlen(p1);i++) //copio todo lo de la segunda cadena hasta el limite de la primera
        p1[i]=p2[i];
    return p1;
}
