public class Main
{
    public static void main(String[] args) 
    {
        FactoryPattern factory = new FactoryPattern();

        Phone phone = factory.getPhone(PhoneType.SAMSUNG);
        
        phone.showInfo();
    }
}