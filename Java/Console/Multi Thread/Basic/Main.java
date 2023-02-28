public class Main
{
    public static void main(String[] args) 
    {
        // Cach 1: Doi voi phuong phap implements interface
        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);
        thread.start(); // goi ham run() de chay cac doan code trong thread

        // Cach 2: Doi voi phuong phap extends class
        Thread2 thread2 = new Thread2();
        thread2.start(); // goi ham run() de chay cac doan code trong thread

        // -> Moi lan chay se cho ra ket qua khac nhau do 2 threads nay chay song song
    }
}