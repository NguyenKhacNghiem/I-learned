// Chuyen ky tu thuong thanh hoa 

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
		s1[i]=s1[i]-32 ; // dua theo bo ma ASCII
	}
	puts(s1) ; 
}

