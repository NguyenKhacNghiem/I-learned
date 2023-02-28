#include <stdio.h>
#include <math.h>

int convert(int) ;

int main()
{
    int n ;

    printf("nhap n:") ;
    scanf("%d",&n) ;

    printf("%d",convert(n)) ;
    return 0 ;
}

int convert(int n)
{
    int count , last , sum=0 ;

    for(count=0 ; n!=0 ; n/=10,count++)
    {
        last = n%10 ;
        sum += last*pow(2,count) ;
    }
    return sum ;
}