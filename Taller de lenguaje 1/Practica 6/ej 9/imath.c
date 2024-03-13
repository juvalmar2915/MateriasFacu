#include <stdio.h>
#include <stdlib.h>

int potencia(int x, int y){
    int i;
    for (i=1;i<=y;i++){
        x=x*x;
    }
    return x;
}
int cuadrado(int x){
    return (x*x);
}
int cubo(int x){
    return (x*x*x);
}
int absoluto(int i){
    if (i<0){
        return (i*-1);
    }
    else{
        return i;
    }
}
int factorial (int i){
    if (i==0){
        return 1;
    }
    else{
       int x;
       for (x=(i-1); x>0; x--){
        i=i*x;
       }
       return i;
    }
}
int sumatoria (int i){
    int sum=0,x;
    for (x=1; x<=i; x++){
        sum=sum+x;
    }
    return sum;
}
int multiplo (int x, int y){
    if ((y%x)==0){
        return 1;
    }
    else{
        return 0;
    }
}
int divisor (int x, int y){
    if ((x%y)==0){
        return 1;
    }
    else{
        return 0;
    }
}
int par (int i){
    if ((i%2)==0){
        return 1;
    }
    else{
        return 0;
    }
}
int impar (int i){
    if ((i%2)!=0){
        return 1;
    }
    else{
        return 0;
    }
}
