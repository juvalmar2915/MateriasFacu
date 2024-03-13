#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>  
#include <math.h>
#include <pthread.h>

double *A, *B, *C, *P, *D, *R,*mattemp1,*mattemp2 , *Result1, *Result2;
int T,bs,n;
double minA,maxD,promP;
double *maxDarreglo,*minAarreglo, *arregloPromedios;
double timetick;
double sumaglobal;
pthread_barrier_t *barreras;
pthread_barrier_t *barreramaxymin;
pthread_barrier_t *barreraprom;
// prototipos de funcion
double dwalltime();
void* resultadoR(void *arg);
void PromedioP(double *p, double *prom,int n,int tid);
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs, int tid);
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs, int tid);
void calcularP(double* r1, double* r2, double maxD, double minA,double *P ,int n, int tid);
void multiplicarPorDouble(double *m, double num, double *r, int n, int tid);

//multiplicacion a*b d*c y calculo de minimo de A y maximo de D
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs, int tid){
  int I, J, K;
  int i,j,k;
  int temp, temp2,temp3,temp4;
  double *ablk, *bblk, *cblk, *dblk, *r1blk, *r2blk;
  double maxloc = -1.00;
  double minloc = 999.00;
   
  for(I = tid*n/T; I < (tid+1)*n/T; I += bs)
  {
    temp3=I*n;
    for(J = 0; J < n; J += bs)
    {
        temp4=J*n;
        r1blk = &r1[temp3 + J];
        r2blk = &r2[temp3 + J];
        for(K = 0; K < n; K += bs)
        {
        ablk = &a[temp3 + K];
        bblk = &b[temp4 + K];
        dblk = &d[temp3 + K];
        cblk = &c[temp4 + K];
        
        for (i = 0; i < bs; i++)
            {
            temp=i*n;
                for (j = 0; j < bs; j++)
                {
                    temp2=j*n;
                    if (dblk[temp+j] > maxloc) maxloc = dblk[temp+j];
                    if (ablk[temp+j] < minloc) minloc = ablk[temp+j];
                    for  (k = 0; k < bs; k++)
                    {
                    r1blk[temp + j] += ablk[temp + k] * bblk[temp2 + k];
                    r2blk[temp + j] += dblk[temp + k] * cblk[temp2 + k];
                    }
                }
            }
        }
    }
  }
  *max=maxloc;
  *min=minloc;
  
}

//Multiplicacion de abc y dcb
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs, int tid){
  int I, J, K;
  int i,j,k;
  int temp, temp2, temp3, temp4;
  double *mt1blk, *mt2blk, *cblk, *bblk, *r1blk, *r2blk;
   
  for(I = tid*n/T; I < (tid+1)*n/T; I += bs)
  {
    temp3=I*n;
    for(J = 0; J < n; J += bs)
    {
        temp4=J*n;
        r1blk = &r1[temp3 + J];
        r2blk = &r2[temp3 + J];
        for(K = 0; K < n; K += bs)
        {
        mt1blk = &mt1[temp3 + K];
        cblk = &c[temp4 + K];
        mt2blk = &mt2[temp3 + K];
        bblk = &b[temp4 + K];
        
        
        
        for (i = 0; i < bs; i++)
            {
            temp=i*n;
                for (j = 0; j < bs; j++)
                {
                    temp2=j*n;
                    for  (k = 0; k < bs; k++)
                    {
                    r1blk[temp + j] += mt1blk[temp + k] * cblk[temp2 + k];
                    r2blk[temp + j] += mt2blk[temp + k] * bblk[temp2 + k];
                    }
                }
            }
        }
    }
  }
}

// Multiplicacion de maxD con abc y minA con DCB y luego suma de estos
void calcularP(double* r1, double* r2, double maxD, double minA,double *p ,int n, int tid){
  int i,j,temp;

  for (i=tid*n/T; i<(tid+1)*n/T; i++){
        temp = i*n;
        
        for (j=0; j<n; j++){
            r1[temp+j] *= maxD;
            r2[temp+j] *= minA;
            p[temp+j]= r1[temp+j] + r2[temp+j];
        }
  }
}

