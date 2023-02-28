#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool isSquareNumber(int n)
{
    int i ;

    for(i=0;i<=n;i++)
        if(pow(i, 2) == n)
            return true ;
    
    return false ;
}

int main()
{
    int n = 5 ;

    if(isSquareNumber(n))
        printf("%d la so chinh phuong", n) ;
    else
        printf("%d khong la so chinh phuong", n) ;

    return 0 ;
}