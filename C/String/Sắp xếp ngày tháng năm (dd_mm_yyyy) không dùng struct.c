#include <stdio.h>
#include <string.h>
#include <stdlib.h>  // do dung ham atoi()

void getDayMonthYear(char date[][20], int day[], int month[], int year[])
{
    int i, j, k, count;

    for (i = 0; i < 3; i++)       
    {
        count = 1 ;
        j = 0 ;
        k = 0 ;

        while (date[i][j] != '\0')
        {
            char temp[20];
            temp[k] = date[i][j];
            k++;
            j++;

            if (date[i][j] == '/' || j == strlen(date[i]))
                if (count == 1)
                {
                    temp[k] = '\0' ;
                    day[i] = atoi(temp);
                    j++;
                    k = 0;
                    count++;
                }
                else if (count == 2)
                {
                    temp[k] = '\0' ;
                    month[i] = atoi(temp);
                    j++;
                    k = 0;
                    count++;
                }
                else
                {
                    temp[k] = '\0' ;
                    year[i] = atoi(temp);
                }
        }
    }
}

void swapDate(char a[], char b[])
{
    char temp[20] ;

    strcpy(temp, a) ;
    strcpy(a, b) ;
    strcpy(b, temp) ;
}

void swapDayMonthYear(int *a, int *b)
{
    int temp ;

    temp = *a ;
    *a = *b ;
    *b = temp ;
}

int main()
{ 
    char date[3][20] ;
    int day[3], month[3], year[3];   // 3 dates -> 3 days + 3 months + 3 years
    int i, k ;

    printf("Nhap 3 date (dd/mm/yyyy): \n");
    scanf("%s",&date[0]) ;
    scanf("%s",&date[1]) ;
    scanf("%s",&date[2]) ;

    // lay ngay, thang, nam tu date va chuyen ve dang int de so sanh
    getDayMonthYear(date, day, month, year);

    // Bubble Sort -> sort day -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
            if (day[k] > day[k+1])
            {
                swapDate(date[k], date[k+1]) ;
                swapDayMonthYear(&day[k], &day[k+1]) ;
                swapDayMonthYear(&month[k], &month[k+1]) ;
                swapDayMonthYear(&year[k], &year[k+1]) ;
            }
    
    // Bubble Sort -> sort month -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
            if (month[k] > month[k+1])
            {
                swapDate(date[k], date[k+1]) ;
                swapDayMonthYear(&month[k], &month[k+1]) ;
                swapDayMonthYear(&year[k], &year[k+1]) ;
            }

    // Bubble Sort -> sort year -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
           if (year[k] > year[k+1])
            {
                swapDate(date[k], date[k+1]) ;
                swapDayMonthYear(&year[k], &year[k+1]) ;
            }
        
    printf("Date sau khi sap xep la: \n");
    puts(date[0]);
    puts(date[1]);
    puts(date[2]);

    return 0;
}