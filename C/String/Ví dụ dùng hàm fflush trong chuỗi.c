#include <stdio.h>
 
int main()
{
    int age;
    char name[30];
    
    printf("Nhap tuoi: "); 
	scanf("%d", &age);
	
    fflush(stdin) ; // xóa du~ liêu. tu` bàn phím TRUOC' khi nhâp. chuôi~ . Nêu' ko nó se~ bõ qua buoc' nhâp. chuôi~ 
	 
    printf("Nhap ten: "); 
	gets(name);
    printf("%s - %d", name, age);
}
