#include <stdio.h>
#include <stdlib.h>
#define LONG 300

int main(){
    FILE *f;
    char linea[LONG];
    // Abrir el archivo
    f = fopen("prueba.txt", "r");
    if (f == NULL){
        printf ("\nError al abrir archivo fuente\n");
        return 1;
    }
    //leo la primera linea
    if (!feof(f)){
        fgets(linea,LONG,f);
    }
    while (!feof(f)){
        // imprimir la linea en la pantalla
        puts(linea);
        // leer una linea del archivo
        fgets(linea,LONG,f); //si llegaba al end of file antes de la correcion se procesaba dos veces la ultima linea ya que el puts quedaba en dicha linea
    }
    fclose(f);
    return 0;
}
