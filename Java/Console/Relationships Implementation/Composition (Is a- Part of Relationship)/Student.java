public class Student
{
    private int id;
    private String name;
    private School school;

    public Student(int id, String name) 
    {
        this.id = id;
        this.name = name;
        this.school = new School("TDTU", "District 7");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", school=" + school.toString() + "]";
    }
}