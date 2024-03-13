#include <stdio.h>
#include <stdlib.h>
struct persona{
    int DNI;
    char nombre[20];
    char apellido[20];
    char sexo[20];
};
typedef struct{
    struct persona * personas;
    int cant;
}barrio;
barrio * reservarmem(int);
void liberarmem(barrio *,int);
void cargar(barrio *,int);
void porcentaje(barrio *, int);
int main()
{
    int num;
    printf("escriba la cantidad de barrios que tiene la ciudad:");
    scanf("%d",&num);
    barrio * ciudad;
    ciudad=reservarmem(num);
    cargar(ciudad,num);
    porcentaje(ciudad, num);
    liberarmem(ciudad,num);
    return 0;
}
barrio * reservarmem(int num){
    int i,cant;
    barrio * aux;
    aux = (barrio *)malloc(num*sizeof(barrio));
    for (i=0; i<num; i++){
        printf("indique la cantidad de personas del barrio %d: ",i);
        scanf("%d",&cant);
        aux[i].cant=cant;
        aux[i].personas=(struct persona *) malloc(cant*sizeof(struct persona));
    }
    return aux;
}
void liberarmem(barrio * c,int num){
    int i;
    for (i=0; i<num; i++){
        free(c[i].personas);
    }
    free(c);
}
void cargar(barrio * c, int num){
    int i,x;
    struct persona p;
    for (i=0; i<num; i++){
        for (x=0; x<c[i].cant; x++){
            /*printf("ingese dni de la persona: ");
            scanf("%d",&p.DNI);
            printf("ingese nombre de la persona: ");
            scanf("%s",p.nombre);
            printf("ingese apellido de la persona: ");
            scanf("%s",p.apellido);
            printf("ingese sexo de la persona: ");
            scanf("%s",p.sexo);
            c[i].personas[x]=p;*/
            printf("ingese dni de la persona: ");
            scanf("%d",&c[i].personas[x].DNI);
            printf("ingese nombre de la persona: ");
            scanf("%s",c[i].personas[x].nombre);
            printf("ingese apellido de la persona: ");
            scanf("%s",c[i].personas[x].apellido);
            printf("ingese sexo de la persona: ");
            scanf("%s",c[i].personas[x].sexo);
        }
    }
}
void porcentaje(barrio * c, int num){
    float p;
    int i,x;
    for (i=0; i<num; i++){
        p=0;
        for (x=0; x<c[i].cant; x++){
            if (strcmp(c[i].personas[x].sexo,"femenino")==0){
                p++;
            }
        }
        p=((p*100)/(c[i].cant));
        printf("la cantidad de porcentaje mujeres en el barrio %d es de: %.2f %",i,p);
    }
}
