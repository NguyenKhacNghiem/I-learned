#include <stdio.h>
#include <math.h>
#include <string.h>

void nhapMaTran(float [][100], int, int) ; 
void inMaTran(float [][100], int, int) ;
void gaussJordan(float [][100], int, int) ; 
float timMaxFirst(float [][100], int) ;
void timSoChia(float, float [][100], float [], int, int, int) ;
void taoCotXoay(float, float [][100], float [], int, int, int, int) ;
int xetHangTroi(int [], int, int) ;
int xetCotTroi(int [], int, int) ;
void ketQua(float [], int) ;

int main()
{
    //fflush(stdin) ; 
    float a[100][100] ; 
    int hang, cot;

    printf("Nhap vao so phuong trinh va so an (n): ") ;
    scanf("%d",&hang) ; 
    cot = hang+1 ; 

    nhapMaTran(a,hang,cot) ; 
    printf("Ma tran ban da nhap la: \n") ;
    inMaTran(a,hang,cot) ;

    gaussJordan(a,hang,cot) ;
    inMaTran(a,hang,cot) ;

    int t=0,i,k ;
    float x[100] ; 

    for(i=0;i<hang;i++)
        for(k=0;k<hang;k++)
            if(a[i][k]!=0)
            { 
                x[t] = a[i][cot-1]/a[i][k] ;
                t++ ;
            }
        
    printf("\nVecto nghiem tim duoc la: \n") ;
    ketQua(x,t) ; 
    
    return 0 ;
}

void nhapMaTran(float a[][100], int hang, int cot)
{
    int i, k ;

    for(i=0;i<hang;i++)
        for(k=0;k<cot;k++)
        {
            printf("a[%d][%d]=",i+1,k+1) ;
            scanf("%f",&a[i][k]) ;
        }
}

void inMaTran(float a[][100], int hang, int cot)
{
    int i, k ;

    for(i=0;i<hang;i++)
    {
        for(k=0;k<cot;k++)
        {
            printf("%.2f\t",a[i][k]) ;
            if(k==cot-2)
                printf("|\t") ; 
        }
        printf("\n") ;
    }
}

void gaussJordan(float a[][100], int hang, int cot)
{
    int hang_troi[100], cot_troi[100],i ,k, size_hangTroi=0, size_cotTroi=0, check=0 ;  
    float max1 = timMaxFirst(a,hang) ;
    
    float soChia[100] ; 

    for(i=0;i<hang;i++)
    {
        for(k=0;k<hang;k++)
            if(a[i][k]==max1)
            {
                hang_troi[size_hangTroi] = i ;
                cot_troi[size_cotTroi] = k ;
                size_hangTroi++ ;
                size_cotTroi++ ;
                check=1 ;   // i: hang troi
                break ;    // k: cot troi
            }

        if(check==1) 
            break ;
    }     
            
    timSoChia(max1, a, soChia, hang, i ,k) ; 
    taoCotXoay(max1, a, soChia, hang, cot, i ,k) ;
    
    printf("Chon phan tu troi la: %.2f\n",max1) ; 
    
    // ---------//
    int count = 1 ;
    int q, w ;   // q la hang
                // w la cot
    float max ; 
    int check2 = 0 ; 

    while(count<hang)
    {
        inMaTran(a,hang,cot) ; 
        // tim max fau tien
        for(q=0;q<hang;q++)
        {
            for(w=0;w<hang;w++)
            {
                if(xetHangTroi(hang_troi,size_hangTroi,q)==0 && xetCotTroi(cot_troi,size_cotTroi,w)==0)
                {
                    max = a[q][w] ;
                    check2 = 1 ;
                    break ;
                } 
            }
            if(check2==1)
                break ;
        }

        // tim max chinh thuc
        for(q=0;q<hang;q++)
            for(w=0;w<hang;w++)
                if(xetHangTroi(hang_troi,size_hangTroi,q)==0 && xetCotTroi(cot_troi,size_cotTroi,w)==0)
                    if(fabs(a[q][w])>fabs(max))
                        max = a[q][w] ; 
        
        printf("Chon phan tu troi la: %.2f\n",max) ; 
        int check3 = 0 ;

        for(i=0;i<hang;i++)
        {
            for(k=0;k<hang;k++)
            {
                if(xetHangTroi(hang_troi,size_hangTroi,i)==0 && xetCotTroi(cot_troi,size_cotTroi,k)==0)
                    if(a[i][k]==max)
                    {
                        hang_troi[size_hangTroi] = i ;
                        cot_troi[size_cotTroi] = k ;
                        size_hangTroi++ ;
                        size_cotTroi++ ;
                        check3=1 ;   // i: hang troi
                        break ;    // k: cot troi
                    }
            }

            if(check3==1) 
                break ;
        }

        timSoChia(max, a, soChia, hang, i ,k) ; 
        taoCotXoay(max, a, soChia, hang, cot, i ,k) ;

        count++ ;
    }
} 

float timMaxFirst(float a[][100], int hang)
{
    int i, k ;

    float max = a[0][0] ; 

    for(i=0;i<hang;i++)
        for(k=0;k<hang;k++)
            if(a[i][k]>max)
                max = a[i][k] ;
            
    return max ; 
}

void timSoChia(float max1, float a[][100], float soChia[], int hang, int i, int k)   // i: hang troi
{                                                                              // k: cot troi
    int j=0 ;
    int r ; 
    
    for(r=0;r<hang;r++)
        if(r!=i)
        {
            soChia[j] = -a[r][k]/max1 ; 
            j++ ;
        }
}

void taoCotXoay(float max1, float a[][100], float soChia[], int hang, int cot, int i, int k)
{
    int r, c ;
    int j=0 ;

    for(r=0;r<hang;r++)
        if(r!=i)
        {
            for(c=0;c<cot;c++)
                a[r][c] = a[i][c]*soChia[j] + a[r][c] ; 
            j++ ; 
        }
}

int xetHangTroi(int hang_troi[], int size, int i)
{
    int k ;

    for(k=0;k<size;k++)
        if(hang_troi[k]==i)
            return -1 ;   // trung
    
    return 0 ;  // ko trung
}

int xetCotTroi(int cot_troi[], int size, int i)
{
    int k ;

    for(k=0;k<size;k++)
        if(cot_troi[k]==i)
            return -1 ;   // trung
    
    return 0 ;  // ko trung
}


void ketQua(float x[], int hang)
{
    int i ;

    for(i=0;i<hang;i++)
        if(fabs(x[i])<10000)
            printf("%.2f\n",x[i]) ;
}

