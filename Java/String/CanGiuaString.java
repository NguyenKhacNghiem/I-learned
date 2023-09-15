public class CanGiuaString
{
    static String centerString(String s, int length) 
    {
		int left = (length - s.length()) / 2;
        int right = length - left - s.length();
        String repeatedChar = " ";
        StringBuffer buff = new StringBuffer();
        
        for (int i = 0; i < left; i++) 
            buff.append(repeatedChar);
        
        buff.append(s);
        for (int i = 0; i < right; i++) 
            buff.append(repeatedChar);
     
        return buff.toString() ;
    }

    public static void main(String[] args) 
    {
		String s1 = "---------------------------------------------------------------------------------------------------\n" ;
        String s2 = centerString("Hello", 99) ;  // 99 la chieu dai cua s1 va s3 -> Muc dich lam cho "Hello" nam giua
        String s3 = "\n---------------------------------------------------------------------------------------------------" ;

        System.out.println(s1 + s2 + s3) ;
    }
}