#include <stdio.h>
#include <math.h>

int change(int) ;

int main()
{
    int n ;

    printf("nhap n:") ; 
    scanf("%d",&n) ;

    printf("%d",change(n)) ;
}

int change(int n)  // thuat. toan' : nhu trong môn TCMT , chia liên tiêp' cho 2 lay' phan du tu duoi len
{
    int count , sum=0 ;

    for(count=0 ; n!=0 ; count++ , n/=2)
        sum += (n%2)*pow(10,count) ;

    return sum ;
}