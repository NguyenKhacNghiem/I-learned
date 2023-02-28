#include <stdio.h>

int khongDeQuy(int n)
{
    int f1 = 1, f2 = 1, fibonacci;

    if(n == 1)            return 0 ;
    if(n == 2 || n == 3)  return 1 ;
 
    for (int i=4;i<=n;i++)
    {
        fibonacci = f1 + f2;
        f2 = f1;
        f1 = fibonacci;
    }

    return fibonacci;
}

int deQuy(int n) 
{
	if(n == 1)            return 0 ;
    if(n == 2 || n == 3)  return 1 ;
	
	return deQuy(n-1) + deQuy(n-2);
}


int main()
{
    int n ;

    printf("Ban muon tim so fibonacci thu may: ") ;
    scanf("%d",&n) ;

    printf("So fibonacci thu %d la: %d\n", n, khongDeQuy(n)) ;
    printf("So fibonacci thu %d la: %d", n, deQuy(n)) ;

    return 0 ;
}