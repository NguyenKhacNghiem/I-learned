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
		count = 1 ;         // -> môi~ con sô' mà nguoi` dùng nhâp. vô luôn xuât' hiên. ít nhât' 1 lân` 
		
		for(k=i+1;k<n;k++)            // dem' lên dê~ tính sô' lân` xuât' hiên. cua~ các phân` tu~ 
		{                               
			if(a[i] == a[k])
			{						                
				count++ ;         // ví du : 1 2 1 2 2
			}                    
		}
		
		if(demxuong(a,i,n) == 1)       // dêm' xuông' dê~ loai. bõ các phân` tu~ dã xuât' hiên. rôi` 
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
	
	for(k=i-1;k>=0;k--)          // ví du : 1 2 1 2 2 
	{
	if(a[k] == a[i])
	return 1;
    }		
}
