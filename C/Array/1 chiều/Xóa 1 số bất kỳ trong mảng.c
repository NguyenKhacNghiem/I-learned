#include <stdio.h>

int NhapMang(int a[])
{
    int i , n ;

    printf("nhap n: ") ;
    scanf("%d",&n) ;

    for(i=0;i<n;i++)
    {
        printf("a[%d] = ",i) ;
        scanf("%d",&a[i]) ;
    }

    return n ;
}

void XuatMang(int a[] , int n)
{
    int i ;

    for(i=0;i<n;i++)
        printf("%d\t",a[i]) ;
}

int XoaSo(int a[] , int n)
{
    int i , k , key ;

    printf("\nnhap so muon xoa: ") ;
    scanf("%d",&key) ;

    for(i=0;i<n;i++)
        if(a[i] == key)
        {
            for(k=i;k<n-1;k++)
                a[k] = a[k+1] ;

            n-- ;
            i--;
        }
    
    return n ;
}

int main()
{
    int a[100] , n ;

    n = NhapMang(a) ;

    printf("Mang truoc khi xoa so la:") ;
    XuatMang(a,n) ;
    
    n = XoaSo(a,n) ;
    printf("Mang sau khi xoa so la:") ;
    XuatMang(a,n) ;

    return 0 ; 
}