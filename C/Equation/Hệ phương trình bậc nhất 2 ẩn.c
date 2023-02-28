#include <stdio.h>

int main()
{
    float a1, b1, c1, a2, b2, c2 ;
    float x, y;

    scanf("%f%f%f", &a1, &b1, &c1);
    scanf("%f%f%f", &a2, &b2, &c2);

    if(a1 == b1 && a1 == a2 && a1 == b2 && c1 != c2)
    {
        printf("VN");
        return 0;
    }

    float d = a1 * b2 - a2 * b1;
    float dx = c1 * b2 - c2 * b1;
    float dy = a1 * c2 - a2 * c1;

    if(d == 0) 
    {
        if(dx + dy == 0)
            printf("VSN");
        else
            printf("VN");
    }
    else 
    {
        x = dx / d;
        y = dy / d;
        printf("%.5f %.5f", x, y);
    }

    return 0 ;
}