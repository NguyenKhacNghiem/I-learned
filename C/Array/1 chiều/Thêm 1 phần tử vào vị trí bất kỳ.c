#include <stdio.h>

void show(int a[], int n)
{
    int i;

    for(i=0;i<n;i++)
        printf("%d ", a[i]);
}

int main()
{
    int a[10] = {1, 2, 3, 4, 5} ;
    int size = 5, value, position, i ;

    printf("Enter the value that you want to add: ");
    scanf("%d", &value) ;

    printf("Enter the position (start at 0) that you want to add: ");
    scanf("%d", &position);

    for(i=size;i>position;i--)
        a[i] = a[i-1];
    
    a[position] = value;
    size++;

    show(a, size) ;
    
    return 0 ;
}