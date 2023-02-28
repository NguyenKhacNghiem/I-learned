#include <stdio.h>
#include <string.h>

int demSoTuTrongChuoi(char s[])     
{
    int i=0, count=0 ;

    while(s[i] != '\0')
    {
        if(s[i] == ' ')
            count++ ;

        i++ ;
    }

    return count + 1 ; 
}