#include <stdio.h>
#include <stdlib.h>
#include "string.h"
#include "diccionario.h"

diccionario Creardiccionario(){
    diccionario d=NULL;
    return d;
}
int Agregarpalabra(diccionario *d,char p[]){
    if ((*d)==NULL){
        (*d)=malloc(sizeof(struct nodo));
        strcpy(((*d)->p),p);
        (*d)->sig=NULL;
        return 1;
    }
    else{
        diccionario aux=(*d);
        while(aux->sig!=NULL){
            if (strcmp(aux->p,p)==0){
                    break;
            }
            aux=aux->sig;
        }
        if (aux->sig==NULL){
            diccionario n=malloc(sizeof(struct nodo));
            strcpy(n->p,p);
            n->sig=NULL;
            aux->sig=n;
            return 1;
        }
        else{
            return 0;
        }
    }
}
int Existepalabra(diccionario d,char p[]){
    if (d==NULL){
        return 0;
    }
    else{
        while(d!=NULL){
            printf("%s",d->p);
            if (strcmp(d->p,p)==0){
                    break;
            }
            d=d->sig;
        }
        if (d==NULL){
            return 0;
        }
        else
            return 1;
    }
}
int Eliminarpalabra(diccionario *d,char p[]){
    if ((*d)==NULL){
        return 0;
    }
    else{
        diccionario aux=(*d);
        diccionario ant=(*d);
        while(aux!=NULL){
            if (strcmp(aux->p,p)==0){
                    break;
            }
            ant=aux;
            aux=aux->sig;
        }
        if (aux==NULL){
            return 0;
        }
        else{
            if (aux==ant){
                ant=aux->p;
                (*d)=ant;
                free(aux);
            }
            else{
                ant->sig=aux->sig;
                free(aux);
            }
            return 1;
        }
    }
}
diccionario Cargardesdeunarchivo(FILE * f,diccionario d){
    char p[20];
    while (!feof(f)){
        fgets(p,20,f);
        if (p!=NULL){
            Agregarpalabra(&d,p);
        }
    }
    return d;
}
FILE * Guardaraunarchivo(diccionario d,FILE * f){
    while (d!=NULL){
        fputs(d->p,f);
        fputs("\n",f);
        d=d->sig;
    }
    return f;
}
void Destruireldiccionario(diccionario * d){
    diccionario aux;
    while((*d)!=NULL){
        aux=(*d);
        (*d)=(*d)->sig;
        free(aux);
    }
}
