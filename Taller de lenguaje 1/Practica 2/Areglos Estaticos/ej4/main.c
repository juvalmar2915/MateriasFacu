#include <stdio.h>
#include <stdlib.h>
#define col 3
void transpuesta(int [][col],int);
int main(){
    int matriz[3][col]={{2,4,7},{5,6,9},{3,1,0}};
    transpuesta(matriz,3);
    return 0;
}
void transpuesta(int M[][col],int f){
    int i,x,mod1;
    for(x=0;x<col;x++){
        for (i=0;i<f;i++){
            mod1=M[i][x]; //guardo el primer valor
            M[i][x]=M[x][i]; //,modifico el valor de la fila por el de la columna
            M[x][i]=mod1; // asigno a la columna el valor de la fila
        }
    }
    for(i=0;i<f;i++){
        for (x=0;x<col;x++)
            printf(" %d ",M[x][i]);
        printf("\n");
    }
}
