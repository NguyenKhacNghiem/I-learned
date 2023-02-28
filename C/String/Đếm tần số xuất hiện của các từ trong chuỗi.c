#include <stdio.h>
#include <string.h>
#include <stdbool.h>

void sapXepTheoThuTuChuCai(int n, char ws[1000][100], int f[1000])
{
    int i, j;
    printf("Theo thu tu chu cai: \n");
    
    for(i=0;i<n-1;i++)
        for(j=0;j<n-1-i;j++)
            if(strcmpi(ws[j], ws[j+1]) > 0)
            {
                int t1 = f[j];
                f[j] = f[j+1];
                f[j+1] = t1;
                
                char t2[100];
                strcpy(t2, ws[j]);
                strcpy(ws[j], ws[j+1]);
                strcpy(ws[j+1], t2);
            }
            
    for(i=0;i<n;i++)
        printf("%s - %d\n", ws[i], f[i]);
}

void sapXepTheoTanSoXuatHienGiamDan(int n, char ws[1000][100], int f[1000])
{
    int i, j;
    printf("Theo tan so xuat hien giam dan: \n");
    
    for(i=0;i<n-1;i++)
        for(j=0;j<n-1-i;j++)
            if(f[j] < f[j+1])
            {
                int t1 = f[j];
                f[j] = f[j+1];
                f[j+1] = t1;

                char t2[100];
                strcpy(t2, ws[j]);
                strcpy(ws[j], ws[j+1]);
                strcpy(ws[j+1], t2);
            }

    for(i=0;i<n;i++)
        printf("%s - %d\n", ws[i], f[i]);
}

int main()
{
    char s[1000], ws[1000][100], w[1000][100];
    int f[1000];
    int i, j = 0, k = 0, l, n;
    bool exist = false, duplicatePartition = false;

    printf("Nhap vao doan van ban: ");
    gets(s);

    for(i=0;i<strlen(s);i++) 
    {
        if(s[i] != ' ' && s[i] != ',' && s[i] != '.' && s[i] != '!' && s[i] != '?') 
        {
            duplicatePartition = false;
            ws[j][k] = s[i];
            k++;
        }
        else 
        { // i am. i am. i am.
            exist = false;

            if(duplicatePartition)
                continue;

            for(l=0;l<j;l++)
                if(strcmp(ws[l], ws[j]) == 0)
                    exist = true;
            
            if(!exist)
                j++;

            k = 0;
            duplicatePartition = true;
        } 
    }

    n = j;
    l = 0;

    for(i=0;i<n;i++)
    {
        f[i] = 0;

        for(j=0;j<strlen(s);j++)
        {   
            if(s[j] != ' ' && s[j] != ',' && s[j] != '.' && s[j] != '!' && s[j] != '?') 
            {
                w[l][k] = s[j];
                k++;
            }
            else
            {
                if(strcmp(ws[i], w[l]) == 0)
                    f[i]++;

                l++;
                k = 0;
            }
        }
    }

    sapXepTheoThuTuChuCai(n, ws, f);
    sapXepTheoTanSoXuatHienGiamDan(n, ws, f);
    
    return 0 ;
}