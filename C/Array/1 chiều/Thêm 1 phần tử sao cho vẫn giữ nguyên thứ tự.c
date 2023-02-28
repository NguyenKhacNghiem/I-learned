#include <stdio.h>

// them 1 phan tu vao mang nhung van giu nguyen duoc thu tu sap xep ban dau
int them(int a[], int n, int key)
{
    int i, j;

    for(i=0;i<n;i++)
        if(a[i] <= key) // mang dang duoc sap xep giam dan
        {
            for(j=n;j>i;j--)
                a[j] = a[j-1] ;
        
            a[i] = key;
            break ;
        }

    return n+1;
}

int main()
{
    // nhap mang
    // xuat mang
    // them()
    // xuat mang   

    return 0 ;
}