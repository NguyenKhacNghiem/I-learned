import java.util.* ;
import java.io.* ;

public class Main
{
    public static void main(String[] args) 
    {
        City city1 = new City(1, "Los Angeles", 100) ;
        City city2 = new City(2, "New York", 110) ;
        City city3 = new City(3, "San Diego", 120) ;
        City city4 = new City(4, "Boston", 130) ;
        City city5 = new City(5, "Chicago", 140) ;
        City city6 = new City(6, "Houston", 150) ;
        City city7 = new City(7, "Seattle", 160) ;
        City city8 = new City(8, "Las Vegas", 170) ;
        City city9 = new City(9, "Portland", 180) ;
        City city10 = new City(10, "Denver", 190) ;
        AdjacentMatrix g = new AdjacentMatrix() ;
        ArrayList<City> cities = new ArrayList<>() ;
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);
        cities.add(city6);
        cities.add(city7);
        cities.add(city8);
        cities.add(city9);
        cities.add(city10);

        System.out.println("*****************************Read file and print Graph") ;
        g.readFile(cities) ;
        g.printGraph() ;

        System.out.println("*****************************Find The Minimum Spanning Tree") ;
        g.primMST() ;
    }
}