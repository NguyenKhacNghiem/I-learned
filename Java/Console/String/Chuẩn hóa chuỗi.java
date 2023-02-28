import java.util.Scanner ;

public class ChuanHoa 
{
	static void chuanHoa(String  s)
    {
        s = s.toLowerCase() ; // in thuong het
        String [] s3;
        String s2 = "";
        s3 = s.split(" ") ;   // tach chuoi me thanh cac chuoi con cach nhau boi dau cach
        
        for(int i = 0; i< s3.length; i++ )
        {
            String s1 = "";
            
            if(s3[i].length() != 0 )
            {
                s1+= Character.toUpperCase(s3[i].charAt(0));
                if(s3[i].length() > 1) s1 += s3[i].substring(1) ;  // tu ky tu thu 1 den het
                s2+= s1;
                if(i< s3.length ) s2+= " ";
            }
        }
        
        if(s2.charAt(s2.length()-1) == ' ') 
        	s2+= "\b";
        
        System.out.print("\nchuoi sau khi chuan hoa: " + s2);
    }
    
    static void nhap()
    {
        String s;
        System.out.print("Nhap vao chuoi ky tu can chua hoa: ");
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        System.out.print("chuoi truoc khi chuan hoa: "+s) ;
        chuanHoa(s);
    }
    
    public static void main(String[] args) 
    {
        nhap();
    }
}
