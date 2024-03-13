#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *archivo1, *archivo2;
    archivo1= fopen("numeros.txt","a");
    archivo2= fopen("numeros.dat","ab");
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
    int numero;
    printf("ingrese un numero del 0 al 9: ");
    scanf("%d",&numero);
    fwrite(&numero,sizeof(int),1,archivo2);
    numero=numero+48;
    fputs(&numero,archivo1);
    fclose(archivo1);
    fclose(archivo2);
    return 0;
}
// no es posible visualizar dichos numeros ya que en el archivo binario esta almacenado como integer mientras en el archivo de texto es un char
// es mas grande el archivo binario. los archivos de texto son usados en ocasiones por ciertos programas como una forma de almacenamiento de los datos.
// Los archivo de texto sirven para manejar archivos donde se guardan caracteres. Es decir si queremos guardar el numero 123456 ocupara 6 bytes, o 12 bytes dependiendo de la codificación que estemos usando. En ocasiones esto no es deseable. Queremos guardar la mayor cantidad de información ocupando la menor cantidad de espacio. Usando un formato binario nuestro numero 123456 ocupara ahora 4 bytes (lo que mide un int en C).
// Cuando trabajamos en formato binario muy a menudo trabajamos con estructuras, que nos permiten empaquetar un conjunto de datos y tratarlo como si fuese una unidad.
