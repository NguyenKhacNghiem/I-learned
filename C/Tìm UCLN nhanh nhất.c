#include <stdio.h>

int khongDeQuy(int a, int b)
{
	while(a!=b)
	{
		if(a>b)	a -= b ;
		else    b -= a ;
	}
	
	return a ;
}

int deQuy(int a, int b)
{
    if(b == 0)	return a ;

    return deQuy(b, a % b) ;
}

int main()
{
    int a = 12, b = 8;

    printf("Khong de quy: %d\n", khongDeQuy(a, b));
    printf("De quy: %d\n", deQuy(a, b));

    while(a ^= b ^= a ^= b %= a); // nho co ";" nha
    printf("Dung 1 dong code: %d", b);

    return 0 ;
}