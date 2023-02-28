// dem so lan xuat hien cua chuoi con trong chuoi me, ko phan biet chu hoa chu thuong
class demo
{
    public static void main(String[] args)
    {
        String s1 = "NgUyeN HoANg OaNH OAnh" ;
        String s2 = "oAnH" ; 
        int count = 0, index ;

        s1 = s1.toUpperCase() ;  // hoac lower
        s2 = s2.toUpperCase() ;  // hoac lower

        while(s1.indexOf(s2)>=0)
        {
            count++ ;
            index = s1.indexOf(s2) + s2.length() ; 
            s1 = s1.substring(index) ; 
        }

        System.out.println(count) ; 
    }
}