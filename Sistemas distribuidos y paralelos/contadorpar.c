#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <sys/resource.h> 
#include <pthread.h>

double dwalltime();
int n;
int x;
int canthilos;
int cantidadtot=0;
int *v;
pthread_mutex_t mutex;
void* funcion(void *arg){
int tid=*(int*)arg;
int i,iguales;
iguales=0;
printf("Hilo id:%d\n",tid);
for(i=tid*n/canthilos;i<(tid+1)*n/canthilos;i++){
	if(v[i]==x)
		iguales++;	
}
pthread_mutex_lock(&mutex);
cantidadtot += iguales;
pthread_mutex_unlock(&mutex);
pthread_exit(NULL);
}
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
canthilos = atoi(argv[1]);
n = atoi(argv[2]);
x = atoi(argv[3]);
pthread_t misThreads[canthilos];
int threads_ids[canthilos];
v = (int*) malloc(n * sizeof(int));
pthread_mutex_init(&mutex, NULL);
unsigned long numBytes = sizeof(int)*n;
int posicionSeleccionada = 20;
unsigned long i;
unsigned long iguales=0;
v=inicializarVector(v,n);	
timetick = dwalltime();
for(int id=0;id<canthilos;id++){
threads_ids[id]=id;
pthread_create(&misThreads[id],NULL,&funcion,(void*)&threads_ids[id]);
}
for(int id=0;id<canthilos;id++){
pthread_join(misThreads[id],NULL);
}
printf("-> Tiempo Paralelo: %f\n", dwalltime() - timetick);
printf("cant oc %d \n",cantidadtot);
for (i=0; i<n; i++){
   if (v[i] == x) cantidadtot--;
}
if (cantidadtot != 0) printf("ERROR: conteo mal realizado\n");
printf("cant oc %d \n",cantidadtot);
free(v);
return 0;
}
