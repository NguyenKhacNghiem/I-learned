public class FactoryPattern 
{
    public Phone getPhone(PhoneType phoneType) 
    {
        Phone phone = null;

        switch(phoneType) 
        {
            case SAMSUNG:
                phone = new Samsung();
                break;
            case APPLE:
                phone = new Apple();
                break;
            case NOKIA:
                phone = new Nokia();
                break;
        }

        return phone;
    }
 }