#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool checkPrime(int n, int i)
{
    if(n < 2 || n % i ==0)  return false ;

    // i<= sqrt(n) thoi. Gio lon hon ma ko false thi true
    if(i > sqrt(n))    return true ;

    return checkPrime(n,i+1) ;
}

int main()
{
    // n = 5, i = 2
    if(checkPrime(5,2))  printf("true") ;
    else                 printf("false") ;
    
    return 0 ;
}