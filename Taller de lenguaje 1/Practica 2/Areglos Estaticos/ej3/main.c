#include <stdio.h>
#include <stdlib.h>
#define n 3
void mult(int [][n],int,int);
int main(){
    int matriz[2][n]={{5,4,6}, {2,3,6}};
    int num;
    printf("escriba un numero a multiplicar en la matriz: ");
    scanf("%d", &num);
    mult(matriz,2,num);
    int g, h;
    for(g=0;g<2;g++){
        for(h=0;h<n;h++)
            printf("%d \n",matriz[g][h]);
    }
    return 0;
}
void mult(int ma[][n],int m, int c){
    int i,x;
    for(i=0; i<m; i++){
        for(x=0; x<n; x++){
            ma[i][x]=ma[i][x]*c;
        }
    }
}
