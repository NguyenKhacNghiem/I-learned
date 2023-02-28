#include <stdio.h>

int main()
{
	int a = 10 ; 
	int *p = &a ;
	 
	printf ("gia tri cua bien a la %d\n",a) ; 
	printf("dia chi cua bien a la %d\n",&a) ;
	printf("gia tri cua con tro la %d\n",p) ; 
	printf("dia chi cua con tro la %d\n",&p) ; 
	printf("gia tri cua bien ma con tro dang tro toi la %d\n",*p) ;
	 
	*p = 100 ;    // thay dôi~ giá tri. cua~ biên' a thông qua con tro~ 
	
	printf("gia tri cua bien a la %d\n",a) ; 
	printf("gia tri cua bien ma con tro dang tro toi la %d\n",*p) ;
}
