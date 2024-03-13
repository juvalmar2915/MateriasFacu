#include <stdio.h>
#include <stdlib.h>
#define CATEGORIAS 8
typedef struct{
    float max;
    float min;
    float sumaTotal;
    float cantElem;
}Celda;
int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("vinos.csv","r");
    archivo2= fopen("reporte_vinos.txt","w");
    if ((archivo1==NULL) || (archivo2==NULL)){
        if(archivo1!=NULL){
            fclose(archivo1);
        }
        else{
            fclose(archivo2);
        }
        printf("uno de los archivos no se abrio correctamente");
        return 1;
    }
    char categorias[200],tipoVino[20];
    Celda infoCategorias[CATEGORIAS];
    int i;
    for (i=0;i<CATEGORIAS-1;i++){
        infoCategorias[i].max=0;
        infoCategorias[i].min=999;
        infoCategorias[i].sumaTotal=0;
        infoCategorias[i].cantElem=0;
    }
    float valor;
    int aconvertir;
    fgets(categorias, 200, archivo1);
    fputs(categorias, archivo2);
    while(!feof(archivo1)){
        for(i=0;i<CATEGORIAS;i++){
            if (i<CATEGORIAS-1){
                fscanf(archivo1, "%f;", &valor);
            }
            else{
                fscanf(archivo1, "%d;", &aconvertir);
                valor=(float) aconvertir;
            }
            if(valor>infoCategorias[i].max)
                infoCategorias[i].max = valor;
            if(valor<infoCategorias[i].min)
                infoCategorias[i].min = valor;
            infoCategorias[i].sumaTotal+=valor;
            infoCategorias[i].cantElem++;
        }
        fgets(tipoVino,20,archivo1); //descarto la info del tipo de vino
    }
    fputs("Promedio\t",archivo2);
    for(i=0;i<CATEGORIAS;i++){
        fprintf(archivo2,"%.2f\t", ((infoCategorias[i].sumaTotal)/(infoCategorias[i].cantElem)));
    }
    fputc('\n', archivo2);
    fputs("Minimo\t",archivo2);
    for(i=0;i<CATEGORIAS;i++){
        fprintf(archivo2,"%.2f\t", infoCategorias[i].min);
    }
    fputc('\n', archivo2);
    fputs("Maximo\t",archivo2);
    for(i=0;i<CATEGORIAS;i++){
        fprintf(archivo2,"%.2f\t", infoCategorias[i].max);
    }
    fputc('\n', archivo2);
    fclose(archivo1);
    fclose(archivo2);
    return 0;
}
