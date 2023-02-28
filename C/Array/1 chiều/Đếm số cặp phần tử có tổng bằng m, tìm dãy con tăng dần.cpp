#include <iostream>
#include <stdio.h>
#include <math.h>
#include <stdbool.h>

using namespace std ;
// a la mang 1 chieu co n phan tu

// dem xem trong mang co bao nhieu cap so ma tong bang m
void Bai16(int a[], int n, int m, FILE *ghiFile)
{
    int count=0 ;

    for(int i=0;i<n-1;i++)
        for(int j=i+1;j<n;j++)
            if(a[i] + a[j] == m)
                count++ ;
    
    fprintf(ghiFile,"\nBai 16: %d",count) ;
}

// tim day con lien tiep tang dan co nhieu phan tu nhat. Xuat so phan tu cua day tim duoc
void Bai17(int a[], int n, FILE *ghiFile)  
{ 
    int count[100], k=0 ;

    for(int i=0;i<n-1;i++)
    {
        count[k] = 1 ; 

        for(int j=i;j<n-1;j++)
        {
            if(a[j] < a[j+1])     
                count[k]++ ;
            else
            {
                k++ ;
                break ;
            }

            if(j == n-2)
            {
                k++ ;
                break ; 
            }
        }
    }
    
    int max = count[0] ;

    for(int i=0;i<k;i++)
        if(count[i] > max)
            max = count[i] ;
    
    if(max == 1)    fprintf(ghiFile,"\nBai 17: 0") ;  // Khong tim thay day tang dan
    else            fprintf(ghiFile,"\nBai 17: %d",max) ;
}
