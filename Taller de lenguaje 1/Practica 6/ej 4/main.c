#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SQUAREOF(x) (x)*(x)

int main() {
    int xin=3;
    printf("\nxin=%i",xin);

    printf("\nSQUAREOF(xin)=%i", SQUAREOF(xin));
    printf("\nSQUAREOF(xin+4)=%i", SQUAREOF(xin+4));
    printf("\nSQUAREOF(xin+xin)=%i", SQUAREOF(xin+xin));
}
//a) el programa realiza la multiplicacion de un numero por si mismo y en algunos casos este mismo sumado otro numero
//b) los resultados no son los esperados ya que en orden de prioridad si yo sumo algo a dicho numero la multiplicacion se hara primero que la suma dejando un resultado erroneo para arreglar eso
// se ponen parentesis
