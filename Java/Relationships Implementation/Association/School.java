import java.util.List;
import java.util.ArrayList;

public class School
{
    private String name, address;
    private List<Student> students = new ArrayList<>();

    public School(String name, String address) 
    {
        this.name = name;
        this.address = address;
    }

    public School()
    {
        this.name = "";
        this.address = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    public void print() {
        System.out.println("School") ;
        System.out.println("name: " + name) ;
        System.out.println("address: " + address) ;

        for(Student s:students)
            System.out.println(s) ;
    }
}