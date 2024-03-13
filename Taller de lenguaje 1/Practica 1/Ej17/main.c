#include <stdio.h>
#include <stdlib.h>

int main()
{
    srand(time(NULL));
    int n1,n2,puntaje=0,i,suma;
    for(i=1;i<=4;i++){
        n1=rand()%(101);
        n2=rand()%(101);
        printf("la suma entre %d y %d es: ", n1,n2);
        scanf("%d",&suma);
        if (suma==(n1+n2))
            puntaje++;
    }
    switch (puntaje){
    case 4:printf("su calificacion obtenida fue: A");break;
    case 3:printf("su calificacion obtenida fue: B");break;
    case 2:printf("su calificacion obtenida fue: C");break;
    case 1:printf("su calificacion obtenida fue: D");break;
    case 0:printf("su calificacion obtenida fue: E");break;
    }
    return 0;
}
