#include <stdio.h>

int main()
{
    int i ;
    
    printf("\n%-10s %-10s %-10s %-10s %-10s\n", "STT\t", " Ho va ten\t", "Ngay sinh\t", "Noi sinh\t", "Ghi chu");
    
    for (i = 0; i < 3; i++)
	{
		char temp[100];
		sprintf(temp, "%s %s", "Nguyen Van", "An");
		printf("\n%-10d \t%-10s\t %-10s\t %-10s\t %-10s ", i + 1, temp, "01/02/2000", "Ha Noi", " Khong");
	}

    return 0 ;
}