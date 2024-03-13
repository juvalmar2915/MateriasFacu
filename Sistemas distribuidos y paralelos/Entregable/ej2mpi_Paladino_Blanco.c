#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>  
#include <math.h>
#include <mpi.h>

// prototipos de funcion
double dwalltime();
double PromedioP(double *p, double *prom, int n);
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs, int T);
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs,int T);
void calcularP(double* r1, double* r2, double maxD, double minA,double *P ,int n, int T);
void multiplicarPorDouble(double *m, double num, double *r, int n, int T);

double dwalltime(){
    double sec;
    struct timeval tv;

    gettimeofday(&tv,NULL);
    sec = tv.tv_sec + tv.tv_usec/1000000.0;
    return sec;
}
//multiplicacion a*b d*c y calculo de minimo de A y maximo de D
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs,int T){
  int I, J, K;
  int i,j,k;
  int temp, temp2, temp3, temp4;
  double *ablk, *bblk, *cblk, *dblk, *r1blk, *r2blk;
  double maxloc = -1.00;
  double minloc = 999.00;
   
  for(I = 0; I < n/T; I += bs)
  {
    temp3 = I*n;
    for(J = 0; J < n; J += bs)
    {   
        temp4 = J*n;
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

  *min = minloc;
  *max = maxloc;
}

//Multiplicacion de abc y dcb
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs, int T){
  int I, J, K;
  int i,j,k;
  int temp, temp2, temp3, temp4;
  double *mt1blk, *mt2blk, *cblk, *bblk, *r1blk, *r2blk;
   
  for(I = 0; I < n/T; I += bs)
  {
    temp3 = I*n;
    for(J = 0; J < n; J += bs)
    {
        temp4 = J*n;
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
void calcularP(double* r1, double* r2, double maxD, double minA,double *P ,int n,int T){
  int i,j,temp;

  for (i=0; i<n/T; i++){
        temp = i*n;
        
        for (j=0; j<n; j++){
            r1[temp+j] *= maxD;
            r2[temp+j] *= minA;
            P[temp+j]= r1[temp+j] + r2[temp+j];
        }
    }
}

// Realizar promedio de P
void promedioP(double *p, double *prom, int n,int T){
int I, J,aux;
double suma=0;
  for(I = 0; I < n/T; I++)
  {
      aux=I*n;
      for(J = 0; J < n; J++)
      {
        suma += p[aux + J];
      }
  }
  *prom = suma;
}

// Multiplicar matriz por double
void multiplicarPorDouble(double *m, double num, double *r, int n, int T){
int I, J,aux;
  for(I = 0; I < n/T; I++)
  {
      aux=I*n;
      for(J = 0; J < n; J++)
      {
        r[aux + J]= m[aux + J] *num;
      }
  }
}


void Proceso0(int n, int cp, int bs){
        int i,j;
        double *A,*B,*C,*D,*P,*R,*mattemp1,*mattemp2,*Result1,*Result2,*part,*part2;
        double maxD, minA,promP,promloc=0,maxloc=-1.0,minloc=999.0;
        A = (double *) malloc(n*n*sizeof(double));
        B = (double *) malloc(n*n*sizeof(double));
        C = (double *) malloc(n*n*sizeof(double));
        D = (double *) malloc(n*n*sizeof(double));
        P = (double *) malloc(n*n*sizeof(double));
        R = (double *) malloc(n*n*sizeof(double));
        mattemp1 = (double *) malloc(n*n*sizeof(double));
        mattemp2 = (double *) malloc(n*n*sizeof(double));
        Result1 = (double *) malloc(n*n*sizeof(double));
        Result2 = (double *) malloc(n*n*sizeof(double));
        part= (double*)malloc(sizeof(double)*(n/cp)*n); 
        part2= (double*)malloc(sizeof(double)*(n/cp)*n); 
         // Inicializacion
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                A[i*n + j] = 1.0;
                B[j*n + i] = 1.0;
                C[j*n + i] = 1.0;
                D[i*n + j] = 1.0;
                P[i*n + j] = 0.0;
                R[i*n + j] = 0.0;
            }
        }
        double t0 = dwalltime();
        
        MPI_Scatter(A, (n/cp)*n, MPI_DOUBLE, part, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        MPI_Bcast(B, n*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        MPI_Scatter(D, (n/cp)*n, MPI_DOUBLE, part2, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        MPI_Bcast(C, n*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        multyminAmaxD(part, B, part2, C, mattemp1, mattemp2, &minloc, &maxloc, n, bs, cp);
        MPI_Allreduce(&minloc, &minA, 1, MPI_DOUBLE, MPI_MIN, MPI_COMM_WORLD);
        MPI_Allreduce(&maxloc, &maxD, 1, MPI_DOUBLE, MPI_MAX, MPI_COMM_WORLD);   
        mult(mattemp1, C, mattemp2, B, Result1, Result2, n, bs, cp);
        calcularP(Result1, Result2, maxD, minA, P,n,cp);
        MPI_Gather(P, (n/cp)*n, MPI_DOUBLE, P, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        promedioP(P, &promloc, n, cp);
        MPI_Allreduce(&promloc, &promP, 1, MPI_DOUBLE, MPI_SUM, MPI_COMM_WORLD);
        promP=promP/(n*n);
        multiplicarPorDouble(P, promP, R, n, cp);
        MPI_Gather(R, (n/cp)*n, MPI_DOUBLE, R, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
        
        double t1 = dwalltime();
        // verificar
        printf("Maximo de D es %f\n" ,maxD);
        printf("Min de A es %f\n" ,minA);
        printf("Promp %f\n", promP);
        double final=2.0*n*n*promP;
        
        printf("Tiempo en segundos: %f\n", t1-t0);
        // Validando
        for (i = 0; i < n; i++)
        {
          for (j = 0; j < n; j++)
          {
            if (R[i*n + j] != final)
            {
              printf("Error en %d, %d, valor: %f\n", i, j, R[i*n + j]);
            }
          }
        }
        

        // liberar memoria      
        free(A);
        free(B);
        free(C);
        free(D);
        free(P);
        free(R);
        free(mattemp1);
        free(mattemp2);
        free(part);
        free(part2);
        free(Result1);
        free(Result2);
}

void Proceso1(int n, int cp, int bs){
    double maxD, minA,promP,promloc=0,maxloc=-1.0,minloc=999.0;
    double *B = (double*)malloc(sizeof(double)*n*n);
    double *C = (double*)malloc(sizeof(double)*n*n);
    double *vacio;
    double *part = (double*)malloc(sizeof(double)*(n/cp)*n);
    double *part2 = (double*)malloc(sizeof(double)*(n/cp)*n);
    double *Result1= (double*)malloc(sizeof(double)*(n/cp)*n);
    double *Result2= (double*)malloc(sizeof(double)*(n/cp)*n);
    double *Result3= (double*)malloc(sizeof(double)*(n/cp)*n);
    double *Result4= (double*)malloc(sizeof(double)*(n/cp)*n);
    double *P= (double*)malloc(sizeof(double)*(n/cp)*n);
    double *R= (double*)malloc(sizeof(double)*(n/cp)*n);
    MPI_Scatter(vacio, 0, MPI_DOUBLE, part, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    MPI_Bcast(B, n*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    MPI_Scatter(vacio, 0, MPI_DOUBLE, part2, (n/cp)*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    MPI_Bcast(C, n*n, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    multyminAmaxD(part, B, part2, C, Result1, Result2, &minloc, &maxloc, n, bs, cp);
    MPI_Allreduce(&minloc, &minA, 1, MPI_DOUBLE, MPI_MIN, MPI_COMM_WORLD);
    MPI_Allreduce(&maxloc, &maxD, 1, MPI_DOUBLE, MPI_MAX, MPI_COMM_WORLD);
    mult(Result1, C, Result2, B, Result3, Result4, n, bs, cp);
    calcularP(Result3, Result4, maxD, minA, P,n,cp);
    MPI_Gather(P, (n/cp)*n, MPI_DOUBLE, vacio, 0, MPI_DOUBLE, 0, MPI_COMM_WORLD); 
    promedioP(P, &promloc, n, cp);
    MPI_Allreduce(&promloc, &promP, 1, MPI_DOUBLE, MPI_SUM, MPI_COMM_WORLD);
    promP=promP/(n*n);
    multiplicarPorDouble(P, promP, R, n, cp);
    MPI_Gather(R, (n/cp)*n, MPI_DOUBLE, vacio, 0, MPI_DOUBLE, 0, MPI_COMM_WORLD); 
    
    free(B);
    free(C);
    free(P);
    free(R);
    free(part);
    free(part2); 
    free(Result1); 
    free(Result2);
    free(Result3); 
    free(Result4);
}

int main(int argc, char *argv[]){
    MPI_Init(&argc, &argv);
    int n, bs,T,miID;
    if (argc != 4){
      printf("Error en la cantidad de parametros. Debe pasar tamaño de matriz, tamaño de bloque y cantidad de hilos");
      exit(1);
    }
    T = atoi(argv[3]);
    if(T!=4 && T!=8 && T!=16){
      printf("Error en los parametros. La cantidad de hilos debe ser 4 o 8");
      exit(1);  
    }
    if (((n = atoi(argv[1])) <= 0) || ((bs = atoi(argv[2])) <= 0) || ((n % bs) != 0)){
      printf("Error en los parametros. Usar: ./%s N BS (N debe ser multiplo de BS)\n", argv[0]);
      exit(1);
    }
    MPI_Comm_rank(MPI_COMM_WORLD,&miID);
    MPI_Comm_size(MPI_COMM_WORLD,&T);
    
    
    
    
    if(miID == 0){
        Proceso0(n, T, bs);
        
        
    }else if (miID >= 1 && miID < T){
        Proceso1(n, T, bs);    
        
        
    }

    

   

    
    
    
    
    MPI_Finalize();
    return 0;
}


