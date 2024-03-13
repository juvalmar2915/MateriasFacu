#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int id;
    unsigned long int dni;
    char apellido[50];
    char nombre[50];
    char trabajo[50];
    char correo[70];
    char ciudad[50];
    char pais[50];
}Persona;

typedef struct{
    unsigned long int dni;
    unsigned long int desplazamiento;
}Vector;

typedef struct{
    Vector *v;
    int tam;
}Indice;
int buscar(FILE* personas, Indice indice, unsigned long int dni, Persona * persona);
int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("C:/Users/valen/Onedrive/Escritorio/Taller de lenguaje 1/Practica 5/ej 11a/“personas.idx","rb+");
    if (archivo1==NULL){
        printf("el archivo no se abrio correctamente");
        return 1;
    }
    Indice indice;
    indice.v=(Vector *) malloc(sizeof(Vector));
    indice.tam=0;
    while (!feof(archivo1)){
        fread(&indice.v[indice.tam].dni,sizeof(unsigned long int),1,archivo1);
        fread(&indice.v[indice.tam].desplazamiento,sizeof(unsigned long int),1,archivo1);
        indice.tam++;
        indice.v=(Vector *) realloc(indice.v,(indice.tam+1)*sizeof(Vector));
    }
    archivo2= fopen("C:/Users/valen/Onedrive/Escritorio/Taller de lenguaje 1/Practica 5/ej 11a/personas.csv","r");
    Persona persona;
    unsigned long int dni;
    printf("ingrese dni a buscar: ");
    scanf("%ld", &dni);
    printf("%d",buscar(archivo2,indice, dni, &persona));
    free(indice.v);
    fclose(archivo1);
    fclose(archivo2);
    return 0;
}

int buscar(FILE* personas, Indice indice, unsigned long int dni, Persona * persona){
    int inicio=0, fin=indice.tam-1, medio=0;
    while (inicio<fin){
        medio=(fin-inicio)/2+inicio;
        if (indice.v[medio].dni>dni){
            fin=medio-1;
        }
        else
            if (indice.v[medio].dni<dni)
                inicio=medio+1;
            else{
                inicio=medio;
                break;
            }
    }
    if (indice.v[inicio].dni==dni){
        int j=0, c;
        fseek(personas,indice.v[inicio].desplazamiento,SEEK_SET);
        fscanf(personas,"%d;%ld;", &persona->id,&persona->dni);
        c=fgetc(personas);
        while (c!=';'){
            persona->apellido[j]=c;
            c=fgetc(personas);
            j++;
        }
        persona->apellido[j]='\0';
        j=0;
        c=fgetc(personas);
        while (c!=';'){
            persona->nombre[j]=c;
            c=fgetc(personas);
            j++;
        }
        persona->nombre[j]='\0';
        j=0;
        c=fgetc(personas);
        while (c!=';'){
            persona->trabajo[j]=c;
            c=fgetc(personas);
            j++;
        }
        persona->trabajo[j]='\0';
        j=0;
        c=fgetc(personas);
        while (c!=';'){
            persona->correo[j]=c;
            c=fgetc(personas);
            j++;
        }
        persona->correo[j]='\0';
        j=0;
        c=fgetc(personas);
        while (c!=';'){
            persona->ciudad[j]=c;
            c=fgetc(personas);
            j++;
        }
        persona->ciudad[j]='\0';
        fgets(persona->pais,200,personas);
        return 1;
    }
    return 0;
}
