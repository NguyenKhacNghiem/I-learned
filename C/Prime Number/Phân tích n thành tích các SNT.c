#include <stdio.h>     // phan tich n thanh tich cac snt 
 
int main()
{
    int n , count , i ;
    printf("Nhap n : ") ;
    scanf("%d",&n) ;
    for(i=2;i<=n;i++)
	{
        count = 0 ;
        for(;n%i==0;)
		{
            count++ ; 
            n /= i ;
        }
        if(count!=0)
		{
            if(count > 1) 
			{
			printf("%d * %d", i, i) ;
		    }
            else 
			{
			printf("%d", i) ;
		    }
            if(n > i)
			{
                printf(" * ") ;
            }
        }
    }
}
