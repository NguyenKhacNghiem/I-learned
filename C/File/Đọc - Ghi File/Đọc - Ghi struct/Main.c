#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char fullname[30];
    char gender[7];  
    int age;
    char phone[20];
    float salary;
    char address[80];
}Information;

int countLineNumber()
{
    FILE *reader;
    int n = 0 ;

    reader = fopen("input.txt", "r");

    while(!feof(reader))
    {
        char c = fgetc(reader);

        if(c == '\n')
            n++;
    }

    return n + 1;
}

int readFile(Information list[])
{
    int n = 0, lineNumber = countLineNumber();
    FILE *reader;

    reader = fopen("input.txt", "r");

    while(!feof(reader))
    {
        char s[200];

        fgets(s, 200, reader);
        
        // read fullname
        int i = 0, k = 0;
        while(s[i] != ';')
        {
            list[n].fullname[k] = s[i];
            i++;
            k++;
        }

        // read gender
        i++;
        k = 0;
        while(s[i] != ';')
        {
            list[n].gender[k] = s[i];
            i++;
            k++;
        }

        // read age
        i++;
        k = 0;
        char age[3];
        while(s[i] != ';')
        {
            age[k] = s[i];
            i++;
            k++;
        }
        list[n].age = atoi(age);

        // read phone number
        i++;
        k = 0;
        while(s[i] != ';')
        {
            list[n].phone[k] = s[i];
            i++;
            k++;
        }

        // read salary
        i++;
        k = 0;
        char salary[20];
        while(s[i] != ';')
        {
            salary[k] = s[i];
            i++;
            k++;
        }
        list[n].salary = atof(salary);

        // read address
        i++;
        k = 0;
        while(s[i] != '\0')
        {
            list[n].address[k] = s[i];
            i++;
            k++;
        }

        if(n + 1 != lineNumber)
            list[n].address[k-1] = '\0';

        n++;
    }

    fclose(reader);
    return n;
}

void writeFile(Information list[], int n)
{
    FILE *writer ;

    writer = fopen("output.txt", "w") ;

    for(int i=0;i<n;i++)
        if(i == n - 1)
            fprintf(writer, "%s;%s;%d;%s;%f;%s", strupr(list[i].fullname), list[i].gender, list[i].age, list[i].phone, list[i].salary, strupr(list[i].address));
        else
            fprintf(writer, "%s;%s;%d;%s;%f;%s\n", strupr(list[i].fullname), list[i].gender, list[i].age, list[i].phone, list[i].salary, strupr(list[i].address));
    
    fclose(writer);
}

void showInformation(Information list[], int n)
{
    printf("%-30s %-7s %-3s      %-20s %-20s      %-80s\n", "Fullname", "Gender", "Age", "Phone Number", "Salary", "Address");
    printf("-----------------------------------------------------------------------------------------------------------------\n");
    
    for(int i=0;i<n;i++)
        printf("%-30s %-7s %-3d    %-22s %-20.2f %-80s\n", list[i].fullname, list[i].gender, list[i].age, list[i].phone, list[i].salary, list[i].address);
}


int main()
{
    Information list[200];
    int n;

    n = readFile(list);
    
    showInformation(list, n);

    printf("Write struct to file 'output.txt' success");
    writeFile(list, n);

    return 0 ;
}