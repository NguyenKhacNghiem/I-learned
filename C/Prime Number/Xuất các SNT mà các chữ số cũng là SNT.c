#include <stdio.h>
#include <math.h>

void xuatcacsnt(int , int) ; 
int kiemtrasnt(int) ; 

int main()
{
	int a,b ; 
	do 
	{
	printf("nhap a :") ;
	scanf("%d",&a) ; 
	printf("nhap b :") ;
	scanf("%d",&b) ;
    }
    while (a<=0 || b<=0 || a>b  ) ; 
	printf("doan can xet luc nay la [%d,%d]\n",a,b) ; 
	xuatcacsnt(a,b) ; 
}

void xuatcacsnt(int a , int b)
{
	int i , temp = 1 , k , count , last , tam ;
	for(i=a;i<=b;i++)
	{
		for(count=2;count<i;count++)
		{
			if (i%count==0)
			{
				temp = 0 ; 
				break ; 
			}
		}
		
		for(k=i;k!=0;k/=10)
		{
			last = k%10 ; 
            tam = kiemtrasnt(last) ; 
            if (tam == 0)
            {
            	break ; 
			}
		}

		if(temp == 1 && tam==1 )
		{
			printf("%d\n",i) ; 
		}
		temp = 1 ; 
	}
}

int kiemtrasnt(int last)
{
	int  i ;
	for(i=2;i<=sqrt(last);i++)
	{
		if (last%i == 0)
		{
			return 0 ;
		}
	}
	return 1 ;
}

