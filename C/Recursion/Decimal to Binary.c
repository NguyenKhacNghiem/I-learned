#include <stdio.h>
#include <math.h>

int Binary(int n,int count)
{   
    if(n==0)    return 0 ;

    return ((n%2)*pow(10,count)) + Binary(n/2,count+1) ;
}

int main()
{
    int n,count=0 ; 
    
    printf("nhap n: ");
    scanf("%d",&n) ;
    
    printf("%d",Binary(n,count)) ;

    return 0 ;
}