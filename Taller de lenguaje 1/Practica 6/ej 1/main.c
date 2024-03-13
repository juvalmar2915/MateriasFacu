#include <stdio.h>
#include <stdlib.h>

int main (int argc, char * argv[]) {
    printf("\nargc = %d",argc); // La variable argc como mínimo valdrá 1, ya que el nombre del programa se toma como primer argumento, almacenado con argv[0], que es el primer elemento de la matriz. Cada elemento del array apunta a un argumento de la línea de ódenes. Todos los argumentos de la línea de ordenes son cadenas.
    printf("\nargv[0] => %s",argv[0]); // Imprime la ruta del programa. Esto se debe ya que argv contiene los argumentos que se han pasado desde el sistema operativo al invocar el programa.
    return 0;
    }
// por consola se pueden pasar argumentos para saber cuantos argumentos le pasamos esta argc y para invocar los argumentos tenemos la matriz argv
