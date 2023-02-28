#include <stdio.h>
#include <math.h>

int findfirst(int) ;
int findlast(int) ;
int countnumber(int) ;
int swap(int , int , int , int) ;

int main()
{
    int n ;

    printf("nhap n:") ;
    scanf("%d",&n) ;

    int first = findfirst(n) ;
    int last = findlast(n) ;
    int count = countnumber(n) ;
    printf("so dao la: %d",swap(n,first,last,count)) ;
    
    return 0 ;
}

int findfirst(int n)
{
    int first ;

    for(first=n;first>=10;) // tim duoc first
        first/=10 ;
    return first ; 
}

int findlast(int n)
{ 
    int last=n%10 ;
    return last ; 
}

int countnumber(int n)
{
    int count = 0 ;

    for(;n!=0;n/=10)
        count++ ;
    
    return count ;
}

int swap(int n , int first , int last , int count) // xem thuat toan' o~ duoi' ne`
{
    int a , b ; 

    for(a=pow(10,count-2);a>=10;a/=10)  // luu y' la count - 2
    {
        b = n / a ;
        b = b % 10 ;
        last = last*10+b ;
    }

    int rev = last*10+first ;

    return rev ;
}