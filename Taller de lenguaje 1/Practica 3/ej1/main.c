#include <stdio.h>
#include <stdlib.h>
struct rectangulo{
    float base,altura;
};
void ini(struct rectangulo *);
float area(struct rectangulo);
int main()
{
    struct rectangulo rect[10];
    int i,rectmenor;
    float menorarea=9999, aux;
    for (i=0;i<4;i++){
        aux=0;
        ini(&rect[i]);
        aux=area(rect[i]);
        if(aux<menorarea){
            menorarea=aux;
            rectmenor=i+1;
        }

    }
    printf("el rectangulo de menor area fue el %d con un area de: %.2f",rectmenor, menorarea);
    return 0;
}
void ini(struct rectangulo *r){
    printf("ingrese base del triangulo: ");
    scanf("%f", &r->base);
    printf("ingrese altura del triangulo: ");
    scanf("%f", &r->altura);
};

float area(struct rectangulo r){
    return ((r.base)*(r.altura));
};
