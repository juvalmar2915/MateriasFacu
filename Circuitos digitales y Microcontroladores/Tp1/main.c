#include <stdio.h>
#include <stdlib.h>



unsigned char * enteroACaracter(unsigned char numero);

int main(){
    unsigned char numero = 125;
    unsigned char *arr;
    arr= enteroACaracter(numero);
    printf("%c ",*arr);
    arr++;
    printf("%c ",*arr);
    arr++;
    printf("%c",*arr);
    return 0;
}

unsigned char * enteroACaracter(unsigned char numero){
    unsigned char cant='0';
    unsigned char *arreglo;
    arreglo = (char*)malloc(3 * sizeof(char));
    arreglo++;
    while(numero > 0){
        *arreglo= (int)(numero % 10) + '0';
        numero= numero/10;
        cant++;
        arreglo++;

    }
    while(cant!='0'){
        arreglo--;
        cant--;
    }
    free(arreglo);
    return arreglo;
}
