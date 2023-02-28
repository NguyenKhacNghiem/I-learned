#include <stdio.h>
#include <stdbool.h>

bool Fibonacci(int n)
{
	int f1 = 0 , f2 = 1, fibonacci = 0 ; 

    while(fibonacci < n)
    {
		fibonacci = f1 + f2 ;
        f1 = f2 ;
        f2 = fibonacci ;
    }

	if(fibonacci == n)	return true ;
    else	            return false ;
}

int main()
{
    int n ;

    printf("Nhap so ban muon kiem tra: ") ;
    scanf("%d",&n) ;

    if(Fibonacci(n))    printf("TRUE") ;
    else                printf("FALSE") ;

    return 0 ;
}