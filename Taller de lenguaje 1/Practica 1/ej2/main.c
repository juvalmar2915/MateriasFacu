#include <stdio.h>
int main(){
char c= 'a';
int x= 64 , cuentac;
printf("char c= %c\n", x); // cuando intento asignar un integer a un char va y busca el numero del int en el codigo asci
printf("int x= %d\n", c); //cuando intento asignar un char a un integer imprime el numero que esta asignado a ese char en el codigo asci
cuentac= 2*32+10%2-1; //separa en terminos
return 0;
}
// b. la diferencia entre un float y un double es que para el double tenes mas bytes para representarlo el float ocupa 4 bytes y el double 8
// d. el sizeof indica cuantos bytes ocupa cada tipo de dato, incluso un registro en la memoria; car ocupa 1 byte, entero ocupa 4 bytes, flotante ocupa 4 bytes, un double ocupa 8 bytes
