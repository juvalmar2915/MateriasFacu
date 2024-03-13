#include <stdio.h>
#include <stdlib.h>

typedef struct nodo{
    int entero;
    struct nodo *sig;
}listaent;

listaent *inilistaenteros(listaent *);
listaent *liberarlista(listaent *);
listaent *agregarenteroalprincipio(listaent *, int, int *);
listaent *agregarenteroalfinal(listaent *, int, int *);
int cantidadelementos(listaent *);
void imprimirlista(listaent *);
//ej 12
listaent *insertarordenado(listaent *,int, int *);
int cantidadelementos12(int);

int main()
{
    listaent *l=inilistaenteros(l);
    int t=0;
    l=agregarenteroalprincipio(l,2,&t);
    l=agregarenteroalfinal(l,5,&t);
    l=agregarenteroalfinal(l,6,&t);
    l=insertarordenado(l,1,&t);
    printf("%d \n",cantidadelementos12(t));
    imprimirlista(l);
    liberarlista(l);
    return 0;
}
listaent *inilistaenteros(listaent *lista){
    lista=NULL;
    return lista;
}

listaent *liberarlista(listaent *lista){
    return (realloc(lista,0));
}

listaent *agregarenteroalprincipio(listaent *lista,int ent,int *t){
    (*t)++;
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

listaent *agregarenteroalfinal(listaent *lista,int ent, int *t){
    (*t)++;
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

int cantidadelementos12(int tamanio){
    return tamanio;
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
// ej 12
listaent *insertarordenado(listaent *lista,int ent, int *t){
    (*t)++;
    listaent *nuevalista;
    listaent *aux;
    listaent *ant;
    nuevalista= (listaent *) malloc(sizeof(listaent));
    nuevalista->entero=ent;
    if (lista==NULL){
        nuevalista->sig=NULL;
        lista=nuevalista;
    }
    else{
        aux=lista;
        ant=aux;
        while ((aux!=NULL) && ((nuevalista->entero)>(aux->entero))){
            ant=aux;
            aux=aux->sig;
        }
        if (aux==NULL){
            ant->sig=nuevalista;
            nuevalista->sig=NULL;
        }
        else{
            if(ant==aux){
                nuevalista->sig=lista;
                lista=nuevalista;
            }
            else{
                ant->sig=nuevalista;
                nuevalista->sig=aux;
            }
        }
    }
    return lista;
}
