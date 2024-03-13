#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    int entero;
    struct nodo *sig;
}listaent;

listaent *inilistaenteros(listaent *);
listaent *liberarlista(listaent *);
listaent *agregarenteroalprincipio(listaent *, int);
listaent *agregarenteroalfinal(listaent *, int);
int cantidadelementos(listaent *);
void imprimirlista(listaent *);

int main()
{
    listaent *l=inilistaenteros(l), *linversa=inilistaenteros(linversa);
    int num;
    printf("ingrese un numero entero positivo: ");
    scanf("%d", &num);
    if (num!=0){
        l=agregarenteroalprincipio(l,num);
        linversa=agregarenteroalfinal(linversa,num);
    }
    while (num!=0){
        printf("ingrese un numero entero positivo: ");
        scanf("%d", &num);
        if (num!=0){
            l=agregarenteroalprincipio(l,num);
            linversa=agregarenteroalfinal(linversa,num);
        }
    }
    printf("lista con orden normal: ");
    imprimirlista(l);
    printf(" la cantidad de elementos de la lista es de %d \n",cantidadelementos(l));
    printf("lista con orden inverso: ");
    imprimirlista(linversa);
    printf(" la cantidad de elementos de la lista es de %d \n",cantidadelementos(linversa));
    liberarlista(l);
    liberarlista(linversa);
    return 0;
}
listaent *inilistaenteros(listaent *lista){
    lista=NULL;
    return lista;
}

listaent *liberarlista(listaent *lista){
    return (realloc(lista,0));
}

listaent *agregarenteroalprincipio(listaent *lista,int ent){
    listaent *nuevalista;
    nuevalista= (listaent *) malloc(sizeof(listaent));
    nuevalista->entero= ent;
    if (lista==NULL){
        nuevalista->sig=NULL;
    }
    else{
        nuevalista->sig=lista;
    }
    lista=nuevalista;
    return lista;
}

listaent *agregarenteroalfinal(listaent *lista,int ent){
    listaent *nuevalista;
    listaent *aux,*ant;
    nuevalista= (listaent *) malloc(sizeof(listaent));
    nuevalista->entero= ent;
    nuevalista->sig= NULL;
    if (lista==NULL){
        lista=nuevalista;
    }
    else{
        aux=lista;
        while (aux!=NULL){
            ant=aux;
            aux=aux->sig;
        }
        ant->sig=nuevalista;
    }
    return lista;
}

int cantidadelementos(listaent *lista){
    int cant=0;
    listaent *aux;
    aux=lista;
    while (aux!=NULL){
        cant++;
        aux=aux->sig;
    }
    return cant;
}

void imprimirlista(listaent *lista){
    listaent *aux;
    if (lista==NULL){
        printf("la lista no tiene elementos");
    }
    else{
        aux=lista;
        while (aux != NULL){
            printf("%d",aux->entero);
            if (aux->sig!=NULL){
                printf(",");
            }
            aux=aux->sig;
        }
    }
}
