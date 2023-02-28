#include <stdio.h>
int main()
{
int n,i ;
float s = 0 ;
printf ( " nhap n : " );
scanf ( "%d",&n );
for ( i=2 ; i <= n ; i++)
{
	s = s + (1/(float)i);
}
printf ("\nsum: %f",s);
return 0;
}
