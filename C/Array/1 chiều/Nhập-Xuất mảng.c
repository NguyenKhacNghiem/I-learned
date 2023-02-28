#include <stdio.h>

int nhapmang(int[]) ;   // Nhap phan tu cho mang -> nguyen lieu la mang
void xuatmang(int[] , int) ; // Xuat mang la xuat tung phan tu cua mang ra

void main()
{
   int a[100] , n ; // n la so phan tu cua mang
   n = nhapmang(a) ; 
   xuatmang(a,n) ;
}

int nhapmang(int a[]) 
{
	int n,i ; 
	printf("Nhap vao so phan tu cho mang:") ;
	scanf("%d",&n) ; 
	for(i=0;i<n;i++)
	{
		printf("a[%d]=",i);
		scanf("%d",&a[i]) ;
	}
}

void xuatmang(int a[],int n)
{
	int i ; 
	for(i=0;i<n;i++)
	{
		printf("%d\n",a[i]) ; 
	}
}
