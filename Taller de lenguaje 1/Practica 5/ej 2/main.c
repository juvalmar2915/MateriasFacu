#include <stdio.h>
#include <stdlib.h>

/* a) int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("datos1.txt","r");
    archivo2= fopen("datos2.txt","w");
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
    int c;
    if (!feof(archivo1)){
        c= fgetc(archivo1);
    }
    while (!feof(archivo1)){
        fputc(c, archivo2);
        c= fgetc(archivo1);
    }
    fclose(archivo1);
    fclose(archivo2);
    return 0;
} */
/* b) #define dimf 300
int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("datos1.txt","r");
    archivo2= fopen("datos2.txt","w");
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
    char linea[dimf];
    int error;
    while (!feof(archivo1)){
        error=fgets(linea,dimf,archivo1);
        if (error!=NULL){
            fputs(linea, archivo2);
        }
    }
    fclose(archivo1);
    fclose(archivo2);
    return 0;
} */

int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("datos1.txt","rb");
    archivo2= fopen("datos2.txt","wb");
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
    char caracter,cuanto;
    while (!feof(archivo1)){
        cuanto=fread(&caracter,sizeof(char),1,archivo1);
        if (cuanto==1)
            fwrite(&caracter,sizeof(char),1,archivo2);
    }
    fclose(archivo1);
    fclose(archivo2);
    return 0;
}
