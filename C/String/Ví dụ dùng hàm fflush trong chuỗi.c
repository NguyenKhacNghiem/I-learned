#include <stdio.h>
 
int main()
{
    int age;
    char name[30];
    
    printf("Nhap tuoi: "); 
	scanf("%d", &age);
	
    fflush(stdin) ; // x�a du~ li�u. tu` b�n ph�m TRUOC' khi nh�p. chu�i~ . N�u' ko n� se~ b� qua buoc' nh�p. chu�i~ 
	 
    printf("Nhap ten: "); 
	gets(name);
    printf("%s - %d", name, age);
}
