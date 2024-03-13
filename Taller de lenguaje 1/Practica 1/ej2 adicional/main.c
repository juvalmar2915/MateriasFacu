#include <stdio.h>
#include <stdlib.h>
/* a)
int main()
{
    int numero,natural, binario=0;
    printf("escriba un numero natural: \n");
    scanf("%d",&numero); //se pone espacio solo en caracteres para limpiar buffer
    natural=numero;
    while (natural>0){
        binario=binario*10;
        binario=binario+natural%2;
        natural=natural/2;
    }
    printf("la representacion binaria para %d es: %d \n", numero, binario);
    return 0;
}
*/
int pasarbinario(int);
int main()
{
    int numero, binario;
    binario=0;
    printf("escriba un numero natural: \n");
    scanf("%d",&numero);
    binario=pasarbinario(numero);
    printf("la representacion binaria para %d es: %d \n", numero, binario);
    return 0;
}
int pasarbinario(int n){
  if (n==0)
      return (0);
  else
      return (n%2 + (pasarbinario(n/2) * 10)); // si yo tengo dentro del return un llamado a una funcion este no se cierra hasta que termina con las funciones de dentro
}
