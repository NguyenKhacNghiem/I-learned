#include <stdio.h>

int NhapMang(int a[])
{
	int i , n ;
	
	printf("Nhap n: ") ;
	scanf("%d",&n) ;
	
	for(i=0;i<n;i++)
	{
		printf("a[%d] = ",i) ;
		scanf("%d",&a[i]) ;
	}
	
	return n ;
}

int Delete(int a[], int n)
{
	int i , j , k ;
	
	for(i=0;i<n;i++)            // 1 2 1 2 2 6 1 3
	{
		for(j=i+1;j<n;j++)
		{
			if(a[i] == a[j])
			{
				for(k=j;k<n;k++)
					a[k] = a[k+1] ;
				
				n-- ; 
				j-- ;  
			}
		}
	}
	
	return n ;
}

void XuatMang(int a[],int n)
{
	int i ;
	
	for(i=0;i<n;i++)
		printf("a[%d] = %d\n",i,a[i]) ;
}

int main()
{
	int a[100] ; 
	int n = NhapMang(a) ;
	
	n = Delete(a,n) ;
	
	printf("Mang sau khi xoa phan tu trung lap la:\n") ;
	XuatMang(a,n) ;
	
	return 0 ;
}
