public class Person
{
    private String name ; 
    private String sex ;
    private int age ;
    private double score ;
    private boolean isLove ; 
    //private ArrayList<String> temp ;  // dung de hoc them kien thuc moi thoi, ko co chuc nang gi

    public Person()
    {
        // this.temp = new ArrayList<String>() ; // Luu y: ArrayList khong tu khoi tao gia tri mac dinh duoc
        // nhung thuoc tinh kia se tu khoi tao gia tri mac dinh
    }

    public Person(String name, String sex, int age, double score, boolean isLove /*,ArrayList<String> temp*/)
    {
        this.name = name ; 
        this.sex = sex ; 
        this.age = age ; 
        this.score = score ;
        this.isLove = isLove ;
        // this.temp = temp ; 
    }

    // getter & setter
    //  ... ... ...

    public String toString()
    {
        return this.name+":"+this.sex+":"+this.age+":"+this.score+":"+this.isLove ; 
    }
}