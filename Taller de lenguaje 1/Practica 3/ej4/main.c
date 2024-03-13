#include <stdio.h>
#include <stdlib.h>
struct carta{
    int numero;
    char clase[10];
};
void barajar(struct carta []);
struct carta sacarcarta(struct carta [],int *);
void devolvercarta(struct carta [],int *,struct carta);
void imprimircarta(struct carta []);
int main(){
    struct carta mazo[40]; //cada mazo tiene una dimf por lo que tendria que hace una estructura mazo que tenga un arreglo de cartas y una dimf
    int x,numero=1,dimf=39;
    char const paloo[10]="oro",paloc[10]="copa",paloe[10]="espada",palob[10]="basto";
    for (x=0;x<10;x++){
        mazo[x].numero=numero;
        strcpy(mazo[x].clase,paloo);
        numero++;
        if (numero==8){
            numero=10;
        }
    }
    numero=1;
    for (x=10;x<20;x++){
        mazo[x].numero=numero;
        strcpy(mazo[x].clase,paloc);
        numero++;
        if (numero==8){
            numero=10;
        }
    }
    numero=1;
    for (x=20;x<30;x++){
        mazo[x].numero=numero;
        strcpy(mazo[x].clase,paloe);
        numero++;
        if (numero==8){
            numero=10;
        }
    }
    numero=1;
    for (x=30;x<40;x++){
        mazo[x].numero=numero;
        strcpy(mazo[x].clase,palob);
        numero++;
        if (numero==8){
            numero=10;
        }
    }
    barajar(mazo);
    struct carta c;
    c=sacarcarta(mazo,&dimf);
    devolvercarta(mazo,&dimf,c);
    imprimircarta(mazo);
    return 0;
}

void barajar(struct carta mazo[]){
    srand(time(NULL));
    int i;
    struct carta aux;
    int randomizar;
    //Almaceno una nueva carta en cada posicion
    for( i = 0; i < 40 ; i++){
        //Genero un numero aleatorio
        randomizar=rand() %40;
        //Intercambio valores de variables
        aux=mazo[i];
        mazo[i]=mazo[randomizar];
        mazo[randomizar]=aux;
    }
}

struct carta sacarcarta(struct carta mazo[],int *dimf){
    struct carta aux;
    aux=mazo[*dimf];
    mazo[*dimf]=mazo[40];
    (*dimf)--;
    return aux;
}

void devolvercarta(struct carta mazo[],int *dimf ,struct carta c){
    mazo[*dimf]=c;
    (*dimf)++;
}

void imprimircarta(struct carta mazo[]){
    int num;
    printf("elija una carta a imprimir: ");
    scanf("%d", &num);
    printf("carta n° %d y de palo %s",mazo[num].numero,mazo[num].clase);
}
