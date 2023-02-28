// Program to demonstrate about the non-static Nested Class

// Outer Class
class OuterClass
{
    static int x = 10;
    int y = 20 ;
    private int z = 30 ;
    String hello = "Hello " ;

    // Inner Class
    class InnerClass
    {
        void display()
        {
            System.out.println("x = " + x) ;
            System.out.println("y = " + y) ;
            System.out.println("z = " + z) ;
        }
    }

    // Local Class
    public String welcome(String name)
    {
        String from = "From Local Class: " ;

        class LocalClass
        {
            // constructor
            LocalClass()
            {
                System.out.println(from) ; // only use, can't change
            }

            String say = " say " ; 
            // System.out.println() ;  // khong dc in ra trong Local Class 

            String sayHelloWorld()
            {
                return name + say + hello + "World !" ;
            }
        }

        LocalClass local = new LocalClass();

        return local.sayHelloWorld() ;
    }

    // Anonymous Class
    interface anonymousInterface
    {
        void anonymousFunction() ;
    }

    public void anonymousSay()
    {
        anonymousInterface anonymous = new anonymousInterface()
        {
            String hello = "hello" ;

            @Override
            public void anonymousFunction()
            {
                System.out.println("Anonymous say: " + hello) ;
            }
        };  // nho co dau ";" nha

        anonymous.anonymousFunction();
    }
}

// test 3 classes above
class NonStaticNestedClass
{
    public static void main(String[] args) 
    {
        OuterClass outer = new OuterClass() ;

        // Inner Class
        OuterClass.InnerClass inner = outer.new InnerClass() ;
        inner.display();

        // Local Class
        System.out.println(outer.welcome("Nghiem")) ;

        // Anonymous Class
        outer.anonymousSay();
    }
}