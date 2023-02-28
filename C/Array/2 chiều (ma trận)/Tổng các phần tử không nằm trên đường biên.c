#include <stdio.h>
#include <math.h>
#include <stdbool.h>

void Nhap(int a[][100], int n)
{
    int i, k ;

    for(i=0;i<n;i++)
        for(k=0;k<n;k++)
        {
            printf("a[%d][%d] = ",i+1,k+1) ; 
            scanf("%d",&a[i][k]) ; 
        }
}

void Xuat(int a[][100], int n)
{
    int i, k ;

    for(i=0;i<n;i++)
    {
        for(k=0;k<n;k++)
            printf("%d\t",a[i][k]) ;
        printf("\n") ;
    }
}

int TinhTongDuongBien(int a[][100], int n)
{
    int i, k, sum=0 ;

    for(k=0;k<n;k++)
        sum += a[0][k] ; 
    
    for(k=0;k<n;k++)
        sum += a[n-1][k] ;
    
    for(i=0;i<n;i++)
        sum += a[i][0] ; 
    
    for(i=0;i<n;i++)
        sum += a[i][n-1] ;
    
    sum = sum - a[0][0] - a[n-1][n-1] - a[0][n-1] - a[n-1][0] ;

    return sum ;
}

int TinhTongKhongNamTrenDuongBien(int a[][100], int n)
{
    int i, k, sum=0 ;

    for(i=0;i<n;i++)
        for(k=0;k<n;k++)
            sum += a[i][k] ; 
    
    return sum - TinhTongDuongBien(a,n) ; 
}

int main()
{
    int a[100][100], n ;

    printf("Nhap kich thuoc cho ma tran vuong A: ") ;
    scanf("%d",&n) ; 

    Nhap(a,n) ;
    Xuat(a,n) ;

    printf("Tong cac phan tu khong nam tren duong bien la: %d\n",TinhTongKhongNamTrenDuongBien(a,n)) ; 

    return 0 ;
}