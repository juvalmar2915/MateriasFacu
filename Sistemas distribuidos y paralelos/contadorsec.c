#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <time.h> 

double dwalltime(){
        double sec;
        struct timeval tv;

        gettimeofday(&tv,NULL);
        sec = tv.tv_sec + tv.tv_usec/1000000.0;
        return sec;
}

int* inicializarVector(int* v,unsigned long N){
unsigned long i;
	for(i=0;i<N;i++){
		v[i]=rand()%1000;
	}
	
	return v;
}


int main(int argc, char *argv[]){
double timetick;
time_t t;
srand((unsigned) time(&t));
int* v;
unsigned long N=atol(argv[1]);
int x=atoi(argv[2]);
unsigned long numBytes = sizeof(int)*N;
int posicionSeleccionada = 20;
unsigned long i;
unsigned long iguales=0;

	v=(int*)malloc(numBytes);
	v=inicializarVector(v,N);	
	timetick = dwalltime();
	for(i=0;i<N;i++){
		if(v[i]==x)
			iguales++;	
	}
	printf("-> Tiempo Secuencial: %f\n", dwalltime() - timetick);
	free(v);
	return 0;
}
