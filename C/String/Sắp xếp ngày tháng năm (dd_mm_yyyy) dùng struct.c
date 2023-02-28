#include <stdio.h>
#include <string.h>
#include <stdlib.h>  // do dung ham atoi()

typedef struct
{
    char dayMonthYear[20] ;
    int day ;
    int month ;
    int year ;
}Date ;

void getDayMonthYear(Date date[])
{
    int i, j, k, count;

    for (i = 0; i < 3; i++)       
    {
        count = 1 ;
        j = 0 ;
        k = 0 ;

        while (date[i].dayMonthYear[j] != '\0')
        {
            char temp[20];
            temp[k] = date[i].dayMonthYear[j];
            k++;
            j++;

            if (date[i].dayMonthYear[j] == '/' || j == strlen(date[i].dayMonthYear))
                if (count == 1)
                {
                    temp[k] = '\0' ;
                    date[i].day = atoi(temp);
                    j++;
                    k = 0;
                    count++;
                }
                else if (count == 2)
                {
                    temp[k] = '\0' ;
                    date[i].month = atoi(temp);
                    j++;
                    k = 0;
                    count++;
                }
                else
                {
                    temp[k] = '\0' ;
                    date[i].year = atoi(temp);
                }
        }
    }
}

void swap(Date *a, Date *b)
{
    Date temp ;

    temp = *a ;
    *a = *b ;
    *b = temp ;
}

int main()
{ 
    Date date[3] ;
    int i, k ;

    printf("Nhap 3 date (dd/mm/yyyy): \n");
    scanf("%s",&date[0].dayMonthYear) ;
    scanf("%s",&date[1].dayMonthYear) ;
    scanf("%s",&date[2].dayMonthYear) ;

    // lay ngay, thang, nam tu date va chuyen ve dang int de so sanh
    getDayMonthYear(date) ;

    // Bubble Sort -> sort day -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
            if (date[k].day > date[k+1].day)
                swap(&date[k], &date[k+1]) ;
            
    
    // Bubble Sort -> sort month -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
            if (date[k].month > date[k+1].month)
                swap(&date[k], &date[k+1]) ;

    // Bubble Sort -> sort year -> tang dan nen >
    for (i = 0; i < 3 - 1; i++)   // 3 la so chuoi (length)
        for (k = 0; k < 3 - 1 - i; k++)
           if (date[k].year > date[k+1].year)
                swap(&date[k], &date[k+1]) ;
        
    printf("Date sau khi sap xep la: \n");
    puts(date[0].dayMonthYear);
    puts(date[1].dayMonthYear);
    puts(date[2].dayMonthYear);

    return 0;
}