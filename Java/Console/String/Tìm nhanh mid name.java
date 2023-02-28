class FindMidName
{
    public static void main(String[] args)
    {
        String name = "nguyen duong hai yen" ; 
        int f = name.indexOf(" ") ; 
        int l = name.lastIndexOf(" ") ; 
        System.out.println(name.substring(f+1,l)) ; 
    }
}
