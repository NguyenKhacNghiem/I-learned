import java.util.Scanner;

public class Exercise5
{
    public static void main(String []agrs)
    {
        int a, b, c, min ; 
        Scanner sc = new Scanner(System.in) ;

        System.out.print("Enter a: ") ;
        a = sc.nextInt() ;
        
        System.out.print("Enter b: ") ;
        b = sc.nextInt() ;

        System.out.print("Enter c: ") ;
        c = sc.nextInt() ;
        
        if(a<b && a<c)   min = a ;
        else if(b<c)     min = b ; 
        else             min = c ; 

        System.out.print("Min is: "+min) ; 
    }
}