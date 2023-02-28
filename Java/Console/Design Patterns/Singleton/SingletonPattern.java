// Co nhieu cach de trien khai Singleton. O day
// trien khai Singleton bang Lazy Initialization

public class SingletonPattern
{
    private static SingletonPattern instance;
    // attributes
    // ...
	
	private SingletonPattern(/* parameters... */) 
    {
        // System.out.println("Hello from private constructor of Singleton !") ;
        
        // attributes
        // ...
    }
	
	public static SingletonPattern getInstance()  // getter
    {
		if(instance == null) 
			instance = new SingletonPattern();
		
		return instance;
	}

    // methods
    public void welcome()
    {
        System.out.println("Hello World !") ;
    }
}