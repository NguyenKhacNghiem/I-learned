public class FunctionalInterface
{
    // Functional Interface can write in the same file
    // Functional Interface can have instace (object)
    @FunctionalInterface
    public interface Calculable
    {
        public abstract double calculate();
    }

    static void printResult(Calculable instance)
    {
        System.out.println("Result: " + instance.calculate()) ;
    }

    public static void main(String[] args) 
    {
        // Don't use Lambra Expression
        printResult(new Calculable() // new Calculable() is anonymous class
        {
            @Override
            public double calculate()
            {
                return 1;
            }
        });

        // Use Lambra Expression
        printResult(() -> {return 2;}); // = printResult(() -> 2);
    }
}