#include <iostream>
#include <stdio.h>

using namespace std ;
// a la mang 2 chieu mxn

// Tinh tong cac so tren moi dong, moi cot
void Bai19(int a[][500], int m, int n, FILE *ghiFile)
{
    int cauA[m], cauB[n] ;

    for(int i=0;i<m;i++)
    {
        cauA[i] = 0 ;

        for(int j=0;j<n;j++)
            cauA[i] += a[i][j] ;
    }

    for(int j=0;j<n;j++)
    {
        cauB[j] = 0 ;

        for(int i=0;i<m;i++)
            cauB[j] += a[i][j] ;
    }

    fprintf(ghiFile,"Bai 19: ") ;
    for(int i=0;i<m;i++)
        fprintf(ghiFile,"%d\t",cauA[i]) ;

    fprintf(ghiFile,"\n      : ") ;
    for(int i=0;i<n;i++)
        fprintf(ghiFile,"%d\t",cauB[i]) ;
}

// Sap xep tang dan tren tung dong
void Bai21(int a[][500], int m, int n, FILE *ghiFile)
{
    int temp ;

    for(int j=0;j<m;j++)
        for(int i=0;i<n-1;i++)
            for(int k=0;k<n-i-1;k++)
                if(a[j][k] > a[j][k+1]) 
                {
                    temp = a[j][k] ; 
                    a[j][k] = a[j][k+1] ; 
                    a[j][k+1] = temp ; 
                }
    
    fprintf(ghiFile,"\nBai 21: \n") ; 
    for(int i=0;i<m;i++)
    {
        fprintf(ghiFile,"        ") ;
        
        for(int j=0;j<n;j++)
            fprintf(ghiFile,"%d\t",a[i][j]) ;
        
        fprintf(ghiFile,"\n") ;
    }
}
