#include <stdio.h>

void converte(int n, int base) 
{
	if(n > 0) 
    {
		converte(n / base, base) ; 
		printf("%d", n % base) ; 
	}
}

int main()
{
    int n, base ;

    printf("Enter decimal number: ") ;
    scanf("%d",&n) ;

    printf("What base would you like to convert (binary, octal, decimal, hexan): ") ;
    scanf("%d",&base) ;

    converte(n,base) ;

    return 0 ;
}