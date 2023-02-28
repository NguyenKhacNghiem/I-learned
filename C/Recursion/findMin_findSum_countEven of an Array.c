#include <stdio.h>

int min(int a, int b)
{
    if(a > b)   return b ;
    return a ;
}

int findMin(int a[], int n)
{
    if (n <= 0)  return -1;    // mang rong
    if (n == 1)  return a[0];
    
    return min(a[n - 1], findMin(a, n - 1));    // ham min viet phia tren
}

int findSum(int a[], int n)
{
    if (n <= 0)  return 0;
       
    return a[n - 1] + findSum(a, n - 1);
}

int countEven(int a[], int n)
{
    if(n == 0)            return 0 ; // mang rong

    if(a[n-1] % 2 == 0)   return 1 + countEven(a,n-1) ;  // cong 1 vo bo nho de quy, n - 1 -> dung lam con chay array
        
    return countEven(a, n-1) ;  // ko cong 1, n - 1 -> dung lam con chay array
}

int main()
{
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // size = 10

    printf("Min = %d\n", findMin(a,10)) ;
    printf("Sum = %d\n", findSum(a,10)) ;
    printf("Number of even = %d\n", countEven(a, 10)) ;
}