#include <stdio.h>

int nhapmang(int [][100] , int , int) ;
void xuatmang(int [][100] , int , int) ;

int main()
{
	int a[100][100] , n , m ;
	printf(" nhap so hang m :") ;
	scanf("%d",&m) ;
	printf("nhap vao so cot n :") ;
	scanf("%d",&n) ;
	nhapmang(a,m,n) ;
	xuatmang(a,m,n) ;
}

int nhapmang(int a[][100] , int m , int n) 
{
	int i , k ; // m là sô hang , n la so cot
	for(i=0;i<m;i++)
		for(k=0;k<n;k++)
		{
			printf("a[%d][%d] = ",i,k) ;
			scanf("%d",&a[i][k]) ;
		}
}

void xuatmang(int a[][100] , int m , int n)
{
	int i , k ;
	for(i=0;i<m;i++)
		for(k=0;k<n;k++)
		{
			printf("a[%d][%d] = %d\n",i,k,a[i][k]) ;
		}
}

