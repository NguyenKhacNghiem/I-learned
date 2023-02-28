#include <stdio.h>

void thayDoi2(int *a)
{
    *a += 10 ;
}

void thayDoi1(int *a)
{
    *a += 10 ;
    thayDoi2(&*a) ;
}

int main()
{
    int a = 0 ;

    thayDoi1(&a) ;

    printf("%d",a) ;

    return 0 ;
}