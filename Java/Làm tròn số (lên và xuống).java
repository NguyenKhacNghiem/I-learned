public class LamTronSo 
{
    public static void main(String[] args) 
    {
        /*        CƠ BẢN 
          - Làm tròn lên:
              + Math.round(1.3) -> 1
              + Math.round(1.5) -> 2
              + Math.ceil(1.5)  -> 2.0
              + Math.ceil(1.3)  -> 2.0
          - Làm tròn xuống: 
              + Math.floor(1.3) -> 1.0
              + Math.floor(1.5) -> 1.0

                 PHỨC TẠP (làm tròn đến số chữ số thập phân mà mình muốn):
            + Cách 1: printf(%.2f) giống C
            + Cách 2: Công thức: Result = (double) Math.round/ceil(value*10^n)/10^n  với n là số chữ số thập phân ta cần
               VD: xem src bên dưới
        */
                                                        // *** LAM TRON LEN ***
        double n = 10.3546645;

        System.out.println("LAM TRON LEN") ;
        System.out.println("Su dung phuong thuc Math.round()");

        // lam tron len gom 1 so thap phan, nhan va chia cho 10
        System.out.println((double) Math.round(n *10)/10) ;

        // lam tron len gom 2 so thap phan, nhan va chia cho 100
        System.out.println((double) Math.round(n*100)/100) ;

        // lam tron len gom 3 so thap phan, nhan va chia cho 1000
        System.out.println((double) Math.round(n*1000)/1000);
 
        System.out.println("Su dung phuong thuc Math.ceil()");

        // lam tron len gom 1 so thap phan, nhan va chia cho 10
        System.out.println((double) Math.ceil(n*10)/10) ;

        // lam tron len gom 2 so thap phan, nhan va chia cho 100
        System.out.println((double) Math.ceil(n*100)/100) ;

        // lam tron len gom 3 so thap phan, nhan va chia cho 1000
        System.out.println((double) Math.ceil(n*1000)/1000) ;

                                                        // *** LAM TRON XUONG ***
        double m = 10.3546645;

        System.out.println("LAM TRON XUONG") ;
        System.out.println("Su dung phuong thuc Math.floor()") ;

        // lam tron xuong gom 1 so thap phan, nhan va chia cho 10
        System.out.println((double) Math.floor(m*10)/10) ;

        // lam tron len gom 2 so thap phan, nhan va chia cho 100
        System.out.println((double) Math.floor(m*100)/100) ;

        // lam tron len gom 3 so thap phan, nhan va chia cho 1000
        System.out.println((double) Math.floor(m*1000)/1000) ;
    }
}
