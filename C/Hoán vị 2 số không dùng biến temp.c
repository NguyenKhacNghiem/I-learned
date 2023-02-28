#include <stdio.h>

int main()
{
    int a = 3, b = 7 ;

    printf("a = %d, b = %d",a,b) ;

    // Hoan vi 2 so su dung toan tu XOR
    a = a^b ;
    b = a^b ;
    a = a^b ;

    printf("a = %d, b = %d",a,b) ; 
}