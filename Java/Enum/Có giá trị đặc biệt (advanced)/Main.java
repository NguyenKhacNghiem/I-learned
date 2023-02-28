public class Main
{
    public static void main(String[] args) 
    {
        for(Student student:Student.values())
            System.out.println(student + ": " 
                                + student.getId() + " - " 
                                + student.getName() + " - " + 
                                student.getGender()) ;
    }
}