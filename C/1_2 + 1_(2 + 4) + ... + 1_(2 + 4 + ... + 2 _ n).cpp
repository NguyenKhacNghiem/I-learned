#include <iostream>

using namespace std ;

float tinhS(int n)
{
    float sum=0 ;
    int a[100] ;
    a[0] = 0 ;

    for(int i=1;i<=n;i++)
    {
        a[i] = a[i-1] + (2*i) ;
        sum += 1.0/a[i] ;
    }   
    
    return sum ;
}

int main()
{
    int n ;

    cout << "Nhap n: " ;
    cin >> n ;

    cout << "S = " ;
    cout << tinhS(n) ;

    return 0 ;
}