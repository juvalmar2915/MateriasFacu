#include <stdio.h>
#include <stdlib.h>
char *reemplazo(char [], char, char);
int main(){
    char palabra[100],c1,c2;
    printf("ingrese una cadena de caracteres: ");
    scanf("%s",palabra);
    printf("ingrese un caracter: ");
    scanf(" %c", &c1);
    printf("ingrese otro caracter: ");
    scanf(" %c", &c2);
    reemplazo(palabra,c1,c2);
    printf("%s",palabra);
    return 0;
}
char *reemplazo(char p[], char c1, char c2){
    int i;
    for (i=0;i<strlen(p);i++){
        if (p[i]==c1)
            p[i]=c2;
    }
    return p;
}
