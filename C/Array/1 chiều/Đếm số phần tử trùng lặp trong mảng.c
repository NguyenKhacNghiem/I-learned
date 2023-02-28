#include <stdio.h>
#include <stdbool.h>

int NhapMang(int a[])
{
	int i , n ;
	
	printf("Nhap kich thuoc mang: ") ;
	scanf("%d",&n) ;
	
	for(i=0;i<n;i++)
	{
		printf("a[%d] = ",i) ;
		scanf("%d",&a[i]) ;
	}
	
	return n ;
}

void XuatMang(int a[],int n)
{
	int i ;
	
	for(i=0;i<n;i++)
		printf("%d\n",a[i]) ;
}

bool kiemTraTrungLap(int a[], int i, int x)
{
    int k, count=0;

    for(k=0;k<i;k++)
        if(a[k]==x)
            count++ ;
    
    if(count==1)
        return true ; 
    return false ; 
}

int demTrungLap(int a[], int n)
{
    int i, count=0, k=0, j ;
    int temp[100] ; 

    for(i=0;i<n;i++)
        if(kiemTraTrungLap(a,i,a[i])==true)
            count++ ;

    return count ; 
}

int main()
{
	int a[100] ; 
	int n = NhapMang(a) ;
	
    printf("Mang da nhap la: \n") ; 
	XuatMang(a,n) ;

    printf("So phan tu trung lap trong mang la: %d",demTrungLap(a,n)) ; 

	return 0 ;
}
