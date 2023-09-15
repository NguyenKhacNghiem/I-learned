public enum Student
{
    // Khoi tao 3 enum voi cac gia tri dac biet (su dung constructor ben duoi)
    // -> giong nhu khoi tao doi tuong vay
    // -> PHAI nam o dau
    STUDENT_A(1, "Nguyen Van A", "Male"),  // dau "," nha
    STUDENT_B(2, "Tran Thi B", "Female"),
    STUDENT_C(2, "Nguyen Van C", "Male") ; // dau ";" nha

    // 3 bien tuong ung voi 3 gia tri dac biet cua cac hang trong enum
    private int id ;
    private String name ;
    private String gender ;

    // private constructor
    private Student(int id, String name, String gender)
    {
        this.id = id;
        this.name = name ;
        this.gender = gender ;
    }

    // getters and setters
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }
}