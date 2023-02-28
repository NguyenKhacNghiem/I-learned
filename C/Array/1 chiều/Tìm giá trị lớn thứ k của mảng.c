// xuât' ra màn hình giá tri. lon' thu' k cua~ mang

#include<stdio.h>

int nhapmang(int []) ; 
int nhapk(int [] , int) ;
int sapxepgiam(int [], int) ;

int main()
{
 int a[100] , n , i , j , k , m ;
 
 n = nhapmang(a) ; 
 k = nhapk(a,n) ;
 sapxepgiam(a,n) ;                // 1 1 5 2 2
 
 	for (i=1;i<n;i++)       
 	{
  		for (j=0;j<i;j++)
  		{
   			if (a[i] == a[j])
   			{
    			for (m=i;m<n;m++)
    			{
    				a[m] = a[m+1] ;        // 1 5 5 2 2
    			}                          
				n-- ;   // n=4
    			i-- ;   // i=0
  			}		
  		}
 	}
 	printf("gia tri lon thu %d la : %d",k,a[k-1]) ;
 }

int nhapmang(int a[])
{
	int n , i ;
	
	printf("nhap so phan tu cua mang:") ;
 	scanf("%d",&n) ;
 	
 	for (i=0;i<n;i++)
 	{
  		printf("a[%d]=",i) ;
  		scanf("%d",&a[i]) ;
 	}
}

int nhapk(int a[] , int n)
{
	int k ;
	
	do 
 	{
  		printf("\n nhap gia tri lon thu k trong mang : ") ;
  		scanf("%d",&k) ;
 	}	 
 	while (k>n || k<=0) ;
}

int sapxepgiam(int a[] , int n)
{
	int i , j , temp ;
	for (i=0;i<n-1;i++)
	{
 		for (j=i+1;j<n;j++)         // 1 2 3 4 5
 		{	                        // -> 5 4 3 2 1 
		 	if (a[i] < a[j])
 			{
  				temp = a[i] ;
  				a[i] = a[j] ;
  				a[j] = temp ;
 			}
		}
    }
}

