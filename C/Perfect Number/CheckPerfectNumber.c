#include <stdio.h>

int check(int) ;

int main()
{
    int n ;

    printf("nhap n:") ;
    scanf("%d",&n) ;

    if(check(n) == n)
        printf("so perfect") ;
    else
        printf("ko la so perfect") ;

    return 0 ;
}

int check(int n)
{
    int i , sum=0 ;

    for(i=1;i<n;i++)
        if(n%i==0)
            sum += i ;
    
    return sum ;
}