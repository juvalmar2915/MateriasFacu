#include <stdio.h>
#include <stdlib.h>

typedef struct{
    unsigned long int dni;
    unsigned long int desplazamiento;
}vector;

int main()
{

    FILE *archivo1, *archivo2;
    archivo1= fopen("personas.csv","r");
    archivo2= fopen("“personas.idx","wb+");
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
    unsigned long int dni,desplazamiento;
    int i=1,x,aux, identificador;
    char linea[500] = {"DNI \t Desplazamiento dentro de personas.csv \n"};
    fwrite(linea,sizeof(linea),1, archivo2);
    fgets(linea,500,archivo1); //copio la información de manera de ya haberla recorrido
    vector *v;
    v=(vector *) malloc(sizeof(vector));
    while(!feof(archivo1)){
        fscanf(archivo1,"%d;%ld;",&identificador, &dni);
        desplazamiento = ftell(archivo1);
        fgets(linea,500, archivo1); //descarta el resto de info
        x=0;
        if (i>1){
        while (dni>=v[x].dni){
            x++;
        }
        for (aux=i-1;aux>x;aux--)
            v[aux]=v[aux-1];
        }
        v[x].dni=dni;
        v[x].desplazamiento=desplazamiento;
        v=(vector *) realloc(v,(i+100)*sizeof(vector));
        i++;
    }
    for (x=0;x<i-1;x++){
        fwrite(&v[x].dni,sizeof(unsigned long int),1,archivo2);
        fwrite(&v[x].desplazamiento,sizeof(unsigned long int),1,archivo2);
    }
    //vuelvo al comienzo del archivo
    fseek(archivo2,0,SEEK_SET);
    //imprimo la información
    fread(linea,sizeof(linea), 1, archivo2);
    printf("%s \n", linea);
    while(!feof(archivo2)){
        i=fread(&dni,sizeof(unsigned long int),1,archivo2);
        x=fread(&desplazamiento,sizeof(unsigned long int),1,archivo2);
        if ((i==1) && (x==1)){
            printf("%ld %d",dni, desplazamiento);
            printf("\n");
        }
    }
    free(v);
    fclose(archivo1);
    fclose(archivo2);
    return 0;
}