// Realizar promedio de P
void promedioP(double *p, double *suma, int n, int tid){
int I, J,aux;
double sumaloc=0;
  for(I = tid*n/T; I < (tid+1)*n/T; I++)
  {
      aux=I*n;
      for(J = 0; J < n; J++)
      {
     sumaloc += p[aux + J];
      }
  }
  *suma=sumaloc;
}

// Multiplicar matriz por double
void multiplicarPorDouble(double *m, double num, double *r, int n, int tid){
int I, J,aux;
  for(I = tid*n/T; I < (tid+1)*n/T; I++)
  {
      aux=I*n;
      for(J = 0; J < n; J++)
      {
        r[aux + J]= m[aux + J] *num;
      }
  }
}

double dwalltime(){
    double sec;
    struct timeval tv;

    gettimeofday(&tv,NULL);
    sec = tv.tv_sec + tv.tv_usec/1000000.0;
    return sec;
}

void* resultadoR(void *arg){
  int I;
  int tid=*(int*)arg;
  //etapa 1(multiplicacion bloques y calculo minimo y maximo)
  multyminAmaxD(A,B,D,C,mattemp1,mattemp2,&minAarreglo[tid],&maxDarreglo[tid],n,bs,tid);
  //termino etapa 1
  pthread_barrier_wait(&barreras[0]);
  
  int mid_T = T / 2;
  int barrier_id;
  while (mid_T > 0){
      barrier_id = tid % mid_T;
      pthread_barrier_wait(&barreramaxymin[barrier_id]);
      if (tid < mid_T){
          if (minAarreglo[tid] > minAarreglo[tid+mid_T]){
              minAarreglo[tid] = minAarreglo[tid+mid_T];
          }
          if (maxDarreglo[tid] < maxDarreglo[tid+mid_T]){
              maxDarreglo[tid] = maxDarreglo[tid+mid_T];
          }
          mid_T = mid_T / 2;
      }
      else{
          break;
      }
  }
  if (tid == 0) {
      minA = minAarreglo[tid];
      maxD = maxDarreglo[tid];
  }
  //etapa 2(multiplicacion bloques)
  mult(mattemp1,C,mattemp2,B,Result1,Result2,n,bs,tid);
  //termino etapa 2
  pthread_barrier_wait(&barreras[1]);
  //etapa 3(calculo de p)
  calcularP(Result1, Result2, maxD, minA, P, n, tid);
  //termino etapa 3
  pthread_barrier_wait(&barreras[2]);
  //etapa 4(calculo de promedio de p)
  promedioP(P, &arregloPromedios[tid], n, tid);
  //termino etapa 4
  pthread_barrier_wait(&barreras[3]);
  //etapa 5(calculo promp)
  mid_T = T / 2;
  while (mid_T > 0){
    barrier_id = tid % mid_T;
    pthread_barrier_wait(&barreraprom[barrier_id]);
    if (tid < mid_T){
        arregloPromedios[tid]+=arregloPromedios[tid+mid_T];
        mid_T = mid_T / 2;
    }
    else{
        break;
    }
  }
  if (tid == 0) {
      promP = arregloPromedios[0]/(n*n);
  } 
  pthread_barrier_wait(&barreras[4]);
  //termino etapa 5
  //etapa 6(calculo de R)
  multiplicarPorDouble(P, promP, R, n,tid);
  pthread_exit(NULL);
}


