#include <stdio.h>

int readfile(int []) ;
void printoddinfile(int [] , int) ; 

int main()
{
    int a[100] ; 
    int size = readfile(a) ;

    printoddinfile(a,size) ; 
    
    return 0 ;
}

int readfile(int a[])
{
    int i , size ; 
    FILE *p ; 

    p = fopen("D:\\input.txt","r") ; 
    fscanf(p,"%d",&size) ; // fscanf phải có &

    for(i=0;i<size;i++)
        fscanf(p,"%d",&a[i]) ; 

    return size ;
}

void printoddinfile(int a[] , int size)
{
    FILE *p ; 
    int i ;

    p = fopen("D:\\sole.txt","w") ; 
    
    for(i=0;i<size;i++)    
        if (a[i] % 2 != 0)
            fprintf(p,"%d\t",a[i]) ;

    fclose(p) ; 
}