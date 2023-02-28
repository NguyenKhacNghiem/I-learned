#include <stdio.h>
#include <string.h>

void deletefirstspace(char []) ; 
void deletemidspace(char[] , int) ; 
void deletelastspace(char[],int) ;
void inhoakytudau(char []) ;
void inhoakytusaudaucach(char [] , int) ; 

int main()
{
	char s[100] ;
	
	printf("nhap vao chuoi ky tu can chuan hoa:") ;
	gets(s) ; 
	
	int length = strlen(s) ; 
	
	deletefirstspace(s) ;
	    
	deletelastspace(s,length) ; 
	
	deletemidspace(s,length) ;
	
	strlwr(s) ;
	
	inhoa(s) ;
	
	inhoakytusaudaucach(s,length) ;
	
	puts(s) ;
}

void deletefirstspace(char s[])
{
	while(s[0] == ' ')         //    nghiem
		strcpy(&s[0],&s[1]) ;    
}

void deletelastspace(char s[],int length) 
{
	while(s[length] == ' ')
		strcpy(&s[length-1],&s[length]) ;    /*nghiem     */        
}

void deletemidspace(char s[] , int length)
{
	int i ;
	
	for(i=0;i<length;i++)      //nguyen   khac    nghiem
		if(s[i] == ' ' && s[i+1] == ' ')
		{
			strcpy(&s[i],&s[i+1]) ;
			i-- ;       // phai tru ra ko thoi khoang giua se co 2 dau cach
		}
}

void inhoa(char s[])
{
	if(s[0]>96)
		s[0] -= 32 ;
}

void inhoakytusaudaucach(char s[] , int length)
{
	int i ; 
	
	for(i=1;i<length;i++)   // i=1 vi ky tu dau da duoc in hoa roi
		if(s[i] == ' ')
			if(s[i+1]>96)
				s[i+1] -= 32 ;
}

