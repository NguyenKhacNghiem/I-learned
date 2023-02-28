#include <stdio.h>

int main()
{
	int a[] = {-2, -1, -3, -4, -5};
	int i;
	int negativeMax = 0 ;
	int n = 5;
	
	for(i=0;i<n;i++)
		if(a[i] < negativeMax)
		{
			negativeMax = a[i];
			break;
		}
	
	if(negativeMax == 0)
		printf("There are no negative number in this array");
	else
	{
		for(i=0;i<n;i++)
			if(a[i] > negativeMax && a[i] < 0)
				negativeMax = a[i];	
		
		printf("The negative max is %d", negativeMax);
	}	
	
	return 0;
}
