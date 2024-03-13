#include <stdio.h>
#include <stdlib.h>
int primo(int, int *);
/*int main()
{
    int num;
    printf("escriba un numero natural mayor que 1: ");
    scanf("%d", &num);
    primo(num);
    return 0;
}*/
int main()
{
    int num,*x;
    x=0;
    while (x<5){
        printf("escriba un numero natural mayor que 1: ");
        scanf("%d", &num);
        primo(num,&x); // con el & mandas la direccion del puntero
    }
}
int primo(int n, int *veces)
{
    int i;
    for (i=2;n>i;i++){
        if ((n%i)==0){
            printf("el numero no es primo \n");
            return 0;
        }
    }
    printf("el numero es primo \n");
    *veces=*veces+1; //no se puede hacer ++ de un puntero
    return 0;
}
