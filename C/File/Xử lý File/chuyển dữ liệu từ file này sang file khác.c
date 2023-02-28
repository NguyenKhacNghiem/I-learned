#include <stdio.h>

void changefile(char []) ; 

int main()
{
    char s[100] ; 
    changefile(s) ;
}

void changefile(char s[])
{
    FILE *p ; 
    int i = 0 ;

    p = fopen("D:\\input.txt","r") ; 
    fgets(s,100,p) ;
    fclose(p) ;

    p = fopen("D:\\input2.txt","w") ;
    fprintf(p,"%s",s) ;
    fclose(p) ;
}