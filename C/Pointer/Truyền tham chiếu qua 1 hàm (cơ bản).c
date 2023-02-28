// Truyen tham chieu

#include <stdio.h>

void tinhtong(int *) ;

int main()
{
    int sum ;

    tinhtong(&sum) ;

    printf("sum = %d",sum) ;
}

void tinhtong(int *sum)
{
    int a = 7 , b = 10 ;
    *sum = a+b ;
}