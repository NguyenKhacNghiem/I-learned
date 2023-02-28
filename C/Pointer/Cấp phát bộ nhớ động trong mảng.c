#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, *p, i ;
    p = (int *)malloc(n * sizeof(int));

    do
    {
        printf("Nhap n (0 < n <= 100): ") ;
        scanf("%d",&n) ;
    }while(n <= 0 || n > 100) ;

    for(i=0;i<n;++i)
    {
        printf("Nhap gia tri cho phan tu thu %d: ",i+1) ;
        scanf("%d",p+i) ;
    }

    for(i=0;i<n;i++)
        printf("%d\t", *(p+i)) ;

    return 0 ;
}