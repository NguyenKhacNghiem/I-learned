import java.util.Scanner;

public class PhuongTrinhBac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        double a, b ;

        System.out.print("Nhap a: ") ;
        a = sc.nextDouble();

        System.out.print("Nhap b: ") ;
        b = sc.nextDouble();

        if(a == 0) {
            if(b == 0)
                System.out.println("Phuong trinh co vo so nghiem") ;
            else
                System.out.println("Phuong trinh vo nghiem") ;
        }
        else {
            System.out.println("Phuong trinh co nghiem x = " + (-b/a)) ;
        }
    }
}