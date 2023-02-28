#include <stdio.h>

int main()
{
	int a[5] = {100, 200, 300, 400, 500} ;
	int *p = a ; // a la mang chu khong phai bien nen khong co dau "&"
	
	int i ;
	for(i=0;i<5;i++)
	{
		printf("Dia chi cua phan tu a[%d] la: %d\n", i, (p+i));
		printf("Gia tri cua phan tu a[%d] = %d\n", i, *(p+i));
	}
	
	return 0 ;
}