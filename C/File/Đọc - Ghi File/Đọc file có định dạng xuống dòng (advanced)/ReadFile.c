#include <stdio.h>
#include <string.h>

int main()
{
    char name[100] ;
    char date[100] ;
    char phone[100] ;
    char school[100] ;
    char address[100] ; 
    FILE *read ; 

    read = fopen("profile.txt","r") ; 

    while(!feof(read))
    {
        char enter[10] ;   // dung de doc ky tu xuong dong giua ham fscanf va fgets (tuong tu nhu scanf va gets)
        char temp[100] ;   // mang temp dung de xu ly chuoi duoc doc tu file truoc khi su dung chinh thuc

        fgets(temp,100,read) ;         // do chuoi doc vao co khoang trang nen phai doc qua bien temp bang ham fgets
        temp[strlen(temp)-1] = '\0' ;  // loai bo ky tu xuong dong o cuoi chuoi
        strcpy(name,temp) ;            // dua vao su dung chinh thuc sau khi xu ly chuoi xong

        fscanf(read,"%s",&date) ;   // chuoi doc vao ko co ky tu khoang trang nen dung ham fscanf -> ko can doc qua temp -> ko can xu ly ky tu xuong dong

        fscanf(read,"%s",&phone) ; 
        
        fgets(enter,10,read) ;     // do phia tren la fscanf nen phai doc ky tu enter (tuong tu scanf va gets)
        strcpy(temp,"") ;          // lam moi lai bien temp
        fgets(temp,100,read) ;
        temp[strlen(temp)-1] = '\0' ; 
        strcpy(school,temp) ;

        strcpy(temp,"") ;
        fgets(temp,100,read) ;
        temp[strlen(temp)] = '\0' ;   // chuoi cuoi cung ko can -1 vi ko co xuong dong 
        strcpy(address,temp) ;  
    }

    fclose(read) ;

    // in thong tin ra man hinh
    puts(name) ;
    puts(date) ;
    puts(phone) ;
    puts(school) ;
    puts(address) ; 

    return 0 ;
}