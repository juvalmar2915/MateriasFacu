#include <stdio.h>
#include <stdlib.h>

#define size 25  //a)el primer error que detecta es que espera un ; , o ) antes de una constante  numerica aunque dicho error se explica como que se intenta usar este define como nombre de una variable
// en la funcion imprimir

void imprimir(int * v){ // reemplaza size por 25 tirando error en compilacion
    int i;
    for (i=0; i<size; i++){ //precompilacion reemplaza por 25 a size
            printf("v[%d]= %d", i, v[i]);
    }
}

int main(){
    int v[size]; // precompilacion define 25 en el tamaño del vector y en compilacion se crea el vector con 25 posiciones
    imprimir(v); // precompilacion reemplaza 25 en la segunda variable y en compilacion se llama a la funcion imprimir(v,25)
    return 0;
}
// c) dos formas de corregir el codigo llamar distinto a la segunda variable pasada o eliminar la segunda variable de la funcion
