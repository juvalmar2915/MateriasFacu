#include <stdio.h>
#include <stdlib.h>
#define dimf 20
int main()
{
    FILE *archivo;
    archivo= fopen("diccionario.txt","r");
    if (archivo==NULL){
        printf("El archivo no se abrio correctamente");
        return 1;
    }
    char palabra[dimf],*arreglo;
    int error,i,cant=0;
    arreglo=(char *) malloc(dimf*sizeof(char));
    while (!feof(archivo)){
        error=fgets(palabra,dimf,archivo);
        if (error!=EOF){
            for (i=0;palabra[i]!='.';i++){
                arreglo[i+dimf*cant]=palabra[i];
            }
            arreglo[i+dimf*cant]='\0';
        }
        cant++;
        arreglo = (char *) realloc(arreglo, (cant+1)*dimf*sizeof(char));
    }
    fclose(archivo);
    char palabradiccio[dimf];
    int cantpalabras=0,x;
    printf("ingrese una palabra a buscar en el diccionario (si desea terminar ZZZ): ");
    scanf("%s",palabra);
    while (strcmp(palabra,"ZZZ")){
        for (i=0;i<=cant;i++){
            for (x=0;x<=dimf,arreglo[dimf*i+x]!='\0';x++){
                palabradiccio[x]=arreglo[dimf*i+x];
            }
            palabradiccio[x]='\0';
            if (strcmp(palabra,palabradiccio)==0){
                cantpalabras++;
                break;
            }
        }
        printf("ingrese una palabra a buscar en el diccionario (si desea terminar ZZZ): ");
        scanf("%s",palabra);
    }
    printf("la cantidad de palabras encontradas en el diccionario fueron de: %d",cantpalabras);
    fclose(archivo);
    return 0;
}
