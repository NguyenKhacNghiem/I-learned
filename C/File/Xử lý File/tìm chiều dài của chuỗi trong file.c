#include <stdio.h>

int getlength(char []) ;
void printlengthintofile(int) ; 

int main()
{
    char s[100] ; 
    int length = getlength(s) ;

    printlengthintofile(length) ; 
}

int getlength(char s[])
{
    FILE *p ; 
    int i = 0 ;

    p = fopen("D:\\input.txt","r") ; 

    fgets(s,100,p) ;

    while(s[i]!='\0')
        i++ ;
    
    fclose(p) ;

    return i ;
}

void printlengthintofile(int length)
{
    FILE *p ;

    p = fopen("D:\\getLength.txt","w") ;
    fprintf(p,"%d",length) ;
    fclose(p) ;
}