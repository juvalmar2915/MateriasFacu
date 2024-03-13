#include <stdio.h>
#include <stdlib.h>
#define dias 30
int main()
{
    float precipitaciones[10][12][dias]={0},valor;
    srand(time(NULL));
    float meses[12]={0},anos[10]={0}, minmes,minp=9999.00;
    int a,m,d;
    precipitaciones[0][0][0]=rand()%689;
    for (a=0;a<10;a++){
        for (m=0;m<12;m++){
                for (d=0;d<dias;d++)
                    valor=rand()%200;
                    precipitaciones[a][m][d]=valor;
        }
    }
    int mesm,anop;
    for (a=0;a<10;a++){
        minmes=9999;
        for (m=0;m<12;m++){
            for (d=0;d<dias;d++){
                meses[m]=meses[m]+precipitaciones[a][m][d];
            }
            if (minmes>meses[m]){
                minmes=meses[m];
                mesm=m;
            }
            anos[a]=anos[a]+meses[m];
        }
        printf("el mes que menos llovio del año %d fue: %d con una precipitacion de %.2f  \n",a+1,mesm+1,minmes);
        anos[a]=anos[a]/12;
        if (anos[a]<minp){
            minp=anos[a];
            anop=a;
        }
    }
    printf("el año que tuvo menor precipitacion promedio fue: %d con una precipitacion de %f  \n",anop+1,minp);
    return 0;
}
