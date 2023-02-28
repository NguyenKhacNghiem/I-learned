// Program to demonstrate about the static Nested Class

// Outer Class
class OuterClass
{
    static int x = 10 ;
    int y = 20 ;
    private static int z = 30 ;

    // static Nested Class
    static class Inner
    {
        void display()
        {
            System.out.println("x = " + x) ;
            // System.out.println("y = " + y) ; static Nested Class khong the truy cap non-static variable
            System.out.println("z = " + z) ;
        }
    }
}

// test 2 classes above
public class StaticNestedClass
{
    public static void main(String[] args) 
    {
        OuterClass.Inner inner = new OuterClass.Inner() ;

        inner.display();
    }
}