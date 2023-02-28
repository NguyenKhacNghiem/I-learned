#include <stdio.h>
#include <string.h>

void timMotTuBenTraiCuaChuoi(char s[])
{
    int i=0 ;
    char trai[100] ;

    if(demSoTuTrongChuoi(s)==1)  printf("Khong tim thay") ;
    else
        while(s[i] != '\0')
        {
            trai[i] = s[i] ;

            if(s[i] == ' ')
            {
                trai[i] = '\0' ;
                printf("%s",trai) ;
                break ;
            }
            
            i++ ;
        }
}
