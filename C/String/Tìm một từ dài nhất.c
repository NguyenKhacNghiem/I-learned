#include <stdio.h>
#include <string.h>

void timMotTuDaiNhat(char s[])
{
    char tu[100][100] ;
	int i , j=0, d=0, max=0 ;

	for (i=0;i<strlen(s);i++)
	{
		if(s[i] != ' ')
		{
			tu[j][d] = s[i] ;
			d++ ;
		}

		if((s[i] == ' ' && s[i+1] != ' ') || i == strlen(s)-1)	
		{
			tu[j][d] = '\0';
			
            if(max < d)    max=d;
			
            j++;
			d=0;
		}
	}

	for(i=0;i<j;i++)
	    if(strlen(tu[i]) == max)
        {
            printf("%s",tu[i]) ;
            break ;
        }
}
