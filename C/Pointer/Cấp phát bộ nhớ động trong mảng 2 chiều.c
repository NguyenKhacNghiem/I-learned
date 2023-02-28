#include <stdio.h>
#include <stdlib.h>

void nhapXuat(int **a, int d, int c)
{
    int i, j;

    for(i=0;i<d;i++)
        for(j=0;j<c;j++)
        {
            printf("a[%d][%d] = ", i, j);
            scanf("%d", &a[i][j]);
        }

    for(i=0;i<d;i++)
    {
        for(j=0;j<c;j++)
            printf("%d\t", a[i][j]);
        printf("\n") ;
    }    
}

int main()
{
    int **a = NULL, d, c, i ;

    printf("Nhap so dong: ") ;
    scanf("%d", &d) ;

    printf("Nhap so cot: ") ;
    scanf("%d", &c) ;

    a = (int **)malloc(d * sizeof(int *));
    for (i=0;i<d;i++)  
        a[i] = (int *)malloc(c * sizeof(int));
    
    nhapXuat(a, d, c) ;

    return 0 ;
}