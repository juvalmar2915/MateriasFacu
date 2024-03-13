#include <stdio.h>
#include <stdlib.h>
#define maximo_int 18487
#define maximo_fracc 36049652

unsigned int elevar(unsigned int n, int m){ //devuelve n^m
    if (m==0){
        return 1;
    } else {
        unsigned int res=n;
        for(int i=0; i<m-1; i++){
            res=res*n;
        }
        return res;
    }
}

unsigned long long elevarLONG(unsigned int n, int m){ //devuelve n^m, permite números de mayor tamaño
    if (m==0){
        return 1;
    } else {
        unsigned long long res = (unsigned long long) n;
        for(int i=0; i<m-1; i++){
            res=res*n;
        }
        return res;
    }
}

int fraccion_a_Entero (unsigned int decimal, int cantidadFraccion){ //convierte la parte fraccional a entero, para poder ser trabajada
    int retorno=0, multiplicacion=1;
    for (int i=cantidadFraccion; i>0; i--){
        multiplicacion=multiplicacion*10;
    }

    int bit_actual = elevar(2,16);
    for (int i=17; i>0; i--){
        decimal*=2;
        if (decimal > (multiplicacion-1)){
            decimal-=multiplicacion;
            retorno+=bit_actual;
        }
        bit_actual/=2;
    }
    return retorno;
}

void entero_a_decimal(unsigned long long num){ //realiza la conversion final e imprime en pantalla el resultado
    unsigned long long resultadoENTERO=0, resultadoFRACCION=0, referencia=elevarLONG(2,33), sumar=5000000000000000000;

    //entera
    resultadoENTERO=num/elevarLONG(2,34);

    //fraccion
    num-=resultadoENTERO*elevarLONG(2,34); //quitamos los valores referentes a la parte entera

    for (int i=34; i>0; i--){
        if(num >= referencia){
            resultadoFRACCION+=sumar;
            num-=referencia;
        }
        sumar/=2;
        referencia/=2;
    }
    //con esto agregamos 0's a la parte fraccionaria en casos de x,00...x
    unsigned long long multiplicacion=1000000000000000000;
    int cantcero=0;

    while (multiplicacion > resultadoFRACCION){
        cantcero++;
        multiplicacion/=10;
    }

    printf("Resultado: %llu.",resultadoENTERO);

    for (int i=0; i<cantcero ;i++){
        printf("0");
    }

    printf("%llu \n",resultadoFRACCION);
}

int main() {
    char radio[255];
    int i,cantfracc,seguir;
    unsigned int radioNUMERO, radio_int, radio_fracc;
    unsigned int piNUMERO=3*elevar(2,17), piFRACCION=fraccion_a_Entero(141594,6),auxfracc;
    unsigned long long resultadoNUMERO;
    do {
        printf("Escriba el radio [2^(-17) ; %d.%d] para calcular el area del circulo:\n",maximo_int,maximo_fracc);
        scanf("%s",radio);
        i=0;
        cantfracc=0;
        radio_int=0;
        radio_fracc=0;
        while ((radio[i] != '.') && (radio[i]!= '\0')){
            radio_int=radio_int*10;
            radio_int+=(radio[i]-48);
            i++;
        }
        if (radio[i]!='\0'){
            i++;
        }
        while (radio[i]!= '\0'){
            radio_fracc=radio_fracc*10;
            radio_fracc+=(radio[i]-48);
            i++;
            cantfracc++;
        }
        if (cantfracc < 8){
            auxfracc=radio_fracc*elevar(10,8-cantfracc);
        }
        else{
            if (cantfracc > 8){
                auxfracc=radio_fracc/elevar(10,cantfracc-8);
            }
            else{
                auxfracc=radio_fracc;
            }
        }
        if ((radio_int < maximo_int) || (radio_int == maximo_int && auxfracc<=maximo_fracc)){
            radioNUMERO = radio_int*elevar(2,17) + fraccion_a_Entero(radio_fracc,cantfracc);
            resultadoNUMERO = (piNUMERO/elevar(2,17))*elevarLONG(radioNUMERO,2)+(elevarLONG(radioNUMERO,2)/elevar(2,17))*piFRACCION; //quitamos los 17 bits de la parte fraccionaria

            entero_a_decimal(resultadoNUMERO);

            printf("Ingrese 0 para terminar: \n");
            scanf("%d",&seguir);
        }
        else{
            printf("ingrese un valor en el rango \n");
            seguir=1;
        }
    } while (seguir);
    return 0;
}
