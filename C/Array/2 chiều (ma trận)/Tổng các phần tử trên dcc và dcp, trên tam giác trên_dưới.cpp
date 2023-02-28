#include <iostream>
#include <stdio.h>

using namespace std ;

// Tinh tong cac phan tu tren duong cheo chinh/phu
void Bai23_a(int a[][500], int n, FILE *ghiFile)
{
    int sum1=0, sum2=0 ;

    for(int i=0;i<n;i++)  sum1 += a[i][i] ;    // chinh       
    for(int i=0;i<n;i++)  sum2 += a[i][n-i-1] ; // phu
    
    fprintf(ghiFile,"Cau a: %d\t%d",sum1,sum2) ;
}

// Tinh tong cac phan tu thuoc tam giac tren/duoi (ko tinh duong cheo chinh)
void Bai23_b(int a[][500], int n, FILE *ghiFile)
{
    int sum1=0, sum2=0, sum=0, sum3=0 ;

    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            if(i == j)
                for(int k=j+1;k<n;k++)
                    sum1 += a[i][k] ;   // tren
        
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            sum += a[i][j] ;
    
    for(int i=0;i<n;i++)  sum3 += a[i][i] ;

    sum2 = sum-sum3-sum1 ;   // duoi = toan bo - cheo chinh - tren

    fprintf(ghiFile,"\nCau b: %d\t%d",sum1,sum2)  ;
}
