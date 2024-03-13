#include <stdio.h>
#include <stdlib.h>
#include "string.h"
typedef struct{
    char nombre[20];
    char apellido[20];
    int edad;
    int cantTitulos;
    int ranking;
    double fortuna;
}tenista;
void initenista(tenista *);
int main()
{
    FILE *archivo1;
    archivo1= fopen("tenistas.dat","wb");
    if (archivo1==NULL){
        fclose(archivo1);
        printf("el archivo no se abrio correctamente");
        return 1;
    }
    int i;
    tenista untenista;
    for (i=0;i<20;i++){
        initenista(&untenista);
        fwrite(&untenista,sizeof(tenista),1,archivo1);
    }
    fclose(archivo1);
    archivo1= fopen("tenistas.dat","rb");
    int mejorRanking=999, masTitulos=0;
    char nombreRanking[20],apellidoRanking[20],nombreTitulos[20],apellidoTitulos[20];
    for (i=0;i<20;i++){
        fread(&untenista, sizeof(tenista), 1,  archivo1);
        if (untenista.cantTitulos>masTitulos){
            strcpy(nombreTitulos,untenista.nombre);
            strcpy(apellidoTitulos,untenista.apellido);
            masTitulos=untenista.cantTitulos;
        }
        if (untenista.ranking<mejorRanking){
            strcpy(nombreRanking,untenista.nombre);
            strcpy(apellidoRanking,untenista.apellido);
            mejorRanking=untenista.ranking;
        }
    }
    printf("el tenista con mas titulos fue: %s %s con un total de %d titulos \n",nombreTitulos,apellidoTitulos,masTitulos);
    printf("el tenista con mejor ranking fue: %s %s posicionado en el ranking %d \n",nombreRanking,apellidoRanking,mejorRanking);
    fclose(archivo1);
    return 0;
}
void initenista(tenista * untenista){
        printf("ingrese el nombre del tenista: ");
        scanf("%s",untenista->nombre);
        printf("ingrese el apellido del tenista: ");
        scanf("%s",untenista->apellido);
        printf("ingrese la edad del tenista: ");
        scanf("%d",&untenista->edad);
        printf("ingrese la cantidad de titulos del tenista: ");
        scanf("%d",&untenista->cantTitulos);
        printf("ingrese el ranking del tenista: ");
        scanf("%d",&untenista->ranking);
        printf("ingrese la fortuna del tenista: ");
        scanf("%lf",&untenista->fortuna);
}
