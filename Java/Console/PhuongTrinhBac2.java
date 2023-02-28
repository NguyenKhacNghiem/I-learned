import java.util.Scanner;

public class PhuongTrinhBac2 {

    static String giaiPTBac1(double a, double b) {
        if(a == 0) {
            if(b == 0)
                return "Phuong trinh co vo so nghiem" ;
            else
                return "Phuong trinh vo nghiem" ;
        }
        
        return "Phuong trinh co nghiem x = " + (-b/a) ;
    } 

    static String giaiPTBac2(double a, double b, double c) {
        double delta = b*b - 4*a*c;

        if(delta < 0)
            return "Phuong trinh vo nghiem" ;

        if(delta == 0)
            return "Phuong trinh co nghiem kep: " + (-b/(2*a)) ;
        
        return "Phuong trinh co 2 nghiem phan biet:\n" + "x1 = " + ((-b+Math.sqrt(delta)) / (2*a)) + "\n" + "x2 = " + ((-b-Math.sqrt(delta)) / (2*a));       
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        double a, b, c;

        System.out.print("Nhap a: ");
        a = sc.nextDouble();

        System.out.print("Nhap b: ");
        b = sc.nextDouble();

        System.out.print("Nhap c: ");
        c = sc.nextDouble();

        if(a == 0) 
            System.out.println("Do a = 0 nen phuong trinh se tro thanh phuong trinh bac nhat. Ket qua la: " + giaiPTBac1(b, c)) ;
        else 
            System.out.println(giaiPTBac2(a, b, c)) ;
    }
}