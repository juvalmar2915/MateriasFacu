#include <stdio.h>
#include <stdlib.h>

int main()
{
    int prim=2,seg=3,ter=4,i;
    float p=3;
    for(i=1;prim<10;i++){
        p=p+(float) 4/(prim*seg*ter);
        prim+=2;
        seg+=2;
        ter+=2;
        p=p- (float) 4/(prim*seg*ter);
        prim+=2;
        seg+=2;
        ter+=2;
    }
    printf("pi= %.6f", p);
    return 0;
}
// no hay diferencia en aproximarlo ya sea con float o con double ya que lo que pide es la aproximacion de 6 digitos y cualquiera de los dos la puede realizar
