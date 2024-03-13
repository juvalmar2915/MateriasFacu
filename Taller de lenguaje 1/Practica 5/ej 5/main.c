#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *archivo;
    archivo= fopen("apuestas.txt","r");
    if (archivo==NULL){
        printf("El archivo no se abrio correctamente");
        return 1;
    }
    char puntocoma,barra;
    int codigoap,error;
    float montoap, montotot=0;
    while (!feof(archivo)){
        error=fscanf(archivo,"%d" "%c" "%f" "%c",&codigoap,&barra,&montoap,&puntocoma);
        if (error!=EOF)
            montotot=montotot+montoap;
    }
    printf("la cantidad apostada fue de: %.2f",montotot);
    fclose(archivo);
    return 0;
}
