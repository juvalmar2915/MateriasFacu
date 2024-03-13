#include <stdio.h>
#include <stdlib.h>

struct direccion {
    char calle[50];
    char ciudad[30];
    int codigo_postal;
    char pais[40];
    };
struct alu{
    char apellido[50];
    char nombre[50];
    char legajo[8];
    float promedio;
    struct direccion domicilio;
    };
typedef struct alu alumno;
void inia(alumno *);
struct pun3D{
    float x;
    float y;
    float z;
};
typedef struct pun3D punto3D;
int main()
{
    alumno alum[30];
    int i;
    float mejorp=0;
    char nombrem[50];
    char apellidom[50];
    for (i=0;i<30;i++){
        inia(&alum[i]);
        if (alum[i].promedio>mejorp){
            mejorp=alum[i].promedio;
            strcpy(nombrem,alum[i].nombre);
            strcpy(apellidom,alum[i].apellido);
        }
    }
    printf("el mejor promedio lo tiene: %s %s con un promedio de %.2f \n",nombrem,apellidom,mejorp);
    printf("%d \n",sizeof(struct pun3D)); // ocupa 12 bytes ya que la structura contiene 3 floats x,y y z y el tamaño de un float es de 4 bytes.
    printf("%d \n",sizeof(punto3D)); // ocupa 12 bytes. si es igual al de struct pun3D ya que lo que hace el typedef es redefinir la estructura con un nombre dado.
    punto3D arreglop[4];
    printf("%d \n",sizeof(arreglop)); // ocupa 48 bytes ya que esta creando 4 structuras de tipo punto3D que como vimos punto3D ocupa 12 bytes.
    return 0;
}
void inia(alumno *a){
    printf("escriba el apellido del alumno: ");
    scanf("%s", &a->apellido);
    printf("escriba el nombre del alumno: ");
    scanf("%s", &a->nombre);
    printf("escriba el legajo del alumno: ");
    scanf("%s", &a->legajo);
    printf("escriba el promedio del alumno: ");
    scanf("%f", &a->promedio);
    printf("escriba la calle donde vive el alumno: ");
    scanf("%s", &a->domicilio.calle);
    printf("escriba la ciudad donde vive el alumno: ");
    scanf("%s", &a->domicilio.ciudad);
    printf("escriba el codigo postal donde vive el alumno: ");
    scanf("%d", &a->domicilio.codigo_postal);
    printf("escriba el pais donde vive el alumno: ");
    scanf("%s", &a->domicilio.pais);
}
