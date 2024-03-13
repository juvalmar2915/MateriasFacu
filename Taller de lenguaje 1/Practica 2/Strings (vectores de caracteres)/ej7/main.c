#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int polindromo(char []);
int polindromop(char []);
int main()
{
    char palabra[100];
    int espolindromo;
    printf("escriba una palabra: ");
    scanf("%s",palabra);
    espolindromo=polindromop(palabra);
    if (espolindromo)
        printf("la palabra: %s es polindroma",palabra);
    else
        printf("la palabra: %s no es polindroma",palabra);
    return 0;
}
int polindromoi(char p[]){
    int i,esp=1,pos=0;
    char alreves[100];
    for (i=strlen(p);i>=0;i--){
        alreves[pos]=p[i-1];
        pos++;
    }
    for (i=0;i<strlen(p);i++){
        if (p[i]!=alreves[i]){
            esp=0;
            break;
        }
    }
    return esp;
}
int polindromop(char p[]){
    int i,esp=1;
    char *alreves=&p[strlen(p)-1]; //guardo la posicion final de la palabra en un puntero
    for (i=0;i<strlen(p);i++){
        if (p[i]!=*alreves){
            esp=0;
            break;
        }
        alreves--; // me muevo en las direcciones del vector palabra
    }
    return esp;
}
