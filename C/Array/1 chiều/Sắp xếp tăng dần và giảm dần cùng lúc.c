// Sắp xếp mảng số nguyên tăng dần trong đoạn [a, b] và giảm dần ngoài đoạn này
#include <stdio.h>
#include <stdbool.h>

void inMang(int arr[], int n) {
    int i;

    for(i=0;i<n;i++)
        printf("%d ", arr[i]);

    printf("\n");
}

void hoanVi(int* x, int* y) {
    int temp = *x;

    *x = *y;
    *y = temp;
}

void sapXepTangDan(int arr[], int n, int a, int b) {
    int i, j;

    for (i=0;i<n-1;i++) {
        for (j=i+1;j<n;j++) 
            if (arr[i] > arr[j] && arr[i] >= a && arr[i] <= b && arr[j] >= a && arr[j] <= b) 
                hoanVi(&arr[i], &arr[j]);
    }
}

void sapXepGiamDan(int arr[], int n, int a, int b) {
    int i, j;

    for (i=0;i<n-1;i++) 
        for (j=i+1;j<n;j++) 
            if ((arr[i] > b || arr[i] < a) && (arr[j] > b || arr[j] < a)) 
                if (arr[i] < arr[j]) 
                    hoanVi(&arr[i], &arr[j]);
}

void sapXep(int arr[], int n) {
    int a, b;

    printf("Nhap a: ");
    scanf("%d", &a);

    printf("Nhap b: ");
    scanf("%d", &b);

    sapXepTangDan(arr, n, a, b);
    sapXepGiamDan(arr, n, a, b);
}

int main() {
    int arr[100], n, i;

    printf("Nhap so luong phan tu cho mang: ");
    scanf("%d", &n);

    for(i=0;i<n;i++) {
        printf("Nhap a[%d]: ", i);
        scanf("%d", &arr[i]);
    }

    printf("Mang truoc khi sap xep: ");
    inMang(arr, n);

    sapXep(arr, n);
    printf("Mang sau khi sap xep: ");
    inMang(arr, n);

    return 0 ;
}