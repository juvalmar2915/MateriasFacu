#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>  
#include <math.h>

// prototipos de funcion
double dwalltime();
void PromedioP(double *p, double *prom, int n);
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs);
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs);
void calcularP(double* r1, double* r2, double maxD, double minA,double *P ,int n);
void multiplicarPorDouble(double *m, double num, double *r, int n);

double dwalltime(){
    double sec;
    struct timeval tv;

    gettimeofday(&tv,NULL);
    sec = tv.tv_sec + tv.tv_usec/1000000.0;
    return sec;
}
//multiplicacion a*b d*c y calculo de minimo de A y maximo de D
void multyminAmaxD(double* a, double* b, double* d, double* c, double* r1, double* r2, double* min, double* max, int n, int bs){
  int I, J, K;
  int i,j,k;
  int temp, temp2, temp3, temp4;
  double *ablk, *bblk, *cblk, *dblk, *r1blk, *r2blk;
  double maxloc = -1.00;
  double minloc = 999.00;
   
  for(I = 0; I < n; I += bs)
  {
    temp3 = I*n;
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

  *min = minloc;
  *max = maxloc;
}

//Multiplicacion de abc y dcb
void mult(double* mt1, double* c, double* mt2, double* b, double* r1, double* r2, int n, int bs){
  int I, J, K;
  int i,j,k;
  int temp, temp2, temp3, temp4;
  double *mt1blk, *mt2blk, *cblk, *bblk, *r1blk, *r2blk;
   
  for(I = 0; I < n; I += bs)
  {
    temp3 = I*n;
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
void calcularP(double* r1, double* r2, double maxD, double minA,double *P ,int n){
  int i,j,temp;

  for (i=0; i<n; i++){
        temp = i*n;
        
        for (j=0; j<n; j++){
            r1[temp+j] *= maxD;
            r2[temp+j] *= minA;
            P[temp+j]= r1[temp+j] + r2[temp+j];
        }
    }
}

// Realizar promedio de P
void promedioP(double *p, double *prom, int n){
int I, J,aux;
double suma=0;
  for(I = 0; I < n; I += 1)
  {
      aux=I*n;
      for(J = 0; J < n; J += 1)
      {
        suma += p[aux + J];
      }
  }
  *prom = suma/(n*n);
}

// Multiplicar matriz por double
void multiplicarPorDouble(double *m, double num, double *r, int n){
int I, J,aux;
  for(I = 0; I < n; I += 1)
  {
      aux=I*n;
      for(J = 0; J < n; J += 1)
      {
        r[aux + J]= m[aux + J] *num;
      }
  }
}

int main(int argc, char *argv[]){
    double *A, *B, *C, *D,*P,*R,*mattemp1,*mattemp2,*Result1,*Result2;
    int n, bs;
    int i,j;
    double maxD, minA,promP;
    
    if ( (argc != 3) || ((n = atoi(argv[1])) <= 0) || ((bs = atoi(argv[2])) <= 0) || ((n % bs) != 0)){
        printf("\nError en los parámetros. Usage: ./%s N BS (N debe ser multiplo de BS)\n", argv[0]);
        exit(1);
    }

    // Alocar
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

    multyminAmaxD(A,B,D,C,mattemp1,mattemp2,&minA,&maxD,n,bs);
    mult(mattemp1,C,mattemp2,B,Result1,Result2,n,bs);
    calcularP(Result1, Result2, minA, maxD, P,n);
    promedioP(P,&promP,n);
    multiplicarPorDouble(P, promP, R, n);
    double t1 = dwalltime();
    printf("Tiempo en segundos: %f\n", t1-t0);

    // verificar
    printf("Maximo de D es %f\n" ,maxD);
    printf("Min de A es %f\n" ,minA);
    printf("Promp %f\n", promP);
    double final=2.0*n*n*promP;
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
    free(Result1);
    free(Result2);
    return 0;
}




