#include <stdio.h>
#include <math.h>

int ktsnt(int) ; 

int main()
{
    int n ;

    printf("nhap so muon kt:") ; 
    scanf("%d",&n) ; 

    if (ktsnt(n) == 1 && n>1)  
        printf("la snt") ; 
    else
        printf("ko la snt") ; 
       return 0 ;
}

int ktsnt(int n)
{
    int i ;
    
    for(i=2;i<=sqrt(n);i++)
        if (n%2==0)
            return 0 ; 
    
    return 1 ;
}