#include <stdio.h>
#include <stdlib.h>
#define cant 50
int main()
{
    int arregloal[cant]={0}, i;
    srand(time(NULL));
    for(i=0;i<cant;i++)
        arregloal[i]=rand();
    for(i=1;i<cant;i+=2){
        if ((arregloal[i]%2)==0)
            printf("%d \n",arregloal[i]);
    }
    return 0;
}
