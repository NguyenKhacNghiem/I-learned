#include <stdio.h>

void docFile(int a[][100], int *m, int *n)
{
    int i, j, temp ;

    FILE *reader ;
    reader = fopen("input.txt", "r");

    // doc so hang, so cot
    fscanf(reader, "%d %d\n", &*m, &*n) ;

    // doc cac phan tu trong ma tran
    for(i=0;i < *m;i++)
        for(j=0;j < *n;j++)
            if(fscanf(reader, "%d", &temp) != EOF)
                a[i][j] = temp;
    
    fclose(reader);
}

int main()
{
    int a[100][100];
    int m, n ;  // m: so hang, n: so cot

    docFile(a, &m, &n);

    return 0 ;
}