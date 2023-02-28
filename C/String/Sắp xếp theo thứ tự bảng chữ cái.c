#include <stdio.h>
#include <string.h>

int main()
{
    char s[3][100], temp[100] ;
    int i, k ;

    printf("Nhap 3 chuoi: \n") ;
    gets(s[0]) ;
    gets(s[1]) ;
    gets(s[2]) ;

    // Bubble Sort
    for(i=0;i<3-1;i++)    // 3 la so chuoi (length)
        for(k=0;k<3-1-i;k++)
            if(strcmp(s[k], s[k+1]) > 0)  // sap xep tang dan, giam dan -> < 0
            {
                strcpy(temp, s[k]) ;
                strcpy(s[k], s[k+1]) ;
                strcpy(s[k+1], temp) ;
            }
        
    printf("Chuoi sau khi sap xep la: \n") ;
    puts(s[0]) ;
    puts(s[1]) ;
    puts(s[2]) ;

    return 0 ;
}