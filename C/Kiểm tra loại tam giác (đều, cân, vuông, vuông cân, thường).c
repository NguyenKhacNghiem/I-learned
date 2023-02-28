#include <stdio.h>

int timCanhDaiNhat(int a, int b, int c)  // tim canh huyen -> max cua a, b, c
{
    if(b > a) a = b ;
    if(c > a) a = c ;

    return a ;
}

void kiemTraTamGiac(int a, int b, int c)  
{
    if(a+b<=c || a+c<=b || b+c<=a)
    {
        printf("Day khong phai la tam giac") ;
        return ;
    }

    if(a == b && b == c && a == c)  
        printf("Tam giac deu") ;
    else if(a*a + b*b == timCanhDaiNhat(a, b, c)*timCanhDaiNhat(a, b, c) && (a == b || a == c || b == c))   
        printf("Tam gia vuong can") ;
    else if(a == b || a == c || b == c) 
        printf("Tam giac can") ;
    else if(a*a + b*b == timCanhDaiNhat(a, b, c)*timCanhDaiNhat(a, b, c))   
        printf("Tam gia vuong") ;
    else 
        printf("Tam giac thuong") ;
}

int main()
{
    int a, b, c ;

    printf("Nhap 3 canh cua tam giac: ") ;
    scanf("%d%d%d", &a, &b, &c) ;

    kiemTraTamGiac(a, b, c) ;

    return 0 ;
}