// su dung con tro trong struct
#include <stdio.h>

struct Hocsinh
{
    int MSSV ;
    int NamSinh ; 
} ;

int main()
{
    struct Hocsinh  *p , hs ;
    p = &hs ; // cho p tro toi dia chi cua bien hs dang co KDL struct
    
    // nhap vo struct qua con tro 
    printf("nhap vao MSSV: ") ;
    scanf("%d",&p->MSSV) ;   // nho co dau & va khi dung con tro thi ->
    printf("nhap vao nam sinh: ") ;
    scanf("%d",&p->NamSinh) ;

    // xuat struct qua con tro
    printf("MSSV la %d\n",p->MSSV) ;
    printf("nam sinh la %d",p->NamSinh) ;

    return 0 ;
}