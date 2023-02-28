#include <stdio.h>
#include <math.h>

int check(int , int) ;
int dem(int) ;
void print(int) ;

int main()
{
    int n ;

    printf("nhap n:") ; 
    scanf("%d",&n) ;
    
    print(n) ;
}

int dem(int i)
{
    int count = 0 ;

    for(;i!=0;i/=10)
        count++ ;

    return count ;
}

void print(int n)
{
    int i , count  ;

    for(i=1;i<=n;i++) // từ 1->n
    {
        count = dem(i) ;
        if(check(i,count) == i)
            printf("%d\t",i) ;
    }
}

int check(int i , int count)
{
    int last , sum = 0 ;

    for(;i!=0;i/=10)
    {
        last = i % 10 ;
        sum += pow(last,count) ; 
    }

    return sum ;
}