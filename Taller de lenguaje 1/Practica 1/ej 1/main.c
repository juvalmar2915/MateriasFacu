#include <stdlib.h>
/*
int main()
{
 double pi= 3.14;
 int y= 5; // tira un warning de como si no fuese usada "warning: unused variable 'y' [-Wunused-variable]|"
 printf("pi= %d\n", pi); // imprime un double como un integer para imprimirlo como double %f "warning: format '%d' expects argument of type 'int', but argument 2 has type 'double' [-Wformat=]|"
 //no termina con un return 0 dice "warning: control reaches end of non-void function [-Wreturn-type]|"
}
*/
#include <stdio.h>
int main(){
 int x=10;
 if (x=5) //dice que recomienda hacer una igualdad en vez de asignacion porque sino en ese if siempre va a entrar warning: suggest parentheses around assignment used as truth value [-Wparentheses]|
 printf("x = 5\n");
 return 0;
}

