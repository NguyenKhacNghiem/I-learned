#include <stdio.h>
#include <stdbool.h>

int main() {
    int a[100], n, i;
    bool check = false;

    printf("Nhap so luong phan tu cho mang: ");
    scanf("%d", &n);

    for(i=0;i<n;i++) {
        printf("Nhap a[%d]: ", i);
        scanf("%d", &a[i]);
    }

    printf("a: ");
    for(i=0;i<n;i++)
        printf("%d ", a[i]);

    for (i=0;i<n-2;i++) 
        if (a[i+1] - a[i] == a[i+2] - a[i+1]) {
            printf("\nCac so tu a[%d] den a[%d] tao thanh mot cap so cong.", i, i + 2);
            check = true;
        }

    if(!check)
        printf("\nTrong danh sach khong co 3 so lien ke nhau tao thanh mot cap so cong\n");  

    return 0 ;
}