#include <stdio.h>
#include <stdlib.h>
#include "string.h"
#include "diccionario.h"

int main()
{
    diccionario d= Creardiccionario();
    int i;
    char p[20];
    printf("escriba una palabra a agregar en el diccionario: ");
    scanf("%s",p);
    while (strcmp(p,"fin")){
        i=Agregarpalabra(&d,p);
        if (i==1){
            printf("su palabra se ingreso correctamente! ");
        }
        printf("escriba una palabra a agregar en el diccionario: ");
        scanf("%s",p);
    }
    printf("escriba una palabra a buscar: ");
    scanf("%s",p);
    if (Existepalabra(d,p)){
        printf("la palabra existe");
    }
    else{
        printf("la palabra no existe");
    }
    Eliminarpalabra(&d,p);
    if (Existepalabra(d,p)){
        printf("la palabra existe");
    }
    else{
        printf("la palabra no existe");
    }
    FILE *archivo;
    archivo=fopen("diccio.txt","a+");
    Guardaraunarchivo(d,archivo);
    fseek(archivo,0,SEEK_SET);
    Cargardesdeunarchivo(archivo,d);
    fclose(archivo);
    Destruireldiccionario(&d);
    return 0;
}
