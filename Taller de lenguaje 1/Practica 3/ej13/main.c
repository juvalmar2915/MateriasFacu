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

int main()
{
    listaent *l=inilistaenteros(l);
    int t=0;
    listaent *lpar=inilistaenteros(lpar);
    int t2=0;
    listaent *limpar=inilistaenteros(limpar);
    int t3=0;
    int num;
    printf("ingrese un numero entero positivo: ");
    scanf("%d",&num);
    if (num!=0){
        l=insertarordenado(l,num,&t);
        if (num%2==0){
            lpar=insertarordenado(lpar,num,&t2);
        }
        else{
            limpar=insertarordenado(limpar,num,&t3);
        }
    }
    while (num!=0){
        printf("ingrese un numero entero positivo: ");
        scanf("%d",&num);
        if (num!=0){
            l=insertarordenado(l,num,&t);
            if (num%2==0){
                lpar=insertarordenado(lpar,num,&t2);
            }
            else{
                limpar=insertarordenado(limpar,num,&t3);
            }
        }
    }
    printf("lista: \n");
    imprimirlista(l);
    printf(" la cantidad de elementos de la lista es de %d \n",cantidadelementos(t));
    printf("lista par: \n");
    imprimirlista(lpar);
    printf(" la cantidad de elementos de la lista es de %d \n",cantidadelementos(t2));
    printf(" lista impar: \n");
    imprimirlista(limpar);
    printf(" la cantidad de elementos de la lista es de %d \n",cantidadelementos(t3));
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
