#include <stdio.h>
#include <string.h>

void demSoLuongKyTuCuaMoiTu(char s[])
{
    int count=0 ;

    for(int i=0;i<strlen(s);i++)   
    {
        if(s[i] != ' ')
            count++ ;

        if(s[i] == ' ' || i==strlen(s)-1)
        {
            printf("%d\t",count) ;

            count=0 ;
        }
    }
}