public class City
{
    private int code;
    private String name;
    private double area;

    public City() {}

    public City(int code, String name, double area) 
    {
        this.code = code;
        this.name = name;
        this.area = area;
    }

    public int getCode() {return code;}
        
    public void setCode(int code) {this.code = code;}
        
    public String getName() {return name;}
        
    public void setName(String name) {this.name = name;}
        
    public double getArea() {return area;}
        
    public void setArea(double area) {this.area = area;}

    public String toString()
    {
        return "City[code=" + code + ", name=" + name + ", area=" + area + "]" ;
    }
}