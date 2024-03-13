#include <stdio.h>
#include <stdlib.h>
int main()
{
    int i;
    srand(time(NULL)); // para que la semilla que tiene guardada rand se actualice cada vez que ejecutamos un programa ponemos al inicio de nuestro programa srand y se puede utilizar de dos maneras una basado  en la hora time(NULL) y tambien basado en el numero de procesos del programa getpid()
    for (i=1;i<=15;i++){
        printf("%d \n",rand());
    }
    return 0;
}
