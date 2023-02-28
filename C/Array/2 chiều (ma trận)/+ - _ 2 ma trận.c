#include <stdio.h>

void input(int matrix[][100], int row, int colum)
{
    int i, k ;

    for(i=0;i<row;i++)
        for(k=0;k<colum;k++)
        {
            printf("[%d][%d] = ", i+1, k+1) ;
            scanf("%d", &matrix[i][k]) ;
        }
}

void output(int matrix[][100], int row, int colum)
{
    int i, k ;

    for(i=0;i<row;i++)
    {
        for(k=0;k<colum;k++)
            printf("%d\t", matrix[i][k]) ;
        
        printf("\n") ;
    }
}

void sumMatrix(int a[][100], int row_a, int colum_a, int b[][100], int row_b, int colum_b)
{
    if(row_a != row_b || colum_a != colum_b)
    {
        printf("Dimension ERROR\n") ; // kich thuoc khong hop le !
        return ;
    }

    int sum[100][100], i, k ;

    for(i=0;i<row_a;i++)        // || row_b
        for(k=0;k<colum_a;k++)  // || colum_b
            sum[i][k] = a[i][k] + b[i][k] ;

    output(sum, row_a, colum_a) ;  // || row_b, colum_b
}

void subMatrix(int a[][100], int row_a, int colum_a, int b[][100], int row_b, int colum_b)
{
    if(row_a != row_b || colum_a != colum_b)
    {
        printf("Dimension ERROR\n") ; // kich thuoc khong hop le !
        return ;
    }

    int sub[100][100], i, k ;

    for(i=0;i<row_a;i++)        // || row_b
        for(k=0;k<colum_a;k++)  // || colum_b
            sub[i][k] = a[i][k] - b[i][k] ;

    output(sub, row_a, colum_a) ;  // || row_b, colum_b
}

void timeMatrix(int a[][100], int row_a, int colum_a, int b[][100], int row_b, int colum_b)
{
    if(colum_a != row_b)
    {
        printf("Dimension ERROR\n") ; // kich thuoc khong hop le !
        return ;
    }

    int time[100][100], i, j, k ;

    for(i=0;i<row_a;i++)      
        for(j=0;j<colum_b;j++)  
            for(k=0;k<row_b;k++)
                time[i][j] += a[i][k]*b[k][j] ;

    output(time, row_a, colum_b) ;  
}

int main()
{
    int a[100][100], b[100][100] ;
    int row_a, row_b, colum_a, colum_b ;

    // input matrix
    printf("Input row number for matrix A: ") ;
    scanf("%d%d", &row_a, &colum_a) ;
    input(a, row_a, colum_a) ;

    printf("Input row number for matrix B: ") ;
    scanf("%d%d", &row_b, &colum_b) ;
    input(b, row_b, colum_b) ;

    // output matrix
    printf("Matrix A = \n") ;
    output(a, row_a, colum_a) ;

    printf("Matrix B = \n") ;
    output(b, row_b, colum_b) ;

    // Sum matrix A and matrix B
    printf("A + B = \n") ;
    sumMatrix(a, row_a, colum_a, b, row_b, colum_b) ;

    // Sub matrix A and matrix B
    printf("A - B = \n") ;
    subMatrix(a, row_a, colum_a, b, row_b, colum_b) ;

    // Time matrix A and matrix B
    printf("A * B = \n") ;
    timeMatrix(a, row_a, colum_a, b, row_b, colum_b) ;

    return 0 ;
}