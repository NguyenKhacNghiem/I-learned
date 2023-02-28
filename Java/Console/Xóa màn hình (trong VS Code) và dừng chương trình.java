import java.util.* ; 

public class test
{
    static void clearScreen()   // xoa man hinh - chi danh cho VS Code
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    static void waitScreen()   // dung chuong trinh
    {
        Scanner sc = new Scanner(System.in) ;
        String temp ; 

        do
        {
            System.out.print("Press Space and Enter to continue...") ; 
            temp = sc.nextLine() ; 
        }while(!temp.equals("\n")) ; 
    }

    public static void main(String[] args)
    {
        waitScreen() ; 
        clearScreen();
    }
}