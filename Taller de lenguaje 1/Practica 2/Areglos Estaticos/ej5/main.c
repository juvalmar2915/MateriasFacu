#include <stdio.h>
#include <stdlib.h>
#define col 3
void suma(int [][col],int [][col],int [][col],int);
int main(){
    int matriz1[2][col]={{3,5,7},{8,3,1}},matriz2[2][col]={{2,4,6},{2,4,6}},matrizr[2][col]={{0},{0}};
    suma(matriz1,matriz2,matrizr,2);
    int i,x;
    for (i=0;i<2;i++)
        for (x=0;x<col;x++)
            printf("%d \n",matrizr[i][x]);
    return 0;
}
void suma(int m1[][col],int m2[][col],int mr[][col],int f){
    int i,x;
    for (i=0;i<f;i++)
        for (x=0;x<col;x++)
            mr[i][x]=m1[i][x]+m2[i][x];
}
