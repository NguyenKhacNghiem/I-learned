#include <stdio.h>

void nhapchuoi(char []) ; 

int main()
{
    char s[100] ;

    printf("nhap vao chuoi ky tu:") ; 
    gets(s) ;
    nhapchuoi(s) ;
}

void nhapchuoi(char s[])
{
    FILE *p ;

    p = fopen("D:\\input.txt","w") ; 
    fprintf(p,"%s",s) ; 
    fclose(p) ; 
}

    