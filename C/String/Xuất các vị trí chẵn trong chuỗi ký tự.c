// Xuat cac vi tri chan trong chuoi ky tu 

#include <stdio.h>
#include <string.h>

int main()
{
	char s1[100] ; 
    int i,l;
	printf("nhap chuoi ky tu :") ; 
	gets(s1) ; 
	l = strlen(s1) ; 
	for(i=0;i<l;i++)
	{
		if (i%2==0)
		{
			printf("%c\n",s1[i]) ; 
		}
	}
}
