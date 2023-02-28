#include <stdio.h>     

int nhapmang(int []) ; 
void demlen(int[],int) ;
int demxuong(int [] , int , int) ; 

int main()
{
	int a[100] , n ;
	n = nhapmang(a) ; 
	demlen(a,n) ;
}

int nhapmang(int a[])
{
	int n , i ; 
	
	printf("nhap vao so phan tu cho mang :") ; 
	scanf("%d",&n) ;
	 
	for(i=0;i<n;i++)
	{
		printf("a[%d] = ",i) ; 
		scanf("%d",&a[i]) ; 
	}
}

void  demlen(int a[] , int n)
{
	int i , k , count ;
	
	for(i=0;i<n;i++)        
	{
		count = 1 ;         // -> m�i~ con s�' m� nguoi` d�ng nh�p. v� lu�n xu�t' hi�n. �t nh�t' 1 l�n` 
		
		for(k=i+1;k<n;k++)            // dem' l�n d�~ t�nh s�' l�n` xu�t' hi�n. cua~ c�c ph�n` tu~ 
		{                               
			if(a[i] == a[k])
			{						                
				count++ ;         // v� du : 1 2 1 2 2
			}                    
		}
		
		if(demxuong(a,i,n) == 1)       // d�m' xu�ng' d�~ loai. b� c�c ph�n` tu~ d� xu�t' hi�n. r�i` 
		{     
			count=0;
		}
		
		if(count > 0)
		{
			printf("gia tri %d xuat hien : %d lan\n",a[i],count) ;
		}
	}
}

int demxuong(int a[] , int i , int n)
{
	int k ;
	
	for(k=i-1;k>=0;k--)          // v� du : 1 2 1 2 2 
	{
	if(a[k] == a[i])
	return 1;
    }		
}
