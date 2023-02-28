#include <iostream>
#include <stdbool.h>
#include <math.h>

using namespace std ;

bool kiemTraSNT(int n)
{
    if(n<2) return false ;

    for(int i=2;i<=sqrt(n);i++)
        if(n%i==0)  
            return false ;
    
    return true ;
}

void nhapMaTran(int a[][100], int m, int n)
{
    for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)                                   
        {
            cout << "a[" << i << "]" << "[" << j << "] = " ;
            cin >> a[i][j] ;
        }
}

int maxSNT(int a[][100], int m, int n)
{
    int i, k ;
    int snt[100], size=0 ;

    for(k=0;k<n;k++)
        if(kiemTraSNT(a[0][k]))
        {
            snt[size] = a[0][k] ;
            size++ ;
        }
        
    for(k=0;k<n;k++)
        if(kiemTraSNT(a[m-1][k]))
        {
            snt[size] = a[m-1][k] ;
            size++ ;
        }
    
    for(i=1;i<m-1;i++)
        if(kiemTraSNT(a[i][0]))
        {
            snt[size] = a[i][0] ;
            size++ ;
        }
    
    for(i=1;i<m-1;i++)
        if(kiemTraSNT(a[i][n-1]))
        {
            snt[size] = a[i][n-1] ;
            size++ ;
        }
       
    int max = snt[0] ;
    for(i=0;i<size;i++)
        if(snt[i] > max)
            max = snt[i] ;
    
    return max ;
}

void xuatMaTran(int a[][100], int m, int n)
{
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
            cout << a[i][j] << "\t" ;
        
        cout << "\n" ;
    }
}

int main()
{
    int a[100][100], m, n ;

    cout << "Nhap m va n: " ;
    cin >> m >> n ;

    nhapMaTran(a,m,n) ;
    xuatMaTran(a,m,n) ;

    cout << "So nguyen to lon nhat tren duong bien la: " ;
    cout << maxSNT(a,m,n) ;

    return 0 ;
}