#include <stdio.h>
#include <stdlib.h>

int main()
{
    char palabra[30];
    int palabras5=0;
    printf("escriba una palabra: ");
    scanf("%s", palabra);
    while (strcmp(palabra, "ZZZ")!=0){
        if (strlen(palabra)==5)
            palabras5++;
        printf("escriba una palabra: ");
        scanf("%s",palabra);
    }
    printf("el numero de palabras de longitud igual a 5 fue: %d",palabras5);
    return 0;
}
