public class Main
{
    public static void main(String[] args) 
    {
        School school = new School("TDTU", "District 7");
        Student student = new Student(1, "Peter", school);

        school = null;  // xoa

        // System.out.println(school.getName()) ; // null roi nen lay ko dc

        // doi tuong tao tu lop A mat nhung doi tuong tao tu lop B van con
        System.out.println(student) ;
        System.out.println(student.getSchool().getName()) ;
    }
}