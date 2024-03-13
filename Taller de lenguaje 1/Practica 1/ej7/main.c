#include <stdio.h>
#include <stdlib.h>

/*a)int main()
{
    int edad;
    printf("ingrese edad: ");
    scanf("%d", &edad); //falto leer edad
    if (edad >= 40){
        printf("Tiene %d años o más",40); // no lleva & en los print
    }
    else
        printf("Tiene menos de %d años",40);
    return 0; // falto el return
}*/
/*b)int main(){
    int total, x = 1;
    total=0; //falto la inicializacion de total
    while (x <= 10) {
        total += x;
        ++x;
    }
    printf("Total = %d",total); //total es un entero
    return 0;
}*/
/*c)int main(){
    int valor;
    printf("ingrese un numero: ");
    scanf("%d",&valor);
    switch (valor % 2) {
        case 0: printf("El valor es par"); break; //falta el break que permite que termine el switch
        case 1: printf("El valor es impar"); break;
    }
    return 0;
}*/
int main(){
    int x, y, suma;
    scanf("%d",&x); // se hace siempre sobre la misma linea, no puede haber 2 scanf seguidos por un problema que tiene en el buffer por eso hay que agregarle el \n o hacerlo en una linea scanf("%d %d",&x,&y)
    scanf("%d",&y); // faltaba el &
    printf("x + y = %d ",x+y);
    return 0;
}
