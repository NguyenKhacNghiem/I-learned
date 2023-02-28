enum Direction
{
    EAST, WEST, SOUTH, NORTH ;
}

public class Main
{
    enum Season
    {
        SPRING, SUMMER, FALL, WINTER ;
    }

    public static void main(String[] args) 
    {
        // TH1: ben ngoai 1 file
        Enum enumObj = new Enum(Day.MONDAY) ;
        System.out.println(enumObj.getDay()) ;

        // TH2: ben trong 1 class
        Season season = Season.SPRING ;
        System.out.println(season) ;

        // TH3: ben ngoai 1 class
        Direction direction = Direction.EAST;
        System.out.println(direction) ;

        // Duyet qua cac phan tu trong enum
        System.out.print("There are 4 seasons in a year: ") ;
        for(Season s:Season.values())
            System.out.print(s + ", ") ;
    }
}