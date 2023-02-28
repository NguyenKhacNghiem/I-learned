#include <stdio.h>

int ucln(int a, int b)
{
    if(a == 0 || b == 0) 
        return a;

    while(a!=b)
        if (a > b) 
            a -= b;
        else 
            b -= a;
        
    return a;
}

int main()
{
    int a, b, c ;

    scanf("%d%d%d",&a, &b, &c);

    if(a <= 0 || b <= 0 || c <= 0)
        printf("DL sai");
    else
        printf("%d", ucln(a, ucln(b, c)));

    return 0 ;
}