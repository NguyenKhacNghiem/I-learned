#include <stdio.h>

int bcnn(int a, int b, int c) 
{
    int max, i ; 

    if(a>b && a>c)
        max = a ; 
    else if(b>c)    
        max = b ;
    else
        max = c ;
    
    for(i=max;i<=a*b*c;i++)
        if(i%a==0 && i%b==0 && i%c==0)
            return i ; 
}

int main() {
    int a, b, c;

    printf("Nhap 3 so a, b, c: ") ;
    scanf("%d%d%d",&a,&b,&c) ; 
    
    printf("boi chung nho nhat la: %d",bcnn(a,b,c)) ; 
    
    return 0;
}

