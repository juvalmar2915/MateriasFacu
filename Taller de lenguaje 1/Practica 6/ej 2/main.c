#include <stdio.h>
#include <stdlib.h>

int main (int argc, char * argv[])
{
    if (argc==5){
        float promedio;
        int i,sumatot=0,num;
        for (i=1;i<argc;i++){
            num=atoi(argv[i]);
            sumatot=sumatot+num;
            //si es de un solo digito seria sumatot=sumatot+*argv[i]-48;
        }
        promedio=(float) sumatot/(argc-1);
        printf("promedio: %.2f",promedio);
    }
    else{
        printf("no se pasaron los 4 argumentos requeridos para calcular el promedio");
    }
    return 0;
}
