#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *archivo1;
    char nombre [250]="C:/Users/valen/OneDrive/Escritorio/Taller de lenguaje 1/Practica 5/ej 8/tenistas.dat";
    archivo1= fopen(nombre,"rb");
    if (archivo1==NULL){
        fclose(archivo1);
        printf("el archivo no se abrio correctamente");
        return 1;
    }
    printf("el fichero ocupa %d bytes \n", sizeof(archivo1));  //tiene este tamaño de 4 bytes ya que este indica lo que ocupa la variable archivo si nos refirieramos con esta a lo que tiene almacenado dicha variable ocupa hacemos un corrimiento
    fseek(archivo1, 0, SEEK_END);
    printf("el tamaño del archivo es de %d bytes \n",ftell(archivo1));

    fclose(archivo1);
}
