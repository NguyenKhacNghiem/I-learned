public class School
{
    private String name, address;

    public School(String name, String address) 
    {
        this.name = name;
        this.address = address;
    }

    public School()
    {
        
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

    @Override
    public String toString() {
        return "School [address=" + address + ", name=" + name + "]";
    }
}