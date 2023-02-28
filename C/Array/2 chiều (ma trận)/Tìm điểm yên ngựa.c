// Tim diem yen ngua (max:hang,min:cot)
#include <stdio.h>

void Nhap(int a[][100] , int hang, int cot)
{
    int i,j ;

    for(i=0;i<hang;i++)
        for(j=0;j<cot;j++)
        {
            printf("a[%d][%d] = ",i,j) ;
            scanf("%d",&a[i][j]) ;
        }
}

int FindMax(int i,int a[][100],int cot)
{
    int k , max = a[i][0] ; 

    for(k=1;k<cot;k++)
        if (a[i][k]>max)
            max = a[i][k] ;

    return max ;
}

int FindMin(int j , int hang , int a[][100])
{
    int k , min = a[0][j] ;

    for(k=1;k<hang;k++)
        if (a[k][j]<min)
            min = a[k][j] ;
    
    return min ;
}

void SaddlePoint(int hang,int cot,int a[][100])
{
    int i , j ;

    for(i=0;i<hang;i++)
        for(j=0;j<cot;j++)
            if(a[i][j]==FindMax(i,a,cot) && a[i][j]==FindMin(j,hang,a))
                printf("a[%d][%d]\n",i,j) ;
}

int main()
{
    int a[100][100],hang,cot ;
    
    printf("Nhap vao so hang: ");
    scanf("%d",&hang) ;
    printf("Nhap vao so cot: ");
    scanf("%d",&cot) ;
    Nhap(a,hang,cot) ; 

    SaddlePoint(hang,cot,a) ; 

    return 0 ;
}  