public class Student
{
    private School school;

    public Student(School school) 
    {
        this.school = school;
    }

    public Student() 
    {

    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String toString()
    {
        return this.school.toString();
    }
}