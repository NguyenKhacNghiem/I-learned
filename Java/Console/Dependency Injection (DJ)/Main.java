public class Main
{
    public static void main(String[] args) 
    {
        School school = new School("Ton Duc Thang University", "District 7");
        Student student = new Student(school);

        System.out.println(student) ;

        school.setAddress("District 8");
        
        System.out.println(student) ;
    }
}