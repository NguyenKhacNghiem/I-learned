public class Enum
{
    Day day;

    public Enum(Day day)
    {
        this.day = day ;
    }

    public String getDay()
    {
        switch(day)
        {
            case MONDAY:
                return "Monday" ;
            case TUESDAY:
                return "Tuesday" ;
            case WEDNESDAY:
                return "Wednesday" ;
        }

        return "" ; // khong quan trong
    }
}