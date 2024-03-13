#include <stdio.h>
#include <stdlib.h>
void upperStr(char []);
void lowerStr(char []);
void numToStr(int, char []);
void numToText(int, char []);
int main()
{
	char cadena[80],almacenonum[50];
	int aconvertir;
	printf("Introduce una cadena:");
	scanf("%s",cadena);
	upperStr(cadena);
	printf ("En Mayusculas: %s\n", cadena);
	lowerStr(cadena);
	printf ("En Minusculas: %s\n", cadena);
	printf("Introduce un numero :");
	scanf("%d",&aconvertir);
	numToStr(aconvertir,almacenonum);
	printf ("El numero en cadena: %s\n", almacenonum);
	printf("Introduce un numero en el rango de 0 a 99:");
	scanf("%d",&aconvertir);
	numToText(aconvertir,almacenonum);
	printf("%s",almacenonum);
	return 0;
}

void upperStr(char string[])
{
	int i=0;
	int desp='a'-'A';
	for (i=0;string[i]!='\0';i++)
	{
		if(string[i]>='a'&&string[i]<='z')
		{
			string[i]=string[i]-desp;
		}
	}
}

void lowerStr(char string[])
{
	int i=0;
	int desp='a'-'A';
	for (i=0;string[i]!='\0';i++)
	{
		if(string[i]>='A'&&string[i]<='Z')
		{
			string[i]=string[i]+desp;
		}
	}
}

void numToStr(int n, char string[])
{
    int i=0,dig,cant=0,aux=n;
    char nums[10]={'0','1','2','3','4','5','6','7','8','9'};
    while (aux>0){
        aux=aux/10;
        cant++;
    }
    string[cant]='\0';
    for (i=0;cant!=0;i++, cant--)
	{
	    dig=n%10;
		string[cant-1]=nums[dig];
		n=n/10;
	}
}

void numToText(int n, char string[])
{
    char *numeros[]={"un","uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

    char *dieces[]={"once", "doce", "trece", "catorce", "quince"};

    char *decenas[]={"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    int i,x,dig;
    dig=n%10;
    n=n/10;
    if (n!=0){
        if (n>1){
            i=n-1;
            strcpy(string,*(decenas+i));
            if (dig!=0){
                x=dig-1;
                strcat(string, " y ");
                strcat(string,*(numeros+x));
            }
        }
        else{
            if (n==1){
                if ((dig>5) || (dig==0)){
                    strcpy(string,*(decenas));
                    if (dig!=0){
                        x=dig-1;
                        strcat(string, " y ");
                        strcat(string,*(numeros+x));
                    }
                }
                else{
                    x=dig-1;
                    strcpy(string,*(dieces+x));
                }
            }
        }
    }
    else{
        if (dig==0){
            strcpy(string,"cero");
        }
        else{
            for (i=0;i<dig;i++);
            strcpy(string,*(numeros+i));
        }
    }
}
