#include <stdio.h>
#include <math.h>

int check(int,int) ;
int dem(int) ;

int main()
{
    int n ; 

    printf("nhap n:") ; 
    scanf("%d",&n) ;
    
    if(check(n,dem(n)) == n)
        printf("la so armstrong") ;
    else
        printf("ko la so armstrong") ;
    
    return 0 ;
}

int check(int n , int count)
{
    int last , sum = 0 ;

    for(;n!=0;n/=10)
    {
        last = n % 10 ;
        sum += pow(last,count) ; 
    }
    
    return sum ;
}

int dem(int n)
{
    int count = 0 ;

    for(;n!=0;n/=10)
        count++ ;
    
    return count ;
}