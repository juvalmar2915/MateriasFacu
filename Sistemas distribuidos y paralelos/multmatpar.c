#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
double dwalltime();
int n;
int canthilos;
double *A, *B, *C;
void* funcion(void *arg){
int tid=*(int*)arg;
int i,j,k;
printf("Hilo id:%d\n",tid);
for(i=tid*n/canthilos;i<(tid+1)*n/canthilos;i++){
	for(j=0;j<n;j++){
		for(k=0;k<n;k++){
			C[i*n+j] += A[i*n+k]*B[k+j*n];
		}	
	}
}   
//Código que ejecutará cada hilo
pthread_exit(NULL);
}
int main(int argc, char* argv[]){
double timetick;
canthilos = atoi(argv[1]);
n = atoi(argv[2]);
pthread_t misThreads[canthilos];
int threads_ids[canthilos];
int i,j,k;
A = (double*) malloc(n * n * sizeof(double));
B = (double*) malloc(n * n * sizeof(double));
C = (double*) malloc(n * n * sizeof(double));
for (i=0; i<n; i++){
  for (j=0; j<n; j++){
    A[i*n+j] = 1;       // Por filas
    B[i+j*n] = 1;       // Por columnas
    C[i*n+j] = 0;       // Por filas
  }
}
timetick = dwalltime();
for(int id=0;id<canthilos;id++){
threads_ids[id]=id;
pthread_create(&misThreads[id],NULL,&funcion,(void*)&threads_ids[id]);
}
for(int id=0;id<canthilos;id++){
pthread_join(misThreads[id],NULL);
}
printf("Tiempo Mult en segundos %f \n", dwalltime() - timetick);

  for (i=0; i<n; i++){
        for (j=0; j<n; j++){
            if (C[i*n+j] != n) printf("Error en posicion %d, %d\n", i, j);
        }
    }

    // Liberar memoria
    free(A);
    free(B);
    free(C);

return 0;
}

/*****************************************************************/

#include <sys/time.h>

double dwalltime()
{
	double sec;
	struct timeval tv;

	gettimeofday(&tv,NULL);
	sec = tv.tv_sec + tv.tv_usec/1000000.0;
	return sec;
}
