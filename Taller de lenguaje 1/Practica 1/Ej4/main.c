#include <stdio.h>
#include <stdlib.h>
/*
int main()
{
    int i, multiplo;
    for(i=1; i<=50; i++){
    multiplo=i%5;
    if (multiplo==0)
        printf("%d es multiplo de 5\n", i);
    }
    return 0;
}
*/
int main()
{
    int i;
    for(i=5; i<=50; i+=5){
        printf("%d es multiplo de 5\n", i);
    }
    return 0;
}
