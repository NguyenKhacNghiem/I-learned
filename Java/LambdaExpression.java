import java.util.* ;

public class LambdaExpression 
{
    public static void main(String[] args) 
    {
        // Initialize data
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(4);

        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Anna");
        names.add("John");
        names.add("Hana");
        names.add("Violet");

        // Sort
        Collections.sort(numbers, (a, b) -> a - b);        // ascending order
        Collections.sort(names, (a, b) -> a.compareTo(b)); // a->z
        // -> a, b have data type like numbers. So we don't need to pass the data type

        // Print
        // Lambda Expression has one method = Method Reference
        numbers.forEach(System.out::println); // == numbers.forEach(i -> System.out.println(i));
        names.forEach(System.out::println); // == names.forEach(i -> System.out.println(i));
    }
}