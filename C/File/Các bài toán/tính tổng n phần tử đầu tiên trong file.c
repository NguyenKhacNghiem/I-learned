#include <stdio.h>

int readfile(int []) ;
void tinhtongb(int [] , int) ;   

int main()
{
    int a[100] ; 
    int size = readfile(a) ;

    tinhtongb(a,size) ;
}

int readfile(int a[])
{
    FILE *p ;
    int i , size ; 

    p = fopen("D:\\input.txt","r") ; 

    fscanf(p,"%d",&size) ; 

    for(i=0;i<size;i++)
        fscanf(p,"%d",&a[i]) ; 

    fclose(p) ;
    return size ; 
}

void tinhtongb(int a[] , int size)
{
    int i , n , sum = 0 ;

    do
    {
        printf("nhap so phan tu ban muon tinh tong:") ; 
        scanf("%d",&n) ;
    } 
    while (n<=0 || n>size) ;

    for(i=0;i<n;i++)
        sum += a[i] ; 

    FILE *p ;

    p = fopen("D:\\tongso.txt","w") ; 
    fprintf(p,"%d",sum) ; 
    fclose(p) ;
}
