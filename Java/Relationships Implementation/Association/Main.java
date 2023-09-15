public class Main
{
    public static void main(String[] args) 
    {
        School school = new School("TDTU", "District 7");
        Student s1 = new Student(1, "Peter");
        Student s2 = new Student(2, "Anna");

        school.getStudents().add(s1);
        school.getStudents().add(s2);

        school.print();
    }
}