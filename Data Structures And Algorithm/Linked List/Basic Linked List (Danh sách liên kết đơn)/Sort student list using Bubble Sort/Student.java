public class Student
{
    private String name ; 
    private double mathematics, programming, DSA1 ;
    private double avg ;

    public Student(String name, double mathematics, double programming, double DSA1)
    {
        this.name = name ;
        this.mathematics = mathematics ;
        this.programming = programming ;
        this.DSA1 = DSA1 ;
        this.avg = (mathematics + programming + DSA1)/3 ; 
    }

    public Student(){}

    public String getName()
    {
        return name ;
    }

    public double getMathematics()
    {
        return mathematics ;
    }

    public double getProgramming()
    {
        return programming ;
    }

    public double getDSA1()
    {
        return DSA1 ;
    }

    public double getAvg()
    {
        return (mathematics + programming + DSA1)/3 ; 
    }

    public void setName(String name)
    {
        this.name = name ;
    }

    public void setMathematics(double mathematics)
    {
        this.mathematics = mathematics ;
    }

    public void setProgramming(double programming)
    {
        this.programming = programming ;
    }

    public void setDSA1(double DSA1)
    {
        this.DSA1 = DSA1 ;
    }

    public void setAvg(double mathematics, double programming, double DSA1)
    {
        this.avg =  (mathematics + programming + DSA1)/3 ; 
    }

    public void swapStudent(Student s)
    {
        this.name = s.name ;
        this.mathematics = s.mathematics ;
        this.programming = s.programming ;
        this.DSA1 = s.DSA1 ;
        this.avg = (s.mathematics + s.programming + s.DSA1)/3 ;
    }

    public String toString()
    {
        return "Student[name=" + name + ", mathematics=" + mathematics + ", programming=" 
        + programming + ", DSA1=" + DSA1 + ", avg=" + avg + "]" ; 
    }
}