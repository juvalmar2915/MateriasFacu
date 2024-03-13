#include <stdio.h>
#include <stdlib.h>

int main (int argc, char * argv[])
{
    if ((argc==4) && ((*argv[2]=='/') || (*argv[2]=='*') || (*argv[2]=='+') || (*argv[2]=='-'))){
        int num1=atoi(argv[1]), num2=atoi(argv[3]);
        if (*argv[2]=='/'){
            printf("el resultado del calculo entre dichos numeros es: %.2f", (float) num1/num2);
        }
        else{
            if (*argv[2]=='*'){
                printf("el resultado del calculo entre dichos numeros es: %d", num1*num2);
            }
            else{
                if (*argv[2]=='+'){
                    printf("el resultado del calculo entre dichos numeros es: %d", num1+num2);
                }
                else{
                    printf("el resultado del calculo entre dichos numeros es: %d", num1-num2);
                }
            }
        }
    }
    else{
        printf("no se pasaron los argumentos requeridos para realizar la operacion o el operador es invalido");
    }
    return 0;
}
