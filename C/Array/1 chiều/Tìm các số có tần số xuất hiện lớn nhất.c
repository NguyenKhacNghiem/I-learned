#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void highestFrequenceNumber(int arr[])
{
    int freq[10]; // mang chua tan so xuat hien cua 10 so
    int i, j;
    int count;    // bien dem tan so

    // tim tan so cua tung phan tu trong mang
    for(i=0;i<10;i++) 
    {
        count = 1; // cac so trong mang deu luon xuat hien it nhat 1 lan

        for(j=i+1;j<10;j++) 
            if(arr[i] == arr[j]) 
            {
                count++;      // tang tan so xuat hien len
                freq[j] = 0;  // danh dau phan tu da duoc dem
            }

        if(freq[i] != 0) 
            freq[i] = count;
    }

    // Tim tan so lon nhat
    int maxFreq = freq[0]; 

    for(i=1;i<10;i++) 
        if(freq[i] > maxFreq) 
            maxFreq = freq[i];

    printf("Cac so co tan so xuat hien lon nhat la: ");
    for(i=0;i<10;i++) 
        if(freq[i] == maxFreq) 
            printf("%d ", arr[i]);
}

void print(int arr[])
{
    int i;

    printf("10 so ngau nhien la: \n");
    for(i=0;i<10;i++)
        printf("%d\n", arr[i]);
}

int main() 
{
    int arr[10];
    int i;

    // random 10 so trong doan [0;10]
    srand((int)time(0));
    for(i=0;i<10;i++)
        arr[i] = 0 + rand() % (10 + 1 - 0);

    print(arr);

    highestFrequenceNumber(arr);
}