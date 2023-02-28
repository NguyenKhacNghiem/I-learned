import java.util.* ;

public class ChuanHoaChuoi_Pro
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in) ;
        String temp = "" ;            
        
        System.out.print("Input s: ") ;
        String s = sc.nextLine() ;

        // xoa cac spaces thua, chi giu lai 1 space giua cac tu dong thoi in thuong chuoi
        String[] items = s.toLowerCase().split(" ") ;
        for(String i:items) 
            if(i.length() > 0)
                temp += i + " " ;
        
        // tao chuoi chuan hoa
        s = "" ;
        while(s.length() != temp.length())
            s += Character.toUpperCase(temp.charAt(s.length())) + temp.substring(s.length() + 1, temp.indexOf(" ",s.length() + 1) + 1) ;                
        
        s = s.trim() ;  // xoa khoang trang thua con du o cuoi chuoi
        System.out.println(s) ;
    }
}