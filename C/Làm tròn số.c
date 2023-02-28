#include <stdio.h>
#include <math.h>

float loop(float n)
{
    while(n>=1)
        n -= 1 ;
    while(n<10)
        n *= 10 ;

    return n ;
}

int tinhtong(float n)
{
    int sum=0, i; 

    while(n>=1)
    {
        n -= 1 ;
        sum += 1 ;
    }

    while(n<10)
    {
        n *= 10 ;
        i = n ; 
        if(i>9)
        {
            i = i%10 ; 
            sum += i ; 
            return sum ; 
        }
        sum+=i ; 
    }
}

int main()
{
    float n ; 

    printf("nhap n: ") ; 
    scanf("%f",&n) ;  

    float temp = n ;

    printf("%.1g\n",n) ;
    printf("%.2f\n",n) ;

    printf("%g\n",floor(loop(temp))) ;
    printf("%d",tinhtong(n)) ;  

    return 0 ;
}