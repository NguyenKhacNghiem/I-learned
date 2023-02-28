#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <conio.h>

int main()
{
    char username[100], password[100], c;
    int i;

    do
    {
        printf("--------Login--------\n\n");

        printf("Username: ");
        gets(username);  

        i = 0;
        printf("Password: ");
        do
        {
            c = getch();
        
            if(c != 13) // khong lay ky tu "enter"
            {
                password[i] = c;
                printf("*");
            }
                
            i++;
        }while(c != 13); // kiem tra c co phai ky tu "enter" hay khong

        password[i - 1] = '\0'; 

        if(strcmp(username, "admin") == 0 && strcmp(password, "123456") == 0)
            printf("\nLogin success !\n");
        else
            printf("\nUsername or password is wrong. Please try again !\n");
            
        system("pause");
        system("cls");

    }while(strcmp(username, "admin") != 0 || strcmp(password, "123456") != 0) ;

    return 0 ;
}