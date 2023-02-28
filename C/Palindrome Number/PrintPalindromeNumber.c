#include <stdio.h>

int check(int) ;
void print(int) ;

int main()
{
    int n ;

    printf("nhap vao n:") ;
    scanf("%d",&n) ;

    print(n) ;

    return 0 ;
}

void print(int n)
{
    int i ;

    for(i=1;i<=n;i++)
        if(check(i) == i)
            printf("%d\t",i) ;
}

int check(int i)
{
    int last , sum = 0 ;

    for(;i!=0;i/=10)
    {
        last = i%10 ;
        sum = sum*10 + last ;
    }

    return sum ;
}

