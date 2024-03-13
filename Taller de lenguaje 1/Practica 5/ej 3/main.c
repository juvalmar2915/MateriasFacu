#include <stdio.h>
#include <stdlib.h>
int main()
{
    FILE *archivo;
    archivo= fopen("datos1.txt","r");
    if (archivo==NULL){
        printf("el archivo no se abrio correctamente");
        return 1;
    }
    int c, cantminus=0, cantmayus=0, digitos=0;
    while (!feof(archivo)){
        c= fgetc(archivo);
        if ((c>=65) && (c<=90)){
            cantmayus++;
        }
        else{
            if ((c>=48) && (c<=57))
                digitos++;
            else{
                if ((c>=97) && (c<=122))
                    cantminus++;
            }
        }
    }
    printf("cantidad de digitos %d, de mayusculas %d, de minusculas %d",digitos,cantmayus,cantminus);
    fclose(archivo);
    return 0;
}
