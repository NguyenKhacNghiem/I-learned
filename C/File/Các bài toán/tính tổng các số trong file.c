#include <stdio.h>

int nhapinput(int []) ;
void getsum(int [] , int) ; 

int main()
{
    int a[100] ; 

    int size = nhapinput(a) ;
    getsum(a,size) ;  
}

int nhapinput(int a[])
{
    FILE *p ;

    int size ; 

    printf("nhap vao so phan tu trong file:") ; 
    scanf("%d",&size) ; 

    p = fopen("D:\\input.txt","w") ; 
    fprintf(p,"%d\t",size) ;

    int i ; 

    for(i=0;i<size;i++)
    {
        printf("a[%d] = ", i) ; 
        scanf("%d",&a[i]) ; 
    } 

    for(i=0;i<size;i++)
        fprintf(p,"%d\t",a[i]) ; 
    
    fclose(p) ;

    return size ;  
}

void getsum(int a[] , int size)
{
    FILE *p ; 
    int sum = 0  , i ;

    for(i=0;i<size;i++)
        sum += a[i] ; 
    p = fopen("D:\\sum.txt","w") ;
    fprintf(p,"tong la : %d",sum) ; 
    fclose(p) ;  
}