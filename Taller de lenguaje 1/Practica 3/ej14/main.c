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
void imprimirlista(listaent *);
listaent *insertarordenado(listaent *,int, int *);
int cantidadelementos(int);
listaent *eliminarmultiplos(listaent *,int , int *);

int main()
{
    listaent *l=inilistaenteros(l);
    int t=0;
    l=agregarenteroalprincipio(l,16,&t);
    l=agregarenteroalprincipio(l,28,&t);
    l=agregarenteroalprincipio(l,2,&t);
    int num;
    printf("ingrese un numero entero positivo: ");
    scanf("%d",&num);
    if (num!=0){
        l=eliminarmultiplos(l,num,&t);
    }
    while (num!=0){
        printf("ingrese un numero entero positivo: ");
        scanf("%d",&num);
        if (num!=0){
            l=eliminarmultiplos(l,num,&t);
        }
    }
    printf("lista: \n");
    imprimirlista(l);
    free(l);
    return 0;
}
listaent *inilistaenteros(listaent *lista){
    lista=NULL;
    return lista;
}

listaent *liberarlista(listaent *lista){
    listaent *aux;
    while (lista!=NULL){
        aux=lista;
        lista=lista->sig;
        free(aux);
    }
    return lista;
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

int cantidadelementos(int tamanio){
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

// ej14

listaent *eliminarmultiplos(listaent *lista, int num, int *t){
    listaent *aux, *ant, *act;
    if (lista==NULL){
        printf("no se pueden eliminar elementos ya que la lista no contiene los mismos");
    }
    else{
        act = lista;
        ant = lista;
        while(act!=NULL){
            while((act!=NULL) && ((act->entero % num) != 0)){
                ant = act;
                act = act->sig;
            }
            if(act!=NULL){
                if(act == ant){
                    ant = act->sig;
                    lista = ant;
                }
                else{
                    ant->sig = act->sig;
                }
            aux = act;
            act = act->sig;
            free(aux);
           }
        }
    }
    return lista;
}
