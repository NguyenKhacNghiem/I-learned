#include <stdio.h>
#include <math.h>

int readfile(int []) ;
void printprimenumber(int [] , int) ; 
int checkprimenumber(int) ; 

int main()
{
    int a[100] ;
    int size = readfile(a) ;  

    printprimenumber(a,size) ; 
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

void printprimenumber(int a[] , int size)
{
    int i ; 
    FILE *p ; 

    p = fopen("D:\\cacsnt.txt","w") ; 
    
    for(i=0;i<size;i++)
        if(checkprimenumber(a[i]) == 1)
            fprintf(p,"%d\t",a[i]) ;
    
    fclose(p) ;
}

int checkprimenumber(int n) 
{
    int i ;

    if(n==0 || n==1)
        return 0 ;

    for(i=2;i<=sqrt(n);i++)
        if(n%i==0)
            return 0 ;
    
    return 1 ;
}