int main(int argc, char *argv[]){
    int x,y,id;
    if (argc != 4){
      printf("Error en la cantidad de parametros. Debe pasar tamaño de matriz, tamaño de bloque y cantidad de hilos");
      exit(1);
    }
    T = atoi(argv[3]);
    if(T!=4 && T!=8){
      printf("Error en los parametros. La cantidad de hilos debe ser 4 o 8");
      exit(1);  
    }
    if (((n = atoi(argv[1])) <= 0) || ((bs = atoi(argv[2])) <= 0) || ((n % bs) != 0)){
      printf("Error en los parametros. Usar: ./%s N BS (N debe ser multiplo de BS)\n", argv[0]);
      exit(1);
    }

    // Alocar
    minAarreglo = (double *) malloc(T*sizeof(double));
    maxDarreglo = (double *) malloc(T*sizeof(double));
    arregloPromedios = (double *) malloc(T*sizeof(double));
    R = (double *) malloc(n*n*sizeof(double));
    P = (double *) malloc(n*n*sizeof(double));
    A = (double *) malloc(n*n*sizeof(double));
    B = (double *) malloc(n*n*sizeof(double));
    C = (double *) malloc(n*n*sizeof(double));
    D = (double *) malloc(n*n*sizeof(double));
    mattemp1 = (double *) malloc(n*n*sizeof(double));
    mattemp2 = (double *) malloc(n*n*sizeof(double));
    Result1 = (double *) malloc(n*n*sizeof(double));
    Result2 = (double *) malloc(n*n*sizeof(double));   
     // Inicializacion
     for (x = 0; x < n; x++){
        for (y = 0; y < n; y++){
            A[x*n + y] = 1.0;
            B[y*n + x] = 1.0;
            C[y*n + x] = 1.0;
            D[x*n + y] = 1.0;
            P[x*n + y] = 0.0;
            R[x*n + y] = 0.0;
            mattemp1[x*n + y] = 0.0;
            mattemp2[x*n + y] = 0.0;
            Result1[x*n + y] = 0.0;
            Result2[x*n + y] = 0.0;
        }
     }
     maxD=0.0;
     minA=999.0;
    //creo barreras
    barreramaxymin=(pthread_barrier_t*) malloc((T/2) * sizeof(pthread_barrier_t));
    barreraprom=(pthread_barrier_t*) malloc((T/2) * sizeof(pthread_barrier_t));
    barreras=(pthread_barrier_t*) malloc((6) * sizeof(pthread_barrier_t));
    for (id = 0; id < T/2; id++){
    pthread_barrier_init(&barreramaxymin[id],NULL,2);
    }
    for (id = 0; id < T/2; id++){
    pthread_barrier_init(&barreraprom[id],NULL,2);
    }
    for (x = 0; x < 6; x++){
    pthread_barrier_init(&barreras[x],NULL,T);
    }
    //creo hilos
    pthread_t misThreads[T];
    int threads_ids[T];

    double t0 = dwalltime();
    
    for(id=0;id<T;id++){
      threads_ids[id]=id;
      pthread_create(&misThreads[id],NULL,&resultadoR,(void*)&threads_ids[id]);
    }
    for(id=0;id<T;id++){
      pthread_join(misThreads[id],NULL);
    }
    double t1 = dwalltime();
    printf("Tiempo en segundos: %f\n", t1-t0);
    // verificar
    printf("Maximo de D es %f\n" ,maxD);
    printf("Min de A es %f\n" ,minA);
    printf("Promp %f\n", promP);
    double final=2.0*n*n*promP;
    // Validando
    for (x = 0; x < n; x++)
    {
      for (y = 0; y < n; y++)
      {
        if (R[x*n + y] != final)
        {
          printf("Error en %d, %d, valor: %f\n", x, y, R[x*n + y]);
        }
      }
    }

    // liberar memoria
    for (id = 0; id < T/2; id++){
        pthread_barrier_destroy(&barreramaxymin[id]);
    }
    for (id = 0; id < T/2; id++){
        pthread_barrier_destroy(&barreraprom[id]);
    }
    for (x = 0; x < 6; x++){
    pthread_barrier_destroy(&barreras[x]);
    }
    free(barreramaxymin);
    free(barreraprom);
    free(barreras);
    free(minAarreglo);
    free(maxDarreglo);
    free(A);
    free(B);
    free(C);
    free(D);
    free(P);
    free(R);
    free(mattemp1);
    free(mattemp2);
    free(Result1);
    free(Result2);
    return 0;
}





