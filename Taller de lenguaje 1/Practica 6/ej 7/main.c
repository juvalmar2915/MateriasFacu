#include <stdio.h>
#include <stdlib.h>
#define DEBUG 0

int main(){
    int x= 15;

    while (x<50){
        #if DEBUG
            printf("x= %d", x);
            y= y+1;
        #endif
        x++;
        return 0;
    }
}
//a) compila ya que la parte del if no se escribe (no escribir es referido a que no se ejecuta/ se saltea del progrma) en el programa porque debug en el define vale 0.
//b) si se cambia el valor del define de debug a 1 la parte del if se termina escribiendo en el preprocesamiento por lo que se ejecutaria y al no haberse declarado una variable y en este caso el codigo
//no se ejecuta ya que tira error en compilacion
//c) no es posible cambiar la variable debug en tiempo de ejecucion ya que esta predefinida en precompilacion
//d) si se aplica ifdef lo que realiza el preprocesador es preguntar si dicha constante esta predefinida y en caso de estarlo dicha parte se escribe en el codigo. En el resultado de la compilacion no
// causa ningun efecto si este definida dicha variable o no ya que lo que se fija es si existe la constante.
