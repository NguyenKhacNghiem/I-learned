#include <stdio.h>
#include <math.h>

void PrintPrimeNumber(int) ; 
int CheckPrimeNumber(int) ;

int main()
{
    int n ; 

    printf("nhap n :") ; 
    scanf("%d",&n) ; 

    PrintPrimeNumber(n) ;

    return 0 ; 
}

void PrintPrimeNumber(int n)
{
    int i ;

    for(i=1;i<=n;i++)  // từ 1->n
        if(CheckPrimeNumber(i) == 1 && i>1) // loại bỏ các số <2
            printf("%d\t",i) ; 
}

int CheckPrimeNumber(int i)
{
    int k ;

    for(k=2;k<=sqrt(i);k++)
        if (i % k == 0)
            return 0 ;
    
    return 1 ;
}