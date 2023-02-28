#include <stdio.h>

int main()
{
	FILE *p ; 
	int n = 1234 ;
	char s[100] ; 
	p = fopen("D:\\output.txt","w") ; 
	fprintf(p,"%d",n) ; 
	fclose(p) ; 
	p = fopen("D:\\input.txt","r") ;  
	fscanf(p,"%[^\n]",s) ;    
	printf("%s",s) ; 
	fclose(p) ; 
}
