#include <stdio.h>
#include <stdlib.h>
#define AREA_CIRCULO(r) (3.14159*(r)*(r))
int main()
{
    srand(time(NULL));
    int i,num;
    for (i=0;i<10;i++){
        num=rand();
        printf("el area del circulo de radio %d es: %.2f \n",num,AREA_CIRCULO(num));
    }
    return 0;
}
