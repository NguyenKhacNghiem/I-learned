import java.util.* ;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex 
{
    public static void main(String[] args) 
    {
        Pattern pattern;
        Matcher matcher;
        String regex = "";

        /* Tim kiem */
        String[] list = {"Trieu Van Than", "Nguyen Thi Hoa", "To Trong Phu", "Ngo Van Tai", "Le Duc Anh", "Do Viet Hung", "Tran Thuy Ha"};

        // Tim nhung cai ten co cum "th" || "Th"
        System.out.println("--------------------") ;
        regex = ".*th.*";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for(String s : list)
        {
            matcher = pattern.matcher(s);

            if(matcher.find())
                System.out.println(s) ;
        }

        // Tim nhung nguoi mang ho "Tran"
        System.out.println("--------------------") ;
        regex = "^Tran?";
        pattern = Pattern.compile(regex);

        for(String s : list)
        {
            matcher = pattern.matcher(s);

            if(matcher.find())
                System.out.println(s) ;
        }

        // Tim nhung cai ten ket thuc boi chu "n"
        System.out.println("--------------------") ;
        regex = ".*n$";
        pattern = Pattern.compile(regex);

        for(String s : list)
        {
            matcher = pattern.matcher(s);

            if(matcher.find())
                System.out.println(s) ;
        }

        /* Thay the */
        String s = "     hello  world    cup 2022!    ";

        // Thay the nhieu khoang trang thanh 1 khoang trang
        System.out.println("--------------------") ;
        regex = "\\s{2,}"; // do la string nen can 2 dau \ (giong \" a)
        
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(s);

        String StringAfterRemoveMultiSpaces = matcher.replaceAll(" ");
        System.out.println(StringAfterRemoveMultiSpaces) ;    
        
        // Xoa khoang trang dau va cuoi (nen dung ham trim() cho nhanh)
        System.out.println("--------------------") ;
        regex = "^\\s|\\s$";  // do la string nen can 2 dau \ (giong \" a)
        
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(StringAfterRemoveMultiSpaces);

        System.out.println(matcher.replaceAll("")) ;   
    }
}