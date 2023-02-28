#include <stdio.h>

int check(int) ;
void print(int) ;

int main()
{
    int n ;

    printf("nhap n:") ;
    scanf("%d",&n) ;

    print(n) ;

    return 0 ;
}

void print(int n)
{
    int i ;

    for(i=1;i<=n;i++)  // i từ 1->n 
        if(check(i) == i)
            printf("%d\t",i) ;
}

int check(int i)
{
    int k , sum = 0 ;

    for(k=1;k<i;k++)
        if(i % k == 0)
            sum += k ;
    
    return sum ;
}