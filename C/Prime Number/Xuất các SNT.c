#include <stdio.h>

int main() 
{
	int n,i,count,temp=1 ; 
	printf("Nhap n: ");
	scanf("%d",&n);
	for(i=2;i<=n;i++)
	{
		for(count=2;count<=i-1;count++)
		{
			if(i % count == 0)
			{
				temp=0;
			}
		}
		if(temp == 1)
		{
			printf("%d\t",i);
		}
		temp = 1;
	}
}