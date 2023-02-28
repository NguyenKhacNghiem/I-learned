public class Main
{
    public static void main(String[] args) 
    {
        // Khoi tao doi tuong Singleton
        SingletonPattern singleton = SingletonPattern.getInstance() ; 
        // -> khong co tu khoa new do khong dung constructor de khoi tao (private ma)

        singleton.welcome();
    }
}