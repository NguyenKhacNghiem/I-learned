#include <stdio.h>

int check(int) ;

int main()
{
    int n ;

    printf("nhap vao n:") ;
    scanf("%d",&n) ;

    if(n == check(n))
        printf("so palindrome") ;
    else
        printf("khong la so palindrome") ;

    return 0 ;
}

int check(int n)
{
    int last , sum=0 ;

    for(;n!=0;n/=10)
    {
        last = n%10 ;    
        sum = sum*10 + last ;
    }
    
    return sum ;
}