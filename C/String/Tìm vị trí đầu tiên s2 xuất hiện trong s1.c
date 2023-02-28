#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int theFirstPositionS2AppearesInS1(char s1[], char s2[])  // position starts with 0
{
    int i = 0, j, k, first ;
    bool check ;

    while(s1[i] != '\0')
    {
        if(s2[0] == s1[i])
        {
            if(strlen(s2) == 1) return i ;                

            first = i ;
            check = true ;

            for(j=1, k=i+1;j<strlen(s2);j++, k++)
                if(s2[j] != s1[k])
                    check = false ;

            if(check)   return  first ; 
        }

        i++ ;
    }

    return -1 ;  // not found 
}

int main()
{
    char s1[100], s2[100] ;

    printf("Enter S1: ") ;
    gets(s1) ;
    printf("Enter S2: ") ;
    gets(s2) ;

    printf("The first position S2 appeares in S1 is: %d\n", theFirstPositionS2AppearesInS1(s1, s2)) ;

    return 0 ;
}