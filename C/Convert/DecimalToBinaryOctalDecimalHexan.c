#include <stdio.h>

void convert(int n, int base) 
{
	if(n > 0) 
    {
		convert(n / base, base) ; 
		
		int x = n % base ;
		
		if(base == 16 && x >= 10)  // hexan
		{
			if(x == 10)			printf("A");
			else if(x == 11)	printf("B");
			else if(x == 12)	printf("C");
			else if(x == 13)	printf("D");
			else if(x == 14)	printf("E");
			else				printf("F");				
		}
		else  // binary, decimal, octal
			printf("%d", x) ; 
	}
}

int main()
{
    int n, base ;

    printf("Enter decimal number: ") ;
    scanf("%d",&n) ;

    printf("What base would you like to convert (binary, octal, decimal, hexan): ") ;
    scanf("%d",&base) ;

    convert(n,base) ;

    return 0 ;
}