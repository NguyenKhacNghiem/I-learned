#include <stdio.h>

void reset(int *a, int *b)
{
    *a = 7;
    *b = 9;
}

int main()
{
    int a, b;

    // Cách 1: dùng biến tạm
    reset(&a, &b);
    int temp = a;                       // temp = 7
    a = b;                              // a = 9
    b = temp;                           // b = 7
    printf("a = %d, b = %d\n", a, b);

    // Cách 2: dùng phép cộng
    reset(&a, &b);
    a = a + b;                          // a = 7 + 9 = 16
    b = a - b;                          // b = 16 - 9 = 7
    a = a - b;                          // a = 16 - 7 = 9
    printf("a = %d, b = %d\n", a, b);

    // Cách 3: dùng toán tử xor (chuyển về bit -> xét từng cặp (cột) nếu giống nhau thì 0, khác nhau thì 1)
    reset(&a, &b);                      // 7 = 0111, 9 = 1110
    a ^= b ;                            // a = 0111 ^ 1001 = 1110
    b ^= a ;                            // b = 1001 ^ 1110 = 0111 = 7
    a ^= b ;                            // a = 1110 ^ 0111 = 1001 = 9
    printf("a = %d, b = %d\n", a, b);

    // Cách 3: dùng toán tử xor (viết gọn)
    reset(&a, &b);
    a^=b^=a^=b;
    printf("a = %d, b = %d\n", a, b);

    return 0;
}