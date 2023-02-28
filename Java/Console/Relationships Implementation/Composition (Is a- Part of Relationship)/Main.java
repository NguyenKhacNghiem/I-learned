public class Main
{
    public static void main(String[] args) 
    {
        Student student = new Student(1, "Peter");
        
        System.out.println(student) ;
        
        student.setSchool(null); // xoa

        // doi tuong tao tu lop A mat thi doi tuong tao tu lop B cung mat luon
        // System.out.println(student) ; // school bi null roi nen khong lay duoc
    }
}