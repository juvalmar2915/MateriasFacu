#include <stdio.h>
#include <stdlib.h>
int invertir(int );
int main()
{
    FILE *archivo;
    archivo= fopen("precipitaciones.txt","r");
    if (archivo==NULL){
        printf("El archivo no se abrio correctamente");
        return 1;
    }
    char guion;
    int precipitado,precipitadomax=0;
    while (!feof(archivo)){
        fscanf(archivo,"%d" "%c",&precipitado,&guion);
        if (precipitado>precipitadomax){
            precipitadomax=precipitado;
        }
    }
    printf("la precipitacion maxima fue de: %d",precipitadomax);
    fclose(archivo);
    return 0;
}
