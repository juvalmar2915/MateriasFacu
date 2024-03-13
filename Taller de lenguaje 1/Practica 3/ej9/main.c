#include <stdio.h>
#include <stdlib.h>

int main()
{
    char *frase;
    frase=(int *) malloc(100*sizeof(char));
    int i,x,mayus,minus,recol,difmm='a'-'A';
    char abecedario[24]={"abcdefghijklmnñopqrstuvwxyz"};
    for (i=0;i<10;i++){
        printf ("Escriba una frase: ");
        gets (frase);
        frase[strlen(frase)]='\n';
        x=0;
        mayus=0;
        minus=0;
        for (x=0;frase[x]!='\n';x++){
            for (recol=0;recol<24;recol++){
                if (frase[x]==abecedario[recol]){
                    minus++;
                    break;
                }
                else{
                    abecedario[recol]=abecedario[recol]-difmm;
                    if (frase[x]==abecedario[recol]){
                        mayus++;
                        abecedario[recol]=abecedario[recol]+difmm;
                        break;
                    }
                    abecedario[recol]=abecedario[recol]+difmm;
                }
            }
        }
        printf("la cantidad de minusculas de la frase es %d y la cantidad de mayusculas es %d \n",minus,mayus);
    }
    free(frase);
    return 0;
}
