#include <stdio.h>
#include <string.h>

typedef struct
{
    char tu[100] ; 
}Tu ; 

int DemSoTuTrongChuoi(char s[])
{
    int soTu = 0, i ;

     for(i=0;i<strlen(s);i++)
        if(s[i]==' ' || i==strlen(s)-1)
            soTu++ ;
    
    return soTu ;
}

void TimCacTuDaiNhat(char s[])
{
    Tu t[100], temp[100] ; 
    int k=0, j=0, i, max ; 

    for(i=0;i<strlen(s);i++)
    {
        if(s[i]!= ' ')
        {
            (temp[k].tu)[j] = s[i] ; 
            j++ ; 

            if(i==strlen(s)-1)
                strcpy(t[k].tu,temp[k].tu) ;

            continue ; 
        }

        strcpy(t[k].tu,temp[k].tu) ; 
        k++ ; 
        j=0 ;
    }

    max = strlen(t[0].tu) ; 

    for(i=1;i<=k;i++)
        if(strlen(t[i].tu)>max)
            max = strlen(t[i].tu) ; 
    
    for(i=0;i<=k;i++)
        if(strlen(t[i].tu)==max)
            puts(t[i].tu) ;
}

int main()
{
    char s[100] ; 

    printf("Nhap chuoi s: ") ; 
    gets(s) ; 

    printf("So tu trong chuoi la: %d\n",DemSoTuTrongChuoi(s)) ;          
    
    printf("Cac tu dai nhat trong chuoi la: \n") ; 
    TimCacTuDaiNhat(s) ;

    return 0 ; 
}