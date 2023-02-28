public class Main
{
    public static void main(String[] args) 
    {
        Student s1 = new Student(1, "Nguyen Van A");
        Student s2 = s1;  // truyen tham chieu trong Java
        
        System.out.println("---------------------------------") ;
        System.out.println(s1) ;
        System.out.println(s2) ;

        s1.setId(2);
        
        System.out.println("---------------------------------") ;
        System.out.println(s1) ;
        System.out.println(s2) ;

        s2.setId(1);

        System.out.println("---------------------------------") ;
        System.out.println(s1) ;
        System.out.println(s2) ;
    }
}