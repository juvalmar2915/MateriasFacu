#include <stdio.h>
#include <stdlib.h>
#include "istack.h"

stack s_create (){
    stack s;
    s=NULL;
    return (s);
}
int s_push(stack * s, int n){
    if ((*s)==NULL){
        (*s)= malloc(sizeof(struct pila));
        (*s)->num=n;
        (*s)->tope=NULL;
    }
    else{
        stack aux;
        aux= malloc(sizeof(struct pila));
        aux->num=n;
        aux->tope=(*s);
        (*s)=aux;
    }
    return (*s)->num;
}
int s_pop (stack * s){
    if ((*s)!=NULL){
        int n;
        stack aux;
        aux=(*s);
        n=(*s)->num;
        (*s)=(*s)->tope;
        free(aux);
        return n;
    }
    else{
        return -1;
    }
}
int s_top (stack * s){
    return (*s)->num;
}
int s_empty(stack * s){
    if ((*s)==NULL){
        return 1;
    }
    else{
        return 0;
    }
}
int s_length(stack * s){
    stack aux;
    int i=0;
    aux=(*s);
    while (aux!=NULL){
        i++;
        aux=aux->tope;
    }
}
