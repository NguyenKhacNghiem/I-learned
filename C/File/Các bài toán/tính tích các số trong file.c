#include <stdio.h>

int readfile(int []) ;
void getmul(int [] , int) ;  

int main()
{
    int a[100] ;
    int size = readfile(a) ;
    getmul(a,size) ;   
}

int readfile(int a[])
{
    FILE *p ;
    int size , i ; 

    p = fopen("D:\\input.txt","r") ; 
 
    fscanf(p,"%d",&size) ; //sau khi đọc xong phần tử thứ nhất thì con trỏ tự nhảy đền phần tử thứ 2

    for(i=0;i<size;i++)
        fscanf(p,"%d",&a[i]) ;  //sau khi đọc xong phần tử thứ 2 thì con trỏ tự nhảy đền phần tử kế tiếp 
    
    fclose(p) ; 
    return size ; 
}

void getmul(int a[] , int size)
{
    int i , mul = 1 ;

    for(i=0;i<size;i++)
        mul *= a[i] ; 

    FILE *p ;

    p = fopen("D:\\mul.txt","w") ;
    fprintf(p,"%d",mul) ; 
    fclose(p) ;      
}