#include <stdio.h>
#include <stdlib.h>
void cantdeletras(char []);
int main()
{
    char palabra[100];
    printf("escriba una palabra: ");
    scanf("%s",palabra);
    cantdeletras(palabra);
    return 0;
}
void cantdeletras(char p[]){
    int letras[24]={0},i,recol;
    char abecedario[24]={"abcdefghijklmnñopqrstuvwxyz"};
    for (i=0;i<strlen(p);i++)
        for (recol=0;recol<24;recol++){
            if (p[i]==abecedario[recol]){
                letras[recol]++;
                break;
            }
        }
    for (recol=0;recol<24;recol++){
        if (letras[recol]>0)
            printf("la letra %c aparecio %d veces \n",abecedario[recol],letras[recol]);
    }
}
