#include <stdio.h>

int tinhtong(int n)
{
    if (n==1)
        return 1 ;

    return n + tinhtong(n-1) ;
}

int main()
{
    int n ;
    printf("nhap n: ") ;
    scanf("%d",&n) ;
    printf("%d",tinhtong(n)) ;
}