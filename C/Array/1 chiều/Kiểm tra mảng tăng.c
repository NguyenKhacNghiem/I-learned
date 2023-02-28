#include <stdio.h>
#include <stdbool.h>

int main()
{
	int a[] = {1, 2, 0, 4, 5};
	int i;
	int n = 5;
	bool isIncrease = true;
	
	for(i=0;i<n-1;i++)
		if(a[i] > a[i+1])
		{
			isIncrease = false;
			break;
		}
	
	if(!isIncrease)
		printf("Mang khong tang");
	else
		printf("Mang tang");
	
	return 0;
}
